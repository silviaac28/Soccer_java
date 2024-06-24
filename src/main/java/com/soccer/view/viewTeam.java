package com.soccer.view;

import java.util.Scanner;
import com.soccer.Controller;
import com.soccer.model.entity.Team;

public class viewTeam {
    public static Controller controlador;

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Equipo");
            System.out.println("2. Actualizar Equipo");
            System.out.println("3. Buscar Equipo");
            System.out.println("4. Eliminar Equipo");
            System.out.println("5. Listar todos Equipos");
            System.out.println("6. Salir al menú principal");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Crear Equipo
                    Team equipo = new Team();
                    System.out.println("Ingrese el código del equipo:");
                    String codigoEquipo = scanner.nextLine();
                    System.out.println("Ingrese Nombre del equipo:");
                    equipo.setNombre(scanner.nextLine());
                    System.out.println("Ingrese la ciudad:");
                    equipo.setCiudad(scanner.nextLine());
                    controlador.equipos.put(codigoEquipo, equipo);
                    System.out.println("Equipo creado con éxito.");
                    break;

                case 2: // Actualizar Equipo
                    System.out.println("Ingrese el código del equipo a actualizar:");
                    codigoEquipo = scanner.nextLine();
                    equipo = controlador.equipos.get(codigoEquipo);
                    if (equipo != null) {
                        System.out.println("Ingrese el nuevo nombre del equipo (actual: " + equipo.getNombre() + "):");
                        equipo.setNombre(scanner.nextLine());
                        System.out.println("Ingrese la nueva ciudad del equipo (actual: " + equipo.getCiudad() + "):");
                        equipo.setCiudad(scanner.nextLine());
                        System.out.println("Equipo actualizado con éxito.");
                    } else {
                        System.out.println("Equipo no encontrado.");
                    }
                    break;

                case 3: // Buscar Equipo
                    System.out.println("Ingrese el código del equipo a buscar:");
                    codigoEquipo = scanner.nextLine();
                    equipo = controlador.equipos.get(codigoEquipo);
                    if (equipo != null) {
                        System.out.println("Nombre del equipo: " + equipo.getNombre());
                        System.out.println("Ciudad del equipo: " + equipo.getCiudad());
                    } else {
                        System.out.println("Equipo no encontrado.");
                    }
                    break;

                case 4: // Eliminar Equipo
                    System.out.println("Ingrese el código del equipo a eliminar:");
                    codigoEquipo = scanner.nextLine();
                    equipo = controlador.equipos.remove(codigoEquipo);
                    if (equipo != null) {
                        System.out.println("Equipo eliminado con éxito.");
                    } else {
                        System.out.println("Equipo no encontrado.");
                    }
                    break;

                case 5: // Listar todos Equipos
                    if (controlador.equipos.isEmpty()) {
                        System.out.println("No hay equipos registrados.");
                    } else {
                        controlador.equipos.forEach((codigo, team) -> {
                            System.out.println("Código: " + codigo + ", Nombre: " + team.getNombre() + ", Ciudad: " + team.getCiudad());
                        });
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
