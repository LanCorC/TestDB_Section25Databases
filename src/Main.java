import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
//            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\databases\\testjava.db");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\lance\\Documents\\CodingJava\\TestDB_Section25Databases\\testjava.db");

        } catch(SQLException e) {
            System.out.println(e);
        }
    }
}