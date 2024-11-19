package Model.User;

import java.util.ArrayList;
import Model.appObjects.Building;
import Model.appObjects.Rent;
import Model.appObjects.Request;

@SuppressWarnings("unused")
public class User_Client extends User {

    
    private ArrayList<Rent> activeRented;

    /* -------------------------------------------------------------------------- */
    /* Construtors */
    /* -------------------------------------------------------------------------- */

    public User_Client() {
    }

    public User_Client(long id, String name, String lastname, String number, String email) {
        super(id, name, lastname, number, email);
    }

    /* -------------------------------------------------------------------------- */
    /* Public Methods */
    /* -------------------------------------------------------------------------- */

    /**
     * Este método debe enviar una solicitud (Request) al dueño (User_Comercial), y,
     * si esta se envía con éxito,se añade un nuevo alquiler (Rent) a la lista
     * activeRented.
     * 
     * @param building
     * @return
     */
    public Request rentProperty(Building building) {
        return new Request(this, building);
    }

    
}
