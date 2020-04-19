package operators;

import cred.heimdall.operators.impl.GreaterThanOperator;
import exceptions.OperandCountException;
import exceptions.UnSupportedOperandTypeException;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class GreaterThanOperatorTest {
    private GreaterThanOperator greaterThanOperator = GreaterThanOperator.getInstance();

    @Test
    public void testSingleton(){
        GreaterThanOperator greaterThanOperator1 = GreaterThanOperator.getInstance();
        Assert.assertSame(greaterThanOperator1, greaterThanOperator);
    }

    @Test(expected = OperandCountException.class)
    public void testOperate(){
        Queue<Object> operands = new LinkedList<>();
        operands.add(10);
        operands.add(10);
        Assert.assertEquals(greaterThanOperator.operate(operands), false);

        operands.add(10);
        operands.add(9);
        Assert.assertEquals(greaterThanOperator.operate(operands), true);

        operands.add(10);
        operands.add(9);
        operands.add(10);
        operands.add(9);
        Assert.assertEquals(greaterThanOperator.operate(operands), true); //throws exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgument(){
        Queue<Object> operands = new LinkedList<>();
        operands.add(15);
        operands.add("20f");
        Assert.assertEquals(greaterThanOperator.operate(operands), true);

        operands.add("15");
        operands.add(20f);
        Assert.assertEquals(greaterThanOperator.operate(operands), true);

        operands.add("15");
        operands.add(null);
        Assert.assertEquals(greaterThanOperator.operate(operands), true);
    }

    @Test(expected = UnSupportedOperandTypeException.class)
    public void testUnSupportedOperands(){
        Queue<Object> operands = new LinkedList<>();
        operands.add("15");
        operands.add(10);
        Assert.assertEquals(greaterThanOperator.operate(operands), true);
    }
}
