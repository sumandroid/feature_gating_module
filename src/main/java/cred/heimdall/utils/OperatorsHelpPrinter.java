package cred.heimdall.utils;

public class OperatorsHelpPrinter {

    public static void print(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Please put space after every value and command including brackets").append("\n");
        stringBuilder.append("Operators available: ").append("\n");
        stringBuilder.append("AllOf ex: PinCode allof ( 560103 560102 )").append("\n");
        stringBuilder.append("And ex: Age >= 20 and PastOrderAmount >= 1000").append("\n");
        stringBuilder.append("Between ex: Age between ( 20 25 )").append("\n");
        stringBuilder.append("EqualsTo ex: Age == 25").append("\n");
        stringBuilder.append("GreaterThanEqualsTo ex: Age >= 25").append("\n");
        stringBuilder.append("GreaterThan ex: Age > 25").append("\n");
        stringBuilder.append("LessThanEqualTo ex: Age <= 25").append("\n");
        stringBuilder.append("LessThan ex: Age < 25").append("\n");
        stringBuilder.append("NoneOf ex: City nof ( Delhi Mumbai )").append("\n");
        stringBuilder.append("NotEquals ex: City != Delhi").append("\n");
        stringBuilder.append("Not ex: ! ( City == Delhi )").append("\n");
        stringBuilder.append("Or ex: Age > 25 || City == Delhi").append("\n");
        System.out.println(stringBuilder.toString());
    }

}
