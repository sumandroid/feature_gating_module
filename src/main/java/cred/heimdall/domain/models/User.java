package cred.heimdall.domain.models;

import cred.heimdall.constants.Gender;

public class User extends Person{

    private float pastOrderAmount;
    private Boolean active;

    public User(String name, String email, String phone, String address, int pincode,
                float pastOrderAmount, Gender gender) {
        super(name, email, phone, address, pincode, gender);
        this.pastOrderAmount = pastOrderAmount;
        this.active = true;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString())
                .append("pastOrderAmount: ")
                .append(pastOrderAmount).append("\n");
        stringBuilder.append("active: ").append(active);
        return stringBuilder.toString();
    }

}
