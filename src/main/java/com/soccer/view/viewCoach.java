package com.soccer.view;

import java.util.Scanner;
import com.soccer.Controller;
import com.soccer.model.entity.Coach;
import com.soccer.model.entity.Team;

public class viewCoach {
    public static Controller controlador;

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Entrenador");
            System.out.println("2. Actualizar Entrenador");
            System.out.println("3. Buscar Entrenador");
            System.out.println("4. Eliminar Entrenador");
            System.out.println("5. Listar todos los Entrenadores");
            System.out.println("6. Salir al menú principal");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Crear Entrenador
                    System.out.println("Ingrese el código del equipo al que pertenece el entrenador:");
                    String codigoEquipo = scanner.nextLine();
                    Team equipo = controlador.equipos.get(codigoEquipo);

                    if (equipo != null) {
                        Coach entrenador = new Coach();
                        System.out.println("Ingrese ID de federación del entrenador:");
                        entrenador.setIdFederacion(scanner.nextInt());
                        scanner.nextLine(); // Consume newline
                        System.out.println("Ingrese Nombre del entrenador:");
                        entrenador.setNombre(scanner.nextLine());
                        System.out.println("Ingrese Apellido del entrenador:");
                        entrenador.setApellido(scanner.nextLine());
                        System.out.println("Ingrese la Edad del entrenador:");
                        entrenador.setEdad(scanner.nextInt());
                        scanner.nextLine(); // Consume newline
                        
                        equipo.addEntrenador(entrenador); // Agrega el entrenador al equipo
                        System.out.println("Entrenador creado con éxito y asignado al equipo " + equipo.getNombre());
                    } else {
                        System.out.println("Equipo no encontrado.");
                    }
                    break;

                case 2: // Actualizar Entrenador
                    System.out.println("Ingrese el código del equipo del entrenador:");
                    codigoEquipo = scanner.nextLine();
                    equipo = controlador.equipos.get(codigoEquipo);

                    if (equipo != null) {
                        System.out.println("Ingrese el ID de federación del entrenador:");
                        int idFederacion = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        Coach entrenador = equipo.getEntrenador(idFederacion);
                        
                        if (entrenador != null) {
                            System.out.println("Ingrese el nuevo nombre del entrenador (actual: " + entrenador.getNombre() + "):");
                            entrenador.setNombre(scanner.nextLine());
                            System.out.println("Ingrese el nuevo apellido del entrenador (actual: " + entrenador.getApellido() + "):");
                            entrenador.setApellido(scanner.nextLine());
                            System.out.println("Ingrese la nueva edad del entrenador (actual: " + entrenador.getEdad() + "):");
                            entrenador.setEdad(scanner.nextInt());
                            scanner.nextLine(); // Consume newline
                            System.out.println("Entrenador actualizado con éxito.");
                        } else {
                            System.out.println("No se encontró entrenador en este equipo con ID de federación " + idFederacion);
                        }
                    } else {
                        System.out.println("Equipo no encontrado.");
                    }
                    break;

                case 3: // Buscar Entrenador
                    System.out.println("Ingrese el código del equipo del entrenador:");
                    codigoEquipo = scanner.nextLine();
                    equipo = controlador.equipos.get(codigoEquipo);

                    if (equipo != null) {
                        System.out.println("Ingrese el ID de federación del entrenador:");
                        int idFederacion = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        Coach entrenador = equipo.getEntrenador(idFederacion);
                        
                        if (entrenador != null) {
                            System.out.println("Nombre del entrenador: " + entrenador.getNombre());
                            System.out.println("Apellido del entrenador: " + entrenador.getApellido());
                            System.out.println("Edad del entrenador: " + entrenador.getEdad());
                            System.out.println("ID de federación del entrenador: " + entrenador.getIdFederacion());
                        } else {
                            System.out.println("No se encontró entrenador en este equipo con ID de federación " + idFederacion);
                        }
                    } else {
                        System.out.println("Equipo no encontrado.");
                    }
                    break;

                case 4: // Eliminar Entrenador
                    System.out.println("Ingrese el código del equipo del entrenador:");
                    codigoEquipo = scanner.nextLine();
                    equipo = controlador.equipos.get(codigoEquipo);

                    if (equipo != null) {
                        System.out.println("Ingrese el ID de federación del entrenador:");
                        int idFederacion = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        boolean eliminado = equipo.removeEntrenador(idFederacion);
                        
                        if (eliminado) {
                            System.out.println("Entrenador con ID de federación " + idFederacion + " eliminado con éxito.");
                        } else {
                            System.out.println("No se encontró entrenador en este equipo con ID de federación " + idFederacion);
                        }
                    } else {
                        System.out.println("Equipo no encontrado.");
                    }
                    break;

                case 5: // Listar todos los Entrenadores
                    for (Team team : controlador.equipos.values()) {
                        for (Coach entrenador : team.getLstEntrenadores()) {
                            System.out.println("Equipo: " + team.getNombre() + ", Nombre: " + entrenador.getNombre() + ", Apellido: " + entrenador.getApellido() + ", Edad: " + entrenador.getEdad() + ", ID de federación: " + entrenador.getIdFederacion());
                        }
                    }
                    break;

                case 6: // Salir al menú principal
                    return;

                default:
                    System.out.println("Opción inválida, inténtelo de nuevo.");
            }
        }
    }
}
