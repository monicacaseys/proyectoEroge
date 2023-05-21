package interfaces;

import javax.swing.JPanel;

import clases.Personaje;
import clases.Pregunta;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class PantallaEscena extends JPanel{
	Ventana ventana;
	private Personaje personaje;
    private Pregunta preguntaActual;
    private JLabel labelPersonaje;
    private JLabel labelNivelAmor;
	public PantallaEscena(Ventana v,final Personaje personaje) {
		this.ventana=v;
		this.personaje = personaje;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{85, 119, 162, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 87, 91, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		
		  // Obtener primera pregunta
        preguntaActual = personaje.obtenerSiguientePregunta();
        
        this.labelPersonaje = new JLabel(personaje.getNombre());
        GridBagConstraints gbc_labelPersonaje = new GridBagConstraints();
        gbc_labelPersonaje.insets = new Insets(0, 0, 5, 5);
        gbc_labelPersonaje.gridx = 1;
        gbc_labelPersonaje.gridy = 1;
        add(labelPersonaje, gbc_labelPersonaje);
        
        this.labelNivelAmor = new JLabel("Nivel de Amor: " + personaje.getNivelAmor());
        GridBagConstraints gbc_labelNivelAmor = new GridBagConstraints();
        gbc_labelNivelAmor.insets = new Insets(0, 0, 5, 5);
        gbc_labelNivelAmor.gridx = 2;
        gbc_labelNivelAmor.gridy = 1;
        add(labelNivelAmor, gbc_labelNivelAmor);

        // Mostrar pregunta en la interfaz
        final JLabel preguntaLabel = new JLabel(preguntaActual.getEnunciado());
		gbc_labelNivelAmor.gridwidth = 2;
		gbc_labelNivelAmor.insets = new Insets(0, 0, 5, 5);
		gbc_labelNivelAmor.gridx = 1;
		gbc_labelNivelAmor.gridy = 3;
		add(preguntaLabel, gbc_labelNivelAmor);
		
	       // Crear botones para las respuestas
        for (final String respuesta : preguntaActual.getRespuestas()) {
            JButton botonRespuesta = new JButton(respuesta);
            botonRespuesta.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
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
            
            add(botonRespuesta);
        }
        
	}

	public void actualizarNivelAmor(boolean respuestaCorrecta) {
        if (respuestaCorrecta) {
            personaje.aumentarAmor();;
        } else {
            personaje.disminuirAmor();;
        }
        labelNivelAmor.setText("Nivel de Amor: " + personaje.getNivelAmor());
    }
}
