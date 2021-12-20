package EjerciociosComplementariosLevel3;

//Se dispone de una lista de Integer, de la cual queremos obtener otra lista aplicando
// la operación de factorial pero no se desean valores repetidos.

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Ejercicio4 {
    
        public static void main(String[] args) {
            List<Integer> palabras = List.of(1, 2, 4, 4, 4);
            List<Integer> otraLista = new ArrayList<>();
            Set<Integer> uniqueValues = new HashSet<>();
            for (Integer numero : palabras) {
                Integer factorial = factorial(numero);
                if (uniqueValues.add(factorial)) {
                    otraLista.add(factorial);
                }
            }
            System.out.println(otraLista);
        }
        private static Integer factorial(Integer numero) {
            if (numero == 1){
                return 1;
            }else {
                return numero * factorial(numero-1);
            }
        }


    }
