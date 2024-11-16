import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import tp8.grupob.ConversorDeMoneda;

@RunWith(Parameterized.class)
public class DolaritosTest {
    private final double monto;
    private final double cotizacion;
    private final double esperado;

    public DolaritosTest(double monto, double cotizacion, double esperado) {
        this.monto = monto;
        this.cotizacion = cotizacion;
        this.esperado = esperado;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> datos() {
        return Arrays.asList(new Object[][]{ //arreglo con valores parametrizados de monto, cotizacion y resultados esperados
            {1000, 1.5, 1500},
            {2000, 0.5, 1000},
            {1200, 0, 0},
        });
    }

    @Test
    public void testConvertir() {
        ConversorDeMoneda conversor = new ConversorDeMoneda();
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()); //imprimir nombre de la prueba
        double resultado = conversor.convertir(monto, cotizacion);
        assertEquals(esperado, resultado, 0.001); // esperado, resultado y delta de 0.001
    }
}
