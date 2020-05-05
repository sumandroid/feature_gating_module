package cred.heimdall;

import cred.heimdall.constants.Gender;
import cred.heimdall.domain.models.User;
import cred.heimdall.evaluators.Context;
import cred.heimdall.evaluators.Evaluator;
import cred.heimdall.evaluators.impl.EvalPostFixToBool;
import cred.heimdall.serializers.ObjectToMapSerializer;
import cred.heimdall.serializers.impl.UserObjSerializer;
import cred.heimdall.utils.OperatorsHelpPrinter;
import cred.heimdall.utils.WelcomeScreenPrinter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        WelcomeScreenPrinter.print();
        Scanner scanner = new Scanner(System.in);
        while(true){
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("help")){
                OperatorsHelpPrinter.print();
            }else if(input.equals("1")){
                User user = new User.Builder().name("suman saurabh")
                        .email("suman.saurabh@gmail.com")
                        .phone("8505947133")
                        .address("sobha mayflower")
                        .pincode(560103)
                        .pastOrderAmount(10000.25f)
                        .gender(Gender.Male)
                        .age(25)
                        .city("Bengaluru")
                        .state("karnataka")
                        .active(true)
                        .build();
                System.out.println("Using dummy user: ");
                System.out.println("User: {\n" + user.toString() + "\n}");
                System.out.println("Enter feature name");
                String featureName = scanner.nextLine();
                System.out.println("Enter condition");
                String condition = scanner.nextLine();
                ObjectToMapSerializer objectToMapSerializer = new UserObjSerializer();
                Context context = new Context(user, objectToMapSerializer);
                processFeatureCondition(featureName.trim(), condition.trim(), context);
                System.out.println("enter 1 again to test the condition or exit to exit the program");
            }else{
                break;
            }
        }
        System.out.println("Program exiting....");
    }

    private static void processFeatureCondition(String featureName, String condition, Context context){
        try{
            Evaluator evaluator = new EvalPostFixToBool();
            boolean result = evaluator.eval(context, condition);
            if(result){
                System.out.println(context.getAttributeVal("name") +
                        " is allowed to use feature: " + featureName);
            }else{
                System.out.println(context.getAttributeVal("name") +
                        " is not allowed to use feature: " + featureName);
            }
        }catch (Exception e){
            System.out.println("Error while evaluating condition: " + e.getMessage() + e.getCause());
        }
    }
}
