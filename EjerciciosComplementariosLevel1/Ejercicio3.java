package EjerciciosComplementariosLevel1;
//Confeccionar un programa que dado un número entero
// como dato de entrada imprima la secuencia de números
// (incrementos de 1) de la siguiente forma:
// 1
//1 2
//1 2 3
//1 2 3 4
//1 2 3 4 5

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un número entero: ");
        int a = sc.nextInt();
        for (int i = 1; i <= a; i++) {
            for (int x = 1; x <= i; x++) {
                System.out.print(x + " ");
            }
            System.out.println(" ");
        }
    }
}
