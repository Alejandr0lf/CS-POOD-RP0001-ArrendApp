package Model.appObjects;

import java.util.ArrayList;
import java.util.HashMap;

import Model.User.User_Client;
import Model.User.User_Comercial;

public class Building {
    private int id;
    private User_Comercial landlord;
    private String direction;
    private int levels;
    private int rooms;
    private int bathrooms;
    private int score;
    private boolean equiped;
    private boolean hasCook;
    private boolean includedServices;
    private HashMap<String, Boolean> services; // Ejemplo: {"WiFi": true, "Luz": true}
    private ArrayList<User_Client> AllTenants;
    private boolean available;

    public Building(int id, User_Comercial landlord, String direction, int levels, int rooms, int bathrooms,
            boolean equiped, boolean hasCook, boolean includedServices, boolean available) {
        initServices();
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
        this.available = available;
    }

    // Constructor
    public Building(int id, User_Comercial landlord, String direction, int levels, int rooms, int bathrooms,
            boolean equiped, boolean hasCook, boolean includedServices, boolean available, boolean wifi, boolean water,
            boolean electricity, boolean gas, boolean security, boolean administration, boolean sewerage,
            boolean publicLight) {
        initServices(wifi, water, electricity, gas, security, administration, sewerage, publicLight);
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
        this.AllTenants = new ArrayList<>();
        this.available = available;
    }

    /* -------------------------------------------------------------------------- */
    /* Methods */
    /* -------------------------------------------------------------------------- */

    public void addscore(int score, User_Client cliente, String comentario) {
        if (score < 0 || score > 10) {
            throw new IllegalArgumentException("La puntuación debe estar entre 0 y 10.");
        }
        this.score = (this.score + score) / 2;
        System.out.println("Comentario del cliente: " + comentario);
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

    public void modifyService(String service, boolean status) {
        this.services.replace(service, status);
    }

    /* ----------------------------- Private methods ---------------------------- */

    private void initServices() {
        this.services = new HashMap<>();
        this.services.put("Wifi", false);
        this.services.put("Water", false);
        this.services.put("Electricity", false);
        this.services.put("Gas", false);
        this.services.put("Security", false);
        this.services.put("Administration", false);
        this.services.put("Sewerage", false);
        this.services.put("PublicLight", false);
    }

    private void initServices(boolean wifi, boolean water,
            boolean electricity, boolean gas, boolean security, boolean administration, boolean sewerage,
            boolean publicLight) {
        this.services = new HashMap<>();
        this.services.put("Wifi", wifi);
        this.services.put("Water", water);
        this.services.put("Electricity", electricity);
        this.services.put("Gas", gas);
        this.services.put("Security", security);
        this.services.put("Administration", administration);
        this.services.put("Sewerage", sewerage);
        this.services.put("PublicLight", publicLight);
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

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
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

    public HashMap<String, Boolean> getServices() {
        return services;
    }

    public void setServices(HashMap<String, Boolean> services) {
        this.services = services;
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

}
