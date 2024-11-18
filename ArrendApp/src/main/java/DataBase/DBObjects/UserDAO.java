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
    public static final String SQLCONSULTA = "SELECT u.nombre, u.apellido, u.cedula, u.telefono, u.correo FROM Usuario u";
    public static final String SQLCONSULTA_ID = "SELECT v.id, v.modelo, v.anio, v.color, v.descripcion, v.ubicacion, m.id as idmarca, m.nombre FROM vehicula v INNER JOIN marca m ON v.id_marca = m.id WHERE v.id = ?";
    public static final String SQLINSERT = "INSERT INTO vehicula(id, modelo, anio, color, descripcion, ubicacion, id_marca) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String SQLBORRAR = "DELETE FROM vehicula WHERE id = ?";
    public static final String SQLACTUALIZAR = "UPDATE vehicula SET modelo = ?, anio = ?, color = ?, descripcion = ?, ubicacion = ?, id_marca = ? WHERE id = ?";

    public List<User> consultar() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet resultado = null;
        List<User> Users = new ArrayList<>();
        try {
            con = DataBaseConnection.getConnection();
            ps = con.prepareStatement(SQLCONSULTA);
            resultado = ps.executeQuery();
            while (resultado.next()) {
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");
                int cedula = resultado.getInt("cedula");
                String telefono = resultado.getString("telefono");
                String correo = resultado.getString("correo");
                User_Client user = new User_Client(cedula, nombre, apellido, telefono, correo);
                Users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Users;
    }
}
