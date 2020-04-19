package operators;

import cred.heimdall.operators.impl.EqualsToOperator;
import exceptions.OperandCountException;
import exceptions.UnSupportedOperandTypeException;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class EqualsToOperatortest {
    private EqualsToOperator equalsToOperator = EqualsToOperator.getInstance();

    @Test
    public void testSingleton(){
        EqualsToOperator equalsToOperator1 = EqualsToOperator.getInstance();
        Assert.assertSame(equalsToOperator1, equalsToOperator);
    }

    @Test(expected = OperandCountException.class)
    public void testOperate(){
        Queue<Object> operands = new LinkedList<>();
        operands.add(10);
        operands.add(10);
        Assert.assertEquals(equalsToOperator.operate(operands), true);

        operands.add(10);
        operands.add(20);
        Assert.assertEquals(equalsToOperator.operate(operands), false);

        operands.add(20);
        operands.add(10);
        operands.add(10);
        Assert.assertEquals(equalsToOperator.operate(operands), false); //throws exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentException(){
        Queue<Object> operands = new LinkedList<>();
        operands.add(20);
        operands.add(null);
        Assert.assertEquals(equalsToOperator.operate(operands), true);
    }
}
