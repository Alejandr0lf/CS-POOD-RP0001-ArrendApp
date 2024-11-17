package Model.User;

import java.util.ArrayList;
import Model.appObjects.Building;
import Model.appObjects.Rent;

public class User_Client extends User {

    private ArrayList<Rent> activeRented;

    /* -------------------------------------------------------------------------- */
    /* Construtors */
    /* -------------------------------------------------------------------------- */

    public User_Client() {
    }

    public User_Client(long iD, String name, String lastname, String number, String email) {
        super(iD, name, lastname, number, email);
    }

    /* -------------------------------------------------------------------------- */
    /* Public Methods */
    /* -------------------------------------------------------------------------- */

    public void rentProperty(Building building){

    }

}
