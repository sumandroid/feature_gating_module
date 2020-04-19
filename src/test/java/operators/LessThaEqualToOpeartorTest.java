package operators;

import cred.heimdall.operators.impl.LessThanEqualToOperator;
import exceptions.OperandCountException;
import exceptions.UnSupportedOperandTypeException;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class LessThaEqualToOpeartorTest {
    private LessThanEqualToOperator lessThanEqualToOperator = LessThanEqualToOperator.getInstance();

    @Test
    public void testSingleton(){
        LessThanEqualToOperator lessThanEqualToOperator1 = LessThanEqualToOperator.getInstance();
        Assert.assertSame(lessThanEqualToOperator1, lessThanEqualToOperator);
    }

    @Test(expected = OperandCountException.class)
    public void testOperate(){
        Queue<Object> operands = new LinkedList<>();
        operands.add(8);
        operands.add(8);
        Assert.assertEquals(lessThanEqualToOperator.operate(operands), true);

        operands.add(10);
        operands.add(9);
        Assert.assertEquals(lessThanEqualToOperator.operate(operands), false);

        operands.add(10);
        operands.add(9);
        operands.add(10);
        operands.add(9);
        Assert.assertEquals(lessThanEqualToOperator.operate(operands), true); //throws exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgument(){
        Queue<Object> operands = new LinkedList<>();
        operands.add(15);
        operands.add("20f");
        Assert.assertEquals(lessThanEqualToOperator.operate(operands), true);

        operands.add("15");
        operands.add(20f);
        Assert.assertEquals(lessThanEqualToOperator.operate(operands), true);

        operands.add("15");
        operands.add(null);
        Assert.assertEquals(lessThanEqualToOperator.operate(operands), true);
    }

    @Test(expected = UnSupportedOperandTypeException.class)
    public void testUnSupportedOperands(){
        Queue<Object> operands = new LinkedList<>();
        operands.add("15");
        operands.add(10);
        Assert.assertEquals(lessThanEqualToOperator.operate(operands), true);
    }


}
