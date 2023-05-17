package interfaces;

import javax.swing.JFrame;

public class Ventana extends JFrame{

	public Ventana() {
		this.setSize(600,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(new PantallaInicio(this));
		this.setVisible(true);
		
	}
	
	public void cambiarAPantalla(Class<?> clase) {//la ? es una plantalla/template puedo usar la clase que quiera sin resticciones
	
		this.getContentPane().setVisible(false);
		if(clase.equals(PantallaInicio.class)) {
			this.setContentPane(new PantallaInicio(this));
		}
		if(clase.equals(PantallaNuevoJugador.class)) {
			this.setContentPane(new PantallaNuevoJugador(this));
		}
		this.getContentPane().setVisible(true);
	}
}
