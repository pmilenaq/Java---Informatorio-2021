package EjerciciosComplementariosLevel1;
//Realizar un programa que calcule el factorial de un número:
//n! = 1 x 2 x 3 x 4 x 5 x … x (n-1) x n.
//Sin hacer uso de librerías.
import java.util.Scanner;

public class Ejercicio4 {
    public Ejercicio4() {
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int factorial = 1;
            System.out.println("Ingrese un numero: ");
            int numero = sc.nextInt();

            for(int i = 1; i <= numero; ++i) {
                factorial *= i;
            }

            System.out.println("El factorial de " + numero + " es : " + factorial);
        }
}


