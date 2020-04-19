package processors;

import cred.heimdall.processors.InfixToPostfix;
import org.junit.Assert;
import org.junit.Test;

public class InfixToPostfixTest {
    private InfixToPostfix infixToPostfix = InfixToPostfix.getInstance();
    @Test
    public void testConvert(){
        String condition = "age between 20 30 and ( city == Delhi or city == Mumbai ) and pastOrderAmount >= 1000";
        String postFix = "age 20 30 between city Delhi == city Mumbai == or and pastOrderAmount 1000 >= and ";
        Assert.assertEquals(infixToPostfix.convert(condition), postFix);
        condition = "( age allof ( 10 20 ) and city nof ( Delhi Mumbai ) ) || pastOrderAmount >= 1000";
        postFix = "age 10 20 allof city Delhi Mumbai nof and pastOrderAmount 1000 >= || ";
        Assert.assertEquals(infixToPostfix.convert(condition), postFix);
    }
}
