package EjerciciosComplementariosLevel1;

import java.util.Scanner;

//Se desea una aplicación que solicite 2 números enteros y realice la operación de potencia (sin uso de librerías).//
public class Ejercicio6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese primer número entero: ");
        int num1 = sc.nextInt();
        System.out.println("Ingrese potencia: ");
        int num2 = sc.nextInt();
        int resultado = 1;

        for (int i = 1; i <= num2; ++i) {
            resultado *= num1;
        }
        System.out.println(num1 + " elevado a " + num2 + " = " + resultado);

    }
}