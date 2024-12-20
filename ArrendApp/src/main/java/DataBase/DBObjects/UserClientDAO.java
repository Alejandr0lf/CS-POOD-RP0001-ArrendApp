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
import DataBase.DBServices.UserService;
import Model.User.User;
import Model.User.User_Client;

public class UserClientDAO {
    public static final String SQLCHECKALL = "SELECT u.ID, u.name, u.lastname, u.phoneNumber, u.email FROM DB_UserUsers u, DB_UserClient v WHERE u.ID = v.ID AND v.status";
    public static final String SQLCHECKID = "SELECT  u.ID, u.name, u.lastname, u.phoneNumber, u.email FROM DB_UserUsers u, DB_UserClient v WHERE u.ID = v.ID AND v.ID = (?)";
    public static final String SQLINSERT = "INSERT INTO DB_UserClient(ID) VALUE (?)";
    public static final String SQLDELETE = "UPDATE DB_UserClient SET status = 0 WHERE ID = (?)";
    public static final String SQLUPDATE = "UPDATE DB_UserUsers u JOIN DB_UserClient v ON u.ID = v.ID SET u.name = (?), u.lastname = (?), u.phoneNumber = (?), u.email = (?) WHERE v.ID = (?) AND v.status = TRUE";

    public List<User> check() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet resultado = null;
        List<User> users = new ArrayList<>();
        try {
            con = DataBaseConnection.getConnection();
            ps = con.prepareStatement(SQLCHECKALL);
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
            Logger.getLogger(UserClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                DataBaseConnection.close(resultado);
                DataBaseConnection.close(ps);
                DataBaseConnection.close(con);
            } catch (SQLException e) {
                Logger.getLogger(UserClientDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        return users;
    }

    public User_Client checkId(User_Client user) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet resultado = null;
        User_Client x = null;
        try {
            con = DataBaseConnection.getConnection();
            ps = con.prepareStatement(SQLCHECKID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            ps.setLong(1, user.getId());
            resultado = ps.executeQuery();
            resultado.absolute(1);
            int cedula = resultado.getInt("ID");
            String nombre = resultado.getString("name");
            String apellido = resultado.getString("lastname");
            String telefono = resultado.getString("phoneNumber");
            String correo = resultado.getString("email");
            x = new User_Client(cedula, nombre, apellido, telefono, correo);

        } catch (SQLException ex) {
            Logger.getLogger(UserClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                DataBaseConnection.close(resultado);
                DataBaseConnection.close(ps);
                DataBaseConnection.close(con);
            } catch (SQLException e) {
                Logger.getLogger(UserClientDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        return x;

    }

    public int create(User_Client user) {
        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            UserService service = new UserService();
            service.create(user);
            con = DataBaseConnection.getConnection();
            ps = con.prepareStatement(SQLINSERT);
            ps.setLong(1, user.getId());
            registros = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                DataBaseConnection.close(ps);
                DataBaseConnection.close(con);
            } catch (SQLException e) {
                Logger.getLogger(UserClientDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        return registros;
    }

    public int delete(User_Client user) {
        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            con = DataBaseConnection.getConnection();
            ps = con.prepareStatement(SQLDELETE);
            ps.setLong(1, user.getId());
            registros = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                DataBaseConnection.close(ps);
                DataBaseConnection.close(con);
            } catch (SQLException e) {
                Logger.getLogger(UserClientDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        return registros;
    }

    public int update(User_Client user) {
        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            con = DataBaseConnection.getConnection();
            ps = con.prepareStatement(SQLUPDATE);

            ps.setString(1, user.getName());
            ps.setString(2, user.getLastname());
            ps.setString(3, user.getphoneNumber());
            ps.setString(4, user.getEmail());
            ps.setLong(5, user.getId());

            registros = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                DataBaseConnection.close(ps);
                DataBaseConnection.close(con);
            } catch (SQLException e) {
                Logger.getLogger(UserClientDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        return registros;
    }
}