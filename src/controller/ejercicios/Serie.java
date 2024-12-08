package controller.ejercicios;
import java.util.Scanner;

public class Serie {
    public int ejecutarFinal() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el numero de serie a presentar: ");
        int n = sc.nextInt();

        int secuencia = 0;
        int a = 1; // dar inicio
        int b = 1;// dar inicio
        int numerador = 1; // dar inicio
        int denominador = 1; // dar inicio
        double suma = 0;
        int exponente= 2;
        boolean bandera = false; 
        for (int i = 1; i <= n; i++) {
            // calcular el exponente
            if (i <= 2) {
                numerador = 1;
                numerador = a;
            }
            // calcular el termino actual
            double termino = sumar(denominador,numerador,exponente);
            String signo;
            if (!(i% 2 == 0) ) {
                bandera = !bandera; }
            if (bandera){
                signo = "+";
            }else {
                signo = "-";
            } 
            if (signo.equals("+")) {
                suma += termino;
            } else {
                suma -= termino;
            }
            // imprimir el termino
            System.out.print (signo + "(" + numerador + "/" + denominador + ")^" + exponente );
            if (i < 0)
            System.out.println(" ");
            
            // actualizar valores
            exponente += 2;
            denominador += 2;
            // actualizar numero fibonacaci
            int c = a + b;
            a = b;
            b = c;
            secuencia++;
        }
        System.out.println("   La suma total es:" + suma);
        return secuencia;
    }
    
    public double sumar (double denominador,double numerador, double exponente ){
        return (Math.pow((double) numerador / denominador, exponente));}


    
}

