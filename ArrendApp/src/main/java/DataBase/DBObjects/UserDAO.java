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

public class UserDAO {
    public static final String SQLCONSULTA = "SELECT u.name, u.lastname, u.ID, u.phoneNumber, u.email FROM DB_UserUsers u";
    public static final String SQLINSERT = "INSERT INTO DB_UserUsers(ID, name, lastname, phoneNumber, email) VALUES (?, ?, ?, ?, ?)";
    public static final String SQLDELETEID = "DELETE FROM DB_UserUsers WHERE id = (?)";
    public static final String SQLACTUALIZAR = "UPDATE DB_UserUsers SET name = ?, lastname = ?, phoneNumber = ?, email = ? WHERE ID = ?";
    public static final String SQLCONSULTA_ID = "SELECT u.name, u.lastname, u.ID, u.phoneNumber, u.email FROM DB_UserUsers u WHERE u.ID = ?";

    public List<User> check() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet resultado = null;
        List<User> users = new ArrayList<>();
        try {
            con = DataBaseConnection.getConnection();
            ps = con.prepareStatement(SQLCONSULTA);
            resultado = ps.executeQuery();
            while (resultado.next()) {
                String nombre = resultado.getString("name");
                String apellido = resultado.getString("lastname");
                int cedula = resultado.getInt("ID");
                String telefono = resultado.getString("phoneNumber");
                String correo = resultado.getString("email");
                User_Client user = new User_Client(cedula, nombre, apellido, telefono, correo);
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                DataBaseConnection.close(resultado);
                DataBaseConnection.close(ps);
                DataBaseConnection.close(con);
            } catch (SQLException e) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        return users;
    }

    public User checkId(User user) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet resultado = null;
        User x = null;
        try {
            con = DataBaseConnection.getConnection();
            ps = con.prepareStatement(SQLCONSULTA_ID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            ps.setLong(1, user.getId());
            resultado = ps.executeQuery();
            resultado.absolute(1);
            String nombre = resultado.getString("name");
            String apellido = resultado.getString("lastname");
            int cedula = resultado.getInt("ID");
            String telefono = resultado.getString("phoneNumber");
            String correo = resultado.getString("email");
            x = new User_Client(cedula, nombre, apellido, telefono, correo);

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                DataBaseConnection.close(resultado);
                DataBaseConnection.close(ps);
                DataBaseConnection.close(con);
            } catch (SQLException e) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        return x;

    }

    public int create(User user) {
        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            con = DataBaseConnection.getConnection();
            ps = con.prepareStatement(SQLINSERT);
            ps.setLong(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getLastname());
            ps.setString(4, user.getphoneNumber());
            ps.setString(5, user.getEmail());
            registros = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                DataBaseConnection.close(ps);
                DataBaseConnection.close(con);
            } catch (SQLException e) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);

            }
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
            ps.setLong(1, user.getId());
            registros = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                DataBaseConnection.close(ps);
                DataBaseConnection.close(con);
            } catch (SQLException e) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);

            }
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
            ps.setString(3, user.getphoneNumber());
            ps.setString(4, user.getEmail());
            ps.setLong(5, user.getId());
            registros = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                DataBaseConnection.close(ps);
                DataBaseConnection.close(con);
            } catch (SQLException e) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        return registros;
    }
}