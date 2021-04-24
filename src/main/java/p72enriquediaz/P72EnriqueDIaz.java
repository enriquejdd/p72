/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p72enriquediaz;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 *
 * @author Enrique
 */
public class P72EnriqueDIaz {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        ArrayList<Horario> horarios = new ArrayList<>();
        String idFichero = "hor_curso_1920_final.csv";

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;

        try (Scanner datosFichero = new Scanner(new File(idFichero))) {
            while (datosFichero.hasNextLine()) {
                linea = datosFichero.nextLine();

                tokens = linea.split(";");
                Horario horario = new Horario();
                int horasmanana = Integer.valueOf(tokens[tokens.length - 1]);

                // Para que solo entren las horas de la mañana y no los de la tarde.
                if (horasmanana < 8) {

                    horario.setCurso(quitarComillas(tokens[1]));
                    horario.setNombreProf(quitarComillasYEspacios(tokens[2]));
                    horario.setAsignatura(quitarComillasYEspacios(tokens[3]));
                    horario.setAula(quitarComillasYEspacios(tokens[4]));
                    horario.setDia(Integer.valueOf(tokens[5]));
                    horario.setHora(Integer.valueOf(tokens[6]));

                    horarios.add(horario);
                }

            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
//        horarios.forEach(System.out::println);

        // Creamos un comparator el cual primero ordenará por el dia y dentro de ese orden lo hará por hora.
        Comparator<Horario> comparadorMultiple = Comparator.comparing(Horario::getDia).thenComparing(Comparator.comparing(Horario::getHora));
        horarios.stream().sorted(comparadorMultiple);
//        horarios.stream().sorted(comparadorMultiple).forEach(System.out::println);
//        System.out.println("");

        // Creamos los dos SET
        Set<String> grupos = new TreeSet();
        Set<String> iniciales = new TreeSet();
        // Recorremos horarios y en cada iteracion cogemos el curso y las iniciales de los profesores
        // para ir rellenando su Set correspondiente.
        for (Horario h : horarios) {
            if (h.getHora() < 8) {
                grupos.add(quitarComillasCursos(h.getCurso()));
//                System.out.println(h.getCurso());
//                System.out.println(h.getCurso().length());
                iniciales.add(h.getNombreProf());
            }
        }

        // Comprobamos que tanto el arrayList como los set tiene la misma cantidad de filas
//        System.out.println("Cantidad datos en horarios " + horarios.size());
//        System.out.println("Cantidad datos en grupos " + grupos.size());
//        grupos.forEach(System.out::println);
//        System.out.println("");
//        System.out.println("Cantidad datos en iniciales " + iniciales.size());
//        iniciales.forEach(System.out::println);
//        System.out.println("");
        System.out.println("Bienvenido");
        System.out.println("¿Qué opción desea?");
        System.out.println("a) Consultar horarios por profesor/a.");
        System.out.println("b) Consultar horarios por grupo.");
        String respuesta = teclado.nextLine();

        while (!respuesta.contains("a") && !respuesta.contains("b")) {
            System.out.println("Opción incorrecta, elige de nuevo");
            System.out.println("a) Consultar horarios por profesor/a.");
            System.out.println("b) Consultar horarios por grupo.");
            respuesta = teclado.nextLine();
        }

        System.out.println("");
        if (respuesta.equals("a")) {
            iniciales.forEach(System.out::println);
            System.out.println("");

            System.out.println("Selecciones un usuario");
            String usuario = teclado.nextLine();

            while (!iniciales.contains(usuario)) {
                System.out.println("Usuario no encontrado, pruebe otro");
                usuario = teclado.nextLine();
            }

            String idFicheroCrear = usuario + ".csv";

            try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFicheroCrear))) {

                for (Horario h : horarios) {
                    linea = h.toString();
                    tokens = linea.split(", ");

                    String resp = "";
                    if (h.getNombreProf().equals(usuario)) {
                        resp = h.getDia() + " " + h.getHora() + " " + h.getAula();
                        flujo.write(resp);
                        flujo.newLine();
                    }
                }
                flujo.flush();

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        } else {
            grupos.forEach(System.out::println);
            System.out.println("");

            System.out.println("Selecciones un grupo");
            String grupo = teclado.nextLine();

            while (!grupos.contains(grupo)) {
                System.out.println("Grupo no encontrado, pruebe otro");
                grupo = teclado.nextLine();
            }

            String idFicheroCrear = grupo + ".csv";

            try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFicheroCrear))) {

                for (Horario h : horarios) {
                    linea = h.toString();
                    tokens = linea.split(", ");

                    String resp = "";
                    if (h.getCurso().contains(grupo)) {
                        resp = h.getDia() + " " + h.getHora() + " " + h.getAsignatura();
                        flujo.write(resp);
                        flujo.newLine();
                    }
                }
                flujo.flush();

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Método para quitar las comillas de los string que obtenemos del archivo csv.
    public static String quitarComillas(String a) {
        String sinComillas = "";

        String[] palabra;
        palabra = a.split("");

        for (int i = 1; i < palabra.length - 1; i++) {
            sinComillas += palabra[i];
        }

        return sinComillas;
    }

    // Método para quitar las comillas y los espacios finales de los string que obtenemos del archivo csv.
    public static String quitarComillasYEspacios(String a) {
        String sinComillas = "";

        String[] palabra;
        palabra = a.split("");

        for (int i = 1; i < palabra.length - 3; i++) {
            sinComillas += palabra[i];
        }

        return sinComillas;
    }
    
    // Se podria dejar solo este y borrar los dos superiores.
    public static String quitarComillasCursos(String a){
        return a.replace(" ", "");
    }
}
