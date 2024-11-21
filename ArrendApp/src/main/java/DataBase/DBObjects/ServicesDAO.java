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
import Model.appObjects.Services;

public class ServicesDAO {

    public static final String SQLCONSULTA = "SELECT bs.ID, bs.wifi, bs.water, bs.electricity, bs.gas, bs.administration FROM DB_BuildingsServices bs;";
    public static final String SQLCONSULTA_ID = "SELECT bs.ID, bs.wifi, bs.water, bs.electricity, bs.gas, bs.administration FROM DB_BuildingsServices bs WHERE bs.ID = ?";
    public static final String SQLINSERT = "INSERT INTO DB_BuildingsServices (ID, wifi, water, electricity, gas, administration) VALUES (?,?,?,?,?,?)";
    public static final String SQLDELETEID = "DELETE FROM DB_BuildingsServices WHERE id = (?)";
    public static final String SQLACTUALIZAR = "UPDATE DB_BuildingsServices SET wifi = ?, water = ?, electricity = ?, gas = ?, administration = ? WHERE ID = ?";

    public List<Services> check() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet resultado = null;
        List<Services> services = new ArrayList<>();
        try {
            con = DataBaseConnection.getConnection();
            ps = con.prepareStatement(SQLCONSULTA);
            resultado = ps.executeQuery();
            while (resultado.next()) {
                Long id = resultado.getLong("ID");
                Boolean wifi = resultado.getBoolean("wifi");
                Boolean water = resultado.getBoolean("water");
                Boolean electricity = resultado.getBoolean("electricity");
                Boolean gas = resultado.getBoolean("gas");
                Boolean administration = resultado.getBoolean("administration");
                Services servicios = new Services(id, wifi, water, electricity, administration, gas);
                services.add(servicios);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return services;
    }

    public Services checkId(Services s) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet resultado = null;
        Services service = null;
        try {
            con = DataBaseConnection.getConnection();
            ps = con.prepareStatement(SQLCONSULTA_ID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            ps.setLong(1, s.getId());
            resultado = ps.executeQuery();
            resultado.absolute(1);
            long id = resultado.getLong("ID");
            Boolean wifi = resultado.getBoolean("wifi");
            Boolean water = resultado.getBoolean("water");
            Boolean electricity = resultado.getBoolean("electricity");
            Boolean gas = resultado.getBoolean("gas");
            Boolean administration = resultado.getBoolean("administration");
            service = new Services(id, wifi, water, electricity, administration, gas);

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return service;
    }

    public int create(Services services) {
        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            con = DataBaseConnection.getConnection();
            ps = con.prepareStatement(SQLINSERT);
            ps.setLong(1, services.getId());
            ps.setBoolean(2, services.isWifi());
            ps.setBoolean(3, services.isWater());
            ps.setBoolean(4, services.isElectricity());
            ps.setBoolean(5, services.isAdministration());
            ps.setBoolean(6, services.isGas());
            registros = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;
    }

    public int delete(Services  services) {
        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            con = DataBaseConnection.getConnection();
            ps = con.prepareStatement(SQLDELETEID);
            ps.setLong(1, services.getId());
            registros = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;
    }

    public int update(Services services) {
        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;

        try {
            con = DataBaseConnection.getConnection();
            ps = con.prepareStatement(SQLACTUALIZAR);

            ps.setBoolean(1, services.isWifi());
            ps.setBoolean(2, services.isWater());
            ps.setBoolean(3, services.isElectricity());
            ps.setBoolean(4, services.isAdministration());
            ps.setBoolean(5, services.isGas());
            registros = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;
    }
}
