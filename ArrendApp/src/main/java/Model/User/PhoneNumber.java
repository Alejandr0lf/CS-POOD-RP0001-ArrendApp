package Model.User;

public class PhoneNumber {
    
    private short  code;
    private long number;

    public PhoneNumber() {
    }

    public PhoneNumber(long code, long number) {
        this.code = (short) code;
        this.number = number;
    }

    public short getCode() {
        return code;
    }

    public void setCode(short code) {
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
