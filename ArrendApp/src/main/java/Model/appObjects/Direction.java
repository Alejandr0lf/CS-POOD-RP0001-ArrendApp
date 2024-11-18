package Model.appObjects;

public class Direction {

    private String adress;
    private String coordinates;
    private String neighborhood;
    private String city;

    public Direction() {
    }

    public Direction(String adress, String coordinates, String neighborhood, String city) {
        this.adress = adress;
        this.coordinates = coordinates;
        this.neighborhood = neighborhood;
        this.city = city;
    }

    /* -------------------------------------------------------------------------- */
    /*                             Getters and Setters                            */
    /* -------------------------------------------------------------------------- */

    public String getAdress() {
        return adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }
    public String getCoordinates() {
        return coordinates;
    }
    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }
    public String getNeighborhood() {
        return neighborhood;
    }
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
}
