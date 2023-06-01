package interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import clases.Jugador;
import clases.Personaje;
import clases.Pregunta;
import clases.TemaDeConversacion;
import enums.Gusto;
import enums.TipoPersonaje;
import utils.PersonajeDAO;

public class Ventana extends JFrame {
    private Gusto gustoElegido;
    private PantallaEscena pantallaEscenaActual;
    protected Personaje personaje;
    protected Jugador jugador;
    private int nivelAmorActual;
    
	public Ventana() {
		this.setSize(800, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(new PantallaInicio(this));
		this.jugador = null; // Inicialmente el jugador es nulo
		this.setIconImage(new ImageIcon("./icono.png").getImage());
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
		    PantallaEscena pantallaEscena = getPantallaEscenaActual();
	        if (pantallaEscena != null) {
	            nivelAmorActual = pantallaEscena.getNivelAmorActual();
	        }
		    pantallaEscenaActual = new PantallaEscena(this, personaje,jugador);
		    this.setContentPane(pantallaEscenaActual);
		}
		
		if (clase.equals(PantallaLugar.class)) {
			this.setContentPane(new PantallaLugar(this));
		}
		if (clase.equals(PantallaCita.class)) {
			
			this.setContentPane(new PantallaCita(this, personaje));
		}
		if (clase.equals(PantallaCasarse.class)) {
			this.setContentPane(new PantallaCasarse(this,jugador,personaje));
		}
		if (clase.equals(PantallaRanking.class)) {
			this.setContentPane(new PantallaRanking(this));
		}
		if (clase.equals(PantallaAmigo.class)) {
			this.setContentPane(new PantallaAmigo(this));
		}
		
		this.getContentPane().setVisible(true);

	}
	
	 public int getNivelAmorActual() {
	        return nivelAmorActual;
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

	  public void setJugador(Jugador jugador) {
	        this.jugador = jugador;
	    }
	  public void crearNuevaPantallaEscena() {
		    Random random = new Random();
		    int indiceAleatorio = random.nextInt(Personaje.getTodos().size());
		    Personaje personajeNuevo = Personaje.getTodos().get(indiceAleatorio);
		    PantallaEscena nuevaPantallaEscena = new PantallaEscena(this, personajeNuevo,jugador);
		    this.setContentPane(nuevaPantallaEscena);
		 //   pantallaEscenaActual = nuevaPantallaEscena;
		}

}
//posible sitio para guardar el personaje asociado a un jugador
/*  jugador.agregarPersonaje(indiceAleatorio); // Agregar el nuevo personaje al jugador

  // Crear un mapa con el personaje y la cantidad
  HashMap<Integer, Integer> mapaPersonajes = new HashMap<>();
  mapaPersonajes.put(indiceAleatorio, 1);

  // Guardar los datos del jugador y los personajes en la base de datos
  PersonajeDAO personajeDAO = new PersonajeDAO();
  personajeDAO.guardarDatosJugadorYPersonajes(jugador, mapaPersonajes);*/