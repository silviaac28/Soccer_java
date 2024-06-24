package com.soccer;

import java.util.Hashtable;

import com.soccer.model.entity.Team;
import com.soccer.view.viewDoctor;
import com.soccer.view.viewPlayer;
import com.soccer.view.viewTeam;
import com.soccer.view.viewCoach;

public class Controller {
    public Hashtable<String, Team> equipos = new Hashtable<>();

    private viewTeam vistaEquipo = new viewTeam();
    private viewPlayer vistaJugador = new viewPlayer();
    private viewDoctor vistaDoctor = new viewDoctor();
    private viewCoach vistaCoach = new viewCoach();

    public void iniciarViewTeam() {
        viewTeam.controlador = this;
        vistaEquipo.start();
    }

    public void iniciarViewPlayer() {
        viewPlayer.controlador = this;
        vistaJugador.start();
    }

    public void iniciarViewDoctor() {
        viewDoctor.controlador = this;
        vistaDoctor.start();
    }

    public void iniciarViewCoach() {
        viewCoach.controlador = this;
        vistaCoach.start();
    }
}
