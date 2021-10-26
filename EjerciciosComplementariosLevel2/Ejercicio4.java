package EjerciciosComplementariosLevel2;

import java.util.ArrayList;
import java.util.List;

//Cargar un arrayList con 12 nombres de estudiantes (String), luego separarlos en 3 cursos
// (3 arrayList) e imprimir dichos cursos.//
public class Ejercicio4 {
    public static void main(String[]args){
        ArrayList<String> nombres = new ArrayList<>();
        getIncluir(nombres);

        List<String> primerCurso = nombres.subList(0,
                4);
        List<String> segundoCurso = nombres.subList(4,
                8);
        List<String> tercerCurso = nombres.subList(8,
                12);

        System.out.println("Estudiantes del primer curso:");
        System.out.println(primerCurso);
        System.out.println("Estudiantes del segundo curso:");
        System.out.println(segundoCurso);
        System.out.println("Estudiantes del tercer curso:");
        System.out.println(tercerCurso);
    }
    private static void getIncluir(ArrayList<String> nombres) {
        incluir(nombres);
    }

    public static void incluir(ArrayList<String> array) {
        array.add("Nestor");
        array.add("Gustavo");
        array.add("Vicente");
        array.add("Antonio");
        array.add("Delia");
        array.add("Beatriz");
        array.add("Eloisa");
        array.add("Mariela");
        array.add("Eduardo");
        array.add("Jose");
        array.add("Emanuel");
        array.add("Lucas");
    }
}

