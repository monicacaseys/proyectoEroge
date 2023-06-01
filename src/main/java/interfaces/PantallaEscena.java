package interfaces;

import javax.swing.JPanel;

import clases.Jugador;
import clases.Personaje;
import clases.Pregunta;
import clases.TemaDeConversacion;
import enums.Gusto;
import utils.PersonajeDAO;

import java.awt.GridBagLayout;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JTextField;
import java.awt.Color;

public class PantallaEscena extends JPanel {
	private Ventana ventana;
	private Personaje personaje;
	private Pregunta preguntaActual;
	private JLabel labelPersonaje;
	private JLabel labelNivelAmor;
	private JLabel labelEnunciado;
	private JLabel labelNivel;
	private JButton botonRespuesta1;
	private JButton botonRespuesta2;
	private JButton botonMasInfo;
	private int nivelAmorActual;
	private byte nivel;

	private JButton botonCita;
	private JButton botnEscena;
	private JButton botonCasarse;
	private BufferedImage fondo;

	private Jugador jugador;

	public PantallaEscena(Ventana v, final Personaje personaje, final Jugador j) {
		this.ventana = v;
		this.personaje = personaje;
		this.jugador = j;

		setLayout(null);

		labelPersonaje = new JLabel(personaje.getNombre());
		labelPersonaje.setForeground(new Color(255, 255, 255));
		labelPersonaje.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 25));
		labelPersonaje.setBounds(229, 22, 377, 43);
		add(labelPersonaje);

		nivelAmorActual = personaje.getNivelAmor();
		labelNivelAmor = new JLabel();
		labelNivelAmor.setForeground(new Color(255, 0, 0));
		labelNivelAmor.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 17));
		labelNivelAmor.setBounds(10, 116, 196, 43);
		add(labelNivelAmor);

		labelEnunciado = new JLabel();
		labelEnunciado.setForeground(new Color(0, 255, 64));
		labelEnunciado.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		labelEnunciado.setBounds(20, 419, 678, 85);
		add(labelEnunciado);

		botonRespuesta1 = new JButton();
		botonRespuesta1.setBackground(new Color(255, 255, 157));
		botonRespuesta1.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 15));

		botonRespuesta1.setBounds(392, 526, 226, 54);
		add(botonRespuesta1);

		botonRespuesta2 = new JButton();
		botonRespuesta2.setBackground(new Color(255, 255, 157));
		botonRespuesta2.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		botonRespuesta2.setBounds(67, 526, 215, 54);
		add(botonRespuesta2);

		botonMasInfo = new JButton("DETALLES");
		botonMasInfo.setBackground(new Color(255, 255, 128));
		botonMasInfo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		botonMasInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarModalInformacion();
			}
		});
		botonMasInfo.setBounds(348, 75, 110, 26);
		add(botonMasInfo);

		nivel = personaje.getNivel();
		labelNivel = new JLabel();
		labelNivel.setForeground(new Color(0, 255, 255));
		labelNivel.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 16));
		labelNivel.setBounds(10, 91, 78, 32);
		add(labelNivel);

		String rutaGif = "/imagenes/corazon.gif";
		JLabel labelGift = new JLabel(new ImageIcon(getClass().getResource(rutaGif)));
		labelGift.setBounds(110, 80, 69, 43);
		add(labelGift);

		botonCita = new JButton("TENER UNA CITA");
		botonCita.setBackground(new Color(208, 208, 255));
		botonCita.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaLugar.class);
			}
		});
		botonCita.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 15));
		botonCita.setForeground(new Color(0, 0, 0));
		botonCita.setBounds(457, 140, 178, 43);
		botonCita.setVisible(false); // Inicialmente oculto
		add(botonCita);

		botonCasarse = new JButton("CÁSATE CONMIGO");
		botonCasarse.setBackground(new Color(255, 215, 174));
		botonCasarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaCasarse.class);
			}
		});
		botonCasarse.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 15));
		botonCasarse.setBounds(457, 218, 178, 38);
		botonCasarse.setVisible(false); // Inicialmente oculto
		add(botonCasarse);

		botonRespuesta1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				verificarRespuesta(botonRespuesta1.getText());
			}
		});
		botonRespuesta2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				verificarRespuesta(botonRespuesta2.getText());
			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}
		});

		actualizarNivelAmor();
		actualizarPregunta();
		botnEscena = new JButton("NEXT");
		botnEscena.setBackground(new Color(240, 240, 240));
		botnEscena.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//guardar persoanje
				PersonajeDAO personajeDAO = new PersonajeDAO();
				HashMap<Personaje, Integer> mapaPersonajes = new HashMap<>();
				mapaPersonajes.put(personaje, 1); // Agregar el personaje con valor
				personajeDAO.guardarDatosJugadorYPersonajes(jugador, mapaPersonajes);
				// posible sitio para guardar datos en BBDD
				System.out.println("Antes de crear nueva pantalla de escena");
				ventana.crearNuevaPantallaEscena();
				System.out.println("Despues de crear nueva pantalla de escena");
				JOptionPane.showMessageDialog(PantallaEscena.this, "MAXIMIZAR LA PANTALLA PARA NEXT", "Muerte",
						JOptionPane.INFORMATION_MESSAGE);

			}
		});
		botnEscena.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 15));
		botnEscena.setBounds(457, 294, 178, 38);
		botnEscena.setVisible(false); // Inicialmente oculto
		add(botnEscena);
		

		try {
			fondo = ImageIO.read(getClass().getResource("/imagenes/ff.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Ruta del archivo de sonido
					String rutaSonido = "/sonidos/hola.wav";

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

	private void actualizarPregunta() {
		Pregunta pregunta = personaje.obtenerSiguientePreguntaNoRespondida();
		if (pregunta != null) {
			// Mostrar enunciado
			labelEnunciado.setText(pregunta.getEnunciado());

			// Mostrar respuestas
			ArrayList<String> respuestas = pregunta.getRespuestas();
			botonRespuesta1.setText(respuestas.get(0));
			botonRespuesta2.setText(respuestas.get(1));

			preguntaActual = pregunta;
		} else {
			// No quedan más preguntas, juego terminado
			JOptionPane.showMessageDialog(this, "Has agotado las preguntas...Se termina el juego para ti");
			System.exit(0);

			/*
			 * Realizar acciones de finalización del juego PersonajeDAO personajeDAO = new
			 * PersonajeDAO(); HashMap<Personaje, Integer> mapaPersonajes = new HashMap<>();
			 * mapaPersonajes.put(personaje, 1); // Agregar el personaje con valor 1
			 * (representando la cantidad)
			 * personajeDAO.guardarDatosJugadorYPersonajes(jugador, mapaPersonajes);
			 */

		}
	}

	private void actualizarNivelAmor() {
		labelNivelAmor.setText("Nivel de Amor: " + nivelAmorActual);
		labelNivel.setText("Nivel: " + nivel);
		repaint();
	}

	public void aumentarNivelAmor(int puntos) {
		nivelAmorActual += puntos;
		actualizarNivelAmor();
	}

	private void verificarRespuesta(String respuestaSeleccionada) {
		// Verificar respuesta
		String respuestaCorrecta = preguntaActual.getRespuestaCorrecta();

		if (respuestaSeleccionada.equals(respuestaCorrecta)) {
			JOptionPane.showMessageDialog(this, "¡Respuesta correcta!");
			personaje.aumentarAmor();
		} else {
			JOptionPane.showMessageDialog(this, "Respuesta incorrecta...");
			personaje.disminuirAmor();
		}
		nivelAmorActual = personaje.getNivelAmor();
		actualizarNivelAmor();

		if (nivelAmorActual >= 100) {
			personaje.aumentarNivel();
			nivel = personaje.getNivel();
			nivelAmorActual = 50;
			personaje.setNivelAmor(nivelAmorActual);
			actualizarNivelAmor();
		}

		if (nivel >= 2) {
			botonCita.setVisible(true);
		} else {
			botonCita.setVisible(false);
		}
		if (nivel >= 3) {
			if (!personaje.isPoliamoroso()) {
				// Personaje no poliamoroso, mostrar botón para casarse y finalizar el juego
				botonCasarse.setVisible(true);
				// Verificar si el jugador tiene personajes poliamorosos guardados en la base de
				// datos
				PersonajeDAO personajeDAO = new PersonajeDAO();
				boolean tienePersonajePoliamorosoVerdadero;
				try {
					tienePersonajePoliamorosoVerdadero = personajeDAO.tienePersonajePoliamorosoVerdadero();
					// Mostrar botón "Next" si tiene personaje poliamoroso verdadero guardado
					if (tienePersonajePoliamorosoVerdadero) {
						botnEscena.setVisible(true);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				// Personaje poliamoroso, mostrar botón para crear una nueva escena con otro
				// personaje
				botnEscena.setVisible(true);
				botonCasarse.setVisible(false);
			}
		}

		if (nivelAmorActual < 0) {
			System.out.println(personaje.getNombre() + " ha muerto.");
			ventana.crearNuevaPantallaEscena();
			JOptionPane.showMessageDialog(PantallaEscena.this, personaje.getNombre() + " ha muerto. Intentalo otra vez",
					"Muerte", JOptionPane.INFORMATION_MESSAGE);
		}
		actualizarPregunta();

	}

	public int getNivelAmorActual() {
		return nivelAmorActual;
	}

	public void setNivelAmorActual(int nivelAmorActual) {
		this.nivelAmorActual = nivelAmorActual;
	}

	private void mostrarModalInformacion() {
		final JDialog dialogo = new JDialog(ventana, "Información del Personaje", true);
		dialogo.setSize(300, 300);
		dialogo.getContentPane().setLayout(null);

		JLabel etiquetaNombre = new JLabel("Nombre: " + personaje.getNombre());
		etiquetaNombre.setBounds(20, 20, 160, 20);
		dialogo.getContentPane().add(etiquetaNombre);

		JLabel etiquetaEdad = new JLabel("Edad: " + personaje.getEdad());
		etiquetaEdad.setBounds(20, 50, 160, 20);
		dialogo.getContentPane().add(etiquetaEdad);

		JLabel etiquetaPersonalidad = new JLabel("Personalidad: " + personaje.getPersonalidad());
		etiquetaPersonalidad.setBounds(20, 80, 160, 20);
		dialogo.getContentPane().add(etiquetaPersonalidad);

		JLabel etiquetaGustos = new JLabel("Gustos: " + personaje.getGustos());
		etiquetaGustos.setBounds(20, 110, 160, 20);
		dialogo.getContentPane().add(etiquetaGustos);

		JLabel etiquetaTipoPersonaje = new JLabel("Tipo de Personaje: " + personaje.getTipoPersonaje());
		etiquetaTipoPersonaje.setBounds(20, 140, 160, 20);
		dialogo.getContentPane().add(etiquetaTipoPersonaje);

		JLabel etiquetaPoliamoroso = new JLabel("Poliamoroso: " + (personaje.isPoliamoroso() ? "Sí" : "No"));
		etiquetaPoliamoroso.setBounds(20, 170, 160, 20);
		dialogo.getContentPane().add(etiquetaPoliamoroso);

		dialogo.setVisible(true);
	}
}