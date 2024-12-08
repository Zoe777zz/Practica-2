package controller.ejercicios;

import java.util.Scanner;



public class Agua {
    public float aguaCalcular() {
        Scanner sc = new Scanner(System.in);
        int resp; 
        float totalPagar; 
        do{
            System.out.print("Ingrese el consumo de Agua potable en m³: ");
            float consumo = sc.nextFloat();
            System.out.print("Pertenece a la tercera edad sí = 0 , no = 1):");
            boolean terceraEdad = tercera_Edad(sc); 
            float porcentajeDiscapacidad = discapacidad(sc); 
            Float consumo_aguaTotal = calcularAguaPotable(consumo,terceraEdad,porcentajeDiscapacidad); 
            
            float alcantarillado = consumo_aguaTotal * 0.35f; 
            float basura = 0.75f;
            float datos = 0.50f; 
            
            totalPagar = consumo_aguaTotal + alcantarillado + basura+ datos;
            // Mostrar resultados
            System.out.println("------------------------- Informe de Pago -------------------------");
            System.out.println("Servicio de agua potable:\t\t\t\t"+consumo_aguaTotal);
            System.out.println("Impuesto de alcantarillado (35%):\t\t\t"+alcantarillado);
            System.out.println("Recolección de basura:\t\t\t\t\t"+basura);
            System.out.println("Procesamiento de datos:\t\t\t\t\t"+datos);
            System.out.println("TOTAL A PAGAR:\t\t\t\t\t\t"+totalPagar);
            do {
                System.out.println("--------------------------------------------------");
                System.out.println("Desea ingresar otro monto? ");
                System.out.println("Si = 0 ---- No = 1 "); // si desea ingresar otro 
                resp = sc.nextInt();
                
                if (resp != 0 && resp != 1) {
                    System.out.println("Numero no valio");
                }
            } while (resp != 0 && resp != 1); 
            
        } while (resp == 0);
        return totalPagar; 
    }
    public static boolean tercera_Edad (Scanner sc) {
        int  comprobar_respuesta;
        do {
            comprobar_respuesta = sc.nextInt();
            if (comprobar_respuesta == 0) {
                return true;
            } else if (comprobar_respuesta == 1) {
                return false;
            } else {
                System.out.println("Solo si = 0 y no = 1");
            }
        } while (true);
    }
    public static float discapacidad (Scanner sc) {
        int  comprobar_discapacidad;
        float porcentaje_discapacidad = 0; 
        do {
            System.out.println("Tiene discapacidad? sí = 0 , no = 1 :");
            comprobar_discapacidad = sc.nextInt();
            
            if (comprobar_discapacidad == 0) {
                System.out.println("Ingrese el porcentaje de discapacidad entre 10 -100");
                porcentaje_discapacidad = sc.nextFloat();
            if (porcentaje_discapacidad >= 10 && porcentaje_discapacidad <= 90) {
                return porcentaje_discapacidad; // Retornar 
            } else {
                System.out.println("Porcentaje inválido");
            }
        } else if (comprobar_discapacidad == 1) {
            return 0; // paso
        } else {
            System.out.println("Respuesta inválida");
        }
        } while (true);
    }

    public static float calcularAguaPotable(float consumo, Boolean tercera_Edad, float porcentaje_discapacidad) {
        
        
        float costo = 3.0f; // Costo base

        if (consumo > 15) {
            costo += (Math.min(consumo, 25) - 15) * 0.1; // limitar el cálculo del costo a un rango específico minimo 
        }
        if (consumo > 25) {
            costo += (Math.min(consumo, 40) - 25) * 0.2;
        }
        if (consumo > 40) {
            costo += (Math.min(consumo, 60) - 40) * 0.3;
        }
        if (consumo > 60) {
            costo += (consumo - 60) * 0.35;
        }
        //tercera_Edad
        if (tercera_Edad && consumo <= 15) {
            costo *= costo * 0.50; // Descuento del 50% para consumo hasta 15 m³
        } else if (tercera_Edad) {
            costo -= (3.00f * 0.30f); // Descuento del 30% sobre el rango base
        }
        // discapacidad 
        if (porcentaje_discapacidad>0) {
            costo -= (3.00 * (porcentaje_discapacidad / 100)); // Descuento según porcentaje de discapacidad sobre el rango base
        }

        
        return costo; // Retornar el costo calculado
    }

    

    
}


