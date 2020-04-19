package operators;

import cred.heimdall.operators.impl.OrOperator;
import exceptions.OperandCountException;
import exceptions.UnSupportedOperandTypeException;
import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedList;
import java.util.Queue;

public class OrOperatorTest {
    private OrOperator orOperator = OrOperator.getInstance();

    @Test
    public void testSingleton(){
        OrOperator orOperator1 = OrOperator.getInstance();
        Assert.assertSame(orOperator1, orOperator);
    }

    @Test(expected = OperandCountException.class)
    public void testOperate(){
        Queue<Object> operands = new LinkedList<>();
        operands.add(true);
        operands.add(false);
        Assert.assertEquals(orOperator.operate(operands), true);

        operands.add(true);
        operands.add(true);
        Assert.assertEquals(orOperator.operate(operands), true);

        operands.add(false);
        operands.add(false);
        Assert.assertEquals(orOperator.operate(operands), false);

        operands.add(false);
        operands.add(false);
        operands.add(true);
        Assert.assertEquals(orOperator.operate(operands), false); //throws exception
    }

    @Test(expected = UnSupportedOperandTypeException.class)
    public void testArgumentSupport(){
        Queue<Object> operands = new LinkedList<>();
        operands.add(true);
        operands.add("false");
        Assert.assertEquals(orOperator.operate(operands), true);
    }
}
