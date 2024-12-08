package controller.ejercicios;

import java.util.Scanner;

public class Autos {
     public int menu(Scanner sc) {
        
        System.out.println("----------------------------");
        System.out.println("-------- Bienvenido --------");
        System.out.println("1. Compañia de Autos");
        System.out.println("2. LLamadas telefónicas ");
        System.out.println("3. Agua Potable");
        System.out.println("4. Serie");
        System.out.println("5. Salir");
        System.out.print("Ingrese la opción: ");
        int op = sc.nextInt();
        sc.nextLine(); // Limpiar el scanner
        return op;
        
    }
    
    public float pagoAuto () {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del empleado: "); // identificarlo
        String empleado = sc.nextLine();
        // Variebles 
        float sueldoEmpleados = 2500.0f; // constante del sueldo 
        float comision=0.0f;
        float utilidad =0.0f;
        float totalVentas =0.0f;
        int vendidos = 0;
        int resp ; 
        float total = 0.0f; 
        do {
            System.out.print("Ingrese el monto de su venta: ");
            float monto = sc.nextFloat();
            totalVentas += monto;
            if(monto > 10000.0){
                comision+= 250; // si e smayor resive comision 
                vendidos++;
            }else{
                vendidos++; // si no solo se añade auto vendido
            }
             // Preguntar si se desea ingresar otra venta
            do {
                System.out.println("Desea ingresar otro monto? ");
                System.out.println("Si = 0 ---- No = 1 "); // si desea ingresar otro 
                resp = sc.nextInt();
                
                if (resp != 0 && resp != 1) {
                    System.out.println("Numero no valio");
                }
            } while (resp != 0 && resp != 1); 
            
        } while (resp == 0);
        
        float utilidades = utilidad(totalVentas);
        // Calcular total a pagar
        total = total(sueldoEmpleados, comision, utilidad);
        
        // Imprimir informe
        System.out.println("------------------------- Informe de Pago -------------------------");
        System.out.println("Nombre del Empleado:\t\t\t\t"+empleado);
        System.out.println("Número total de autos vendidos:\t\t\t"+vendidos);
        System.out.println("Valor total de las ventas:\t\t\t"+totalVentas);
        System.out.println("Sueldo mensual:\t\t\t\t\t"+sueldoEmpleados);
        System.out.println("Comisión por autos vendidos:\t\t\t"+comision);
        System.out.println("Utilidad por valor total de ventas:\t\t"+utilidades);
        System.out.println("Monto total a pagar al final del mes:\t\t"+total);
        // Retornar el monto total a pagar 
        
        return total;
    } 
    
    public float utilidad (float totalVenta) {
        return totalVenta * 0.05f;
    }     
    public float total (float sueldoEmpleados, float comision, float utilidad) {
        return sueldoEmpleados + comision +utilidad; 
    }
   
}
        
        
        
    


