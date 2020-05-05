package cred.heimdall.domain.models;

import cred.heimdall.constants.Gender;

import javax.swing.text.html.parser.TagElement;

public class User extends Person{

    private float pastOrderAmount;
    private Boolean active;

    public User(){
    }

    private User(Builder builder){
        name = builder.name;
        email = builder.email;
        phone = builder.phone;
        address = builder.address;
        pincode = builder.pincode;
        gender = builder.gender;
        age = builder.age;
        city = builder.city;
        state = builder.state;
        pastOrderAmount = builder.pastOrderAmount;
        active = builder.active;
    }

    public float getPastOrderAmount() {
        return pastOrderAmount;
    }

    public void setPastOrderAmount(float pastOrderAmount) {
        this.pastOrderAmount = pastOrderAmount;
    }

    public Boolean getActive() {
        return active;
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

    public static class Builder extends Person{
        private float pastOrderAmount;
        private Boolean active;

        public Builder(){
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Builder phone(String phone){
            this.phone = phone;
            return this;
        }

        public Builder address(String address){
            this.address = address;
            return this;
        }

        public Builder pincode(int pincode){
            this.pincode = pincode;
            return this;
        }

        public Builder gender(Gender gender){
            this.gender = gender;
            return this;
        }

        public Builder age (int age){
            this.age = age;
            return this;
        }

        public Builder city(String city){
            this.city = city;
            return this;
        }

        public Builder state(String state){
            this.state = state;
            return this;
        }

        public Builder pastOrderAmount(float pastOrderAmount){
            this.pastOrderAmount = pastOrderAmount;
            return this;
        }

        public Builder active(boolean active){
            this.active = active;
            return this;
        }

        public User build(){
            return new User(this);
        }



    }

}
