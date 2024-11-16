import org.junit.*;
import static org.junit.Assert.*;
import tp8.grupob.ConversorDeMoneda;

public class ConversorTest {
    private static ConversorDeMoneda conversor;
    private ConversorDeMoneda conversorSinSaldo;
    private ConversorDeMoneda conversorConSaldo;

    @BeforeClass
    public static void setUpClass() {
        conversor = new ConversorDeMoneda();
        System.out.println("Bienvenido a las pruebas del Conversor de Moneda.");
    }

    @Before
    public void setUp() {
        conversorSinSaldo = new ConversorDeMoneda(); //No estático, para pruebas de cambio de saldo, clase sin saldo
        conversorConSaldo = new ConversorDeMoneda(500.0); //No estático, para pruebas con saldo inicial de 500
    }

    @Test
    public void testConvertir() {
        double resultado = conversor.convertir(1000, 1200);
        assertEquals(1200000, resultado, 0.001);
    }

    @Test
    public void testCalcularCotizacion() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());//imprimir nombre de la prueba
        double resultado = conversor.calcularCotizacion(1800000, 1620);
        assertEquals(1111.111, resultado, 0.001);
    }
    
    @Test
    public void testAumentarSaldoSinAtributo() {
        double saldoInicial = 100.0;
        double incremento = 50.0;
        double resultadoEsperado = 150.0;
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());//imprimir nombre de la prueba
        assertEquals(resultadoEsperado, conversorSinSaldo.aumentarSaldo(saldoInicial, incremento), 0.001);
    }

    @Test
    public void testAumentarSaldoConAtributo() {
        double incremento = 200.0;
        double resultadoEsperado = 700.0; // 500 (saldo inicial) + 200 (incremento)
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());//imprimir nombre de la prueba
        assertEquals(resultadoEsperado, conversorConSaldo.aumentarSaldo(incremento), 0.001);
    }

    @Test
    public void testRetirarDolaresSinAtributo() {
        double saldoInicial = 300.0;
        double montoARetirar = 100.0;
        double resultadoEsperado = 200.0;
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());//imprimir nombre de la prueba
        assertEquals(resultadoEsperado, conversorSinSaldo.retirarDolares(saldoInicial, montoARetirar), 0.001);
    }

    @Test
    public void testRetirarDolaresConAtributo() {
        double montoARetirar = 200.0;
        double resultadoEsperado = 300.0; // 500 (saldo inicial) - 200 (retiro)
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());//imprimir nombre de la prueba
        assertEquals(resultadoEsperado, conversorConSaldo.retirarDolares(montoARetirar), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRetirarDolaresSinAtributoFondosInsuficientes() {
        double saldoInicial = 100.0;
        double montoARetirar = 200.0;
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());//imprimir nombre de la prueba
        conversorSinSaldo.retirarDolares(saldoInicial, montoARetirar);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRetirarDolaresConAtributoFondosInsuficientes() {
        double montoARetirar = 600.0; // Excede el saldo inicial de 500
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());//imprimir nombre de la prueba
        conversorConSaldo.retirarDolares(montoARetirar);
    }

    @After
    public void tearDown() {
        System.out.println("Prueba finalizada, campos en 0.");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Todas las operaciones han finalizado.");
    }
}
