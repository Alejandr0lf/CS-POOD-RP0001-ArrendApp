package Model.User;

import java.util.ArrayList;
import Model.appObjects.Building;
import Model.appObjects.Rent;

public class User_Comercial extends User {

    private ArrayList<Building> buildings;
    private ArrayList<Rent> activeRentals;

    public User_Comercial() {
    }

    public User_Comercial(int iD, String name, String lastname, String number, String email) {
        super(iD, name, lastname, number, email);
    }
    
}
