package interfaces;

import javax.swing.JPanel;

import enums.Gusto;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PantallaLugar extends JPanel {
	Ventana ventana;
	private JButton btnCine;
	Gusto gustoElegido;
	private BufferedImage fondo;
	public PantallaLugar(Ventana v) {
		this.ventana=v;
		
		JButton btnPlaya = new JButton("PLAYA");
		btnPlaya.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gustoElegido= Gusto.PLAYA;
				 // Establecer el gusto elegido en la instancia de Ventana
		        ventana.setGustoElegido(gustoElegido);
				// Cambiar a la pantalla Escena
		        ventana.cambiarAPantalla(PantallaCita.class);
		        
			}
		});
		btnPlaya.setBackground(new Color(255, 128, 192));
		btnPlaya.setBounds(264, 130, 231, 39);
		btnPlaya.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 20));
	
		setLayout(null);
		
		JLabel titulo = new JLabel("ELIGE LUGAR PARA EL ENCUENTRO");
		titulo.setForeground(new Color(64, 0, 128));
		titulo.setBounds(98, 20, 559, 61);
		titulo.setBackground(new Color(128, 255, 0));
		titulo.setFont(new Font("Whimsy TT", Font.BOLD | Font.ITALIC, 34));
		add(titulo);
		add(btnPlaya);
		
		btnCine = new JButton("CINE");
		btnCine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gustoElegido= Gusto.CINE;
				 // Establecer el gusto elegido en la instancia de Ventana
		        ventana.setGustoElegido(gustoElegido);
				// Cambiar a la pantalla Escena
		        ventana.cambiarAPantalla(PantallaCita.class);
			}
		});
		btnCine.setBackground(new Color(255, 128, 192));
		btnCine.setBounds(264, 196, 231, 39);
		btnCine.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 20));
		add(btnCine);
		
		JButton btnPetanca = new JButton("PETANCA");
		btnPetanca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gustoElegido= Gusto.PETANCA;
				 // Establecer el gusto elegido en la instancia de Ventana
		        ventana.setGustoElegido(gustoElegido);
				// Cambiar a la pantalla Escena
		        ventana.cambiarAPantalla(PantallaCita.class);
			}
		});
		btnPetanca.setBackground(new Color(255, 128, 192));
		btnPetanca.setBounds(264, 262, 231, 39);
		btnPetanca.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 20));
		add(btnPetanca);
		
		JButton btnBeatbox = new JButton("BEATBOXING");
		btnBeatbox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gustoElegido= Gusto.BEATBOXING;
				 // Establecer el gusto elegido en la instancia de Ventana
		        ventana.setGustoElegido(gustoElegido);
				// Cambiar a la pantalla Escena
		        ventana.cambiarAPantalla(PantallaCita.class);
			}
		});
		btnBeatbox.setBackground(new Color(255, 128, 192));
		btnBeatbox.setBounds(264, 327, 231, 38);
		btnBeatbox.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 20));
		add(btnBeatbox);
		
		JButton btnCosplay = new JButton("COSPLAY");
		btnCosplay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gustoElegido= Gusto.COSPLAY;
				 // Establecer el gusto elegido en la instancia de Ventana
		        ventana.setGustoElegido(gustoElegido);
				// Cambiar a la pantalla Escena
		        ventana.cambiarAPantalla(PantallaCita.class);
			}
		});
		btnCosplay.setBackground(new Color(255, 128, 192));
		btnCosplay.setBounds(264, 390, 231, 39);
		btnCosplay.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 20));
		add(btnCosplay);
		
		try {
            fondo = ImageIO.read(getClass().getResource("/imagenes/corazon.png"));
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
