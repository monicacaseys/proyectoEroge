package interfaces;

import javax.swing.JPanel;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.UIManager;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;

public class PantallaInicio extends JPanel {
	
	private Ventana ventana;
	  private BufferedImage fondo;
	
	public PantallaInicio(Ventana v) {
		  this.ventana = v;
		  
	        GridBagLayout gridBagLayout = new GridBagLayout();
	        gridBagLayout.columnWidths = new int[]{0, 151, 0, 0};
	        gridBagLayout.rowHeights = new int[]{0, 38, 55, 50, 55, 50, 0, 0};
	        gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
	        gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
	        setLayout(gridBagLayout);
	        
	        JButton botonExit = new JButton("EXIT");
	        botonExit.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		 System.exit(0);
	        	}
	        });
	        
	        	        JButton botonRanking = new JButton("VER RANKING");
	        	        botonRanking.addMouseListener(new MouseAdapter() {
	        	        	@Override
	        	        	public void mouseClicked(MouseEvent e) {
	        	        		ventana.cambiarAPantalla(PantallaRanking.class);
	        	        	}
	        	        });
	        	        
	        	        	        
	        	        	        JButton botonJugar = new JButton("NEW GAME");
	        	        	        botonJugar.setBackground(new Color(255, 142, 255));
	        	        	        botonJugar.addMouseListener(new MouseAdapter() {
	        	        	            @Override
	        	        	            public void mouseClicked(MouseEvent e) {
	        	        	                ventana.cambiarAPantalla(PantallaNuevoJugador.class);
	        	        	            }
	        	        	        });
	        	        	        botonJugar.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 20));
	        	        	        GridBagConstraints gbc_botonJugar = new GridBagConstraints();
	        	        	        gbc_botonJugar.fill = GridBagConstraints.BOTH;
	        	        	        gbc_botonJugar.insets = new Insets(0, 0, 5, 5);
	        	        	        gbc_botonJugar.gridx = 1;
	        	        	        gbc_botonJugar.gridy = 3;
	        	        	        add(botonJugar, gbc_botonJugar);
	        	        botonRanking.setBackground(new Color(255, 96, 255));
	        	        botonRanking.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 20));
	        	        GridBagConstraints gbc_botonRanking = new GridBagConstraints();
	        	        gbc_botonRanking.fill = GridBagConstraints.BOTH;
	        	        gbc_botonRanking.insets = new Insets(0, 0, 5, 5);
	        	        gbc_botonRanking.gridx = 1;
	        	        gbc_botonRanking.gridy = 4;
	        	        add(botonRanking, gbc_botonRanking);
	        botonExit.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 20));
	        GridBagConstraints gbc_botonExit = new GridBagConstraints();
	        gbc_botonExit.insets = new Insets(0, 0, 5, 5);
	        gbc_botonExit.gridx = 1;
	        gbc_botonExit.gridy = 5;
	        add(botonExit, gbc_botonExit);
	        

			try {
	            fondo = ImageIO.read(getClass().getResource("/imagenes/tierraa.png"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

			// Ruta del archivo de sonido
			String rutaSonido = "/sonidos/intro.wav";

			try {
			    // Cargar el archivo de sonido
			    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource(rutaSonido));

			    // Crear el clip de sonido
			    Clip clip = AudioSystem.getClip();

			    // Abrir el archivo de sonido en el clip
			    clip.open(audioInputStream);

			    // Reproducir el sonido
			    clip.start();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
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
