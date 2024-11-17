package Model.User;

import Model.Tools.ToolForString;

public class User implements ToolForString {
    private int ID; // number of the document (Cédula)
    private String name;
    private String lastname;
    private String number;
    private String email;

    public User() {
    }

    public User(int iD, String name, String lastname, String number, String email) {
        ID = iD;
        this.name = name;
        this.lastname = lastname;
        this.number = number;
        this.email = email;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("User:\n").append("\t" + ID + "\n").append("\t" + name + "\n");
        str.append("\t" + lastname + "\n").append("\t" + email + "\n");
        str.append("\t+" + decomposeNumber(number)[0]).append(" ").append(decomposeNumber(number)[1]);
        return str.toString();
    }

}
