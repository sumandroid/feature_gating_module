package cred.heimdall.domain.models;

import cred.heimdall.constants.Gender;

public abstract class Person {
    private String name;
    private String email;
    private String phone;
    private String address;
    private int pincode;
    private Gender gender;

    public Person(String name, String email, String phone, String address, int pincode, Gender gender){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.pincode = pincode;
        this.gender = gender;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("name: ").append(name).append("\n");
        stringBuilder.append("email: ").append(email).append("\n");
        stringBuilder.append("phone: ").append(phone).append("\n");
        stringBuilder.append("address: ").append(address).append("\n");
        stringBuilder.append("pincode: ").append(pincode).append("\n");
        stringBuilder.append("gender: ").append(Gender.value(gender)).append("\n");
        return stringBuilder.toString();
    }
}
