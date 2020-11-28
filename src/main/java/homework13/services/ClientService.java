package homework13.services;


import homework13.entities.Client;
import homework13.utils.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private static final String GET_ALL = "SELECT * FROM clients";
    private static final String GET_PHONE_SEARCH = "SELECT * FROM clients WHERE phone = ?";
    private static final String GET_CLIENT_ACCOUNT_SEARCH = "SELECT * FROM clients AS c INNER JOIN accounts a ON ? = a.client_id";
    private static final String GET_CLIENT_ALIAS_SEARCH = "SELECT c.name, c.email, s.alias FROM clients AS c INNER JOIN client_status cs ON c.id = cs.client_id  INNER JOIN statuses s ON cs.status_id = s.id WHERE c.age >= ?";

    private static final String SAVE = "INSERT INTO clients (name, email, phone, about) VALUES (?,?,?,?)";
    private static final String UPDATE_ALL = "UPDATE clients SET name = ?, email = ?, phone = ?, about = ? WHERE id = ?";
    private static final String UPDATE_NAME = "UPDATE clients SET name = ? WHERE id = ?";
    private static final String UPDATE_EMAIL = "UPDATE clients SET email = ? WHERE id = ?";
    private static final String UPDATE_PHONE = "UPDATE clients SET phone = ? WHERE id = ?";
    private static final String UPDATE_ABOUT = "UPDATE clients SET about = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM clients WHERE id = ?";

    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        try (Connection connection = Database.getConnection()) {
            assert connection != null;
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(GET_ALL);
                connection.setAutoCommit(false);
                while (resultSet.next()) {
                    Client client = new Client();
                    client.setId(resultSet.getInt("id"));
                    client.setName(resultSet.getString("name"));
                    client.setEmail(resultSet.getString("email"));
                    client.setPhone(resultSet.getLong("phone"));
                    client.setAbout(resultSet.getString("about"));
                    clients.add(client);
                }
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public List<Client> getPhoneSearch(long phone) {
        List<Client> clients = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_PHONE_SEARCH)) {
            preparedStatement.setLong(1, phone);
            ResultSet resultSet = preparedStatement.executeQuery();
            connection.setAutoCommit(false);
            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setEmail(resultSet.getString("email"));
                client.setPhone(resultSet.getLong("phone"));
                client.setAbout(resultSet.getString("about"));
                clients.add(client);
            }
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return clients;
    }

    public List<Client> clientAccountSearch(int id) {
        List<Client> clients = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_CLIENT_ACCOUNT_SEARCH)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            connection.setAutoCommit(false);
            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setEmail(resultSet.getString("email"));
                client.setPhone(resultSet.getLong("phone"));
                client.setAbout(resultSet.getString("about"));
                clients.add(client);
            }
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return clients;
    }

    public List<Client> clientAliasSearch(int age) {
        List<Client> clients = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_CLIENT_ALIAS_SEARCH)) {
            preparedStatement.setInt(1, age);
            ResultSet resultSet = preparedStatement.executeQuery();
            connection.setAutoCommit(false);
            while (resultSet.next()) {
                Client client = new Client();
                client.setName(resultSet.getString("name"));
                client.setEmail(resultSet.getString("email"));
//                client.setAbout(resultSet.getString("alias"));
                clients.add(client);
            }
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return clients;
    }

    public void saveClient(Client client) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE)) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getEmail());
            preparedStatement.setLong(3, client.getPhone());
            preparedStatement.setString(4, client.getAbout());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAllClients(int id, String newName, String newEmail, long newPhone, String newAbout) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ALL)) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1, newName);
            preparedStatement.setString(2, newEmail);
            preparedStatement.setLong(3, newPhone);
            preparedStatement.setString(4, newAbout);
            preparedStatement.setInt(5, id);
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateClientsName(int id, String newName) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_NAME)) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1, newName);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateClientsEmail(int id, String newEmail) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMAIL)) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1, newEmail);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void updateClientsPhone(int id, long newPhone) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PHONE)) {
            connection.setAutoCommit(false);
            preparedStatement.setLong(1, newPhone);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateClientsAbout(int id, String newAbout) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ABOUT)) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1, newAbout);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteClients(int id) {
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