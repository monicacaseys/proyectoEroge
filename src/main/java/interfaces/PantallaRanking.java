package interfaces;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import clases.Jugador;
import clases.Personaje;
import utils.PersonajeDAO;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaRanking extends JPanel {
	Ventana ventana;

	public PantallaRanking(Ventana v) {
		this.ventana = v;// y esto tambien imprecindible
		setLayout(new BorderLayout(0, 0));

		JLabel labelBienvenido = new JLabel("Ranking de Jugadores");
		labelBienvenido.setBackground(new Color(64, 128, 128));
		labelBienvenido.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 15));
		add(labelBienvenido, BorderLayout.NORTH);

		JScrollPane lista = new JScrollPane();
		add(lista, BorderLayout.CENTER);

		JPanel contenedorElementos = new JPanel();
		lista.setViewportView(contenedorElementos);
		contenedorElementos.setLayout(new BoxLayout(contenedorElementos, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);

		JButton botonAtras = new JButton("Atrás");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaInicio.class);
			}
		});
		botonAtras.setBackground(new Color(128, 255, 255));
		botonAtras.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 13));
		panel.add(botonAtras);

		JButton botonExit = new JButton("Exit");
		botonExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		botonExit.setBackground(new Color(128, 255, 255));
		botonExit.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 13));
		panel.add(botonExit);

		System.out.println("Estableciendo conexión a la base de datos...");

		try {
			Statement statement = PersonajeDAO.conectar();
			Connection conexion = statement.getConnection();
			System.out.println("Conexión establecida correctamente: " + (conexion != null && !conexion.isClosed()));

			if (conexion != null && !conexion.isClosed()) {
				// Realizar la consulta para obtener los datos necesarios para el ranking
				System.out.println("Ejecutando consulta...");

				String query = "SELECT j.nombre AS nombreJugador, GROUP_CONCAT(p.nombre SEPARATOR ', ') AS nombrePersonaje "
						+ "FROM jugador j " + "JOIN jugador_personaje jp ON j.id = jp.idJugador "
						+ "JOIN personaje p ON jp.idPersonaje = p.id "
						+ "GROUP BY j.id, j.nombre;";
	
				PreparedStatement preparedStatement = conexion.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery();
				System.out.println("Resultados obtenidos: " + resultSet.next());

				// o hacer un getTodos de esa tabla y hacer el bucle con get todos

				while (resultSet.next()) { // for(short i=0;i<resultSet.size();i++)
					// Obtener los datos del jugador y personaje desde el resultado de la consulta
					String nombreJugador = resultSet.getString("nombreJugador");
					String nombrePersonaje = resultSet.getString("nombrePersonaje");

					// Mostrar los datos en el ranking
					contenedorElementos.add(new ElementoRancking(ventana, nombreJugador, nombrePersonaje)); // (ventana,
																											// nombreJugador.get(i),
																											// nombrePersonaje)
					System.out.println("Nombre del jugador: " + nombreJugador);
					System.out.println("Nombre del personaje: " + nombrePersonaje);
				}

				resultSet.close();
				preparedStatement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
