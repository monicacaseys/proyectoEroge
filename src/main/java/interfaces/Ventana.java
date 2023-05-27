package interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;

import javax.swing.JFrame;

import clases.Personaje;
import clases.Pregunta;
import clases.TemaDeConversacion;
import enums.Gusto;
import enums.TipoPersonaje;
import utils.PersonajeDAO;

public class Ventana extends JFrame {
    private Gusto gustoElegido;
    private PantallaEscena pantallaEscenaActual;
    private Personaje personaje;

	public Ventana() {
		this.setSize(600, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(new PantallaInicio(this));
		this.setVisible(true);

	}

	public void cambiarAPantalla(Class<?> clase) {// la ? es una plantalla/template puedo usar la clase que quiera sin
													// resticciones

		this.getContentPane().setVisible(false);
		if (clase.equals(PantallaInicio.class)) {
			this.setContentPane(new PantallaInicio(this));
		}
		if (clase.equals(PantallaNuevoJugador.class)) {
			this.setContentPane(new PantallaNuevoJugador(this));
		}
		if (clase.equals(PantallaHistoria.class)) {
			this.setContentPane(new PantallaHistoria(this));
		}
		

		if (clase.equals(PantallaEscena.class)) {
		    Random random = new Random();
		    int indiceAleatorio = random.nextInt(Personaje.getTodos().size());
		    personaje = Personaje.getTodos().get(indiceAleatorio);
		    System.out.println(personaje);
		    pantallaEscenaActual = new PantallaEscena(this, personaje);
		    this.setContentPane(pantallaEscenaActual);
		}
		if (clase.equals(PantallaLugar.class)) {
			this.setContentPane(new PantallaLugar(this));
		}
		if (clase.equals(PantallaCita.class)) {
			
			this.setContentPane(new PantallaCita(this, personaje));
		}
		this.getContentPane().setVisible(true);

	}
	 public void setGustoElegido(Gusto gustoElegido) {
	        this.gustoElegido = gustoElegido;
	    }

	public Gusto getGustoElegido() {
		return gustoElegido;
	}
	public PantallaEscena getPantallaEscenaActual() {
        return pantallaEscenaActual;
    }
	public void setPantallaEscenaActual(PantallaEscena pantallaEscena) {
	    this.pantallaEscenaActual = pantallaEscena;
	}


	
	
}
