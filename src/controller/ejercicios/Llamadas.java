package controller.ejercicios;

import java.util.Scanner;

import controller.util.Utilidades;

public class Llamadas {
    public  enum zonas{
        America_del_norte (12,2.75f),America_central(15,1.89f ),America_del_sur(18,1.60f), Europa(19,3.50f ), Asia(23,4.50f), Africa(25,3.10f), Oceania(29,3.00f), Resto_del_mundo(31,6.00f); 
        // constructor de clase - inicializar la clase 
        private final int geografica; // declarar 
        private final float precio; // declarar
        zonas (int geografica, float precio){
            this.geografica= geografica; // uso this
            this.precio = precio; 
        }
        public int getgeografica(){ // obtener 
            return geografica; 
        }
        public float getprecio(){
            return precio; 
        }
    }
    // cuentan parecido a un array 
    // 
    public float totalLlamadas () {
        float minutosTotal = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("------- CODIGO ZONA GEOGRAFICA ------ ");
        System.out.println("12 : America del norte");
        System.out.println("15 : America central");
        System.out.println("18 : America del sur");
        System.out.println("19 : Europa");
        System.out.println("23 : Asia");
        System.out.println("25 : África");
        System.out.println("29 : Oceanía");
        System.out.println("31 : Resto del mundo");
        int resp ;
        zonas zn; // defino - se debe inicializar 
        zn = zonas.values()[0];// se debe inicializar con un elemento - el primer valor de todo el grupo : 0
        do {
            System.out.print("Ingrese el CÓDIGO de su zona geográfica: ");
            int codigo =  Utilidades.transformarInt(sc.nextLine());
            if (codigo == 12  || codigo == 15|| codigo == 18|| codigo == 19|| codigo == 23|| codigo == 25|| codigo == 29|| codigo == 31 ){
             // AVANZA
                System.out.print("Ingrese los minutos hablados: ");
                int minutos = Utilidades.transformarInt(sc.nextLine());
                for(int i =0; i< zonas.values().length ;i++){// recorre usar length 
                    zn = zonas.values()[i]; // cada elemento
                    if (zn.getgeografica() == codigo){ // comparo los elementos 
                        break; // salgo
                    }
                }
                minutosTotal = zn.getprecio() * minutos;
            }else 
               System.out.println("Código incorrecto");
            do {
                System.out.println("Desea ingresar otra llamada ? ");
                System.out.println("Si = 0 ---- No = 1 "); // si desea ingresar otro 
                resp = sc.nextInt();
                sc.nextLine(); // limpiar el buffer 
                
                if (resp != 0 && resp != 1) {
                    System.out.println("Numero no valido");
                }
            } while (resp != 0 && resp != 1);
        } while (resp == 0);
        System.out.println("El costo de sus minutos hablados es: " + minutosTotal);
        return minutosTotal; 
    } 
    
    
}
