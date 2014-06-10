package nl.rossie.scrambler.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import nl.rossie.scrambler.consts.ScramblerConsts;
import nl.rossie.scrambler.model.Scramble;

public class DataStore {

	public static final String driver = "org.sqlite.JDBC";
	private Connection con = null;
	private static boolean driverLoaded = false;
	private Scramble scramble;
	
	private void setupDriver(){
		try
		{
			//Load the JDBC driver class dynamically.
			if (!driverLoaded){
				Driver d = (Driver)Class.forName(driver).newInstance();
				DriverManager.registerDriver(d);
				driverLoaded = true;
			}
		}
		catch(Exception e)
		{
			System.out.println("Error loading database driver: " + e.toString());
			return;
		}
		System.out.println("Driver loaded..");
	}
	
	public void saveTime(Scramble scramble){
		setScramble(scramble);
		setupDriver();
		connect();
		storeTime();
		
	}
	
	private void connect(){

		try
		{
			if(con == null){
				con = DriverManager.getConnection(ScramblerConsts.CONNECTION_STRING);
				System.out.println("Connected to SQLite..");
			}
		}
		catch(SQLException e)
		{
			System.out.println("Error creating connection: " + e.toString());
			return;
		}

	}
	
	private void storeTime(){

		Statement stmt;
		try
		{
			String sql_create = "CREATE TABLE solves (id INTEGER PRIMARY KEY AUTOINCREMENT, scramble TEXT NOT NULL, category TEXT NOT NULL, solve_case  TEXT NOT NULL, solve_time NUMBER ,date NUMBER NOT NULL)";
			stmt = con.createStatement();
			if(!exists(stmt, "solves")){
				stmt.execute(sql_create);
				System.out.println("SOLVES table created..");
				stmt.execute("CREATE INDEX caseidx ON solves (solve_case);");
				System.out.println("Index on table SOLVES created..");
			}else{
//				stmt.execute("drop table SOLVES");
//				System.out.println("SOLVES DROPPED..");
				System.out.println("SOLVES table allready exists..");
			}
			Long dateNow = Calendar.getInstance().getTime().getTime();
			String alg = scramble.getScramble();
			alg = alg.replace("'", "''");
			String sql_insert = "insert into solves ( scramble, category, solve_case, solve_time, date) values ('" + alg + "','" +  scramble.getCategory() +  "','"  +  scramble.getName() +  "'," +  scramble.getResult()  + ","+ dateNow + " )";
			System.out.println(sql_insert);
			stmt.execute(sql_insert);
            stmt.close();
			
		}
		catch(SQLException e)
		{
			System.out.println("Error creating or running statement: " + e.toString());
			try
			{
				con.close();
			}
			catch(Exception exception)
			{ 
				System.out.println("Error creating closing connection: " + e.toString());
			}
			return;
		}

		System.out.println("SQL stuff done...");
	}
	
	public boolean exists(Statement stmt, String table) {
	    try {
	    	stmt.execute("SELECT * FROM " + table);
	        return true;
	    } catch (SQLException e) {
	         return false;
	    }
	}

	public String getAverages(Date from, Date untill, String caseId) throws SQLException{

		StringBuilder sb = new StringBuilder();
		
		setScramble(scramble);
		setupDriver();
		connect();

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");   

		
		sb.append("Results for " + caseId +  " from " + dateFormat.format(from) + " untill " + dateFormat.format(untill) + "\n"); 
		Statement stmt = con.createStatement();
		
		
		Calendar c = Calendar.getInstance(); 
		c.setTime(from); 
		c.add(Calendar.DATE, -0);
		Date startDate =  c.getTime();

		c.setTime(untill); 
		c.add(Calendar.DATE, 1);
		Date endDate =  c.getTime();
		
		String sql_select = "select * from solves where  category = '" + caseId +  "' and date >= " + startDate.getTime()  + " and date <= " +  endDate.getTime();
		
		ResultSet res = stmt.executeQuery(sql_select);
		
		String scramble, solve_case;
		Long solve_time = new Long(0);
		int count = 1;
        while(res.next())
        {
        	scramble = res.getString("scramble");
        	solve_case = res.getString("solve_case");
        	solve_time = res.getLong("solve_time");
        	Date date = res.getDate("date");
        	sb.append(count + " : " + TimeDisplayUtil.longToTimeString(solve_time) + "  " + dateFormat.format(date) +  "  " + solve_case  +  " " + scramble   +  "\n" );
        	count++;
        }
        res.close();
		
		return sb.toString();
	}
	
	
	public Scramble getScramble() {
		return scramble;
	}

	public void setScramble(Scramble scramble) {
		this.scramble = scramble;
	}	
}
