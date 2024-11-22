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
import DataBase.DBServices.DirectionService;
import DataBase.DBServices.ServicesService;
import DataBase.DBServices.UserComercialService;
import Model.User.User_Comercial;
import Model.appObjects.Building;
import Model.appObjects.Direction;
import Model.appObjects.Services;

public class BuildingDAO {
    public static final String SQLCHECK = "SELECT ub.ID as buildingID, ub.landlord, ub.levels, ub.rooms, ub.bathrooms, ub.score, ub.equiped, ub.hasCook, ub.includedServices, ub.available,bd.adress, bd.coordinates, bd.neighborhood, bd.city,uu.name, uu.lastName, uu.phoneNumber, uu.email FROM DB_UserBuildings ub, DB_BuildingsServices bs, DB_BuildingDirection bd, DB_UserComercial uc, DB_UserUsers uu WHERE uu.ID = uc.ID AND ub.services = bs.ID AND ub.direction = bd.coordinates AND uc.ID = ub.landlord";

            //Primero creamos el servicio con el id del Building
            //Después creamos la dirección con las coordenadas del Building
            //Podemos crear el Building -> null
            //ServicioCrearUsuarioComercial() -> x
            //Building.setLandlord(x)

            //ServiceComercial -> búsque -> landlord RETURN UserComercial
            //New Building(ID, lanlord....);


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

    public List<Building> check() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet result = null;
        List<Building> buildings = new ArrayList<>();
        try {
            con = DataBaseConnection.getConnection();
            ps = con.prepareStatement(SQLCHECK);
            result = ps.executeQuery();
            while (result.next()) {

                /* ---------------------------- crear el Servicio --------------------------- */
                ServicesService srv = new ServicesService();
                Services serv = new Services(result.getLong("buildingID"));
                Services service = srv.checkId(serv);

                /* --------------------------- crear la direccion --------------------------- */
                DirectionService drt = new DirectionService();
                Direction dirt = new Direction(result.getString("coordinates"));
                Direction direction = drt.checkId(dirt);

                /* -------------------------- crear user comercial -------------------------- */
                User_Comercial dbUser = new User_Comercial(String.valueOf(result.getLong("landlord")));
                UserComercialService cService = new UserComercialService();
                User_Comercial comercial = cService.checkId(dbUser);

                // /* ---------------------------- Crear el building --------------------------- */
                long id = result.getLong("BuildingID");
                int levels = result.getInt("levels");
                int rooms = result.getInt("rooms");
                int bathrooms = result.getInt("bathrooms");
                int score = result.getInt("score");
                boolean equiped = result.getBoolean("equiped");
                boolean hasCook = result.getBoolean("hasCook");
                boolean includedServices = result.getBoolean("includedServices");
                boolean available = result.getBoolean("available");

                Building building = new Building(id, comercial, direction, levels, rooms, bathrooms, score, equiped,
                        hasCook, includedServices, available, service);

                buildings.add(building);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuildingDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BuildingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return buildings;
    }

    // public int create(User user) {
    // Connection con = null;
    // PreparedStatement ps = null;
    // int registros = 0;
    // try {
    // con = DataBaseConnection.getConnection();
    // ps = con.prepareStatement(SQLINSERT);
    // ps.setLong(1, user.getID());
    // ps.setString(2, user.getName());
    // ps.setString(3, user.getLastname());
    // ps.setString(4, user.getNumber());
    // ps.setString(5, user.getEmail());
    // registros = ps.executeUpdate();
    // } catch (SQLException ex) {
    // Logger.getLogger(BuildingDAO.class.getName()).log(Level.SEVERE, null, ex);
    // } catch (ClassNotFoundException ex) {
    // Logger.getLogger(BuildingDAO.class.getName()).log(Level.SEVERE, null, ex);
    // }
    // return registros;
    // }

    // public int delete(User user) {
    // Connection con = null;
    // PreparedStatement ps = null;
    // int registros = 0;
    // try {
    // con = DataBaseConnection.getConnection();
    // ps = con.prepareStatement(SQLDELETEID);
    // ps.setLong(1, user.getID());
    // registros = ps.executeUpdate();
    // } catch (SQLException ex) {
    // Logger.getLogger(BuildingDAO.class.getName()).log(Level.SEVERE, null, ex);
    // } catch (ClassNotFoundException ex) {
    // Logger.getLogger(BuildingDAO.class.getName()).log(Level.SEVERE, null, ex);
    // }
    // return registros;
    // }

    // public int update(User user) {
    // Connection con = null;
    // PreparedStatement ps = null;
    // int registros = 0;

    // try {
    // con = DataBaseConnection.getConnection();
    // ps = con.prepareStatement(SQLACTUALIZAR);

    // ps.setString(1, user.getName());
    // ps.setString(2, user.getLastname());
    // ps.setString(3, user.getNumber());
    // ps.setString(4, user.getEmail());
    // ps.setLong(5, user.getID());
    // registros = ps.executeUpdate();

    // } catch (SQLException ex) {
    // Logger.getLogger(BuildingDAO.class.getName()).log(Level.SEVERE, null, ex);
    // } catch (ClassNotFoundException ex) {
    // Logger.getLogger(BuildingDAO.class.getName()).log(Level.SEVERE, null, ex);
    // }
    // return registros;
    // }
}
