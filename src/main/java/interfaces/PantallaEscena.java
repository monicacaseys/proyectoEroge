package interfaces;

import javax.swing.JPanel;

import clases.Personaje;
import clases.Pregunta;
import clases.TemaDeConversacion;
import enums.Gusto;

import java.awt.GridBagLayout;

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
import java.util.Random;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
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
	private JLabel fondo;
	private JButton botonCita;
	private JButton botnEscena;
	private JButton botonCasarse;

	public PantallaEscena(Ventana v, Personaje personaje) {
		this.ventana = v;
		this.personaje = personaje;

		setLayout(null);

		labelPersonaje = new JLabel(personaje.getNombre());
		labelPersonaje.setForeground(new Color(255, 255, 255));
		labelPersonaje.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 16));
		labelPersonaje.setBounds(219, 10, 203, 26);
		add(labelPersonaje);

		nivelAmorActual = personaje.getNivelAmor();
		labelNivelAmor = new JLabel();
		labelNivelAmor.setForeground(new Color(255, 255, 255));
		labelNivelAmor.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 17));
		labelNivelAmor.setBounds(10, 116, 196, 43);
		add(labelNivelAmor);

		labelEnunciado = new JLabel();
		labelEnunciado.setForeground(new Color(255, 255, 255));
		labelEnunciado.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		labelEnunciado.setBounds(21, 323, 678, 85);
		add(labelEnunciado);

		botonRespuesta1 = new JButton();
		botonRespuesta1.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 15));

		botonRespuesta1.setBounds(389, 453, 226, 54);
		add(botonRespuesta1);

		botonRespuesta2 = new JButton();
		botonRespuesta2.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		botonRespuesta2.setBounds(68, 453, 215, 54);
		add(botonRespuesta2);

		botonMasInfo = new JButton("Mas Info");
		botonMasInfo.setBackground(new Color(255, 255, 128));
		botonMasInfo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		botonMasInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarModalInformacion();
			}
		});
		botonMasInfo.setBounds(476, 50, 110, 26);
		add(botonMasInfo);

		nivel = personaje.getNivel();
		labelNivel = new JLabel();
		labelNivel.setForeground(new Color(255, 255, 255));
		labelNivel.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 14));
		labelNivel.setBounds(10, 91, 78, 32);
		add(labelNivel);

		String rutaGif = "/imagenes/corazon.gif";
		JLabel labelGift = new JLabel(new ImageIcon(getClass().getResource(rutaGif)));
		labelGift.setBounds(110, 80, 69, 43);
		add(labelGift);
/*
		fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(PantallaEscena.class.getResource("/imagenes/ran.png")));
		fondo.setBounds(-31, -43, 740, 607);
		add(fondo);
		*/
		botonCita = new JButton("TENER UNA CITA");
		botonCita.setBackground(new Color(0, 159, 236));
		botonCita.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaLugar.class);
			}
		});
		botonCita.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 15));
		botonCita.setForeground(new Color(0, 0, 0));
		botonCita.setBounds(422, 175, 178, 63);
		botonCita.setVisible(false); // Inicialmente oculto
		add(botonCita);
		
		botonCasarse = new JButton("ME CASOO");
		botonCasarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			//	ventana.cambiarAPantalla(PantallaCasarse.class);
			}
		});
		botonCasarse.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 15));
		botonCasarse.setBounds(20, 175, 178, 63);
		botonCasarse.setVisible(false); // Inicialmente oculto
		add(botonCasarse);
		
		botnEscena = new JButton("Ligar más");
		botnEscena.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaEscena.class);
			}
		});
		botnEscena.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 15));
		botnEscena.setBounds(21, 248, 177, 63);
		botnEscena.setVisible(false); // Inicialmente oculto
		add(botnEscena);
		
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
		});

		actualizarNivelAmor();
		actualizarPregunta();
		
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
			JOptionPane.showMessageDialog(this, "¡Fin del juego!");
			// Realizar acciones de finalización del juego
		}
	}

	private void actualizarNivelAmor() {
		labelNivelAmor.setText("Nivel de Amor: " + nivelAmorActual);
		labelNivel.setText("Nivel: " + nivel);
		repaint();
	}
	
	public void aumentarNivelAmor(int puntos ) {
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
	            if (personaje.isPoliamoroso()) {
	                // Personaje poliamoroso, mostrar botón para crear una nueva escena con otro personaje
	                botnEscena.setVisible(true);
	            } else {
	                // Personaje no poliamoroso, mostrar botón para casarse y finalizar el juego
	            	botonCasarse.setVisible(true);
	            }
	        }
	        actualizarPregunta();
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