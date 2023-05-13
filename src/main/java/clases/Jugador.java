package clases;

public class Jugador extends Presentacion {

	public Jugador(String nombre, byte edad, String personalidad, String gustos) {
		super(nombre, edad, personalidad, gustos);
	}

	@Override
	public String toString() {
		return "Jugador " +super.toString();
	}
	
	
	
	

}
