package interfaces;

import javax.swing.JPanel;

import clases.Personaje;
import enums.Gusto;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaCita extends JPanel{
	Ventana ventana;
	private Personaje personaje;
	public PantallaCita(Ventana v,Personaje p) {
		this.ventana=v;
		this.personaje=p;
		Gusto gustoElegido = ventana.getGustoElegido();
		setLayout(null);
		
		JLabel labelTexto = new JLabel("Porfin podemos relajarnos de tanta pregunta y tener un momento mas intimo. Me gustAAs!!");
		labelTexto.setBounds(49, 315, 379, 90);
		add(labelTexto);
		
		JLabel labelLugar = new JLabel("El encuentro tiene lugar en " + gustoElegido.toString());
		labelLugar.setBounds(92, 56, 294, 42);
		add(labelLugar);
		
		JButton botonContinuar = new JButton("Continuar");
		botonContinuar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//volver a la Escena anterior con los datos guardados.
				 PantallaEscena pantallaEscena = ventana.getPantallaEscenaActual();
			        if (pantallaEscena != null) {
			            int nivelAmorActual = personaje.getNivelAmor();
			            pantallaEscena.aumentarNivelAmor(nivelAmorActual);
			            ventana.setContentPane(pantallaEscena);
			            ventana.getContentPane().setVisible(true);
			        }
			}
		});
		botonContinuar.setBounds(410, 415, 128, 50);
		add(botonContinuar);
	}
	




	
}