import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\databases\\testjava.db");
        } catch(SQLException e) {
            System.out.println(e);
        }
    }
}