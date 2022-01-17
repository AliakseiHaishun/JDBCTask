package Opereations;

import java.sql.*;

public class BalanceOperations {
    private static final String DB_URL = "jdbc:postgresql://localhost/postgres";
    private static final String USER = "postgres";
    private static final String PASS = "1111";
    private int value;
    private int accountId;
    private int transactionId;

    public BalanceOperations(int accountId, int value, int transactionId) {
        this.accountId = accountId;
        this.value = value;
        this.transactionId = transactionId;
    }

    public void plussingBalance() {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement();) {
            try {
                String string = "UPDATE Accounts SET ballance = ballance + " + value + " WHERE accountId = " + accountId;
                statement.execute(string);
                String string1 = "INSERT INTO Transactions VALUES (" + transactionId + ", " + accountId + ", " + value + ")";
                statement.execute(string1);


            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.err.println("Connection is failed!");
            e.printStackTrace();
        }
    }
    public void decidingBalance() {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement();) {
            try {
                String string = "UPDATE Accounts SET ballance = ballance - " + value + " WHERE accountId = " + accountId;
                ResultSet rs = statement.executeQuery("select ballance from Accounts where accountId = " + accountId);
                String string1 = "INSERT INTO Transactions VALUES (" + transactionId + ", " + accountId + ", " + value + ")";
                statement.execute(string1);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.err.println("Connection is failed!");
            e.printStackTrace();
        }
    }


}
