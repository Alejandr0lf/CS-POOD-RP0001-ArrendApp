package Model.User;

import Model.Tools.ToolForString;

public abstract class User implements ToolForString {
    private long ID; // number of the document (Cédula)
    private String name;
    private String lastname;
    private String number;
    private String email;

    public User() {
    }

    public User(long iD, String name, String lastname, String num, String email) {
        if (isValidMovile(num)) {
            ID = iD;
            this.number = num;
            this.name = name;
            this.lastname = lastname;
            this.email = email;
        }else{
            throw new RuntimeException("Error creando el usuario... Número incorrecto " + num);
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(this.getClass().getSimpleName() + "\n").append("\tCédula: " + ID + "\n");
        str.append("\tName: " + name + " ").append(lastname + "\n");
        str.append("\tEmail: " + email + "\n").append("\t" + this.number);
        return str.toString();
    }

    public long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
