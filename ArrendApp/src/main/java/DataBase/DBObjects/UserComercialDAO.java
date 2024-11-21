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
import Model.User.User_Comercial;
import Model.appObjects.Building;
import Model.appObjects.Direction;
import Model.appObjects.Services;

/* -------------------------------------------------------------------------- */
/*                         ATENCION ATENCION ATENCION                         */
/* -------------------------------------------------------------------------- */
/**
 * NO se ha podido añadir el objeto de tipo Building al constructor de
 * userComercial porque se encuentra incompleto. debe reemplazarse el null por
 * objetos válidos después
 */
public class UserComercialDAO {
    public static final String SQLCHECKALL = "SELECT ub.ID as BuildingID, ub.levels, ub.rooms, ub.bathrooms, ub.score, ub.equiped, ub.hasCook, ub.includedServices, ub.available, bs.ID as ServiceID, bs.wifi, bs.water, bs.electricity, bs.gas, bs.administration, bd.adress, bd.coordinates, bd.neighborhood, bd.city, uc.ID as UserID, uc.building, uu.name, uu.lastName, uu.phoneNumber, uu.email, uu.ID FROM DB_UserBuildings ub, DB_BuildingsServices bs, DB_BuildingDirection bd, DB_UserComercial uc, DB_UserUsers uu WHERE uu.ID = uc.ID AND uc.building = ub.ID AND ub.services = bs.ID AND ub.direction = bd.coordinates";

    // "SELECT ub.ID as BuildingID, ub.landlord, ub.levels, ub.rooms, ub.bathrooms, ub.score, ub.equiped, ub.hasCook, ub.includedServices, ub.services, ub.available, ub.direction, "
    //         + "bs.ID as ServiceID, bs.wifi, bs.water, bs.electricity, bs.gas, bs.administration, "
    //         + "bd.adress, bd.coordinates, bd.neighborhood, bd.city, "
    //         + "uc.ID as UserID, uc.building, "
    //         + "uu.name, uu.lastName, uu.phoneNumber, uu.email"
    //         + "FROM DB_UserBuildings ub, DB_BuildingsServices bs, DB_BuildingDirection bd, DB_UserComercial uc, DB_UserUsers uu"
    //         + "WHERE uu.ID = uc.ID AND uc.building = ub.ID AND ub.services = bs.ID AND ub.direction = bd.coordinates";

    // "SELECT v.ID as UserID, v.Building as BuildingID FROM DB_UserComercial v
    // WHERE v.ID = (?) AND v.status";

    // SELECT ub.ID as BuildingID, ub.landlord, ub.levels, ub.rooms, ub.bathrooms,
    // ub.score, ub.equiped, ub.hasCook, ub.includedServices, ub.services,
    // ub.available, ub.direction, bs.ID as ServiceID, bs.wifi, bs.water,
    // bs.electricity, bs.gas, bs.administration, bd.adress, bd.coordinates,
    // bd.neighborhood, bd.city, uc.ID as UserID, uc.building FROM DB_UserBuildings
    // ub, DB_BuildingsServices bs, DB_BuildingDirection bd, DB_UserComercial uc
    // WHERE ub.landlord = uc.ID AND ub.services = bs.ID AND ub.direction =
    // bd.adress;

    // public static final String SQLCHECKID = "SELECT u.ID, u.name, u.lastname,
    // u.phoneNumber, u.email FROM DB_UserUsers u, DB_UserClient v WHERE u.ID = v.ID
    // AND v.ID = (?)";
    // public static final String SQLINSERT = "INSERT INTO DB_UserClient(ID) VALUE
    // (?)";
    // public static final String SQLDELETE = "UPDATE DB_UserClient SET status = 0
    // WHERE ID = (?)";
    // public static final String SQLUPDATE = "UPDATE DB_UserUsers u JOIN
    // DB_UserClient v ON u.ID = v.ID SET u.name = (?), u.lastname = (?),
    // u.phoneNumber = (?), u.email = (?) WHERE v.ID = (?) AND v.status = TRUE";

    // consultar
    // consultarPorID
    //
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

                /* ---------------------------- datos de usuario ---------------------------- */
                String nombre = resultado.getString("name");
                String apellido = resultado.getString("lastname");
                int id_c = resultado.getInt("ID");
                String telefono = resultado.getString("phoneNumber");
                String correo = resultado.getString("email");
                User_Comercial landlord = new User_Comercial(id_c, nombre, apellido, telefono, correo);

                /* --------------------------- datos del servicio --------------------------- */
                long id_s = resultado.getLong("ServiceID");
                boolean wifi = resultado.getBoolean("wifi");
                boolean water = resultado.getBoolean("water");
                boolean electricity = resultado.getBoolean("electricity");
                boolean gas = resultado.getBoolean("gas");
                boolean administration = resultado.getBoolean("administration");
                Services service = new Services(id_s, wifi, water, electricity, administration, gas);

                /* -------------------------- datos de la direccion ------------------------- */
                String adress = resultado.getString("adress");
                String neighborhood = resultado.getString("neighborhood");
                String city = resultado.getString("neighborhood");
                String coordinates = resultado.getString("coordinates");
                Direction direction = new Direction(adress, coordinates, neighborhood, city);

                /* ---------------------------- datos de la casa ---------------------------- */
                //long bid = resultado.getLong("BuildingID");
                int levels = resultado.getInt("levels");
                int rooms = resultado.getInt("rooms");
                int bathrooms = resultado.getInt("bathrooms");
                int score = resultado.getInt("score");
                boolean equiped = resultado.getBoolean("equiped");
                boolean hasCook = resultado.getBoolean("hasCook");
                boolean includedServices = resultado.getBoolean("includedServices");
                boolean available = resultado.getBoolean("available");
                Building building = new Building(landlord, direction, levels, rooms, bathrooms, score, equiped, hasCook, includedServices, available, service);
                landlord.getBuildings().add(building);
                users.add(landlord);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    // public User_Client checkId(User_Client user) {
    // Connection con = null;
    // PreparedStatement ps = null;
    // ResultSet resultado = null;
    // User_Client x = null;
    // try {
    // con = DataBaseConnection.getConnection();
    // ps = con.prepareStatement(SQLCHECKID, ResultSet.TYPE_SCROLL_SENSITIVE,
    // ResultSet.TYPE_FORWARD_ONLY);
    // ps.setLong(1, user.getId());
    // resultado = ps.executeQuery();
    // resultado.absolute(1);
    // int cedula = resultado.getInt("ID");
    // String nombre = resultado.getString("name");
    // String apellido = resultado.getString("lastname");
    // String telefono = resultado.getString("phoneNumber");
    // String correo = resultado.getString("email");
    // x = new User_Client(cedula, nombre, apellido, telefono, correo);

    // } catch (SQLException ex) {
    // Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
    // } catch (ClassNotFoundException ex) {
    // Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
    // }
    // return x;

    // }

    // public int create(User_Client user) {
    // Connection con = null;
    // PreparedStatement ps = null;
    // int registros = 0;
    // System.out.println(user);
    // try {
    // UserService service = new UserService();
    // service.create(user);
    // con = DataBaseConnection.getConnection();
    // ps = con.prepareStatement(SQLINSERT);
    // ps.setLong(1, user.getId());
    // registros = ps.executeUpdate();
    // } catch (SQLException ex) {
    // Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
    // } catch (ClassNotFoundException ex) {
    // Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
    // }
    // return registros;
    // }

    // public int delete(User_Client user) {
    // Connection con = null;
    // PreparedStatement ps = null;
    // int registros = 0;
    // try {
    // con = DataBaseConnection.getConnection();
    // ps = con.prepareStatement(SQLDELETE);
    // ps.setLong(1, user.getId());
    // registros = ps.executeUpdate();
    // } catch (SQLException ex) {
    // Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
    // } catch (ClassNotFoundException ex) {
    // Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
    // }
    // return registros;
    // }

    // public int update(User_Client user) {
    // Connection con = null;
    // PreparedStatement ps = null;
    // int registros = 0;
    // try {
    // con = DataBaseConnection.getConnection();
    // ps = con.prepareStatement(SQLUPDATE);

    // ps.setString(1, user.getName());
    // ps.setString(2, user.getLastname());
    // ps.setString(3, user.getphoneNumber());
    // ps.setString(4, user.getEmail());
    // ps.setLong(5, user.getId());

    // registros = ps.executeUpdate();

    // } catch (SQLException ex) {
    // Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
    // } catch (ClassNotFoundException ex) {
    // Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
    // }
    // return registros;
    // }
}