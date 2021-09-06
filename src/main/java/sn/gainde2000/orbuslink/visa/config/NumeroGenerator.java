package sn.gainde2000.orbuslink.visa.config;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;

import sn.gainde2000.orbuslink.visa.model.Depot;
import sn.gainde2000.orbuslink.visa.model.Etalink;

public abstract class NumeroGenerator {
	

	
	 public static String generateCodeArticle(Depot lastDepot) {
		 int year = Calendar.getInstance().get(Calendar.YEAR);
        try {
            Long a = lastDepot.getId();
            String LastYear = lastDepot.getAnneeExcercice();
            NumberFormat nf = new DecimalFormat("000000");
            
	            Long b = a + 1;
	            String index = nf.format(b);
	            if(LastYear.equals(String.valueOf(LastYear)))
	            {
	            	return year+ index;
	            }
	            return year + "000001";
	        } catch (Exception e) {
	            return year + "000001";
	        }

	 }
	 
	 
	 public static String generateSequenceFile(Etalink etalink) {
		 int year = Calendar.getInstance().get(Calendar.YEAR);
        try {
            Long a = etalink.getId();
            String LastYear = etalink.getAnneeCloture();
            NumberFormat nf = new DecimalFormat("000000");
            
	            Long b = a + 1;
	            String index = nf.format(b);
	            if(LastYear.equals(String.valueOf(LastYear)))
	            {
	            	return year+ index;
	            }
	            return year + "000001";
	        } catch (Exception e) {
	            return year + "000001";
	        }

	 }
	 
	

}
