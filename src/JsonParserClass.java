import java.io.*;
import org.json.simple.*;
import org.json.simple.parser.*;

import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.sqlite.*;


public class JsonParserClass {
	RoomList roomList = new RoomList();
	ArrayList<Integer> floorList = new ArrayList<>();
	int floor;

	public void processResponse(String response) {
    	Gson gson = new Gson();
    	InsertApp app = new InsertApp();

        roomList = gson.fromJson(response, RoomList.class);
           
        for (Room room : roomList.data) {
        	floor = parseFloor(room);
        	
        	System.out.println(room.building + ", " + room.room + ", "+ floor);
        	app.insert(room.building, room.room, 40, floor);
        }
        
    }
	
	public int parseFloor(Room room) {
		int e;
		
		if(room.room.startsWith("B")) {
			char c = room.room.charAt(1);
			String d = c + "";
			e = Integer.parseInt(d);
			e = -e;
		} else {
			char c = room.room.charAt(0);
			String d = c + "";
			e = Integer.parseInt(d);
		}
		return e;		
	}
	
	public static void main(String[] args) {
		JsonParserClass jsonParserClass = new JsonParserClass();
		CheckJSON cjson = new CheckJSON();
		
        try {
			jsonParserClass.processResponse(cjson.check());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //System.out.println(cjson.getDriver());
	}

}