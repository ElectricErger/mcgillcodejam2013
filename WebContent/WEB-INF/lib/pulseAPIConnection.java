

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
/*import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
*/


public class pulseAPIConnection {

	public static void main(String[] args) {
		String[] stats = {"66094","66095","66077","66096","50578"};
		String stat = stats[1];
		String timeUnit = "day";
		String startTime = "2013-11-11T00:00:00-05:00";
		
		String url = "https://api.pulseenergy.com/pulse/1/points/" + stat + "/data.json?key=0FADE7A00390DCABB05491C9E6D35ECE&interval=" + timeUnit + "&start=" + startTime;
		try {
			APIParse(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void APIParse(String query) throws IOException{
	    
		System.out.println("ENTER");
		URL url = new URL (query);
		System.out.println("URL OK");
	    URLConnection uc = url.openConnection();
		System.out.println("Connection OK");
		InputStreamReader input = new InputStreamReader(uc.getInputStream());
		System.out.println("Input OK");
		BufferedReader in = new BufferedReader(input);
		System.out.println("Buffer OK");
	    String inputLine;
			while ((inputLine = in.readLine()) != null) {
			    System.out.println(inputLine);
			}

	}
}
