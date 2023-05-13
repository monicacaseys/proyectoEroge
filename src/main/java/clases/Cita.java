package clases;

import java.util.ArrayList;

public class Cita {

	private ArrayList<String> actividades;
	private int incrementoAmor;
	
	public Cita(ArrayList<String> actividades, int incrementoAmor) {
		super();
		this.actividades = actividades;
		this.incrementoAmor = incrementoAmor;
	}

	public ArrayList<String> getActividades() {
		return actividades;
	}

	public void setActividades(ArrayList<String> actividades) {
		this.actividades = actividades;
	}

	public int getIncrementoAmor() {
		return incrementoAmor;
	}

	public void setIncrementoAmor(int incrementoAmor) {
		this.incrementoAmor = incrementoAmor;
	}

	@Override
	public String toString() {
		return "Cita [actividades=" + actividades + ", incrementoAmor=" + incrementoAmor + "]";
	}
	
	
}
