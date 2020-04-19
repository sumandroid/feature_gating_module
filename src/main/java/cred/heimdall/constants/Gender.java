package cred.heimdall.constants;

public enum Gender {
    Male("Male"), Female("Female");

    String value;

    Gender(String value) {
        this.value = value;
    }

    public static String value(Gender gender){
        return gender.value;
    }

    @Override
    public String toString(){
        return value;
    }
}
