package com.soccer.view;

import java.util.Scanner;
import com.soccer.Controller;
import com.soccer.model.entity.Coach;
import com.soccer.model.entity.Doctor;
import com.soccer.model.entity.Team;

public class viewDoctor {
    public static Controller controlador;

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Doctor");
            System.out.println("2. Actualizar Doctor");
            System.out.println("3. Buscar Doctor");
            System.out.println("4. Eliminar Doctor");
            System.out.println("5. Listar todos los Doctores");
            System.out.println("6. Salir al menú principal");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Crear Doctor
                    System.out.println("Ingrese el código del equipo al que pertenece el doctor:");
                    String codigoEquipo = scanner.nextLine();
                    Team equipo = controlador.equipos.get(codigoEquipo);

                    if (equipo != null) {
                        System.out.println("Ingrese ID del doctor:");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.println("Ingrese Nombre del doctor:");
                        String nombre = scanner.nextLine();
                        System.out.println("Ingrese Apellido del doctor:");
                        String apellido = scanner.nextLine();
                        System.out.println("Ingrese la Edad del doctor:");
                        int edad = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.println("Ingrese el Título del doctor:");
                        String titulo = scanner.nextLine();
                        System.out.println("Ingrese los Años de experiencia del doctor:");
                        int expYear = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        Doctor doctor = new Doctor(id, nombre, apellido, edad, titulo, expYear);
                        equipo.addDoctor(doctor); // Usamos el método addDoctor
                        System.out.println("Doctor creado con éxito y asignado al equipo " + equipo.getNombre());
                    } else {
                        System.out.println("Equipo no encontrado.");
                    }
                    break;

                case 2: // Actualizar Doctor
                    System.out.println("Ingrese el código del equipo del doctor:");
                    codigoEquipo = scanner.nextLine();
                    equipo = controlador.equipos.get(codigoEquipo);

                    if (equipo != null) {
                        System.out.println("Lista de Doctores:");
                        int index = 1;
                        for (Doctor doctor : equipo.getLstDoctores()) {
                            System.out.println(index + ". " + doctor.getNombre() + " " + doctor.getApellido());
                            index++;
                        }
                        System.out.println("Seleccione el doctor a actualizar (ingrese el número):");
                        int select = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        if (select > 0 && select <= equipo.getLstDoctores().size()) {
                            Doctor doctor = equipo.getLstDoctores().get(select - 1);
                            System.out.println("Ingrese el nuevo nombre del doctor (actual: " + doctor.getNombre() + "):");
                            doctor.setNombre(scanner.nextLine());
                            System.out.println("Ingrese el nuevo apellido del doctor (actual: " + doctor.getApellido() + "):");
                            doctor.setApellido(scanner.nextLine());
                            System.out.println("Ingrese la nueva edad del doctor (actual: " + doctor.getEdad() + "):");
                            doctor.setEdad(scanner.nextInt());
                            scanner.nextLine(); // Consume newline
                            System.out.println("Ingrese el nuevo título del doctor (actual: " + doctor.getTitulo() + "):");
                            doctor.setTitulo(scanner.nextLine());
                            System.out.println("Ingrese los nuevos años de experiencia del doctor (actual: " + doctor.getExpYear() + "):");
                            doctor.setExpYear(scanner.nextInt());
                            scanner.nextLine(); // Consume newline
                            System.out.println("Doctor actualizado con éxito.");
                        } else {
                            System.out.println("Número de doctor seleccionado inválido.");
                        }
                    } else {
                        System.out.println("Equipo no encontrado.");
                    }
                    break;

                case 3: // Buscar Doctor
                    System.out.println("Ingrese el código del equipo del doctor:");
                    codigoEquipo = scanner.nextLine();
                    equipo = controlador.equipos.get(codigoEquipo);

                    if (equipo != null) {
                        System.out.println("Lista de Doctores:");
                        int index = 1;
                        for (Doctor doctor : equipo.getLstDoctores()) {
                            System.out.println(index + ". " + doctor.getNombre() + " " + doctor.getApellido());
                            index++;
                        }
                        System.out.println("Seleccione el doctor a buscar (ingrese el número):");
                        int select = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        if (select > 0 && select <= equipo.getLstDoctores().size()) {
                            Doctor doctor = equipo.getLstDoctores().get(select - 1);
                            System.out.println("Nombre del doctor: " + doctor.getNombre());
                            System.out.println("Apellido del doctor: " + doctor.getApellido());
                            System.out.println("Edad del doctor: " + doctor.getEdad());
                            System.out.println("Título del doctor: " + doctor.getTitulo());
                            System.out.println("Años de experiencia del doctor: " + doctor.getExpYear());
                        } else {
                            System.out.println("Número de doctor seleccionado inválido.");
                        }
                    } else {
                        System.out.println("Equipo no encontrado.");
                    }
                    break;

                case 4: // Eliminar Doctor
                    System.out.println("Ingrese el código del equipo del doctor:");
                    codigoEquipo = scanner.nextLine();
                    equipo = controlador.equipos.get(codigoEquipo);

                    if (equipo != null) {
                        System.out.println("Lista de Doctores:");
                        int index = 1;
                        for (Doctor doctor : equipo.getLstDoctores()) {
                            System.out.println(index + ". " + doctor.getNombre() + " " + doctor.getApellido());
                            index++;
                        }
                        System.out.println("Seleccione el doctor a eliminar (ingrese el número):");
                        int select = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        if (select > 0 && select <= equipo.getLstDoctores().size()) {
                            equipo.getLstDoctores().remove(select - 1);
                            System.out.println("Doctor eliminado con éxito.");
                        } else {
                            System.out.println("Número de doctor seleccionado inválido.");
                        }
                    } else {
                        System.out.println("Equipo no encontrado.");
                    }
                    break;

                case 5: // listar los doctores
                    for (Team team : controlador.equipos.values()) {
                        for (Doctor doctor : team.getLstDoctores()) {
                            System.out.println("Equipo: " + team.getNombre() + ", Nombre: " + doctor.getNombre() + ", Apellido: " + doctor.getApellido() + ", Edad: " + doctor.getEdad() + ", Titulo del doctor: " + doctor.getTitulo() + ", Años de experiencia: " + doctor.getExpYear());
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