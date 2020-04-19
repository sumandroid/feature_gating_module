package processors;

import cred.heimdall.constants.Gender;
import cred.heimdall.domain.models.User;
import cred.heimdall.evaluators.Context;
import cred.heimdall.processors.InfixToPostfix;
import cred.heimdall.serializers.ObjectToMapSerializer;
import cred.heimdall.serializers.impl.UserObjSerializer;
import exceptions.InfixToPostfixException;
import exceptions.UnSupportedOperandTypeException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InfixToPostfixTest {
    private InfixToPostfix infixToPostfix = InfixToPostfix.getInstance();
    private Context context;

    @Before
    public void init(){
        User user = new User("suman saurabh",
                "sumansaurabh93s@gmail.com",
                "8505947133",
                "Sobha Mayflower, Bellandur, Bengaluru",
                560103,
                10000,
                Gender.Male,
                25,
                "Delhi",
                "Delhi");
        ObjectToMapSerializer serializer = new UserObjSerializer();
        context = new Context(user, serializer);
    }

    @Test(expected = Exception.class)
    public void testConvert(){
        String condition = "age between 20 30 and ( city == Delhi or city == Mumbai ) and pastOrderAmount >= 1000";
        String postFix = "age 20 30 between city Delhi == city Mumbai == or and pastOrderAmount 1000 >= and ";
        Assert.assertEquals(infixToPostfix.convert(condition), postFix);
        condition = "( age allof ( 10 20 ) and city nof ( Delhi Mumbai ) ) || pastOrderAmount >= 1000";
        postFix = "age 10 20 allof city Delhi Mumbai nof and pastOrderAmount 1000 >= || ";
        Assert.assertEquals(infixToPostfix.convert(condition), postFix);
    }

    @Test(expected = Exception.class)
    public void testEval(){
        String condition = "age between 20 30 and ( city == Delhi or city == Mumbai ) and pastOrderAmount >= 1000";
        String postFix = infixToPostfix.convert(condition);
        Assert.assertEquals(infixToPostfix.eval(postFix, context), true);
        condition = "( age allof ( 10 20 ) and city nof ( Delhi Mumbai ) ) || pastOrderAmount <= 1000";
        postFix = infixToPostfix.convert(condition);
        Assert.assertEquals(infixToPostfix.eval(postFix, context), false);
        condition = "( age allof ( 10 20 30 ) and city nof ( Delhi Mumbai ) ) || pastOrderAmount <= 1000 2000";
        postFix = infixToPostfix.convert(condition);
        Assert.assertEquals(infixToPostfix.eval(postFix, context), false);
    }


}
