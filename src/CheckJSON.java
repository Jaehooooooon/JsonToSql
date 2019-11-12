import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class CheckJSON {
	String driver = null;

    public String check() throws Exception{
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("/Users/seojaehoon/Desktop/rooms.json"));
        JSONObject jo = (JSONObject) obj;
        String response = jo.toString();
        
        setDriver((String) jo.get("JDBCDriver"));
        
        return response;
    }
    
    public void setDriver(String driver){
        this.driver = driver;
    }
    public String getDriver(){
        return driver;
    }
}
