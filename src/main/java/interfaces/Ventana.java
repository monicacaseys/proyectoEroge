package interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

import javax.swing.JFrame;

import clases.Personaje;
import clases.TemaDeConversacion;
import enums.Gusto;
import enums.TipoPersonaje;
import utils.PersonajeDAO;

public class Ventana extends JFrame {

	private ArrayList<Personaje> personajes;

	public Ventana() {
		this.setSize(600, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(new PantallaInicio(this));
		this.personajes = cargarPersonajesDesdeBD();
		this.setVisible(true);

	}

private ArrayList<Personaje> cargarPersonajesDesdeBD() {
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
         // Imprimir los personajes cargados en el ArrayList
            System.out.println("Personajes cargados desde la base de datos:");
            for (Personaje personaje : personajes) {
                System.out.println(personaje);
            }

            // Crear una lista vacía de temas de conversación
            ArrayList<TemaDeConversacion> temas = new ArrayList<>();

            try {
                // Crear instancia de Personaje con los datos obtenidos
                Personaje personaje = new Personaje(nombre, edad, personalidad, gustos, tipoPersonaje, temas, poliamoroso,nivelAmor,(byte) nivel);
                personajes.add(personaje);
            } catch (SQLException e) {
                // Manejar la excepción de SQL
                e.printStackTrace();
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Manejar la excepción de SQL
    }

    return personajes;
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

		this.getContentPane().setVisible(true);

	}
}
