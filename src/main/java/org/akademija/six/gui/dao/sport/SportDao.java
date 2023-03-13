package org.akademija.six.gui.dao.sport;

import org.akademija.six.gui.dao.Dao;
import org.akademija.six.gui.dao.connection.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SportDao implements Dao<Sport> {
    @Override
    public Sport save(Sport entity) {
        return null;
    }

    @Override
    public List<Sport> getAll() {
        List<Sport> sports = new ArrayList<>();
        String sqlSelect = """
               SELECT * FROM sport
               """;
        Connection connection = ConnectionPool.getInstance().getConnection();
        try(PreparedStatement ps = connection.prepareStatement(sqlSelect)){
            ResultSet rs = ps.executeQuery();
            Sport sport = new Sport();
            sport.setId(rs.getLong(1));
            sport.setSportName(rs.getString("sport_name"));
            sport.setDescription(rs.getString("description"));
            sports.add(sport);
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return sports;
    }

    @Override
    public Sport get(Long id) {
        String sqlSelect = """
               SELECT * FROM sport WHERE id=?
               """;
        Connection connection = ConnectionPool.getInstance().getConnection();
        try(PreparedStatement ps = connection.prepareStatement(sqlSelect)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            Sport sport = new Sport();
            sport.setId(rs.getLong(1));
            sport.setSportName(rs.getString("sport_name"));
            sport.setDescription(rs.getString("description"));
            return sport;
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }finally {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return null;
    }

    @Override
    public Sport update(Sport entity) {
        return null;
    }

    @Override
    public boolean delete(Sport entity) {
        return false;
    }
}
