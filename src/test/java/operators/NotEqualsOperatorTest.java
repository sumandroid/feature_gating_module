package operators;

import cred.heimdall.operators.impl.NotEqualsOperator;
import exceptions.OperandCountException;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class NotEqualsOperatorTest {
    private NotEqualsOperator notEqualsOperator = NotEqualsOperator.getInstance();

    @Test
    public void testSingleton(){
        NotEqualsOperator notEqualsOperator1 = NotEqualsOperator.getInstance();
        Assert.assertSame(notEqualsOperator1, notEqualsOperator);
    }

    @Test(expected = OperandCountException.class)
    public void testOperate(){
        Queue<Object> operands = new LinkedList<>();
        operands.add(10);
        operands.add(9);
        Assert.assertEquals(notEqualsOperator.operate(operands), true);

        operands.add(10);
        operands.add(10);
        Assert.assertEquals(notEqualsOperator.operate(operands), false);

        operands.add("10");
        operands.add(10);
        Assert.assertEquals(notEqualsOperator.operate(operands), true);

        operands.add(10);
        operands.add(9);
        operands.add(9);
        Assert.assertEquals(notEqualsOperator.operate(operands), true); //throws exception
    }
}
