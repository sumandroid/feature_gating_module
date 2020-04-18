package cred.heimdall.constants;

public enum Gender {
    MALE("Male"), FEMALE("Female");

    String value;

    Gender(String value) {
        this.value = value;
    }

    public static String value(Gender gender){
        return gender.value;
    }
}
