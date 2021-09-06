package sn.gainde2000.orbuslink.visa.util;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequester2 {

	
	public static String SendRequest(String argUrl, String requestXml)
    {
        String result = null;
         try {
            URL url = new URL(argUrl);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();


            //URLConnection con = url.openConnection();
            con.setRequestMethod("POST");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setConnectTimeout(60000);
            con.setReadTimeout(60000);
            con.setUseCaches(false);
            con.setDefaultUseCaches(false);

            con.setRequestProperty("Content-Type", "text/xml");
            OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
            writer.write(requestXml);
            writer.flush();
            writer.close();
            // lecture de la reponse
            InputStreamReader reader = new InputStreamReader(con.getInputStream());
            StringBuilder buf = new StringBuilder();
            char[] cbuf = new char[2048];
            int num;
            while (-1 != (num = reader.read(cbuf))) {
                buf.append(cbuf, 0, num);
            }
            result = buf.toString();
            
            } catch (Throwable t) {
            t.printStackTrace(System.out);
             //System.out.println("result null httpRequester");
        }
        
         return result;
    }
	
	
	
}
