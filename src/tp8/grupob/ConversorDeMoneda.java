
package tp8.grupob;

public class ConversorDeMoneda {
    public static void main(String[] args) {
    }
    double saldo = 500;

//Constructor con saldo para cambios en su variable    
    public ConversorDeMoneda(double saldo) {
        this.saldo = saldo;
    }
    
//Constructor vacio para pruebas donde no hay saldo inicializado y se recibe por parametro
    public ConversorDeMoneda() {
    }
     
    public double convertir(double monto, double cotizacion) {
        return monto * cotizacion;
    }

//Calcular cotización, con error aritmético al poner 0 como montoInicial
    public double calcularCotizacion(double montoFinal, double montoInicial) {
        if (montoInicial == 0) throw new ArithmeticException("División por cero no permitida");
        return montoFinal / montoInicial;
    }
    
//Para una clase vacia
    public double aumentarSaldo(double saldo, double incremento) {
        return saldo + incremento;
    }
    
//Para una clase con el atributo saldo
    public double aumentarSaldo(double incremento) {
        return this.saldo + incremento;
    }

//Para una clase vacia, con error al tener menos fondos de los necesarios.  
    public double retirarDolares(double saldo, double montoARetirar) {
        if (montoARetirar > saldo) throw new IllegalArgumentException("Fondos insuficientes");
        return saldo - montoARetirar;
    }

//Para una clase con el atributo saldo, con error al tener menos fondos de los necesarios.
    public double retirarDolares(double montoARetirar) {
        if (montoARetirar > this.saldo) throw new IllegalArgumentException("Fondos insuficientes");
        return this.saldo - montoARetirar;
    }
}

