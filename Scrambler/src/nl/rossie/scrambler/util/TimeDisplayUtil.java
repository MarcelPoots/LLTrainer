package nl.rossie.scrambler.util;

import java.util.Calendar;

public class TimeDisplayUtil {


	public static String longToTimeString(Long time){
	
		Calendar c = Calendar.getInstance(); 
		
		c.setTimeInMillis(time);
		
		@SuppressWarnings("deprecation")
		String mins =  c.getTime().getMinutes()+"";
		@SuppressWarnings("deprecation")
		String secs =  c.getTime().getSeconds()+"";

	    if (secs.length() == 1){
	    	secs= "0" + secs; 
	    }
	    if (mins.length() == 1){
	    	mins= "0" + mins; 
	    }
		
	    String honderste = (time / 100) % 10 + "";
	    
	    String duizendste = "0";
    	String temp = time+ "";
    	if (temp.length() > 2){
    		int start = temp.length() - 2;
    		duizendste = temp.substring(start,start + 1);
    	}
    
	    return  mins + ":" + secs + ":" + honderste + duizendste;		
		 
	}

}
