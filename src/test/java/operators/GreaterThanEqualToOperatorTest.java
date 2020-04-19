package operators;

import cred.heimdall.operators.impl.GreaterThanEqualToOperator;
import exceptions.OperandCountException;
import exceptions.UnSupportedOperandTypeException;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class GreaterThanEqualToOperatorTest {
    private GreaterThanEqualToOperator greaterThanEqualToOperator = GreaterThanEqualToOperator.getInstance();

    @Test
    public void testSingleton(){
        GreaterThanEqualToOperator greaterThanEqualToOperator1 = GreaterThanEqualToOperator.getInstance();
        Assert.assertSame(greaterThanEqualToOperator1, greaterThanEqualToOperator);
    }

    @Test(expected = OperandCountException.class)
    public void testOperate(){
        Queue<Object> operands = new LinkedList<>();
        operands.add(10);
        operands.add(10);
        Assert.assertEquals(greaterThanEqualToOperator.operate(operands), true);

        operands.add(10);
        operands.add(11f);
        Assert.assertEquals(greaterThanEqualToOperator.operate(operands), false);

        operands.add(10);
        operands.add(11);
        operands.add(10);
        operands.add(11);
        Assert.assertEquals(greaterThanEqualToOperator.operate(operands), true); //throws exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgument(){
        Queue<Object> operands = new LinkedList<>();
        operands.add(15);
        operands.add("20f");
        Assert.assertEquals(greaterThanEqualToOperator.operate(operands), true);

        operands.add("15");
        operands.add(20f);
        Assert.assertEquals(greaterThanEqualToOperator.operate(operands), true);

        operands.add("15");
        operands.add(null);
        Assert.assertEquals(greaterThanEqualToOperator.operate(operands), true);
    }

    @Test(expected = UnSupportedOperandTypeException.class)
    public void testUnSupportedOperands(){
        Queue<Object> operands = new LinkedList<>();
        operands.add("15");
        operands.add(10);
        Assert.assertEquals(greaterThanEqualToOperator.operate(operands), true);
    }
}
