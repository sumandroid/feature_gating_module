package cred.heimdall.domain.models;

import cred.heimdall.constants.Gender;

public abstract class Person {
    protected String name;
    protected String email;
    protected String phone;
    protected String address;
    protected int pincode;
    protected Gender gender;
    protected int age;
    protected String city;
    protected String state;

    public Person(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
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
