package Model.appObjects;

import java.time.LocalDate;
import Model.User.User_Client;
import Model.User.User_Comercial;

public class Rent {
    private int ID;
    private Building building;
    private User_Comercial Landlord;
    private User_Client tenant;
    private int price;
    private LocalDate initDate;
    private LocalDate endgDate;

    public Rent() {
    }

    public Rent(int iD, Building bld, User_Comercial lrd, User_Client tnt, int price, LocalDate iDate,
            LocalDate eDate) {
        ID = iD;
        this.building = bld;
        this.Landlord = lrd;
        this.tenant = tnt;
        this.price = price;
        this.initDate = iDate;
        this.endgDate = eDate;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public User_Comercial getLandlord() {
        return Landlord;
    }

    public void setLandlord(User_Comercial landlord) {
        Landlord = landlord;
    }

    public User_Client getTenant() {
        return tenant;
    }

    public void setTenant(User_Client tenant) {
        this.tenant = tenant;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getInitDate() {
        return initDate;
    }

    public void setInitDate(LocalDate initDate) {
        this.initDate = initDate;
    }

    public LocalDate getEndgDate() {
        return endgDate;
    }

    public void setEndgDate(LocalDate endgDate) {
        this.endgDate = endgDate;
    }

    
}
