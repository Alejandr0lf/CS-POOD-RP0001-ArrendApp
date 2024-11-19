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
import Model.User.User;
import Model.User.User_Client;
import Model.User.User_Comercial;
import Model.appObjects.Building;

public class BuildingDAO {
    public static final String SQLCONSULTA = "SELECT b.ID, b.landlord, b.levels, b.rooms, b.bathrooms, b.score, b.equiped, b.hasCook, b.includedServices, b.services, b.available, b.direction FROM DB_UserBuildings b";
    // public static final String SQLINSERT = "INSERT INTO DB_UserClient(ID, name,
    // lastname, phoneNumber, email) VALUES (?, ?, ?, ?, ?)";
    // public static final String SQLINSERTCOM = "INSERT INTO DB_UserComercial(ID,
    // building) VALUES (?, ?)";
    // public static final String SQLINSERTCLI = "INSERT INTO DB_UserClient(ID)
    // VALUES (?)";
    // public static final String SQLDELETEID = "DELETE FROM DB_UserUsers WHERE id =
    // (?)";
    // public static final String SQLACTUALIZAR = "UPDATE DB_UserUsers SET name = ?,
    // lastname = ?, phoneNumber = ?, email = ? WHERE ID = ?";

    // public static final String SQLCONSULTA_ID = "SELECT v.id, v.modelo, v.anio,
    // v.color, v.descripcion, v.ubicacion, m.id as idmarca, m.nombre FROM vehicula
    // v INNER JOIN marca m ON v.id_marca = m.id WHERE v.id = ?";
    // public static final String SQLBORRAR = "DELETE FROM vehicula WHERE id = ?";

    public List<Building> consultar() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet resultado = null;
        List<Building> building = new ArrayList<>();
        try {
            con = DataBaseConnection.getConnection();
            ps = con.prepareStatement(SQLCONSULTA);
            resultado = ps.executeQuery();
            while (resultado.next()) {
                String ID = resultado.getString("ID");
                String landlord = resultado.getString("landlord");
                int levels = resultado.getInt("levels");
                int rooms = resultado.getInt("rooms");
                int bathrooms = resultado.getInt("bathrooms");
                int score = resultado.getInt("score");
                boolean equiped = resultado.getBoolean("equiped");
                boolean hasCook = resultado.getBoolean("hasCook");
                boolean includedServices = resultado.getBoolean("includedServices");
                boolean available = resultado.getBoolean("available");
                int services = resultado.getInt("services");
                String direction = resultado.getString(direction);
                User_Client user = new User_Client(cedula, nombre, apellido, telefono, correo);
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuildingDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BuildingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    public int create(User user) {
        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            con = DataBaseConnection.getConnection();
            ps = con.prepareStatement(SQLINSERT);
            ps.setLong(1, user.getID());
            ps.setString(2, user.getName());
            ps.setString(3, user.getLastname());
            ps.setString(4, user.getNumber());
            ps.setString(5, user.getEmail());
            registros = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BuildingDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BuildingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;
    }

    public int delete(User user) {
        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            con = DataBaseConnection.getConnection();
            ps = con.prepareStatement(SQLDELETEID);
            ps.setLong(1, user.getID());
            registros = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BuildingDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BuildingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;
    }

    public int update(User user) {
        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;

        try {
            con = DataBaseConnection.getConnection();
            ps = con.prepareStatement(SQLACTUALIZAR);

            ps.setString(1, user.getName());
            ps.setString(2, user.getLastname());
            ps.setString(3, user.getNumber());
            ps.setString(4, user.getEmail());
            ps.setLong(5, user.getID());
            registros = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(BuildingDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BuildingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;
    }
}
