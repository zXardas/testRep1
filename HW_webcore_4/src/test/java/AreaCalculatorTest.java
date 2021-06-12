import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(TimingExtension.class)
class AreaCalculatorTest {
   private static Logger logger = LoggerFactory.getLogger(AreaCalculatorTest.class.getName());
    @BeforeAll
    static void beforeAllTests(){
        logger.info("Перед тестами");
    }
    @AfterAll
    static void afterAllTests(){
        logger.info("После тестов");
    }

@DisplayName("Проверка корректности вычисления - areaCalc()")
//    @Test
    //без параметров
    /*
    void areaCalc() throws Exception {
       AreaCalculator a = new AreaCalculator();
        assertEquals(43.30127018922193,a.areaCalc(10,10,10));
        assertEquals(4.993746088859544,a.areaCalc(1,10,10));

    }*/

@ParameterizedTest
@CsvFileSource(resources="/test.csv")

void areaCalc(int a, int b, int c, double res) throws Exception {
    AreaCalculator obj = new AreaCalculator();

    assertEquals(res, obj.areaCalc(a,b,c));


}

    @DisplayName("Проверка корректности ввода - sideTest()")
    @Test
    void sideTest() {
        AreaCalculator a = new AreaCalculator();
        Throwable exception = assertThrows(Exception.class, () -> {a.areaCalc(0,-1,1);});
        assertEquals(exception.getMessage(),"Стороны треугольника не могут быть равны или меньше 0" );
    }
}