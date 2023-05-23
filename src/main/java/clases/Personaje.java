package clases;

import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.HashMap;

import enums.Gusto;
import enums.TipoPersonaje;
import utils.PersonajeDAO;

import java.util.Random;

public class Personaje extends Persona {

	private int nivelAmor;
	private byte nivel;
	private TipoPersonaje tipoPersonaje;
	private TemaDeConversacion temas;
	private HashSet<CitaIdeal> citasIdeales;
	private boolean poliamoroso;
	private BufferedImage imagen;
	private int indiceTemaActual;
	private List<Pregunta> preguntasNoRespondidas = new ArrayList<>();

	public Personaje(String nombre, int edad, String personalidad, HashSet<Gusto> gustos, TipoPersonaje tipoPersonaje,
			TemaDeConversacion temas, boolean poliamoroso, int nivelAmor, byte nivel) throws SQLException { 
		super(nombre, edad, personalidad, gustos);
		this.nivelAmor = nivelAmor;
		this.nivel = nivel;
		this.tipoPersonaje = tipoPersonaje;
		this.temas = temas;
		preguntasNoRespondidas.addAll(temas.getPreguntas());
		Collections.shuffle(preguntasNoRespondidas);
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

	public Pregunta obtenerSiguientePreguntaNoRespondida() {
		if (!preguntasNoRespondidas.isEmpty()) {
			return preguntasNoRespondidas.remove(0);
		} else {
			return null; // No hay más preguntas por responder
		}
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

	public TemaDeConversacion getTemas() {
		return temas;
	}

	public void setTemas(TemaDeConversacion temas) {
		this.temas = temas;
	}

}
