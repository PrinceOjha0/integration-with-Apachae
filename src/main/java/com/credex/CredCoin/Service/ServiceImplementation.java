package com.credex.CredCoin.Service;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class ServiceImplementation implements ServiceLayer {

	public JSONObject loginapi(String username, String password)  throws Exception {
	//	final Logger LOGGER = LoggerFactory.getLogger(ServiceImplementation.class);
	    System.out.println(username+password);
	        String authString = username + ":"+ password;
	        String encodedAuthString = Base64.getEncoder().encodeToString(authString.getBytes(StandardCharsets.UTF_8));

	        String apiUrl = "http://localhost:9080/syncope/rest/users/self";
	        URL url = new URL(apiUrl);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setRequestMethod("GET");
	        connection.setRequestProperty("Authorization", "Basic " + encodedAuthString);

	        int responseCode = connection.getResponseCode();
	        if (responseCode == HttpURLConnection.HTTP_OK) {
	            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	            String inputLine;
	            StringBuilder response = new StringBuilder();
	            while ((inputLine = in.readLine()) != null) {
	                response.append(inputLine);
	            }
	            in.close();
	            JSONObject json = new JSONObject(response.toString());
	            System.out.println(response.toString());

				

				if (json.length() != 0) {
					return json;
	        } 
				}
				else {
	            System.out.println("Failed to authenticate. Response code: " + responseCode);
	        }
	        throw new RuntimeException("Failed to authenticate. Response code: " + responseCode);
	}
}

	        
	    
