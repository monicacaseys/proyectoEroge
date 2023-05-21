package clases;

public class CitaIdeal {
	private Lugar lugar;
	private float multiplicadorAmor;

	public CitaIdeal(Lugar lugar, float multiplicadorAmor) {
		this.lugar = lugar;
		this.multiplicadorAmor = multiplicadorAmor;
	}

	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	public float getMultiplicadorAmor() {
		return multiplicadorAmor;
	}

	public void setMultiplicadorAmor(float multiplicadorAmor) {
		this.multiplicadorAmor = multiplicadorAmor;
	}
	

}
