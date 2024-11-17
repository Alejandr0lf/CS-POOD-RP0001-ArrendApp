package Model.User;

import Model.Tools.ToolForString;

public abstract class User implements ToolForString {
    private long ID; // number of the document (Cédula)
    private String name;
    private String lastname;
    private PhoneNumber number;
    private String email;

    public User() {
    }

    public User(long iD, String name, String lastname, String number, String email) {
        ID = iD;
        this.name = name;
        this.lastname = lastname;
        this.number = new PhoneNumber(decomposeNumber(number)[0], decomposeNumber(number)[1]);
        this.email = email;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(this.getClass().getSimpleName() + "\n").append("\tCédula: " + ID + "\n");
        str.append("\tName: " + name + " ").append(lastname + "\n");
        str.append("\tEmail: " + email + "\n").append("\t" + this.number);
        return str.toString();
    }

}
