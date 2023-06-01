package interfaces;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import utils.PersonajeDAO;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PantallaAmigo extends JPanel {
	Ventana ventana;
	private BufferedImage fondo;

	public PantallaAmigo(Ventana v) {
		this.ventana = v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 163, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 58, 62, 27, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JButton botonExit = new JButton("EXIT");
		botonExit.setBackground(new Color(255, 128, 255));
		botonExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaInicio.class);
			}
		});
		botonExit.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 14));
		botonExit.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_botonExit = new GridBagConstraints();
		gbc_botonExit.insets = new Insets(0, 0, 5, 5);
		gbc_botonExit.gridx = 2;
		gbc_botonExit.gridy = 3;
		add(botonExit, gbc_botonExit);

		try {
			Statement statement = PersonajeDAO.conectar();
			Connection conexion = statement.getConnection();
			System.out.println("Conexión establecida correctamente: " + (conexion != null && !conexion.isClosed()));

			if (conexion != null && !conexion.isClosed()) {
				// Realizar la consulta para obtener los datos necesarios para el ranking
				System.out.println("Ejecutando consulta...");

				String query = "SELECT j.nombre AS nombreJugador, GROUP_CONCAT(p.nombre SEPARATOR ', ') AS nombrePersonaje "
						+ "FROM jugador j " + "JOIN jugador_personaje jp ON j.id = jp.idJugador "
						+ "JOIN personaje p ON jp.idPersonaje = p.id " + "WHERE j.id = (SELECT MAX(id) FROM jugador) "
						+ "GROUP BY j.id, j.nombre;";

				PreparedStatement preparedStatement = conexion.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery();
				System.out.println("Resultados obtenidos: " + resultSet.next());

				// Obtener los nombres del jugador y personajes
				String nombreJugador = resultSet.getString("nombreJugador");
				String nombrePersonajes = resultSet.getString("nombrePersonaje");

				JLabel lblNewLabel = new JLabel(nombreJugador);
				lblNewLabel.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 16));
				lblNewLabel.setForeground(Color.RED);
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.gridwidth = 2;
				gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel.gridx = 1;
				gbc_lblNewLabel.gridy = 1;
				add(lblNewLabel, gbc_lblNewLabel);

				JLabel lblNewLabel_1 = new JLabel(nombrePersonajes);
				lblNewLabel_1.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 13));
				lblNewLabel_1.setForeground(Color.WHITE);
				GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
				gbc_lblNewLabel_1.gridwidth = 4;
				gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_1.gridx = 0;
				gbc_lblNewLabel_1.gridy = 2;
				add(lblNewLabel_1, gbc_lblNewLabel_1);

				System.out.println("Nombre del último jugador: " + nombreJugador);
				System.out.println("Nombres de los personajes asociados: " + nombrePersonajes);

				resultSet.close();
				preparedStatement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			fondo = ImageIO.read(getClass().getResource("/imagenes/kk.jpeg"));
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
