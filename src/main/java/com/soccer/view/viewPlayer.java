package com.soccer.view;

import java.util.Scanner;
import com.soccer.Controller;
import com.soccer.model.entity.Player;
import com.soccer.model.entity.Team;

public class viewPlayer {
    public static Controller controlador;

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Jugador");
            System.out.println("2. Actualizar Jugador");
            System.out.println("3. Buscar Jugador");
            System.out.println("4. Eliminar Jugador");
            System.out.println("5. Listar todos los Jugadores");
            System.out.println("6. Salir al menú principal");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Crear Jugador
                    System.out.println("Ingrese el código del equipo al que pertenece el jugador:");
                    String codigoEquipo = scanner.nextLine();
                    Team equipo = controlador.equipos.get(codigoEquipo);

                    if (equipo != null) {
                        Player jugador = new Player();
                        System.out.println("Ingrese Nombre del jugador:");
                        jugador.setNombre(scanner.nextLine());
                        System.out.println("Ingrese la edad del jugador:");
                        jugador.setEdad(scanner.nextInt());
                        scanner.nextLine(); // Consume newline
                        System.out.println("Ingrese la posición del jugador:");
                        jugador.setPosicion(scanner.nextLine());
                        
                        equipo.addJugador(jugador); // Agrega el jugador al equipo
                        System.out.println("Jugador creado con éxito y asignado al equipo " + equipo.getNombre());
                    } else {
                        System.out.println("Equipo no encontrado.");
                    }
                    break;

                case 2: // Actualizar Jugador
                    System.out.println("Ingrese el código del equipo del jugador:");
                    codigoEquipo = scanner.nextLine();
                    equipo = controlador.equipos.get(codigoEquipo);

                    if (equipo != null) {
                        System.out.println("Ingrese el nombre del jugador a actualizar:");
                        String nombreJugador = scanner.nextLine();
                        Player jugador = equipo.getLstJugadores().stream()
                                .filter(p -> p.getNombre().equals(nombreJugador))
                                .findFirst()
                                .orElse(null);

                        if (jugador != null) {
                            System.out.println("Ingrese el nuevo nombre del jugador (actual: " + jugador.getNombre() + "):");
                            jugador.setNombre(scanner.nextLine());
                            System.out.println("Ingrese la nueva edad del jugador (actual: " + jugador.getEdad() + "):");
                            jugador.setEdad(scanner.nextInt());
                            scanner.nextLine(); // Consume newline
                            System.out.println("Ingrese la nueva posición del jugador (actual: " + jugador.getPosicion() + "):");
                            jugador.setPosicion(scanner.nextLine());
                            System.out.println("Jugador actualizado con éxito.");
                        } else {
                            System.out.println("Jugador no encontrado.");
                        }
                    } else {
                        System.out.println("Equipo no encontrado.");
                    }
                    break;

                case 3: // Buscar Jugador
                    System.out.println("Ingrese el código del equipo del jugador:");
                    codigoEquipo = scanner.nextLine();
                    equipo = controlador.equipos.get(codigoEquipo);

                    if (equipo != null) {
                        System.out.println("Ingrese el nombre del jugador a buscar:");
                        String nombreJugador = scanner.nextLine();
                        Player jugador = equipo.getLstJugadores().stream()
                                .filter(p -> p.getNombre().equals(nombreJugador))
                                .findFirst()
                                .orElse(null);

                        if (jugador != null) {
                            System.out.println("Nombre del jugador: " + jugador.getNombre());
                            System.out.println("Edad del jugador: " + jugador.getEdad());
                            System.out.println("Posición del jugador: " + jugador.getPosicion());
                        } else {
                            System.out.println("Jugador no encontrado.");
                        }
                    } else {
                        System.out.println("Equipo no encontrado.");
                    }
                    break;

                case 4: // Eliminar Jugador
                    System.out.println("Ingrese el código del equipo del jugador:");
                    codigoEquipo = scanner.nextLine();
                    equipo = controlador.equipos.get(codigoEquipo);

                    if (equipo != null) {
                        System.out.println("Ingrese el nombre del jugador a eliminar:");
                        String nombreJugador = scanner.nextLine();
                        boolean removed = equipo.getLstJugadores()
                                .removeIf(p -> p.getNombre().equals(nombreJugador));

                        if (removed) {
                            System.out.println("Jugador eliminado con éxito.");
                        } else {
                            System.out.println("Jugador no encontrado.");
                        }
                    } else {
                        System.out.println("Equipo no encontrado.");
                    }
                    break;

                case 5: // Listar todos los jugadores
                    System.out.println("Ingrese el código del equipo:");
                    codigoEquipo = scanner.nextLine();
                    equipo = controlador.equipos.get(codigoEquipo);

                    if (equipo != null) {
                        if (equipo.getLstJugadores().isEmpty()) {
                            System.out.println("No hay jugadores registrados en este equipo.");
                        } else {
                            System.out.println("Listado de jugadores:");
                            equipo.getLstJugadores().forEach(jugador -> {
                                System.out.println("Nombre: " + jugador.getNombre() + ", Edad: "
                                        + jugador.getEdad() + ", Posición: "
                                        + jugador.getPosicion());
                            });
                        }
                    } else {
                        System.out.println("Equipo no encontrado.");
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
