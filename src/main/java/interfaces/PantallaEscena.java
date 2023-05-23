package interfaces;

import javax.swing.JPanel;

import clases.Personaje;
import clases.Pregunta;
import enums.Gusto;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaEscena extends JPanel {
	private Ventana ventana;
	private Personaje personaje;
	private Pregunta preguntaActual;
	private JLabel labelPersonaje;
	private JLabel labelNivelAmor;
	private JLabel labelEnunciado;
	private JButton botonRespuesta1;
	private JButton botonRespuesta2;
	private JLabel labelTexto;

	public PantallaEscena(Ventana v, Personaje personaje) {
		this.ventana = v;
		this.personaje = personaje;
		Gusto gustoElegido = ventana.getGustoElegido();

		setLayout(new GridBagLayout());
		
		labelTexto = new JLabel("El encuentro tiene lugar en " + gustoElegido.toString());
		GridBagConstraints gbc_labelTexto = new GridBagConstraints();
		gbc_labelTexto.insets = new Insets(0, 0, 5, 5);
		gbc_labelTexto.gridx = 1;
		gbc_labelTexto.gridy = 0;
		add(labelTexto, gbc_labelTexto);

		labelPersonaje = new JLabel(personaje.getNombre());
		GridBagConstraints gbc_labelPersonaje = new GridBagConstraints();
		gbc_labelPersonaje.insets = new Insets(0, 0, 5, 5);
		gbc_labelPersonaje.gridx = 1;
		gbc_labelPersonaje.gridy = 1;
		add(labelPersonaje, gbc_labelPersonaje);

		labelNivelAmor = new JLabel("Nivel de Amor: " + personaje.getNivelAmor());
		GridBagConstraints gbc_labelNivelAmor = new GridBagConstraints();
		gbc_labelNivelAmor.insets = new Insets(0, 0, 5, 0);
		gbc_labelNivelAmor.gridx = 2;
		gbc_labelNivelAmor.gridy = 1;
		add(labelNivelAmor, gbc_labelNivelAmor);

		labelEnunciado = new JLabel();
		GridBagConstraints gbc_labelEnunciado = new GridBagConstraints();
		gbc_labelEnunciado.insets = new Insets(0, 0, 5, 5);
		gbc_labelEnunciado.gridx = 1;
		gbc_labelEnunciado.gridy = 2;
		add(labelEnunciado, gbc_labelEnunciado);

		botonRespuesta1 = new JButton();
		GridBagConstraints gbc_botonRespuesta1 = new GridBagConstraints();
		gbc_botonRespuesta1.insets = new Insets(0, 0, 5, 5);
		gbc_botonRespuesta1.gridx = 1;
		gbc_botonRespuesta1.gridy = 3;
		add(botonRespuesta1, gbc_botonRespuesta1);

		botonRespuesta2 = new JButton();
		GridBagConstraints gbc_botonRespuesta2 = new GridBagConstraints();
		gbc_botonRespuesta2.insets = new Insets(0, 0, 0, 5);
		gbc_botonRespuesta2.gridx = 1;
		gbc_botonRespuesta2.gridy = 4;
		add(botonRespuesta2, gbc_botonRespuesta2);

		botonRespuesta1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verificarRespuesta(botonRespuesta1.getText());
			}
		});

		botonRespuesta2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verificarRespuesta(botonRespuesta2.getText());
			}
		});

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

	    actualizarPregunta();
	}

}