package operators;

import cred.heimdall.constants.Gender;
import cred.heimdall.domain.models.User;
import cred.heimdall.operators.impl.AndOperator;
import exceptions.OperandCountException;
import exceptions.UnSupportedOperandTypeException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedList;
import java.util.Queue;

public class AndOperatorTest {
    private AndOperator andOperator = AndOperator.getInstance();

    @Test
    public void testSingleton(){
        AndOperator andOperator1 = AndOperator.getInstance();
        Assert.assertSame(andOperator1, andOperator);
    }

    @Test(expected = OperandCountException.class)
    public void testOperate(){
        Queue<Object> operands = new LinkedList<>();
        operands.add(true);
        operands.add(true);
        Assert.assertEquals(andOperator.operate(operands), true);

        operands.add(true);
        operands.add(false);
        Assert.assertEquals(andOperator.operate(operands), false);

        operands.add(false);
        Assert.assertEquals(andOperator.operate(operands), false); //throws exception
    }

    @Test(expected = UnSupportedOperandTypeException.class)
    public void testOperandSupport(){
        Queue<Object> operands = new LinkedList<>();
        operands.add(true);
        operands.add("true");
        Assert.assertEquals(andOperator.operate(operands), false); //throws exception
    }
}
