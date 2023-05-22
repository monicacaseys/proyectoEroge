package interfaces;

import javax.swing.JPanel;

import clases.Personaje;
import clases.Pregunta;
import enums.Gusto;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaEscena extends JPanel {
	Ventana ventana;
	private Personaje personaje;
	private Pregunta preguntaActual;
	private JLabel labelPersonaje;
	private JLabel labelNivelAmor;
	private JButton botonRespuesta;
	private JLabel labelLugar;
	private JLabel labelTexto;


	public PantallaEscena(Ventana v, final Personaje personaje) {
		this.ventana = v;
		this.personaje = personaje;
		Gusto gustoElegido = ventana.getGustoElegido();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 85, 119, 162, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 87, 91, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);


		
		
		labelTexto = new JLabel("El encuentro tiene lugar en " + gustoElegido.toString()); //obtener el gusto elegido
		GridBagConstraints gbc_labelTexto = new GridBagConstraints();
		gbc_labelTexto.insets = new Insets(0, 0, 5, 5);
		gbc_labelTexto.gridx = 1;
		gbc_labelTexto.gridy = 1;
		add(labelTexto, gbc_labelTexto);

		this.labelPersonaje = new JLabel(personaje.getNombre());
		GridBagConstraints gbc_labelPersonaje = new GridBagConstraints();
		gbc_labelPersonaje.insets = new Insets(0, 0, 5, 5);
		gbc_labelPersonaje.gridx = 1;
		gbc_labelPersonaje.gridy = 2;
		add(labelPersonaje, gbc_labelPersonaje);

		this.labelNivelAmor = new JLabel("Nivel de Amor: " + personaje.getNivelAmor());
		GridBagConstraints gbc_labelNivelAmor = new GridBagConstraints();
		gbc_labelNivelAmor.insets = new Insets(0, 0, 5, 5);
		gbc_labelNivelAmor.gridx = 2;
		gbc_labelNivelAmor.gridy = 2;
		add(labelNivelAmor, gbc_labelNivelAmor);
		gbc_labelNivelAmor.gridwidth = 2;
		gbc_labelNivelAmor.insets = new Insets(0, 0, 5, 5);
		gbc_labelNivelAmor.gridx = 1;
		gbc_labelNivelAmor.gridy = 3;

		// Mostrar pregunta en la interfaz
		final JLabel preguntaLabel = new JLabel(preguntaActual.getEnunciado());
		GridBagConstraints gbc_preguntaLabel = new GridBagConstraints();
		gbc_preguntaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_preguntaLabel.gridx = 1;
		gbc_preguntaLabel.gridy = 4;
		add(preguntaLabel, gbc_preguntaLabel);

		for (final String respuesta : preguntaActual.getRespuestas()) {
			botonRespuesta = new JButton(respuesta);
			botonRespuesta.addMouseListener(new MouseAdapter() {
				@Override 
				public void mouseClicked(MouseEvent e) {
					// Verificar respuesta
					if (respuesta.equals(preguntaActual.getRespuestaCorrecta())) {
						System.out.println("Respuesta correcta!");
					} else {
						System.out.println("Respuesta incorrecta!");
					}

					// Obtener siguiente pregunta
					preguntaActual = personaje.obtenerSiguientePregunta();
					preguntaLabel.setText(preguntaActual.getEnunciado());
				}

			});
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
			gbc_btnNewButton.gridx = 2;
			gbc_btnNewButton.gridy = 3;
			add(botonRespuesta, gbc_btnNewButton);
		}

	}

	public void actualizarNivelAmor(boolean respuestaCorrecta) {
		if (respuestaCorrecta) {
			personaje.aumentarAmor();
			;
		} else {
			personaje.disminuirAmor();
			;
		}
		labelNivelAmor.setText("Nivel de Amor: " + personaje.getNivelAmor());
	}


}
