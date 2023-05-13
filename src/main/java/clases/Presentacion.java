package clases;

public class Presentacion {

	private String nombre;
	private byte edad;
	private String personalidad;
	private String gustos;
	
	public Presentacion(String nombre, byte edad, String personalidad, String gustos) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.personalidad = personalidad;
		this.gustos = gustos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public byte getEdad() {
		return edad;
	}

	public void setEdad(byte edad) {
		this.edad = edad;
	}

	public String getPersonalidad() {
		return personalidad;
	}

	public void setPersonalidad(String personalidad) {
		this.personalidad = personalidad;
	}

	public String getGustos() {
		return gustos;
	}

	public void setGustos(String gustos) {
		this.gustos = gustos;
	}

	@Override
	public String toString() {
		return " [nombre=" + nombre + ", edad=" + edad + ", personalidad=" + personalidad + ", gustos="
				+ gustos + "]";
	}
	
	
}
