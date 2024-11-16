import org.junit.Test;
import tp8.grupob.ConversorDeMoneda;

public class CotizacionTest {
    @Test(expected = ArithmeticException.class)
    public void testCotizarCero() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());//imprimir nombre de la prueba
        ConversorDeMoneda conversor = new ConversorDeMoneda();
        conversor.calcularCotizacion(1000, 0);
    }
}
