package clases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import enums.Gusto;
import enums.TipoPersonaje;
import utils.PersonajeDAO;

public class Jugador extends Persona {
	
	private String nombreClave;
	public Jugador(String nombre, int edad, String personalidad, HashSet<Gusto> gustos) throws SQLException {
		super(nombre, edad, personalidad, gustos); //String nombreClave,
		// TODO Auto-generated constructor stub
		HashMap<String, Object> columnas = new HashMap<>();
	    columnas.put("nombre", nombre);
	    columnas.put("edad", edad);
	    columnas.put("personalidad", personalidad);
	  //columnas.put("nombreClave", nombreClave);
	    
	    PersonajeDAO.insertar("jugador", columnas);
	    
	    
	}

	
	
/*CONTRCUTRO PAR COMPROBAR SI HAY ESE NOMBRE Y CONTINUAR
	public Jugador(String nombre, int edad, String personalidad, HashSet<Gusto> gustos) throws JugadorNoExisteException {
	    super(nombre, edad, personalidad, gustos);

	    LinkedHashSet<String> columnasSacar = new LinkedHashSet<>();
	    columnasSacar.add("nombre");

	    HashMap<String, Object> restricciones = new HashMap<>();
	    restricciones.put("nombre", nombre);

	    ArrayList<Object> resultado = null;
	    try {
	        resultado = DAO.consultar("jugador", columnasSacar, restricciones);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    if (resultado.isEmpty()) {
	        throw new JugadorNoExisteException("El jugador no existe");
	    }
	}
*/

	 public static Jugador crearNuevoJugador(String nombre, int edad, String personalidad, HashSet<Gusto> gustos) throws SQLException {
	        return new Jugador(nombre, edad, personalidad, gustos);
	    }

	
	
	
	

}
