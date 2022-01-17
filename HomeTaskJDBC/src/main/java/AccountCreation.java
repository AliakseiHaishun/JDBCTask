import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountCreation {
    static final String DB_URL = "jdbc:postgresql://localhost/postgres";
    static final String USER = "postgres";
    static final String PASS = "1111";


    public static void main(String[] args) {
        String acc1 = "INSERT INTO Accounts VALUES (21, 11, 244, 'usd')";
        String acc2 = "INSERT INTO Accounts VALUES (22, 12, 1001, 'byn')";
        String acc3 = "INSERT INTO Accounts VALUES (23, 13, 0, 'pln')";
        List<String> stringList = new ArrayList<>();
        stringList.add(acc1);
        stringList.add(acc2);
        stringList.add(acc3);

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement();) {
            try {
                for (int i = 0; i < stringList.size(); i++) {
                    statement.execute(stringList.get(i));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.err.println("Connection is failed!");
            e.printStackTrace();
        }
    }
}
