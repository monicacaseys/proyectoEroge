package clases;

import java.util.ArrayList;

public class Cementerio {
	private ArrayList <Personaje> personajes;
	private int incrementoAmor;
	
	public Cementerio(ArrayList<Personaje> personajes, int incrementoAmor) {
		super();
		this.personajes = personajes;
		this.incrementoAmor = incrementoAmor;
	}

	public ArrayList<Personaje> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(ArrayList<Personaje> personajes) {
		this.personajes = personajes;
	}

	public int getIncrementoAmor() {
		return incrementoAmor;
	}

	public void setIncrementoAmor(int incrementoAmor) {
		this.incrementoAmor = incrementoAmor;
	}

	@Override
	public String toString() {
		return "Cementerio [personajes=" + personajes + ", incrementoAmor=" + incrementoAmor + "]";
	}
	
	
	
	
	

}
