package cred.heimdall;

import cred.heimdall.constants.Gender;
import cred.heimdall.domain.models.User;

public class Main {

    public static void main(String []args){
        System.out.println("Welcome to heimdall! A feature gating module \n");
        User user = new User("suman saurabh",
                "sumansaurabh93s@gmail.com",
                "8505947133",
                "Sobha Mayflower, Bellandur, Bengaluru",
                560103,
                10000,
                Gender.MALE);

        System.out.println("User: {\n" + user.toString() + "\n}");

    }
}
