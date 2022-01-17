import java.sql.*;

public class StructureCreation {
     static final String DB_URL = "jdbc:postgresql://localhost/postgres";
     static final String USER = "postgres";
     static final String PASS = "1111";

    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("No postgres driver");
            return;
        }
        try ( Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
              Statement statement = connection.createStatement();) {
            try {
                statement.execute("CREATE TABLE Users (\n" +
                        "userId int NOT NULL,\n" +
                        "name varchar(50) NOT NULL,\n" +
                        "adress varchar(255),\n" +
                        "PRIMARY KEY (userId)\n" +
                        ");\n" +
                        "CREATE TABLE Accounts (\n" +
                        "accountId int NOT NULL,\n" +
                        "userId int NOT NULL,\n" +
                        "ballance int NOT NULL,\n" +
                        "currency varchar (15) NOT NULL,\n" +
                        "PRIMARY KEY (accountId),\n" +
                        "FOREIGN KEY (userId) REFERENCES Users (userId)\n" +
                        ");\n" +
                        "CREATE TABLE Transactions (\n" +
                        "transactionId int NOT NULL,\n" +
                        "accountId int NOT NULL,\n" +
                        "ammount int NOT NULL,\n" +
                        "PRIMARY KEY (transactionId),\n" +
                        "FOREIGN KEY (accountId) REFERENCES Accounts (accountId)\n" +
                        ");");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.err.println("Connection is failed!");
            e.printStackTrace();
        }


    }
}
