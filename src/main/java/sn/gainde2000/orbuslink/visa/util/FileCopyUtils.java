package sn.gainde2000.orbuslink.visa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Value;

public class FileCopyUtils {
	
	@Value("${etalinkFile}")
    static String ETALINK_FILE;
	@Value("${urlFolder}")
    static String urlFolder;
	
	public static void main(String[] args) throws Exception {
        String url1 = "D:\\a.txt";// Source file path
                 String url2 = "E:\\b.txt";// Target path (copy to E drive, rename to b.txt)
        copy("C:\\Users\\MTHIAM\\PROJECTS\\GAINDE\\VISA\\OrbusLinkVisaBackend\\files\\senetafi.xlsm", urlFolder+"test.xlsm");
    }
 
private static void copy(String url1, String url2) throws Exception {
    FileInputStream in = new FileInputStream(new File(url1));
    FileOutputStream out = new FileOutputStream(new File(url2));
    byte[] buff = new byte[512];
    int n = 0;
         System.out.println("Copy file:" + "\n" + "Source path:" + url1 + "\n" + "Target path:"
    + url2);
    while ((n = in.read(buff)) != -1) {
        out.write(buff, 0, n);
    }
    out.flush();
    in.close();
    out.close();
         System.out.println("Copy completed");
    }

}
