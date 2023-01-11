import org.junit.Assert;
import org.junit.Test;

public class MainClassTest {

    MainClass mainClass = new MainClass();

    @Test
    public void testGetLocalNumber(){
        int a = mainClass.getLocalNumber();
        if (a != 14) {
            Assert.fail("Возвращаемое методом getLocalNumber() значение " + a + " не совпало с ожидаемым 14.");
        }
    }

    @Test
    public void testGetClassNumber(){
        int a = mainClass.getClassNumber();
        if (a <= 45) {
            if (a == 45) {
                Assert.fail("Возвращаемое методом getClassNumber() значение равно 45.");
            } else {
                Assert.fail("Возвращаемое методом getClassNumber() значение " + a + " меньше 45.");
            }
        }
    }
}
