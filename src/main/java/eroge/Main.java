package eroge;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import clases.Personaje;
import clases.Pregunta;
import clases.TemaDeConversacion;
import enums.Gusto;
import enums.TipoPersonaje;
import interfaces.Ventana;
import utils.PersonajeDAO;

public class Main {
    public static void main(String[] args) {
    	
    	    
			try {
				ArrayList<Personaje> personajes = Personaje.getTodos();
				 for (Personaje p : personajes) {
		    	        System.out.println("Nombre: " + p.getNombre() + ", Edad: " + p.getEdad() + ", Personalidad: " + p.getPersonalidad());
		    	        System.out.print("Gustos: ");
		    	        Iterator<Gusto> iterator = p.getGustos().iterator();
		    	        while (iterator.hasNext()) {
		    	            Gusto gusto = iterator.next();
		    	            System.out.print(gusto);
		    	            if (iterator.hasNext()) {
		    	                System.out.print(", ");
		    	            }
		    	        }
		    	        System.out.println();
		    	        // Agrega aquí las propiedades adicionales del personaje que deseas mostrar
		    	        
				 }
		    	    
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        Ventana v = new Ventana();
    }
}

