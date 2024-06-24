package com.soccer;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("¡Bienvenido a BET PLAY!\n");
        System.out.println("Seleccione la opción deseada: \n");
        Controller controlador = new Controller();
    

    
        Scanner scanner= new Scanner(System.in); 

        while (true) {
            System.out.println("1. Gestión Equipos");
            System.out.println("2. Gestión Jugadores");
            System.out.println("3. Gestión Doctores");
            System.out.println("4. Gestión Entrenadores");
            System.out.println("5. Salir del programa");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Crear Equipo
                    controlador.iniciarViewTeam();
                    break;

                case 2: // Gestionar Jugadores
                    controlador.iniciarViewPlayer();
                    break;

                case 3: // Gestionar Doctores
                    controlador.iniciarViewDoctor();
                    break;

                case 4: // Gestionar Entrenadores
                    controlador.iniciarViewCoach();
                    break;

                case 5: // Salir
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción inválida, inténtelo de nuevo.");
            }
        }
    }
}

