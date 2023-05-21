package utils;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map.Entry;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class PersonajeDAO {

	private static Connection conexion;
	// 127.0.0.1 3306 bicicletasdaw root admin
		private static Statement conectar() {
		//intentar conectar general
		try {
			BufferedReader lector=new BufferedReader(new FileReader("bdconfig.ini"));
			String ip=lector.readLine();
			int puerto=Integer.parseInt(lector.readLine());
			String nombreBD=lector.readLine();
			String user=lector.readLine();
			String password=lector.readLine();
			lector.close();
			conexion = DriverManager.getConnection("jdbc:mysql://"+ip+":"+puerto+
					"/"+nombreBD, user, password);
			return conexion.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
		private static void desconectar(Statement s) {
			try { // el try catch lo pone como sugerencia al escribir close
				s.close();
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		public static int insertar(String tabla, HashMap<String, Object> columnas) throws SQLException { 																		
			
			Statement smt = conectar();
			String consulta = "insert into " + tabla + " (";
			Iterator it = columnas.keySet().iterator();
			while (it.hasNext()) {
				consulta += (String) it.next() + ",";
			}

			consulta = consulta.substring(0, consulta.length() - 1);	// hay que quitar la ultima coma porque sino sale error se sintaxixs
			consulta += ") values ("; 
			it = columnas.values().iterator();
			while (it.hasNext()) {
				Object elemento = it.next();
				if(elemento.getClass()!=String.class&&elemento.getClass()!=Character.class) { // sea lo que sea no lleavara comillas porq sino peta
					consulta+=elemento+",";
				} else {
					consulta += "'" + (String) elemento + "',";
				}
				
			}
		
			consulta = consulta.substring(0, consulta.length() - 1); 	// volver a quitar la ultima coma
			consulta += ")";
			if(Config.verboseMode) {
			System.out.println(consulta);
			}
			int ret = smt.executeUpdate(consulta);
			desconectar(smt);
			return ret; 
		}

		public static int borrar(String tabla, HashMap<String, Object> columnas) throws SQLException {																						// SUGUIERE
			Statement smt = conectar();
			String consulta = "delete from " + tabla + " where ";
			Iterator it = columnas.entrySet().iterator();
			while (it.hasNext()) {
				Entry actual = (Entry) it.next(); // importar de mapa
				
				if(actual.getValue()!=String.class&&actual.getValue()!=Character.class) {
					consulta += (String) actual.getKey() + "=" + (String) actual.getValue() + " and";
					
				}else {
					consulta += (String) actual.getKey() + "='" + (String) actual.getValue() + "' and"; // va recorriendo las entradas podemos buscar por el campo que nos de la gana
				}
			
			}
			consulta = consulta.substring(0, consulta.length() - 5); // borra el ultimo and
			if(Config.verboseMode) {
			System.out.println(consulta);// antes de hacer la operacion la imprimimos para ver si haty errores
			}
			
			int ret = smt.executeUpdate(consulta);// facil de usar. hayq ue cambiar la clave primaria de la que se metio en
													// la base de datos porque sino esta suplicada. Desde aqui lo inserto
													// desde java
			// desconectar
			desconectar(smt);
			return ret; // me da el numero de evces que se borro
		}

		public static ArrayList<Object> consultar(String tabla, LinkedHashSet<String> columnasSelect,
				HashMap<String, Object> restricciones) throws SQLException { 

			Statement smt = conectar();
			String query = "select ";
			Iterator ith = columnasSelect.iterator();
			while (ith.hasNext()) {
				query += (String) ith.next() + ",";
			}
			query = query.substring(0, query.length() - 1) + " from " + tabla + (restricciones.size() > 0 ? " where " : "");
			Iterator itm = restricciones.entrySet().iterator();
			while (itm.hasNext()) {
				Entry actual = (Entry) itm.next();
				if(actual.getValue().getClass()!=String.class&&actual.getValue().getClass()!=Character.class) {
					query += (String) actual.getKey() + "=" + (String) actual.getValue() + " and ";
				}else {
					query += (String) actual.getKey() + "='" + (String) actual.getValue() + "' and ";	
				}
				
			}
			if(restricciones.size()>0) { //importante esta condicion conla resticcion
				query=query.substring(0,query.length()-5);
			}
			if(Config.verboseMode) {
			System.out.println(query);
			}

			ResultSet cursor = smt.executeQuery(query); 
			ArrayList<Object> fila = new ArrayList<Object>();
			
			while (cursor.next()) { 
	           Iterator hsCols=columnasSelect.iterator();
	           while(hsCols.hasNext()) {
	        	   String nombreCol=(String)hsCols.next();
	        	   try {
	        		   fila.add(cursor.getInt(cursor.findColumn(nombreCol))); // Si no es un entero da error por lo que lo capturo 
	        	   }catch(NumberFormatException | SQLException e) {
	        		   fila.add(cursor.getString(cursor.findColumn(nombreCol))); // por si es un string lo mete ahi
	        	   }
	           }
	           }
			desconectar(smt);
			return fila;

		}
		
		public static int actualizar(String tabla,HashMap<String, Object> datosAModificar, HashMap<String,Object> restricciones) throws SQLException {
			String query="update "+tabla+" set ";
			Iterator itm= datosAModificar.entrySet().iterator();
			while(itm.hasNext()) {
				Entry actual=(Entry)itm.next() ;//poner un solo next dentro del bucle
				if(actual.getValue().getClass()!=String.class&&actual.getValue().getClass()!=Character.class) {
					query+=actual.getKey()+" = "+actual.getValue()+",";
				}else {
					query+=actual.getKey()+" = '"+actual.getValue()+"',";
				}
			}
				query=query.substring(0,query.length()-1)+" where ";
				Iterator itr = restricciones.entrySet().iterator();
				while(itr.hasNext()) {
					Entry actual=(Entry)itr.next() ;//poner un solo next dentro del bucle
					if(actual.getValue().getClass()!=String.class&&actual.getValue().getClass()!=Character.class) {
						query+=actual.getKey()+" = "+actual.getValue()+" and ";
					}else {
						query+=actual.getKey()+" = '"+actual.getValue()+"' and ";
					}
				
				}
				query=query.substring(0,query.length()-5);
				
				Statement smt=conectar();
				if(Config.verboseMode) {
				System.out.println(query);
				}
				int ret=smt.executeUpdate(query);
				desconectar(smt);
				
				return ret;
				
		}

	    public static boolean verificarExistenciaPersonaje(String nombre) throws SQLException {
	        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/eroge", "root", "admin")) {
	            String query = "SELECT COUNT(*) FROM personaje WHERE nombre = ?";
	            try (PreparedStatement statement = connection.prepareStatement(query)) {
	                statement.setString(1, nombre);
	                ResultSet resultSet = statement.executeQuery();
	                if (resultSet.next()) {
	                    int count = resultSet.getInt(1);
	                    return count > 0;
	                }
	            }
	        }
	        return false;
}
}
