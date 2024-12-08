package controller.util;

import java.util.Random;

public class Utilidades {
    public static boolean validate (String number){ // statico no crear instancia 
        boolean band = true; // la clase que lo envuelve el Boolean
        if(number.charAt(0)== '-'){
            number = number.substring(1);}
        int cont_p =0;
        for (int i=0;i < number.length(); i++){
            if (!Character.isDigit(number.charAt(i)) && number.charAt(i)!='.' ){
                band = false;
                break;
            }else if (number.charAt(i) == '.')
                cont_p ++;

        }
        if(cont_p>=2)
            band = false;
        return band;
    }
    public static int transformarInt(String num) {
        int resp = 0;
        if (validate(num))
            resp = (int)Utilidades.transformarFloat(num);//Integer.parseInt(num);
        return resp;
    }
    public static double transformarDouble (String num) {
        double resp = 0;
        if (Utilidades.validate(num))
            resp = Double.parseDouble(num);
        return resp;    
    }
    public static float transformarFloat (String num) {
        float resp = 0.0f;
        if (validate(num))
            resp = Float.parseFloat(num);
        return resp;    
    }
    
    public static int generaNumeroRango (int minimo, int maximo){
        Random random = new Random();
        
        // 2-10
        // 2+11 ----------------- 2+(9)}
        return minimo + random.nextInt((maximo+1)-minimo);
       
        // random.nextInt() ----------> int  un valor entre cero y el valor especifico
        // origin in bout el minimo y maximo en rangos maximo origen - minimo 
    }
    public static float generaNumeroRangoFloat (float minimo, float maximo){
        Random random = new Random();
        return minimo + random.nextFloat() * ((maximo+1) - minimo);
    }
    public static float redondear (float numero){
        float aux = numero *100.00f;
        float aux1 = (float)((int)aux);
        return (aux1/100.00f);
        //return (float)(Math.round(numero*100.00)/100.00);
    }
}
