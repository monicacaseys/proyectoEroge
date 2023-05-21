package clases;

import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

import enums.Gusto;
import enums.TipoPersonaje;
import utils.PersonajeDAO;

import java.util.Random;

public class Personaje extends Persona {

	private int nivelAmor;
	private byte nivel;
	private TipoPersonaje tipoPersonaje;
	private ArrayList<TemaDeConversacion> temas;
	private HashSet<CitaIdeal> citasIdeales;
	private boolean poliamoroso;
	private BufferedImage imagen;
	private int indiceTemaActual;

	public Personaje(String nombre, int edad, String personalidad, HashSet<Gusto> gustos, TipoPersonaje tipoPersonaje,
	        ArrayList<TemaDeConversacion> temas, boolean poliamoroso, int nivelAmor,byte nivel) throws SQLException { //debo añadir nivelAmor y nivel?
	    super(nombre, edad, personalidad, gustos);
	    this.nivelAmor = nivelAmor;
	    this.nivel = nivel;
	    this.tipoPersonaje = tipoPersonaje;
	    this.temas = temas;
	    this.indiceTemaActual = 0;
	    this.poliamoroso = poliamoroso;
	}





	public int getNivelAmor() {
		return nivelAmor;
	}

	public void setNivelAmor(int nivelAmor) {
		this.nivelAmor = nivelAmor;
	}

	public byte getNivel() {
		return nivel;
	}

	public void setNivel(byte nivel) {
		this.nivel = nivel;
	}

	public TipoPersonaje getTipoPersonaje() {
		return tipoPersonaje;
	}

	public void setTipoPersonaje(TipoPersonaje tipoPersonaje) {
		this.tipoPersonaje = tipoPersonaje;
	}



	public HashSet<CitaIdeal> getCitasIdeales() {
		return citasIdeales;
	}

	public void setCitasIdeales(HashSet<CitaIdeal> citasIdeales) {
		this.citasIdeales = citasIdeales;
	}

	public boolean isPoliamoroso() {
		return poliamoroso;
	}

	public void setPoliamoroso(boolean poliamoroso) {
		this.poliamoroso = poliamoroso;
	}

	public BufferedImage getImagen() {
		return imagen;
	}

	public void setImagen(BufferedImage imagen) {
		this.imagen = imagen;
	}
//dudo
	public TemaDeConversacion obtenerTemaDeConversacionAleatorio() {
        Random random = new Random();
        int indiceAleatorio = random.nextInt(temas.size());
        return temas.get(indiceAleatorio);
    }

	   public Pregunta obtenerSiguientePregunta() {
	        TemaDeConversacion temaActual = temas.get(indiceTemaActual);
	        Pregunta siguientePregunta = temaActual.obtenerPreguntaSiguiente();
	        
	        // Incrementar el índice del tema actual
	        indiceTemaActual++;
	        if (indiceTemaActual >= temas.size()) {
	            indiceTemaActual = 0;
	        }
	        
	        return siguientePregunta;
	    }
	public void morir(Personaje personaje) {
		if (nivelAmor < 0) {
			System.out.println(super.getNombre() + " ha muerto.");
		}
	}

	public void aumentarAmor() {
		nivelAmor += 15;
		System.out.println(super.getNombre() + " ha aumentado su nivel de amor a " + nivelAmor);
	}

	public void disminuirAmor() {
		nivelAmor -= 15;
		System.out.println(super.getNombre() + " ha disminuido su nivel de amor a " + nivelAmor);

	}

	public ArrayList<TemaDeConversacion> getTemas() {
		return temas;
	}

	public void setTemas(ArrayList<TemaDeConversacion> temas) {
		this.temas = temas;
	}

}
