/**
 * Marcel Poots
 */
package nl.rossie.scrambler.consts;

/**
 * @author Marcel P
 *
 */
public class ScramblerConsts {

	public static final String APP_NAME      = "Marcel's Rubiks cube trainer";
	public static final String VERSION       = "2.2.1";
	public static final String NEW_LINE      = "\r\n";
	public static final String EMPTY         = "";
	
	public static final int OPTION_OLL       = 0;
	public static final int OPTION_PLL       = 1;
	public static final int OPTION_COLL      = 2;	
	public static final int OPTION_CMLL      = 3;
	public static final int OPTION_CLL       = 4;
	public static final int OPTION_3X3       = 5;
	public static final int OPTION_2X2       = 6;
	public static final int OPTION_ZBLLH     = 7;
	public static final int OPTION_EG1       = 8;
	public static final int OPTION_DEFAULT   = 9;
	public static final int OPTION_F2L       = 10;
	public static final int OPTION_WV        = 11;
	public static final int OPTION_F2LE      = 12;
	
	//Scramble options
	public static final int OLL              = 1;
	public static final int PLL              = 2;
	public static final int COLL             = 3;
	public static final int CMLL             = 4;
	public static final int CLL              = 5;
	public static final int ZBLLH            = 6;
	public static final int EG1              = 7;
	public static final int DEFAULT          = 8;
	public static final int F2L              = 9;
	public static final int WV               = 10;
	public static final int F2LE             = 11;

	public static final String OLL_STRING    = "OLL";
	public static final String F2L_STRING    = "F2L";
	public static final String F2LE_STRING   = "F2LE";	
	public static final String PLL_STRING    = "PLL";
	public static final String COLL_STRING   = "COLL";
	public static final String CMLL_STRING   = "CMLL";
	public static final String CLL_STRING    = "CLL";
	public static final String ZBLLH_STRING  = "ZBLLH"; 
	public static final String EG1_STRING    = "EG-1";
	public static final String DEF_STRING    = "DEFAULT";
	public static final String WV_STRING     = "WV";
	
	public static String[] OPTIONS = {"OLL","F2L","F2LE", "PLL","WV", "CLL","CMLL","COLL","ZBLLH", "EG-1", "DEFAULT"};
	
	public static final String CONNECTION_STRING    = "jdbc:sqlite:solves.db";
	
}
