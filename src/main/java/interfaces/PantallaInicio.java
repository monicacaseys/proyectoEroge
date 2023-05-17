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

public class PantallaInicio extends JPanel {
	
	private Ventana ventana;
	
	public PantallaInicio(Ventana v) {
		  this.ventana = v;
	        GridBagLayout gridBagLayout = new GridBagLayout();
	        gridBagLayout.columnWidths = new int[]{0, 151, 0, 0};
	        gridBagLayout.rowHeights = new int[]{0, 41, 39, 0, 0};
	        gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
	        gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
	        setLayout(gridBagLayout);

	        JLabel labelBackground = new JLabel(new ImageIcon(PantallaInicio.class.getResource("/imagenes/tierra.png")));
	        labelBackground.setLayout(new GridBagLayout());
	        GridBagConstraints gbc_labelBackground = new GridBagConstraints();
	        gbc_labelBackground.gridx = 0;
	        gbc_labelBackground.gridy = 0;
	        gbc_labelBackground.gridwidth = 3;
	        gbc_labelBackground.gridheight = 4;
	        gbc_labelBackground.fill = GridBagConstraints.BOTH;
	        add(labelBackground, gbc_labelBackground);

	        JButton botonJugar = new JButton("JUGAR");
	        botonJugar.setBackground(new Color(255, 142, 255));
	        botonJugar.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                ventana.cambiarAPantalla(PantallaJugar.class);
	            }
	        });
	        botonJugar.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 20));
	        GridBagConstraints gbc_botonJugar = new GridBagConstraints();
	        gbc_botonJugar.fill = GridBagConstraints.BOTH;
	        gbc_botonJugar.insets = new Insets(0, 0, 5, 5);
	        gbc_botonJugar.gridx = 1;
	        gbc_botonJugar.gridy = 1;
	        add(botonJugar, gbc_botonJugar);

	        JButton botonRanking = new JButton("VER RANKING");
	        botonRanking.setBackground(new Color(255, 96, 255));
	        botonRanking.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 20));
	        GridBagConstraints gbc_botonRanking = new GridBagConstraints();
	        gbc_botonRanking.fill = GridBagConstraints.BOTH;
	        gbc_botonRanking.insets = new Insets(0, 0, 5, 5);
	        gbc_botonRanking.gridx = 1;
	        gbc_botonRanking.gridy = 2;
	        add(botonRanking, gbc_botonRanking);
	}
	
	

}
