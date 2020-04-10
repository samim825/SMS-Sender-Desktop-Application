
package smssender;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class SmsSender {
     private static String apiBaseUrl ="http://api.greenweb.com.bd/api.php";
    
    private static String token = "226230f17066ac245f248f25b0afec81";
    
    
	public static void sendSMS(String to, String messageBody) throws Exception {
       // int apiBaseUrl = 0;
                StringBuilder url = new StringBuilder(apiBaseUrl)
                .append("?token=")
                .append(token)
                .append("&to=")
                .append(to)
                .append("&message=")
                .append(messageBody);
		
                //System.out.println("url:"+url);
                
		URL obj = new URL(url.toString().replaceAll(" ", "+"));
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent",  "Mozilla/5.0");

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());

	}
    }
    

