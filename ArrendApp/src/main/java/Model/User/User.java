package Model.User;

import Model.Tools.ToolForString;

public abstract class User implements ToolForString {
    private long id; // phoneNumberber of the document (Cédula)
    private String name;
    private String lastname;
    private String phoneNumber;
    private String email;

    public User() {
    }

    public User(String id){
        this.id = Long.valueOf(id);
    }

    public User(long iD, String name, String lastname, String phoneNumber, String email) {
        try {
            this.id = iD;
            this.phoneNumber = isValidMovile(phoneNumber);
            this.name = name;
            this.lastname = lastname;
            this.email = email;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(this.getClass().getSimpleName() + "\n").append("\tCédula: " + id + "\n");
        str.append("\tName: " + name + " ").append(lastname + "\n");
        str.append("\tEmail: " + email + "\n").append("\t" + this.phoneNumber);
        return str.toString();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getphoneNumber() {
        return phoneNumber;
    }

    public void setphoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
