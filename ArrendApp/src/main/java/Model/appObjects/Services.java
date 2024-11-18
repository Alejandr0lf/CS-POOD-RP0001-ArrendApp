package Model.appObjects;

public class Services {
    
    private boolean wifi;
    private boolean ater;
    private boolean electricity;
    private boolean administration;
    private boolean gas;

    public Services() {
    }

    public Services(boolean wifi, boolean ater, boolean electricity, boolean administration, boolean gas) {
        this.wifi = wifi;
        this.ater = ater;
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

    public boolean isAter() {
        return ater;
    }

    public void setAter(boolean ater) {
        this.ater = ater;
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

    
}
