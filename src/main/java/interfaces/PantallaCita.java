package interfaces;

import javax.swing.JPanel;

import clases.Personaje;
import enums.Gusto;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class PantallaCita extends JPanel{
	Ventana ventana;
	private Personaje personaje;
	public PantallaCita(Ventana v,Personaje p) {
		this.ventana=v;
		this.personaje=p;
		final Gusto gustoElegido = ventana.getGustoElegido();
		setLayout(null);
		
		JLabel labelTexto = new JLabel("Porfin podemos conocernos mejor <3"+"\n Me gustAAs!!");
		labelTexto.setForeground(new Color(0, 255, 0));
		labelTexto.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 22));
		labelTexto.setBounds(59, 255, 680, 90);
		add(labelTexto);
		
		JLabel labelLugar = new JLabel("El encuentro tiene lugar en " + gustoElegido.toString());
		labelLugar.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 20));
		labelLugar.setForeground(new Color(0, 255, 0));
		labelLugar.setBounds(167, 181, 511, 42);
		add(labelLugar);
		
		JButton botonContinuar = new JButton("Continuar");
		botonContinuar.setForeground(new Color(0, 0, 0));
		botonContinuar.setBackground(new Color(128, 128, 64));
		botonContinuar.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 13));
		botonContinuar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				  PantallaEscena pantallaEscena = ventana.getPantallaEscenaActual();
	                if (pantallaEscena != null) {
	                	int nivelAmorGuardado = pantallaEscena.getNivelAmorGuardado();
	                    if (!personaje.getGustos().contains(gustoElegido)) {
	                        // El gusto elegido no coincide con los gustos del personaje, aumentar en 20 puntos
	                        pantallaEscena.aumentarNivelAmor(20);
	                    } else {
	                        // El gusto elegido coincide con los gustos del personaje, aumentar en 40 puntos
	                        pantallaEscena.aumentarNivelAmor(40);
	                    }
	                    pantallaEscena.setNivelAmorActual(nivelAmorGuardado);
	                    ventana.setContentPane(pantallaEscena);
	                    ventana.getContentPane().setVisible(true);
	                }
			}
		});
		botonContinuar.setBounds(474, 393, 128, 50);
		add(botonContinuar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PantallaCita.class.getResource("/imagenes/llll.jpg")));
		lblNewLabel.setBounds(0, 0, 800, 790);
		add(lblNewLabel);
	}
}
