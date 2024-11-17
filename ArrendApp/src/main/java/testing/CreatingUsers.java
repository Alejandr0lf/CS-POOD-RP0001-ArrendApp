package testing;

import Model.User.User;

public class CreatingUsers {
    public static void main(String[] args) {
        User user1 = new User(10101010, "Roberto", "Ambriosio", "+57 311 393 6341", "ambrosio@nodomain.com");
        System.out.println(user1);
    }
}
