package routeSec;

/******************************************************************************
*Md5Genrator.java: Written as a part of RouteSec Term project for CSC/ECE573
*Authors: Aditya Vyas, Bhavin Shah, Manshi Choudhry, Spoorthi Gururaj 
*Date: 20 Nov 2012
*Written and compiled on Ubuntu 12.04, Eclipse IDE 
*******************************************************************************
*The program forms the portion of the project where we generate the MD5 hash 
*of the packets in the communication between the client and the server. 
*Also used to visually verify the authenticity of the packets as a work around
*to TCP_MD5 sig option.
*This version uses a capture file as opposed to its server counterpart that listens
*and calculates MD5 hash pf packets directly off the NIC
*******************************************************************************/




import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException;

public class Md5Genrator {

	
	
	/*********************************************************************
	 * Converting input byte data to string.
	 * *******************************************************************/
	private static String convertToHex(byte[] data) { 
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) { 
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do { 
                if ((0 <= halfbyte) && (halfbyte <= 9)) 
                    buf.append((char) ('0' + halfbyte));
                else 
                    buf.append((char) ('a' + (halfbyte - 10)));
                halfbyte = data[i] & 0x0F;
            } while(two_halfs++ < 1);
        } 
        return buf.toString();
    } 
	
	/**************************************************************************
	 *calculating the MD5 hash
	 *************************************************************************/
	 public static String MD5(String text) 
			    throws NoSuchAlgorithmException, UnsupportedEncodingException  { 
			        MessageDigest md;
			        md = MessageDigest.getInstance("MD5");
			        byte[] md5hash = new byte[32];
			        md.update(text.getBytes("iso-8859-1"), 0, text.length());
			        md5hash = md.digest();
			        return convertToHex(md5hash);
			        
			    } 
     public static void wIf(Long a, String b) throws IOException{
    	                     //File f = new File("/home/spoorthi/Desktop/pck.csv");
    	     			//final FileWriter writer = new FileWriter();
    	                     FileWriter writer = new FileWriter("/home/spoorthi/Desktop/pck.csv",true);
    	                     
    	    writer.append(a.toString());
		    writer.append(',');
		    writer.append(b);
		    writer.append('\n');
		    writer.flush();	 
     
     }
	 
}
