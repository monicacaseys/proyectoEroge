package clases;

import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
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

	private int id;
	private int nivelAmor;
	private byte nivel;
	private TipoPersonaje tipoPersonaje;
	private TemaDeConversacion temas;
	private HashSet<CitaIdeal> citasIdeales;
	private boolean poliamoroso;
	private BufferedImage imagen;
	private int indiceTemaActual;
	private List<Pregunta> preguntasNoRespondidas = new ArrayList<>();
	

	public Personaje(String nombre) throws SQLException {
		super(nombre);
	
	}
	public Personaje(int id,String nombre, int edad, String personalidad, HashSet<Gusto> gustos, TipoPersonaje tipoPersonaje,
			boolean poliamoroso, int nivelAmor, byte nivel) throws SQLException {
		super(nombre, edad, personalidad, gustos);
		this.nivelAmor = nivelAmor;
		this.nivel = nivel;
		this.tipoPersonaje = tipoPersonaje;
		this.temas = new TemaDeConversacion();
		crearTema();
		preguntasNoRespondidas.addAll(temas.getPreguntas());
	    Collections.shuffle(preguntasNoRespondidas);
		this.indiceTemaActual = 0;
		this.poliamoroso = poliamoroso;
		this.id=id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	        	int idPersonaje = (int) resultados.get(i);
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
	            Personaje personaje = new Personaje(idPersonaje,nombre, edad, personalidad, gustos, tipoPersonaje, poliamoroso, nivelAmor, nivel);
	          
	            
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
	        Pregunta siguientePregunta = preguntasNoRespondidas.remove(0);
	        return siguientePregunta;
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
	public void aumentarNivel() {
	    nivel++;
	    nivelAmor = 50;
	}
	public TemaDeConversacion getTemas() {
		return temas;
	}

	public void setTemas(TemaDeConversacion temas) {
		this.temas = temas;
	}
	public void crearTema() {
	    TemaDeConversacion tema = new TemaDeConversacion();

	    Pregunta pregunta1 = new Pregunta("¿Cuál es mi color favorito?",
	            new ArrayList<>(Arrays.asList("Rojo", "Azul")), "Azul");
	    Pregunta pregunta2 = new Pregunta("¿Cuál es mi comida favorita?",
	            new ArrayList<>(Arrays.asList("Pizza", "Sushi")), "Pizza");
	    Pregunta pregunta3 = new Pregunta("¿Eres misogin@?",
	            new ArrayList<>(Arrays.asList("Si", "No")), "No");
	    Pregunta pregunta4 = new Pregunta("¿Cuál es una barrera para las mujeres en su lucha por la igualdad de género?",
	            new ArrayList<>(Arrays.asList("Su objetivización", "Estar locas ")), "Su objetivización");
	    Pregunta pregunta5 = new Pregunta("¿Cómo podemos fomentar una educación más equitativa e inclusiva?",
	            new ArrayList<>(Arrays.asList("Porno sin filtros", "Porno filtrado")), "Porno filtrado");
	    Pregunta pregunta6 = new Pregunta("¿Te parece importante promover el liderazgo feminista?",
	            new ArrayList<>(Arrays.asList("Si", "No")), "Si");
	    Pregunta pregunta7 = new Pregunta("¿Cuál es el papel de la educación en la desmantelación del patriarcado?",
	            new ArrayList<>(Arrays.asList("No puede hacer nada", "Papel de actor importante")), "Papel de actor importante");
	    Pregunta pregunta8 = new Pregunta("¿Cómo podemos abordar la violencia de género?",
	            new ArrayList<>(Arrays.asList("Leyes y conscienciación", "Mantenerse al margen")), "Leyes y conscienciación");
	    Pregunta pregunta9 = new Pregunta("¿Existe una representación equitativa y diversa en los medios de comunicación?",
	            new ArrayList<>(Arrays.asList("Si", "No")), "Si");
	    Pregunta pregunta10 = new Pregunta("¿Apoyas la lucha contra el patriarcado?",
	            new ArrayList<>(Arrays.asList("Si", "No")), "Si");
	    Pregunta pregunta11 = new Pregunta("¿Desafias los roles de género tradicionales impuestas por la sociedad?",
	            new ArrayList<>(Arrays.asList("Si", "No")), "Si");
	    Pregunta pregunta12 = new Pregunta("¿Es bueno hablar sobre el patriarcado y feminismo?",
	            new ArrayList<>(Arrays.asList("Si", "No")), "Si");
	    Pregunta pregunta13 = new Pregunta(" ¿Perrito caliente machista o ensalada heteronormativa?",
	            new ArrayList<>(Arrays.asList("Perrito caliente machista", "Ensalada heteronormativa")), "Perrito caliente machista");
	    Pregunta pregunta14 = new Pregunta("Si fuera un videojuego¿cuál sería su nivel más difícil?",
	            new ArrayList<>(Arrays.asList("Fortaleza del Machismo", "Laberinto de la Heteronorma")), "Laberinto de la Heteronorma");
	    Pregunta pregunta15 = new Pregunta("¿Cómo podemos desafiar el patriarcado en nuestra vida cotidiana?",
	            new ArrayList<>(Arrays.asList("Cuestionar roles", "Seguir roles")), "Cuestionar roles");
	   
	    tema.agregarPregunta(pregunta1);
	    tema.agregarPregunta(pregunta2);
	    tema.agregarPregunta(pregunta3);
	    tema.agregarPregunta(pregunta4);
	    tema.agregarPregunta(pregunta5);
	    tema.agregarPregunta(pregunta6);
	    tema.agregarPregunta(pregunta7);
	    tema.agregarPregunta(pregunta8);
	    tema.agregarPregunta(pregunta9);
	    tema.agregarPregunta(pregunta10);
	    tema.agregarPregunta(pregunta11);
	    tema.agregarPregunta(pregunta12);
	    tema.agregarPregunta(pregunta13);
	    tema.agregarPregunta(pregunta14);
	    tema.agregarPregunta(pregunta15);

	    temas = tema; // Asignar el tema de conversación al personaje
	}
	


}
