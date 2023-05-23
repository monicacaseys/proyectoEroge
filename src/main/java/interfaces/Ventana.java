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

	private ArrayList<Personaje> personajes;
    private Gusto gustoElegido;

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
		if (clase.equals(PantallaLugar.class)) {
			this.setContentPane(new PantallaLugar(this));
		}

		if (clase.equals(PantallaEscena.class)) {
		    Random random = new Random();
		    int indiceAleatorio = random.nextInt(personajes.size());
		    Personaje personaje = personajes.get(indiceAleatorio);
		    this.setContentPane(new PantallaEscena(this, personaje));
		}
		this.getContentPane().setVisible(true);

	}
	 public void setGustoElegido(Gusto gustoElegido) {
	        this.gustoElegido = gustoElegido;
	    }

	public Gusto getGustoElegido() {
		return gustoElegido;
	}

	
}
