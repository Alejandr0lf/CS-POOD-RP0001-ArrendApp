package DataBase.DBObjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import DataBase.Connection.DataBaseConnection;
import Model.appObjects.Direction;

public class DirectionDAO {

    public static final String SQLCONSULTA = "SELECT * FROM DB_BuildingDirection bd";
    public static final String SQLCONSULTA_ID = "SELECT * FROM DB_BuildingDirection bd WHERE bd.coordinates = (?);";
    public static final String SQLINSERT = "INSERT INTO DB_BuildingDirection (adress, coordinates, neighborhood, city) VALUES (?,?,?,?)";
    public static final String SQLDELETEID = "DELETE FROM DB_BuildingDirection WHERE coordinates = (?)";
    public static final String SQLACTUALIZAR = "UPDATE DB_BuildingDirection SET adress = ?, neighborhood = ?, city = ? WHERE coordinates = ?";

    public List<Direction> check() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet resultado = null;
        List<Direction> directions = new ArrayList<>();
        try {
            con = DataBaseConnection.getConnection();
            ps = con.prepareStatement(SQLCONSULTA);
            resultado = ps.executeQuery();
            while (resultado.next()) {
                String adress = resultado.getString("adress");
                String coordinates = resultado.getString("coordinates");
                String neighborhood = resultado.getString("neighborhood");
                String city = resultado.getString("city");
                Direction direction = new Direction(adress, coordinates, neighborhood, city);
                directions.add(direction);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return directions;
    }

    public Direction checkId(Direction s) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet resultado = null;
        Direction direction = null;
        try {
            con = DataBaseConnection.getConnection();
            ps = con.prepareStatement(SQLCONSULTA_ID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            ps.setString(1, s.getCoordinates());
            resultado = ps.executeQuery();
            resultado.absolute(1);
            String adress = resultado.getString("adress");
            String coordinates = resultado.getString("coordinates");
            String neighborhood = resultado.getString("neighborhood");
            String city = resultado.getString("city");
            direction = new Direction(adress, coordinates, neighborhood, city);

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return direction;
    }

    public int create(Direction direction) {
        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            con = DataBaseConnection.getConnection();
            ps = con.prepareStatement(SQLINSERT);
            ps.setString(1, direction.getAdress());
            ps.setString(2, direction.getCoordinates());
            ps.setString(3, direction.getNeighborhood());
            ps.setString(4, direction.getCity());
            registros = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;
    }

    public int delete(Direction direction) {
        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            con = DataBaseConnection.getConnection();
            ps = con.prepareStatement(SQLDELETEID);
            ps.setString(1, direction.getCoordinates());
            registros = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;
    }

    public int update(Direction direction) {
        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            con = DataBaseConnection.getConnection();
            ps = con.prepareStatement(SQLACTUALIZAR);
            ps.setString(1, direction.getAdress());
            ps.setString(2, direction.getNeighborhood());
            ps.setString(3, direction.getCity());
            ps.setString(4, direction.getCoordinates());
            registros = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;
    }
}
