package homework13.services;

import homework13.entities.Accounts;
import homework13.entities.Statuses;
import homework13.utils.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StatusService {

//        private int id;
//    private String alias;
//    private String description;

    private static final String GET_ALL = "SELECT * FROM statuses";
    private static final String SAVE = "INSERT INTO statuses (alias, description) VALUES (?,?)";
    private static final String UPDATE_ALL = "UPDATE statuses SET alias = ?, description = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM statuses WHERE id = ?";

    public List<Statuses> getAllStatuses() {
        List<Statuses> statuses = new ArrayList<>();
        try (Connection connection = Database.getConnection()) {
            assert connection != null;
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(GET_ALL);
                connection.setAutoCommit(false);
                while (resultSet.next()) {
                    Statuses status = new Statuses();
                    status.setId(resultSet.getInt("id"));
                    status.setAlias(resultSet.getString("alias"));
                    status.setDescription(resultSet.getString("description"));
                    statuses.add(status);
                }
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statuses;
    }

    public void saveStatuses(Statuses status) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE)) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1, status.getAlias());
            preparedStatement.setString(2, status.getDescription());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAllStatuses(int id, String newAlias, String newDescription) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ALL)) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1, newAlias);
            preparedStatement.setString(2, newDescription);
            preparedStatement.setInt(3, id);
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteStatuses(int id) {
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
