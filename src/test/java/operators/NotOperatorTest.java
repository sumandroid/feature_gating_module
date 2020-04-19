package operators;

import cred.heimdall.operators.impl.NotOperator;
import exceptions.OperandCountException;
import exceptions.UnSupportedOperandTypeException;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class NotOperatorTest {
    private NotOperator notOperator = NotOperator.getInstance();

    @Test
    public void testSingleton(){
        NotOperator notOperator1 = NotOperator.getInstance();
        Assert.assertSame(notOperator1, notOperator);
    }

    @Test(expected = OperandCountException.class)
    public void testOperate(){
        Queue<Object> operands = new LinkedList<>();
        operands.add(true);
        Assert.assertEquals(notOperator.operate(operands), false);

        operands.add(false);
        Assert.assertEquals(notOperator.operate(operands), true);

        operands.add(false);
        operands.add(false);
        Assert.assertEquals(notOperator.operate(operands), true); //throws exception
    }

    @Test(expected = UnSupportedOperandTypeException.class)
    public void testOperandSupport(){
        Queue<Object> operands = new LinkedList<>();
        operands.add(true);
        Assert.assertEquals(notOperator.operate(operands), false);

        operands.add("true");
        Assert.assertEquals(notOperator.operate(operands), false); //throws error
    }

    @Test(expected = UnSupportedOperandTypeException.class)
    public void testUnSupportedOperands(){
        Queue<Object> operands = new LinkedList<>();
        operands.add("true");
        Assert.assertEquals(notOperator.operate(operands), true);
    }

}
