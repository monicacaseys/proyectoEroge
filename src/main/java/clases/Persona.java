package clases;

import java.util.HashSet;

import enums.Gusto;

public class Persona {
	 private String nombre;
	    private int edad;
	    private String personalidad;
	    private HashSet<Gusto> gustos;
	    
		public Persona(String nombre, int edad, String personalidad, HashSet<Gusto> gustos) {
			super();
			this.nombre = nombre;
			this.edad = edad;
			this.personalidad = personalidad;
			this.gustos =gustos;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public int getEdad() {
			return edad;
		}

		public void setEdad(int edad) {
			this.edad = edad;
		}

		public String getPersonalidad() {
			return personalidad;
		}

		public void setPersonalidad(String personalidad) {
			this.personalidad = personalidad;
		}

		public HashSet<Gusto> getGustos() {
			return gustos;
		}

		public void setGustos(HashSet<Gusto> gustos) {
			this.gustos = gustos;
		}

		@Override
		public String toString() {
			return "Persona [nombre=" + nombre + ", edad=" + edad + ", personalidad=" + personalidad + ", gustos="
					+ gustos + "]";
		}
	    
		
	    

}
