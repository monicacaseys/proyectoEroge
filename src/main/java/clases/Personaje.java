package clases;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashSet;

import enums.Gusto;
import enums.TipoPersonaje;

public class Personaje extends Persona {

	private int nivelAmor;
	private byte nivel;
	private TipoPersonaje tipoPersonaje;
	private ArrayList<TemaDeConversacion> temas;
	private HashSet<CitaIdeal> citasIdeales;
	private boolean poliamoroso;
	private BufferedImage imagen;

	public Personaje(String nombre, int edad, String personalidad, HashSet<Gusto> gustos, int nivelAmor,
			byte nivel, TipoPersonaje tipoPersonaje, ArrayList<TemaDeConversacion> temas,
			HashSet<CitaIdeal> citasIdeales, boolean poliamoroso, BufferedImage imagen) {
		super(nombre, edad, personalidad, gustos);
		this.nivelAmor = nivelAmor;
		this.nivel = nivel;
		this.tipoPersonaje = tipoPersonaje;
		this.temas = new ArrayList<>();
		this.citasIdeales = new HashSet<>();
		this.poliamoroso = poliamoroso;
		this.imagen = imagen;
	}

	public Personaje(String nombre, int edad, String personalidad, HashSet<Gusto> gustos,
			TipoPersonaje tipoPersonaje, boolean poliamoroso) {
		super(nombre, edad, personalidad, gustos);
		this.nivelAmor = 50;
		this.nivel = 1;
		this.tipoPersonaje = tipoPersonaje;
		this.temas = new ArrayList<>();
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

	public ArrayList<TemaDeConversacion> getTemas() {
		return temas;
	}

	public void setTemas(ArrayList<TemaDeConversacion> temas) {
		this.temas = temas;
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

	public void agregarTemaDeConversacion(TemaDeConversacion tema) {
		temas.add(tema);
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
		System.out.println(super.getNombre() + " ha disminuido su nivel de amor a " +nivelAmor);

	    }

}
