package Model.appObjects;

import java.util.ArrayList;
import Model.User.User_Client;
import Model.User.User_Comercial;

public class Building {

    private int id;
    private User_Comercial landlord;
    private Direction direction;
    private int levels;
    private int rooms;
    private int bathrooms;
    private int score;
    private boolean equiped;
    private boolean hasCook;
    private boolean includedServices;
    private Services services;
    private ArrayList<User_Client> AllTenants;
    private boolean available;

    public Building() {
    }

    // Constructor
    public Building(int id, User_Comercial landlord, Direction direction, int levels, int rooms, int bathrooms,
            boolean equiped, boolean hasCook, boolean includedServices, boolean available, boolean wifi, boolean water,
            boolean electricity, boolean gas, boolean administration) {
        
        this.id = id;
        this.landlord = landlord;
        this.direction = direction;
        this.levels = levels;
        this.rooms = rooms;
        this.bathrooms = bathrooms;
        this.score = 0;
        this.equiped = equiped;
        this.hasCook = hasCook;
        this.includedServices = includedServices;
        this.services = new Services(wifi, water, electricity, administration, gas);
        this.AllTenants = new ArrayList<>();
        this.available = available;
    }

    /* -------------------------------------------------------------------------- */
    /* Methods */
    /* -------------------------------------------------------------------------- */

    public void addscore(int score, User_Client cliente, String comentario) {
        if (score < 0 || score > 10) {
            throw new IllegalArgumentException("The Score needs to be between 0 and 10.");
        }
        this.score = (this.score + score) / 2;
        System.out.println("Comment: " + comentario);
    }

    public void actualizarDatos(int levels, int rooms, int bathrooms, boolean equiped, boolean hasCook,
            boolean includedServices, boolean available) {
        this.levels = levels;
        this.rooms = rooms;
        this.bathrooms = bathrooms;
        this.equiped = equiped;
        this.hasCook = hasCook;
        this.includedServices = includedServices;
        this.available = available;
    }

    /* -------------------------------------------------------------------------- */
    /* Getters and Setters */
    /* -------------------------------------------------------------------------- */

    public User_Comercial getLandlord() {
        return landlord;
    }

    public void setLandlord(User_Comercial landlord) {
        this.landlord = landlord;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getLevels() {
        return levels;
    }

    public void setLevels(int levels) {
        this.levels = levels;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isEquiped() {
        return equiped;
    }

    public void setEquiped(boolean equiped) {
        this.equiped = equiped;
    }

    public boolean isHasCook() {
        return hasCook;
    }

    public void setHasCook(boolean hasCook) {
        this.hasCook = hasCook;
    }

    public boolean isIncludedServices() {
        return includedServices;
    }

    public void setIncludedServices(boolean includedServices) {
        this.includedServices = includedServices;
    }

    public ArrayList<User_Client> getAllTenants() {
        return AllTenants;
    }

    public void setAllTenants(ArrayList<User_Client> allTenants) {
        AllTenants = allTenants;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }
}
