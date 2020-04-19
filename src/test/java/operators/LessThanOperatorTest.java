package operators;

import cred.heimdall.operators.impl.LessThanOperator;
import exceptions.OperandCountException;
import exceptions.UnSupportedOperandTypeException;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class LessThanOperatorTest {
    private LessThanOperator lessThanOperator = LessThanOperator.getInstance();

    @Test
    public void testSingleton(){
        LessThanOperator lessThanOperator1 = LessThanOperator.getInstance();
        Assert.assertSame(lessThanOperator1, lessThanOperator);
    }

    @Test(expected = OperandCountException.class)
    public void testOperate(){
        Queue<Object> operands = new LinkedList<>();
        operands.add(8);
        operands.add(8);
        Assert.assertEquals(lessThanOperator.operate(operands), false);

        operands.add(7);
        operands.add(8);
        Assert.assertEquals(lessThanOperator.operate(operands), true);

        operands.add(10);
        operands.add(9);
        operands.add(10);
        Assert.assertEquals(lessThanOperator.operate(operands), true); //throws exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgument(){
        Queue<Object> operands = new LinkedList<>();
        operands.add(15);
        operands.add("20f");
        Assert.assertEquals(lessThanOperator.operate(operands), true);

        operands.add("15");
        operands.add(20f);
        Assert.assertEquals(lessThanOperator.operate(operands), true);

        operands.add("15");
        operands.add(null);
        Assert.assertEquals(lessThanOperator.operate(operands), true);
    }

    @Test(expected = UnSupportedOperandTypeException.class)
    public void testUnSupportedOperands(){
        Queue<Object> operands = new LinkedList<>();
        operands.add("15");
        operands.add(10);
        Assert.assertEquals(lessThanOperator.operate(operands), true);
    }
}
