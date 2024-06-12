package HW26Test;

import HW26.Methods;
import org.junit.jupiter.api.*;

public class MethodsTest {
    Methods methods;
    @BeforeEach
    public void beforeEach(){
        methods = new Methods();
    }
    @AfterEach
    public void afterEach(){
        methods = null;
    }
    @Test
    public void averageMethodTest(){
        int[] array = new int[]{1,2,3,4,5};
        double index = methods.average(array);
        Assertions.assertEquals(3,index);
    }
    @Test
    public void averageMethodNullTest(){
        int[] array = null;
        double index = methods.average(array);
        Assertions.assertEquals(-1,index);
    }
    @Test
    public void averageMethodZeroTest(){
        int[] array = {};
        double index = methods.average(array);
        Assertions.assertEquals(-2,index);
    }
    @Test
    public void squareMatrixTest(){
        int[][] array = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        boolean index = methods.squareArray(array);
        Assertions.assertEquals(true,index);
    }
    @Test
    public void squareMatrixNullTest(){
        int[][] array = null;
        boolean index = methods.squareArray(array);
        Assertions.assertEquals(false,index);
    }
    @Test
    public void squareMatrixZeroTest(){
        int[][]array = {{}};
        boolean index = methods.squareArray(array);
        Assertions.assertEquals(false,index);
    }
}