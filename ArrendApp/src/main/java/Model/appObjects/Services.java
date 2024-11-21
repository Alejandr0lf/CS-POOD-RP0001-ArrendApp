package Model.appObjects;

public class Services {

    private long serviceId;
    private boolean wifi;
    private boolean water;
    private boolean electricity;
    private boolean administration;
    private boolean gas;

    public Services() {
    }

    public Services(long serviceId){
        this.serviceId = serviceId;
    }

    public Services(long serviceId, boolean wifi, boolean water, boolean electricity, boolean administration, boolean gas) {
        this.serviceId = serviceId;
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

    public long getServiceId() {
        return serviceId;
    }

    public void setServiceId(long serviceId) {
        this.serviceId = serviceId;
    }
}
