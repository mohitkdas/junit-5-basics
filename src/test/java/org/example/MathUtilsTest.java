package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("When running MathUtils")
class MathUtilsTest {

    MathUtils mathUtils;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeAll
    static void beforeAllInit() {
        System.out.println("This needs to run before all");
    }

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        mathUtils = new MathUtils();
        testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags());
    }

    @AfterEach
    void cleanUp() {
        System.out.println("Cleaning up...");
    }

    @Nested
    @DisplayName("add method")
    @Tag("Math")
    class AddTest {
        @Test
        @DisplayName("Testing add method for +")
        void addPositive() {
            assertEquals(2, mathUtils.add(1, 1), () -> "should return a positive number");
        }

        @Test
        @DisplayName("Testing add method for -")
        void addNegative() {
            assertEquals(-2, mathUtils.add(-1, -1));
        }
    }

    @Test
    @DisplayName("Testing add method")
    @Tag("Math")
    void add() {
//        MathUtils mathUtils = new MathUtils();
        int expected = 2;
        int actual = mathUtils.add(1,1);
        assertEquals(expected, actual, "The add method should add two numbers");
    }

    @Test
//    @EnabledOnOs(OS.WINDOWS)
    @Tag("Math")
    void divide() {
//        MathUtils mathUtils = new MathUtils();
//        boolean assumption = false;
//        assumeTrue(assumption);
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0),
                "Divide by zero should throw");
    }

    @Test
    @Tag("Circle")
    void computeCircleRadius() {
//    @RepeatedTest(3)
//    void computeCircleRadius(RepetitionInfo repetitionInfo) {
//        MathUtils mathUtils = new MathUtils();
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10),
                "Should return right circle area");
    }

    @Test
    @DisplayName("multiply method")
    @Tag("Math")
    void multiply() {
//        System.out.println("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags());
        testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags());
//        assertEquals(4, mathUtils.multiply(2, 2), "should return the right product");
        assertAll(
                () -> assertEquals(4, mathUtils.multiply(2, 2)),
                () -> assertEquals(0, mathUtils.multiply(2, 0)),
                () -> assertEquals(-2, mathUtils.multiply(2, -1))
        );
    }

    @Test
    @Disabled
    @DisplayName("TDD method. Should not run")
    void testDisable() {
        fail("This test should be disabled");
    }

}