package com.soccer.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String codigo;
    private String nombre;
    private String ciudad;
    private List<Player> lstJugadores = new ArrayList<>();
    private List<Doctor> lstDoctores = new ArrayList<>();
    private List<Coach> lstEntrenadores = new ArrayList<>();

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<Player> getLstJugadores() {
        return lstJugadores;
    }

    public void setLstJugadores(List<Player> lstJugadores) {
        this.lstJugadores = lstJugadores;
    }

    public void addJugador(Player jugador) {
        this.lstJugadores.add(jugador);
    }

    public List<Doctor> getLstDoctores() {
        return lstDoctores;
    }

    public void setLstDoctores(List<Doctor> lstDoctores) {
        this.lstDoctores = lstDoctores;
    }

    public void addDoctor(Doctor doctor) {
        this.lstDoctores.add(doctor);
    }

    public List<Coach> getLstEntrenadores() {
        return lstEntrenadores;
    }

    public void setLstEntrenadores(List<Coach> lstEntrenadores) {
        this.lstEntrenadores = lstEntrenadores;
    }

    public void addEntrenador(Coach entrenador) {
        this.lstEntrenadores.add(entrenador);
    }

    // Método para obtener un entrenador por su ID de federación
    public Coach getEntrenador(int idFederacion) {
        for (Coach entrenador : lstEntrenadores) {
            if (entrenador.getIdFederacion() == idFederacion) {
                return entrenador;
            }
        }
        return null; // Retorna null si no se encuentra ningún entrenador con ese ID de federación
    }

    // Método para eliminar un entrenador por su ID de federación
    public boolean removeEntrenador(int idFederacion) {
        Coach entrenadorToRemove = null;
        for (Coach entrenador : lstEntrenadores) {
            if (entrenador.getIdFederacion() == idFederacion) {
                entrenadorToRemove = entrenador;
                break;
            }
        }
        if (entrenadorToRemove != null) {
            lstEntrenadores.remove(entrenadorToRemove);
            return true; // Se eliminó correctamente
        }
        return false; // No se encontró el entrenador con ese ID de federación
    }
}
