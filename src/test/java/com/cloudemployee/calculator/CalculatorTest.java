package com.cloudemployee.calculator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

/**
 * @author rtanchico
 */

class CalculatorTest {

    Calculator calculator = mock(Calculator.class);

    String operationStr = "(81*52)-(29*36)";
    ArrayList<Character> operators = new ArrayList<Character>();

    @Test
    void getNumbers() {
        doNothing().when(calculator).getNumbers(operationStr);
    }

    @Test
    void getOperators() {
        doNothing().when(calculator).getOperators(operationStr);
    }

    @Test
    void getNextOperator() {
        doNothing().when(calculator).getNextOperator(operators);
    }
}