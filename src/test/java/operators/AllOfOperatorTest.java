package operators;
import cred.heimdall.operators.impl.AllOfOperator;
import exceptions.OperandCountException;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class AllOfOperatorTest {
    private AllOfOperator allOfOperator = AllOfOperator.getInstance();

    @Test
    public void testSingleton(){
        AllOfOperator allOfOperator2 = AllOfOperator.getInstance();
        Assert.assertSame(allOfOperator, allOfOperator2);
    }

    @Test(expected = OperandCountException.class)
    public void testOperate(){
        Queue<Object> operands = new LinkedList<>();
        operands.add(true);
        operands.add(true);
        operands.add(true);
        Boolean res = (Boolean) allOfOperator.operate(operands);
        Assert.assertEquals(res, true);

        operands.add(true);
        res = (Boolean) allOfOperator.operate(operands);
        Assert.assertEquals(res, true);

        operands.add(true);
        operands.add(true);
        operands.add(false);
        res = (Boolean) allOfOperator.operate(operands);
        Assert.assertEquals(res, false); //throws exception
    }
}
