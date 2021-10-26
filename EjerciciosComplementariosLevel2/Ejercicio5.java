package EjerciciosComplementariosLevel2;

import java.util.ArrayList;

//Dados 2 ArrayList que contienen horas-trabajadas (array1) y valor-por-hora(array2)
// del resumen de carga de horas semanal de un empleado. Se debe generar otra lista
// que contenga los totales y luego imprimir el total final a cobrar.//
public class Ejercicio5 {
    public static void main(String[] args) {
        ArrayList<Integer> horasTrabajadas = new ArrayList();
        ArrayList<Integer> valorPorHora = new ArrayList();
        ArrayList<Integer> totales = new ArrayList();
        int totalFinal = 0;
        totalHoras(horasTrabajadas);
        totalValores(valorPorHora);
        finalTotales(horasTrabajadas, valorPorHora, totales);
        System.out.println(totales);

        for (Integer item : totales) totalFinal += item;
        System.out.println("Total Final a cobrar :" + totalFinal);
    }

    public static void totalHoras(ArrayList<Integer> array) {
        array.add(6);
        array.add(7);
        array.add(8);
        array.add(4);
        array.add(5);
    }

    public static void totalValores(ArrayList<Integer> array) {
        array.add(350);
        array.add(345);
        array.add(550);
        array.add(600);
        array.add(320);
    }

    public static void finalTotales(ArrayList<Integer> horas, ArrayList<Integer> valores, ArrayList<Integer> totales) {
        for (int i = 0; i < horas.size(); i++) {
            totales.add(horas.get(i) * valores.get(i));
        }

    }
}

