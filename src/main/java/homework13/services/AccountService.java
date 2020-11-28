package homework13.services;

import homework13.entities.Accounts;
import homework13.utils.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountService {


    private static final String GET_ALL = "SELECT * FROM accounts";
    private static final String GET_ACCOUNT_SEARCH = "SELECT number FROM accounts WHERE value > ?";
    private static final String SAVE = "INSERT INTO accounts (clientId, number, value) VALUES (?,?,?)";
    private static final String UPDATE_ALL = "UPDATE accounts SET number = ?, value = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM accounts WHERE id = ?";

    public List<Accounts> getAllAccounts() {
        List<Accounts> accounts = new ArrayList<>();
        try (Connection connection = Database.getConnection()) {
            assert connection != null;
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(GET_ALL);
                connection.setAutoCommit(false);
                while (resultSet.next()) {
                    Accounts account = new Accounts();
                    account.setId(resultSet.getInt("id"));
                    account.setClientId(resultSet.getInt("clientId"));
                    account.setNumber(resultSet.getString("number"));
                    account.setValue(resultSet.getDouble("value"));
                    accounts.add(account);
                }
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public List<Accounts> accountsForValueSearch(double value) {
        List<Accounts> accounts = new ArrayList<>();

        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ACCOUNT_SEARCH)) {
            preparedStatement.setDouble(1, value);
            ResultSet resultSet = preparedStatement.executeQuery();
            connection.setAutoCommit(false);
            while (resultSet.next()) {
                Accounts account = new Accounts();
                account.setNumber(resultSet.getString("number"));
                accounts.add(account);
            }
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return accounts;
    }

    public void saveAccounts(Accounts account) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE)) {
            connection.setAutoCommit(false);
            preparedStatement.setInt(1, account.getClientId());
            preparedStatement.setString(2, account.getNumber());
            preparedStatement.setDouble(3, account.getValue());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAllAccounts(int id, String newNumber, double newValue) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ALL)) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1, newNumber);
            preparedStatement.setDouble(2, newValue);
            preparedStatement.setInt(3, id);
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteAccounts(int id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            connection.setAutoCommit(false);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

