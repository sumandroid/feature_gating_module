package operators;

import cred.heimdall.operators.impl.NoneOfOperator;
import exceptions.OperandCountException;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class NoneOfOperatorTest {
    private NoneOfOperator noneOfOperator = NoneOfOperator.getInstance();

    @Test
    public void testSingleton(){
        NoneOfOperator noneOfOperator1 = NoneOfOperator.getInstance();
        Assert.assertSame(noneOfOperator1, noneOfOperator);
    }

    @Test(expected = OperandCountException.class)
    public void testOperate(){
        Queue<Object> operands = new LinkedList<>();
        operands.add(8);
        operands.add(9);
        operands.add(10);
        Assert.assertEquals(noneOfOperator.operate(operands), true);

        operands.add("suman");
        operands.add("saurabh");
        operands.add("test");
        Assert.assertEquals(noneOfOperator.operate(operands), true);

        operands.add("suman");
        operands.add("saurabh");
        operands.add("suman");
        Assert.assertEquals(noneOfOperator.operate(operands), false);

        operands.add("suman");
        operands.add("saurabh");
        operands.add(10);
        Assert.assertEquals(noneOfOperator.operate(operands), true);

        operands.add("suman");
        operands.add("saurabh");
        operands.add(10);
        operands.add("saurabh");
        Assert.assertEquals(noneOfOperator.operate(operands), true); //throws exception

    }
}
