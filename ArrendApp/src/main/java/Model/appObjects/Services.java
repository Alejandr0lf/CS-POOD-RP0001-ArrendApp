package Model.appObjects;

public class Services {

    private long id_s;
    private boolean wifi;
    private boolean water;
    private boolean electricity;
    private boolean administration;
    private boolean gas;

    public Services() {
    }

    public Services(long id_s){
        this.id_s = id_s;
    }

    public Services(long id_s, boolean wifi, boolean water, boolean electricity, boolean administration, boolean gas) {
        this.id_s = id_s;
        this.wifi = wifi;
        this.water = water;
        this.electricity = electricity;
        this.administration = administration;
        this.gas = gas;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isElectricity() {
        return electricity;
    }

    public void setElectricity(boolean electricity) {
        this.electricity = electricity;
    }

    public boolean isAdministration() {
        return administration;
    }

    public void setAdministration(boolean administration) {
        this.administration = administration;
    }

    public boolean isGas() {
        return gas;
    }

    public void setGas(boolean gas) {
        this.gas = gas;
    }

    public long getId_s() {
        return id_s;
    }

    public void setId_s(long id_s) {
        this.id_s = id_s;
    }
}
