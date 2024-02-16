import java.sql.*;

public class Main {
    public static final String DB_NAME = "testjava.db";
    public static final String CONNECTION_STRING="jdbc:sqlite:C:\\Users\\Matty\\IdeaProjects\\TestDB_Section25Databases\\testjava.db";
    public static final String TABLE_CONTACTS = "contacts";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {

//        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\lance\\Documents\\CodingJava\\TestDB_Section25Databases\\testjava.db");
//            Statement statement = conn.createStatement()) {
//            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\databases\\testjava.db");

        try {
//            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\lance\\Documents\\CodingJava\\TestDB_Section25Databases\\testjava.db");
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();

            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS +
                    " (" + COLUMN_NAME + " text, " +
                    COLUMN_PHONE + " integer, " +
                    COLUMN_EMAIL + " text" + ")");

            insertContact(statement, "Lance",64534231,"lance@email.com");
            insertContact(statement, "Joe",45632,"joe@anywhere.com");
            insertContact(statement, "Jane",4829484,"jane@somewhere.com");
            insertContact(statement, "Fido",9038,"dog@email.com");

            statement.execute("UPDATE " + TABLE_CONTACTS + " SET " +
                    COLUMN_PHONE + "=5566789" + " WHERE " + COLUMN_NAME +
                    "='Jane'");

            statement.execute("DELETE FROM " + TABLE_CONTACTS +
                    " WHERE " + COLUMN_NAME + "='Joe'");

            ResultSet results = statement.executeQuery("SELECT  * FROM contacts");
            while(results.next()) {
                System.out.println(results.getString(COLUMN_NAME) + " "
                        + results.getInt(COLUMN_PHONE) + " "
                        + results.getString(COLUMN_EMAIL));
            }
            results.close();
            statement.close();
            conn.close();

        } catch(SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }

    }

    private static void insertContact(Statement statement, String name, int phone, String email) throws SQLException {
        statement.execute("INSERT INTO " + TABLE_CONTACTS +
                " (" + COLUMN_NAME + ", " +
                COLUMN_PHONE + ", " +
                COLUMN_EMAIL + ") " +
                "VALUES('"+name+"',"+phone+",'"+email+"')");
    }
}