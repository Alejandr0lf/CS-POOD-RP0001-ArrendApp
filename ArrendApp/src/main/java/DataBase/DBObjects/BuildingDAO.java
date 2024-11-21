package DataBase.DBObjects;

public class BuildingDAO {
    public static final String SQLCHECK = "SELECT ub.ID as BuildingID, ub.landlord, ub.levels, ub.rooms, ub.bathrooms, ub.score, ub.equiped, ub.hasCook, ub.includedServices, ub.services, ub.available, ub.direction, "
            + "bs.ID as ServiceID, bs.wifi, bs.water, bs.electricity, bs.gas, bs.administration, "
            + "bd.adress, bd.coordinates, bd.neighborhood, bd.city, uc.ID as UserID, uc.building "
            + "FROM DB_UserBuildings ub, DB_BuildingsServices bs, DB_BuildingDirection bd, DB_UserComercial uc"
            + "WHERE ub.landlord = uc.ID AND ub.services = bs.ID AND ub.direction = bd.adress;";

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

    // public List<Building> consultar() {
    //     Connection con = null;
    //     PreparedStatement ps = null;
    //     ResultSet result = null;
    //     List<Building> buildings = new ArrayList<>();
    //     try {
    //         con = DataBaseConnection.getConnection();
    //         ps = con.prepareStatement(SQLCHECK);
    //         result = ps.executeQuery();
    //         while (result.next()) {

    //             // Esto es para crearla
    //             // Traer datos del servicio -> crear el servicio
    //             // Traer datos de la dirección -> Crear dirección
    //             // Crear el UserCliente con propidad en null
    //             // Crear el Building con Propietario
    //             // Seterar la propiedad del User_Comercial
    //             // Usar el ServiceCreate(X) para User_Comercial y para la Propiedad

    //             /* ---------------------------- crear el Servicio --------------------------- */
    //             boolean wifi = result.getBoolean("wifi");
    //             boolean water = result.getBoolean("water");
    //             boolean eletricity = result.getBoolean("electricity");
    //             boolean administration = result.getBoolean("administration");
    //             boolean gas = result.getBoolean("gas");
    //             Services service = new Services(result.getLong("BuildingID"), wifi, water, eletricity, administration,
    //                     gas);

    //             /* --------------------------- crear la direccion --------------------------- */
    //             String adress = result.getString("adress");
    //             String coordinates = result.getString("coordinates");
    //             String neighborhood = result.getString("neighborhood");
    //             String city = result.getString("city");
    //             Direction direction = new Direction(adress, coordinates, neighborhood, city);

    //             /* -------------------------- crear user comercial -------------------------- */
    //             User_Comercial dbUser = new User_Comercial(String.valueOf(result.getLong("landlord")));
    //             UserComercialService cService = new UserComercialService(); // funcionará cuando UserComercialService
    //                                                                         // esté creado
    //             User_Comercial comercial = cService.checkId(dbUser);

    //             /* ---------------------------- Crear el building --------------------------- */
    //             long id = result.getLong("BuildingID");
    //             int levels = result.getInt("levels");
    //             int rooms = result.getInt("rooms");
    //             int bathrooms = result.getInt("bathrooms");
    //             int score = result.getInt("score");
    //             boolean equiped = result.getBoolean("equiped");
    //             boolean hasCook = result.getBoolean("hasCook");
    //             boolean includedServices = result.getBoolean("includedServices");
    //             boolean available = result.getBoolean("available");

    //             Building building = new Building(comercial, direction, levels, rooms, bathrooms, score, equiped,
    //                     hasCook, includedServices, available, service);

    //             buildings.add(building);

    //         }
    //     } catch (SQLException ex) {
    //         Logger.getLogger(BuildingDAO.class.getName()).log(Level.SEVERE, null, ex);
    //     } catch (ClassNotFoundException ex) {
    //         Logger.getLogger(BuildingDAO.class.getName()).log(Level.SEVERE, null, ex);
    //     }
    //     return buildings;
    // }

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
