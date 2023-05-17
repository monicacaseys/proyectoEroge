package eroge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

import clases.Personaje;
import clases.Pregunta;
import clases.TemaDeConversacion;
import enums.Gusto;
import enums.TipoPersonaje;
import interfaces.Ventana;

public class Main {

	public static void main(String[] args) {
		
		 Pregunta pregunta1 = new Pregunta("¿Cuál es tu color favorito?",
	                new ArrayList<>(Arrays.asList("Rojo", "Azul", "Verde")), "Azul");

	        Pregunta pregunta2 = new Pregunta("¿Cuál es tu comida favorita?",
	                new ArrayList<>(Arrays.asList("Pizza", "Hamburguesa", "Sushi")), "Sushi");

	        // Crear tema de conversación
	        TemaDeConversacion tema1 = new TemaDeConversacion();
	        tema1.agregarPregunta(pregunta1);
	        tema1.agregarPregunta(pregunta2);

	        HashSet<Gusto> gustos = new HashSet<>();
	        gustos.add(Gusto.PLAYA);
	        gustos.add(Gusto.CINE);
	        gustos.add(Gusto.SUSHI);

	        // Crear personaje
	        Personaje personaje = new Personaje("Alice", 25, "Alegre", gustos,
	                TipoPersonaje.MOUNSTRO, false);

	        // Asignar tema de conversación aleatorio al personaje
	        Random random = new Random();
	        ArrayList<TemaDeConversacion> temas = new ArrayList<>();
	        temas.add(tema1);

	        TemaDeConversacion temaAleatorio = temas.get(random.nextInt(temas.size()));
	        personaje.agregarTemaDeConversacion(temaAleatorio);

	
	

	    System.out.println("Nivel de amor de " + personaje.getNombre() + ": " + personaje.getNivelAmor());
	
	    Ventana v= new Ventana();
	}

}
