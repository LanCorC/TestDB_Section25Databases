import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
//        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\lance\\Documents\\CodingJava\\TestDB_Section25Databases\\testjava.db");
//            Statement statement = conn.createStatement()) {
//            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\databases\\testjava.db");

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\lance\\Documents\\CodingJava\\TestDB_Section25Databases\\testjava.db");
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE contacts (name TEXT, phone INTEGER, email TEXT)");

            statement.close();
            conn.close();


        } catch(SQLException e) {
            System.out.println(e);
        }
    }
}