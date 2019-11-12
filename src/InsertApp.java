import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertApp {
	
	private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:/Users/seojaehoon/Desktop/db.sqlite3";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
 
    /**
     * Insert a new row into the warehouses table
     *
     * @param building_no
     * @param room_no
     */
    public void insert(String building_no, String room_no, int capacity, int floor) {
        String sql = "INSERT INTO main_classroom(building_no_id,room_no,capacity,floor) VALUES(?,?,?,?)";
 
        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, building_no);
            pstmt.setString(2, room_no);
            pstmt.setInt(3, capacity);
            pstmt.setInt(4, floor);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
