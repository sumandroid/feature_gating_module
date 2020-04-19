package domain.model;

import cred.heimdall.constants.Gender;
import cred.heimdall.domain.models.User;
import org.junit.Assert;
import org.junit.Test;

public class UserTest {
    private User user;

    @Test
    public void testUserCreate(){
        user = new User();
        String name = "Suman Saurabh";
        String email = "sumansaurabh93s@gmail.com";
        String phone = "8505947133";
        String address = "Sobha Mayflower, Bellandur";
        int pincode = 560103;
        Gender gender = Gender.Male;
        int age = 25;
        String city = "Bengaluru";
        String state = "Karnataka";
        float pastOrderAmount = 1000;
        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        user.setAddress(address);
        user.setPincode(pincode);
        user.setGender(gender);
        user.setAge(age);
        user.setCity(city);
        user.setState(state);
        user.setPastOrderAmount(pastOrderAmount);
        Assert.assertEquals(user.getName(), name);
        Assert.assertEquals(user.getEmail(), email);
        Assert.assertEquals(user.getPhone(), phone);
        Assert.assertEquals(user.getAddress(), address);
        Assert.assertEquals(user.getPincode(), pincode);
        Assert.assertEquals(user.getGender(), gender);
        Assert.assertEquals(user.getAge(), age);
        Assert.assertEquals(user.getCity(), city);
        Assert.assertEquals(user.getState(), state);
        Assert.assertEquals(user.getPastOrderAmount(), pastOrderAmount, 0.0001);
        Assert.assertEquals(user.getActive(), true);
    }
}
