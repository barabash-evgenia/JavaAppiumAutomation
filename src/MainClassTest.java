import org.junit.Test;

public class MainClassTest {
    MainClass mainClass = new MainClass();
    @Test
    public void testGetLocalNumber(){
        int a = mainClass.getLocalNumber();
        if (a != 14) {
            System.out.println("Возвращаемое методом getLocalNumber() значение '" + a + "' не совпало с ожидаемым '14'.");
        }
    }
}
