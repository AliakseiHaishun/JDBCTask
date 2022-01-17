import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserCreation {
    static final String DB_URL = "jdbc:postgresql://localhost/postgres";
    static final String USER = "postgres";
    static final String PASS = "1111";


    public static void main(String[] args) {
        String user1 = "INSERT INTO Users VALUES (11, 'Alexey Haishun', 'Minsk, Pushkina')";
        String user2 = "INSERT INTO Users VALUES (12, 'Ivan Ivanov', 'Molodechno, V.Gostinez')";
        String user3 = "INSERT INTO Users VALUES (13, 'Alex Jameson', 'UK, London, Fulham.Road')";
        List<String> stringList = new ArrayList<>();
        stringList.add(user1);
        stringList.add(user2);
        stringList.add(user3);

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement();) {
            try {
                for (int i = 0; i < stringList.size(); i++) {
                    statement.execute(stringList.get(i));
                }

            } catch (SQLException e) {
                System.err.println("Ошибка запроса!");
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.err.println("Connection is failed!");
            e.printStackTrace();
        }
    }
}
