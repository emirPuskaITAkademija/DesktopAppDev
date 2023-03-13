package org.akademija.six.gui.dao.player;

import org.akademija.six.gui.dao.Dao;
import org.akademija.six.gui.dao.connection.ConnectionPool;
import org.akademija.six.gui.dao.sport.Sport;
import org.akademija.six.gui.dao.sport.SportDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDao implements Dao<Player> {
    @Override
    public Player save(Player entity) {
        return null;
    }

    @Override
    public List<Player> getAll() {
        List<Player> players = new ArrayList<>();
        String sqlQuery = """
                SELECT
                p.id,name,surname,sport_name as sport, of_years, vegetarian, favourite_color
                FROM players p
                JOIN sport s ON p.sport=s.id;
                """;
        //1. konekcija s bazom
        Connection connection = ConnectionPool.getInstance().getConnection();
        //2. PreparedStatement ili Statement
        try (PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery)) {
            //3. java.sql.Result
            //3.1 ResultSetMetada
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                Player player = new Player();
                player.setId(resultSet.getLong(1));
                player.setName(resultSet.getString("name"));
                player.setSurname(resultSet.getString("surname"));
                SportDao sportDao = new SportDao();
                Sport sport = sportDao.getAll()
                        .stream()
                        .filter(s-> {
                            try {
                                return s.getSportName().equals(resultSet.getString("sport"));
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }
                        }).findFirst().orElse(null);
                player.setSport(sport);
                player.setVegetarian(resultSet.getBoolean("vegetarian"));
                player.setOfYears(resultSet.getInt("of_years"));
                player.setFavouriteColor(resultSet.getString("favourite_color"));
                players.add(player);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        ConnectionPool.getInstance().releaseConnection(connection);
        return players;
    }

    public List<String> getColumnNames() {
        List<String> columnNames = new ArrayList<>();
        String sqlQuery = "SELECT * FROM players";
        //1. konekcija s bazom
        Connection connection = ConnectionPool.getInstance().getConnection();
        //2. PreparedStatement ili Statement
        try (PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery)) {
            //3. java.sql.Result
            //3.1 ResultSetMetada
            ResultSet resultSet = prepareStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                String columName = resultSetMetaData.getColumnName(i);
                columnNames.add(columName);
            }
            ConnectionPool.getInstance().releaseConnection(connection);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return columnNames;
    }

    @Override
    public Player get(Long id) {
        return null;
    }

    /**
     * Single Responsibility
     *
     * @param player
     * @return player
     */
    @Override
    public Player update(Player player) {
        String sqlUpdate = """
                 UPDATE players SET name = ?, 
                 surname = ?, 
                 sport = ?, 
                 of_years = ?, 
                 vegetarian = ?, 
                 favourite_color = ? WHERE id = ?
                 """;
        Connection connection = ConnectionPool.getInstance().getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate)){
            preparedStatement.setString(1, player.getName());
            preparedStatement.setString(2, player.getSurname());
            //preparedStatement.setString(3, player.getSport());
            preparedStatement.setInt(4, player.getOfYears());
            preparedStatement.setBoolean(5, player.getVegetarian());
            preparedStatement.setString(6, player.getFavouriteColor());
            preparedStatement.setLong(7, player.getId());
            preparedStatement.executeUpdate();
        }catch (SQLException exception){
            System.err.println(exception.getMessage());
        }finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return player;
    }


    @Override
    public boolean delete(Player entity) {
        return false;
    }
}
