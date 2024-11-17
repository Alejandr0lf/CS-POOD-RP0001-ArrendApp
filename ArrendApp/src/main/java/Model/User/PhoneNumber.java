package Model.User;

public class PhoneNumber {
    
    private long code;
    private long number;

    public PhoneNumber() {
    }

    public PhoneNumber(long code, long number) {
        this.code = code;
        this.number = number;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "PhoneNumber: +" + code + " " + number;
    }

    
}
