package interfaces;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaJugar extends JPanel{
	
	private Ventana ventana;
	public PantallaJugar(Ventana v) {
		this.ventana=v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 142, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 41, 42, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton newGame = new JButton("NUEVA PARTIDA");
		newGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaNuevoJugador.class);
			}
		});
		newGame.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 20));
		GridBagConstraints gbc_newGame = new GridBagConstraints();
		gbc_newGame.fill = GridBagConstraints.BOTH;
		gbc_newGame.insets = new Insets(0, 0, 5, 5);
		gbc_newGame.gridx = 1;
		gbc_newGame.gridy = 1;
		add(newGame, gbc_newGame);
		
		JButton continuar = new JButton("CONTINUAR");
		continuar.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 20));
		GridBagConstraints gbc_continuar = new GridBagConstraints();
		gbc_continuar.fill = GridBagConstraints.BOTH;
		gbc_continuar.insets = new Insets(0, 0, 5, 5);
		gbc_continuar.gridx = 1;
		gbc_continuar.gridy = 2;
		add(continuar, gbc_continuar);
		
	}
	
	

}
