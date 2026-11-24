import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
public class PiTest {

    // Тест для нуля итераций
    @org.junit.Test
    public void testZeroTerms() {
        int expected = 0;
        // Приводим double к int с помощью (int)
        int actual = (int) lr1.calculatePi(0);
        assertEquals("При 0 итерациях результат должен быть 0", expected, actual);
    }

    // Тест для одной итерации: 4.0 / 1.0 = 4.0
    @org.junit.Test
    public void testOneTerm() {
        int expected = 4;
        int actual = (int) lr1.calculatePi(1);
        assertEquals("При 1 итерации результат должен быть 4", expected, actual);
    }

    // Тест для двух итераций: 4.0 - (4.0 / 3.0)
    @org.junit.Test
    public void testTwoTerms() {
        double expected = 4.0 - (4.0 / 3.0);
        double actual = lr1.calculatePi(2);
        assertEquals("Неверный результат для 2 итераций", expected, actual, 1e-9);
    }

    // Тест для большого количества итераций
    @org.junit.Test
    public void testLargeNumberOfTerms() {
        int nTerms = 1000000;
        double actual = lr1.calculatePi(nTerms);
        assertEquals("Результат для 1000000 итераций должен быть близок к Math.PI", Math.PI, actual, 1e-5);
    }

    //
    @org.junit.Test
   public void testRangeForSmallN() {
        for (int n = 1; n <= 100; n++) {
            double result = lr1.calculatePi(n);
            assertTrue("Результат вышел за пределы для n=" + n + ": " + result,
                    result > 2.0 && result <= 4.1);
        }
    }

    //
    @org.junit.Test
    public void testAlternatingBehavior() {
        double evenResult = lr1.calculatePi(100);
        double oddResult = lr1.calculatePi(101);

        assertTrue("Четное число итераций должно давать результат меньше PI", evenResult < Math.PI);
        assertTrue("Нечетное число итераций должно давать результат больше PI", oddResult > Math.PI);
    }
}