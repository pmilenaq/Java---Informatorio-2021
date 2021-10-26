package EjerciciosComplementariosLevel1;
//Realizar un programa que solicite por consola 2 números enteros.
// Para luego imprimir el resultado de la suma, resta, multiplicación, división y módulo (resto de la división)
// de ambos números.//
import java.util.Scanner;

public class Ejercicio2 {
    public Ejercicio2() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese primer numero entero:");
        int a = sc.nextInt();
        System.out.println("Ingrese segundo numero entero:");
        int b = sc.nextInt();
        int resultadoSuma = a + b;
        System.out.println("El valor de la suma es: " + resultadoSuma);
        int resultadoResta = a - b;
        System.out.println("El valor de la resta es: " + resultadoResta);
        int resultadoMult = a * b;
        System.out.println("El valor de la multiplicacion es: " + resultadoMult);
        int resultadoDiv = a / b;
        System.out.println("El valor de la division es: " + resultadoDiv);
        int resultadoModulo = a % b;
        System.out.println("El valor del modulo es: " + resultadoModulo);
    }
}



