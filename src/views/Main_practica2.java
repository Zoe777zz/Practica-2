package views;

import java.util.Scanner;

import controller.ejercicios.Agua;
import controller.ejercicios.Autos;
import controller.ejercicios.Llamadas;
import controller.ejercicios.Serie;




public class Main_practica2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op = 0;// para el menu

        do {
            Autos menu = new Autos(); // Crear el objeto del menú
            op = menu.menu(sc); // Guardar y actualizar
            switch (op) {
                case 1:
                Autos ventas = new Autos();
                ventas.pagoAuto();
                break; 
                case 2:
                    Llamadas llamadas = new Llamadas();
                    llamadas.totalLlamadas(); 
                    
                    break;
                case 3:
                    Agua agua = new Agua();
                    agua.aguaCalcular(); 
                    break;
                case 4:
                    Serie serie = new Serie();
                    serie.ejecutarFinal();
                    break;
                
                case 5:
                    System.out.println("Vuelve pronto ^_^");
                    break;
                default:
                    System.out.println("Opción incorrecta >:(");
                    break;
            }
        } while (op != 5);

        //sc.close(); // Scanner

    }

}
