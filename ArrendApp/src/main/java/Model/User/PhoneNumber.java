package Model.User;

public class PhoneNumber {

    private short code;
    private long number;

    public PhoneNumber() {
    }

    public PhoneNumber(String num) {
        num.replaceAll("[^0-9]", "");
        num.substring(num.length() - 10); // Last 10 digits
        this.code = Short.valueOf(num);
        num.substring(0, num.length() - 10); // Country code
        this.number = Long.valueOf(code);
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
