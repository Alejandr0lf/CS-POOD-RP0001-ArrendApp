package Model.User;

import java.util.ArrayList;

import Model.appObjects.Rent;

public class User_Client extends User {

    private ArrayList<Rent> activeRented;

    public User_Client() {
    }

    public User_Client(int iD, String name, String lastname, String number, String email) {
        super(iD, name, lastname, number, email);
    }
    
}
