package cred.heimdall;

import cred.heimdall.constants.Gender;
import cred.heimdall.domain.models.User;
import cred.heimdall.evaluators.Context;
import cred.heimdall.serializers.ObjectToMapSerializer;
import cred.heimdall.serializers.impl.UserObjSerializer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to heimdall! A feature gating module \n");
        System.out.println("press 1 to evaluate features and press 2 to exit the program.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        User user = new User("suman saurabh",
                "sumansaurabh93s@gmail.com",
                "8505947133",
                "Sobha Mayflower, Bellandur, Bengaluru",
                560103,
                10000,
                Gender.Male);
        ObjectToMapSerializer objectToMapSerializer = new UserObjSerializer();
        Context context = new Context(user, objectToMapSerializer);
        if (!input.equals("2")) {
            while (true) {
                System.out.println("Using dummy user: ");
                System.out.println("User: {\n" + user.toString() + "\n}");
                System.out.println("Enter feature name");
                String featureName = scanner.nextLine();
                System.out.println("Enter condition");
                String condition = scanner.nextLine();
                processFeatureCondition(featureName.trim(), condition.trim(), context);
            }
        }
        System.out.println("Program exiting....");
    }

    private static void processFeatureCondition(String featureName, String condition, Context context){

    }
}
