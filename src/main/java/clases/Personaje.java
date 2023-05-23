package clases;

import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
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
			boolean poliamoroso, int nivelAmor, byte nivel) throws SQLException {
		super(nombre, edad, personalidad, gustos);
		this.nivelAmor = nivelAmor;
		this.nivel = nivel;
		this.tipoPersonaje = tipoPersonaje;
		this.temas = temas;
		//preguntasNoRespondidas.addAll(temas.getPreguntas());
	//	Collections.shuffle(preguntasNoRespondidas);
		this.indiceTemaActual = 0;
		this.poliamoroso = poliamoroso;
	}
	
	public static ArrayList<Personaje> getTodos() {
	    ArrayList<Personaje> personajes = new ArrayList<>();

	    try {
	        // Definir las columnas a seleccionar en la consulta
	        LinkedHashSet<String> columnasSelect = new LinkedHashSet<>();
	        columnasSelect.add("id");
	        columnasSelect.add("nombre");
	        columnasSelect.add("edad");
	        columnasSelect.add("personalidad");
	        columnasSelect.add("nivelAmor");
	        columnasSelect.add("nivel");
	        columnasSelect.add("tipoPersonaje");
	        columnasSelect.add("poliamoroso");
	        columnasSelect.add("gustos");

	        // Definir las restricciones de la consulta (si es necesario)
	        HashMap<String, Object> restricciones = new HashMap<>();
	        // Agrega aquí las restricciones necesarias, por ejemplo, si deseas filtrar por algún valor específico

	        // Realizar la consulta a la base de datos para obtener los resultados
	        ArrayList<Object> resultados = PersonajeDAO.consultar("personaje", columnasSelect, restricciones);

	        // Recorrer los resultados y crear instancias de Personaje
	        for (int i = 0; i < resultados.size(); i += 9) {
	            String nombre = (String) resultados.get(i + 1);
	            int edad = (int) resultados.get(i + 2);
	            String personalidad = (String) resultados.get(i + 3);
	            int nivelAmor = (int) resultados.get(i + 4);
	            byte nivel = ((Integer) resultados.get(i + 5)).byteValue();
	            String tipoPersonajeStr = (String) resultados.get(i + 6).toString().toUpperCase();
	            boolean poliamoroso = (int) resultados.get(i + 7) == 1;
	            String gustosStr = (String) resultados.get(i + 8).toString().toUpperCase();

	            // Crear instancia de TipoPersonaje a partir del valor obtenido de la base de datos
	            TipoPersonaje tipoPersonaje = TipoPersonaje.valueOf(tipoPersonajeStr);

	            // Convertir la cadena de gustos en un HashSet<Gusto>
	            HashSet<Gusto> gustos = new HashSet<>();
	            String[] gustosArr = gustosStr.split(",");
	            for (String gustoStr : gustosArr) {
	                gustos.add(Gusto.valueOf(gustoStr.trim()));
	            }

	            // Crear instancia de Personaje con los datos obtenidos
	            Personaje personaje = new Personaje(nombre, edad, personalidad, gustos, tipoPersonaje, poliamoroso, nivelAmor, nivel);

	            // Agregar el personaje a la lista
	            personajes.add(personaje);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // Manejar la excepción de SQL
	    }

	    return personajes;
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
