package EjerciciosComplementariosLevel1;

import java.util.Scanner;
//Realizar un programa que dado un String de entrada en minúsculas lo convierta por completo a mayúsculas.
//Sin uso de métodos o librerías que realicen toUppercase().//
public class Ejercicio7 {
    public static void main(String[] args) {

        System.out.println("Ingrese palabra o texto en minúsculas: ");
        Scanner sc = new Scanner(System.in);
        String palabra = sc.nextLine();

        for(int i = 0; i < palabra.length(); i++) {
           char letras = palabra.charAt(i);
           if (letras >= 'a' && letras<= 'z'){
               letras = (char)(letras - 32);
           }
               System.out.println((char) (letras));
        }

    }

}

