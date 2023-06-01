package interfaces;

import javax.swing.JPanel;

import clases.Personaje;
import enums.Gusto;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;

public class PantallaCita extends JPanel{
	Ventana ventana;
	private Personaje personaje;
	private PantallaEscena pantallaEscena;
	private int nivelAmorSeleccionado;
	private BufferedImage fondo;


	public PantallaCita(Ventana v,Personaje p) {
		this.ventana=v;
		this.personaje=p;
		this.pantallaEscena = ventana.getPantallaEscenaActual();

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
	                	
	                    if (!personaje.getGustos().contains(gustoElegido)) {
	                        // El gusto elegido no coincide con los gustos del personaje, aumentar en 20 puntos
	                        pantallaEscena.aumentarNivelAmor(20);
	                    } else {
	                        // El gusto elegido coincide con los gustos del personaje, aumentar en 40 puntos
	                        pantallaEscena.aumentarNivelAmor(40);
	                    }
	                    pantallaEscena.setNivelAmorActual(ventana.getNivelAmorActual());
	                    ventana.setContentPane(pantallaEscena);
	                    ventana.getContentPane().setVisible(true);
	                }
			}
		});
		botonContinuar.setBounds(474, 393, 128, 50);
		add(botonContinuar);
		
		
		try {
            fondo = ImageIO.read(getClass().getResource("/imagenes/llll.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

	}

	 @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);

	        if (fondo != null) {
	            g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
	        }
	    }
}
