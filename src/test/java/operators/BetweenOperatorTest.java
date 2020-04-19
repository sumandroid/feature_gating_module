package operators;

import cred.heimdall.operators.impl.BetweenOperator;
import exceptions.OperandCountException;
import exceptions.UnSupportedOperandTypeException;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class BetweenOperatorTest {
    private BetweenOperator betweenOperator = BetweenOperator.getInstance();

    @Test
    public void testSingleton(){
        BetweenOperator betweenOperator1 = BetweenOperator.getInstance();
        Assert.assertSame(betweenOperator1, betweenOperator);
    }

    @Test(expected = OperandCountException.class)
    public void testOperate(){
        Queue<Object> operands = new LinkedList<>();
        operands.add(15);
        operands.add(10);
        operands.add(20);
        Assert.assertEquals(betweenOperator.operate(operands), true);

        operands.add(15);
        operands.add(10);
        operands.add(5);
        Assert.assertEquals(betweenOperator.operate(operands), false);

        operands.add(18);
        Assert.assertEquals(betweenOperator.operate(operands), false); //throws exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgument(){
        Queue<Object> operands = new LinkedList<>();
        operands.add(15);
        operands.add(10);
        operands.add(20f);
        Assert.assertEquals(betweenOperator.operate(operands), true);
    }

    @Test(expected = UnSupportedOperandTypeException.class)
    public void testUnSupportedOperands(){
        Queue<Object> operands = new LinkedList<>();
        operands.add("15");
        operands.add(10);
        operands.add(20);
        Assert.assertEquals(betweenOperator.operate(operands), true);
    }
}
