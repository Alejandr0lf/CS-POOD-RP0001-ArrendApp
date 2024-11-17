package testing;

import java.util.Scanner;

import Model.User.PhoneNumber;
import Model.User.User;
import Model.User.User_Client;

public class CreatingUsers {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        User user1 = new User_Client(10101010, "Roberto", "Ambriosio", "+57 311 393 6341", "ambrosio@nodomain.com");
        System.out.println(user1);

        PhoneNumber num = new PhoneNumber(scan.nextInt(), scan.nextInt());
        System.out.println(num);

    }
}
