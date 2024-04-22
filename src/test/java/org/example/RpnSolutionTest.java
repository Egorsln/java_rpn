package org.example;

import org.junit.Test;

import java.lang.reflect.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class RpnSolutionTest {
    @Test
    public void RpnSolution_doArithmeticOperation_plus_calculation_assert_true() throws Exception {
        assertEquals(15, RpnSolution.doArithmeticOperation(10, 5, "+"));
    }
    @Test
    public void RpnSolution_doArithmeticOperation_minus_calculation_assert_true() throws Exception {
        assertEquals(5, RpnSolution.doArithmeticOperation(10, 5, "-"));
    }
    @Test
    public void RpnSolution_doArithmeticOperation_multiplication_calculation_assert_true() throws Exception {
        assertEquals(50, RpnSolution.doArithmeticOperation(10, 5, "*"));
    }
    @Test
    public void RpnSolution_doArithmeticOperation_division_calculation_assert_true() throws Exception {
        assertEquals(2, RpnSolution.doArithmeticOperation(10, 5, "/"));
    }
    @Test
    public void RpnSolution_doArithmeticOperation_wrong_operation_assert_false() throws Exception {
        assertThrows(Exception.class, () -> {
            RpnSolution.doArithmeticOperation(10, 10, "o");
        });
    }
    @Test
    public void RpnSolution_doArithmeticOperation_zero_division_assert_false() throws Exception {
        assertThrows(Exception.class, () -> {
            RpnSolution.doArithmeticOperation(10, 0, "/");
        });
    }


    @Test
    public void RpnSolution_rpnSolve_plus_calculation_assert_true() throws Exception {
        assertEquals(4, RpnSolution.rpnSolve("2 2 +"));
    }
    @Test
    public void RpnSolution_rpnSolve_plus_calculation_assert_false() throws Exception {
        assertNotEquals(0, RpnSolution.rpnSolve("2 2 +"));
    }
}