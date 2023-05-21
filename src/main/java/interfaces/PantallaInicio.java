package interfaces;

import javax.swing.JPanel;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.Icon;

public class PantallaInicio extends JPanel {
	
	private Ventana ventana;
	
	public PantallaInicio(Ventana v) {
		  this.ventana = v;
		  
	        GridBagLayout gridBagLayout = new GridBagLayout();
	        gridBagLayout.columnWidths = new int[]{0, 151, 0, 0};
	        gridBagLayout.rowHeights = new int[]{0, 38, 41, 39, 39, 0, 0, 0};
	        gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
	        gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
	        setLayout(gridBagLayout);

	        JLabel fondo = new JLabel(new ImageIcon(PantallaInicio.class.getResource("/imagenes/tierra2.png")));
			fondo.setLayout(new GridBagLayout());
			GridBagConstraints gbc_fondo = new GridBagConstraints();
			gbc_fondo.gridx = 0;
			gbc_fondo.gridy = 0;
			gbc_fondo.gridwidth = 3;
			gbc_fondo.gridheight = 7;
			gbc_fondo.fill = GridBagConstraints.BOTH;
			add(fondo, gbc_fondo);
			
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
	        gbc_botonJugar.gridy = 2;
	        add(botonJugar, gbc_botonJugar);
	        
	        JButton botonContinuar = new JButton("CONTINUAR");
	        botonContinuar.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 20));
	        GridBagConstraints gbc_botonContinuar = new GridBagConstraints();
	        gbc_botonContinuar.insets = new Insets(0, 0, 5, 5);
	        gbc_botonContinuar.gridx = 1;
	        gbc_botonContinuar.gridy = 3;
	        add(botonContinuar, gbc_botonContinuar);

	        JButton botonRanking = new JButton("VER RANKING");
	        botonRanking.setBackground(new Color(255, 96, 255));
	        botonRanking.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 20));
	        GridBagConstraints gbc_botonRanking = new GridBagConstraints();
	        gbc_botonRanking.fill = GridBagConstraints.BOTH;
	        gbc_botonRanking.insets = new Insets(0, 0, 5, 5);
	        gbc_botonRanking.gridx = 1;
	        gbc_botonRanking.gridy = 4;
	        add(botonRanking, gbc_botonRanking);
	        
	        JButton botonExit = new JButton("EXIT");
	        botonExit.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		 System.exit(0);
	        	}
	        });
	        botonExit.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 20));
	        GridBagConstraints gbc_botonExit = new GridBagConstraints();
	        gbc_botonExit.insets = new Insets(0, 0, 5, 5);
	        gbc_botonExit.gridx = 1;
	        gbc_botonExit.gridy = 5;
	        add(botonExit, gbc_botonExit);
	}
	
	

}
