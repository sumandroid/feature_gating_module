package cred.heimdall.utils;

public class WelcomeScreenPrinter {

    public static void print(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Welcome to heimdall! A feature gating module").append("\n");
        stringBuilder.append("*********************************************").append("\n");
        stringBuilder.append("enter help to see all the commands available, 1 to start testing feature ")
                .append("and exit to exit the program");
        System.out.println(stringBuilder.toString());
    }
}
