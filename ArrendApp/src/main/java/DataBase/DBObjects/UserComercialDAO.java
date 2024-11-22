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
import Model.User.User_Comercial;

public class UserComercialDAO {
    public static final String SQLCHECKALL = "SELECT uc.ID as comercialID, uu.name, uu.lastName, uu.phoneNumber, uu.email FROM DB_UserUsers uu, DB_UserComercial uc WHERE uu.ID = uc.ID AND uc.status";
    public static final String SQLCHECKID = "SELECT uc.ID as comercialID, uu.name, uu.lastName, uu.phoneNumber, uu.email FROM DB_UserUsers uu, DB_UserComercial uc WHERE uu.ID = uc.ID AND uc.ID = (?) AND uc.status";
    public static final String SQLINSERT = "INSERT INTO DB_UserComercial(ID) VALUE (?)";
    public static final String SQLDELETE = "UPDATE DB_UserComercial SET status = 0 WHERE ID = (?)";
    public static final String SQLUPDATE = "UPDATE DB_UserUsers u JOIN DB_UserComercial v ON u.ID = v.ID SET u.name = (?), u.lastname = (?), u.phoneNumber = (?), u.email = (?) WHERE v.ID = (?) AND v.status = TRUE";

    public List<User_Comercial> check() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet resultado = null;
        List<User_Comercial> users = new ArrayList<>();
        try {
            con = DataBaseConnection.getConnection();
            ps = con.prepareStatement(SQLCHECKALL);
            resultado = ps.executeQuery();
            while (resultado.next()) {
                String nombre = resultado.getString("name");
                String apellido = resultado.getString("lastname");
                int cedula = resultado.getInt("comercialID");
                String telefono = resultado.getString("phoneNumber");
                String correo = resultado.getString("email");
                User_Comercial user = new User_Comercial(cedula, nombre, apellido, telefono, correo);
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    public User_Comercial checkId(User_Comercial user) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet resultado = null;
        User_Comercial x = null;
        try {
            con = DataBaseConnection.getConnection();
            ps = con.prepareStatement(SQLCHECKID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            ps.setLong(1, user.getId());
            resultado = ps.executeQuery();
            resultado.absolute(1);
            int cedula = resultado.getInt("comercialID");
            String nombre = resultado.getString("name");
            String apellido = resultado.getString("lastname");
            String telefono = resultado.getString("phoneNumber");
            String correo = resultado.getString("email");
            x = new User_Comercial(cedula, nombre, apellido, telefono, correo, null, null);

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;

    }

    // Validar si el usuario existe, si existe y está inactivo, se le cambia el
    // estado y se sobreescribe (update)
    public int create(User_Comercial user) {
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
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;
    }

    public int delete(User_Comercial user) {
        Connection con = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            con = DataBaseConnection.getConnection();
            ps = con.prepareStatement(SQLDELETE);
            ps.setLong(1, user.getId());
            registros = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;
    }

    public int update(User_Comercial user) {
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
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;
    }
}