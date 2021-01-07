package it.academy;

import java.sql.*;

public class MainForTask5 {

    private static final String URL = "jdbc:mysql://localhost:3306/listexpenses?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {

        String dateArg = args[0];

        String receiver = args[1];
        int receiverArg = Integer.parseInt(receiver);

        String values = args[2];
        double valueArg = Double.parseDouble(values);

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            final Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            final Statement statement = connection.createStatement();

            String template = "insert into listexpenses.expenses (paydate,receiver,value) \n" +
                    "values (?, ?, ?)";

            PreparedStatement pStatement = connection.prepareStatement(template);

            pStatement.setString(1, dateArg);
            pStatement.setInt(2, receiverArg);
            pStatement.setDouble(3, valueArg);

            final int result = pStatement.executeUpdate();

            final ResultSet resultPrint = statement.executeQuery("select * from expenses;");

            while (resultPrint.next()) {

                String paydate = resultPrint.getString(2);
                double value = resultPrint.getDouble(3);
                String name = resultPrint.getString(4);
                System.out.println("date: " + paydate + ", value=" + value + ", name=" + name);
            }
            pStatement.close();
            resultPrint.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
