package interfaces;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import clases.Jugador;
import enums.Gusto;
import exceptions.NombreSinNumeros;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import javax.swing.JCheckBox;
import java.awt.Color;

public class PantallaNuevoJugador extends JPanel {

	private Ventana ventana;
	private JTextField textoNombre;
	private JTextField textoEdad;
	private JTextField textoPersonalidad;
	private JCheckBox checkboxPlaya;
	private JCheckBox chekboxCine;
	private JCheckBox checkBoxSushi;
	private JCheckBox checkBoxPetanca;
	private JCheckBox checkBoxBeatBox;
	private JCheckBox checkBoxCosplay;
	private JLabel lblNewLabel_1;

	public PantallaNuevoJugador(Ventana v) {
		this.ventana = v;
		setLayout(null);

		JLabel tituloDatos = new JLabel("RELLENAME");
		tituloDatos.setForeground(new Color(0, 0, 0));
		tituloDatos.setBounds(306, 210, 220, 39);
		tituloDatos.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 29));
		add(tituloDatos);

		JLabel labelNombre = new JLabel("NOMBRE");
		labelNombre.setForeground(new Color(0, 255, 255));
		labelNombre.setBackground(Color.RED);
		labelNombre.setBounds(247, 390, 93, 19);
		labelNombre.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 18));
		add(labelNombre);

		textoNombre = new JTextField();
		textoNombre.setBounds(359, 390, 137, 19);
		add(textoNombre);
		textoNombre.setColumns(10);

		JLabel labelEdad = new JLabel("EDAD");
		labelEdad.setBackground(new Color(128, 0, 64));
		labelEdad.setForeground(new Color(0, 255, 255));
		labelEdad.setBounds(276, 419, 73, 30);
		labelEdad.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 18));
		add(labelEdad);

		textoEdad = new JTextField();
		textoEdad.setBounds(359, 419, 137, 19);
		add(textoEdad);
		textoEdad.setColumns(10);

		JLabel labelPersonalidad = new JLabel("PERSONALIDAD");
		labelPersonalidad.setForeground(new Color(0, 230, 230));
		labelPersonalidad.setBounds(181, 452, 161, 30);
		labelPersonalidad.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 18));
		add(labelPersonalidad);

		textoPersonalidad = new JTextField();
		textoPersonalidad.setBounds(359, 448, 137, 19);
		add(textoPersonalidad);
		textoPersonalidad.setColumns(10);

		JLabel labelGustos = new JLabel("GUSTOS");
		labelGustos.setForeground(new Color(0, 255, 255));
		labelGustos.setBounds(191, 492, 93, 32);
		labelGustos.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 18));
		add(labelGustos);

		checkboxPlaya = new JCheckBox("Playa");
		checkboxPlaya.setFont(new Font("Tahoma", Font.BOLD, 14));
		checkboxPlaya.setBounds(169, 558, 73, 21);
		add(checkboxPlaya);

		chekboxCine = new JCheckBox("Cine");
		chekboxCine.setFont(new Font("Tahoma", Font.BOLD, 14));
		chekboxCine.setBounds(247, 530, 73, 20);
		add(chekboxCine);

		checkBoxSushi = new JCheckBox("Sushi");
		checkBoxSushi.setFont(new Font("Tahoma", Font.BOLD, 14));
		checkBoxSushi.setBounds(169, 530, 73, 19);
		add(checkBoxSushi);

		checkBoxPetanca = new JCheckBox("Petanca");
		checkBoxPetanca.setFont(new Font("Tahoma", Font.BOLD, 14));
		checkBoxPetanca.setBounds(247, 558, 103, 20);
		add(checkBoxPetanca);

		checkBoxBeatBox = new JCheckBox("Beatboxing");
		checkBoxBeatBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		checkBoxBeatBox.setBounds(258, 587, 120, 21);
		add(checkBoxBeatBox);

		checkBoxCosplay = new JCheckBox("Cosplay");
		checkBoxCosplay.setFont(new Font("Tahoma", Font.BOLD, 14));
		checkBoxCosplay.setBounds(169, 587, 87, 21);
		add(checkBoxCosplay);

		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.setBackground(new Color(192, 192, 192));
		botonAceptar.setBounds(488, 555, 120, 30);
		botonAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String nombre = textoNombre.getText();
					validarNombre();
					int edad = Integer.parseInt(textoEdad.getText());
					String personalidad = textoPersonalidad.getText();
					HashSet<Gusto> gustos = obtenerGustosSeleccionados(); // Método para obtener los gustos
																			// seleccionados

					Jugador nuevoJugador = Jugador.crearNuevoJugador(nombre, edad, personalidad, gustos);
					ventana.setJugador(nuevoJugador);

					JOptionPane.showMessageDialog(PantallaNuevoJugador.this, "Jugador creado correctamente.",
							"Confirmación", JOptionPane.INFORMATION_MESSAGE);
					ventana.cambiarAPantalla(PantallaHistoria.class);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(PantallaNuevoJugador.this,
							"Error: La edad debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(PantallaNuevoJugador.this, "Error: " + ex.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}

		});

		botonAceptar.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 18));
		add(botonAceptar);
		JButton botonAtras = new JButton("Atrás");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaInicio.class);
			}
		});
		botonAtras.setBackground(new Color(192, 192, 192));
		botonAtras.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 15));
		botonAtras.setBounds(37, 622, 93, 39);
		add(botonAtras);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(PantallaNuevoJugador.class.getResource("/imagenes/bocaaa.png")));
		lblNewLabel_1.setBounds(-107, -157, 896, 957);
		add(lblNewLabel_1);

	}

	private void validarNombre() throws NombreSinNumeros {
		String nombre = textoNombre.getText();
		if (nombre.matches(".*\\d.*")) {
			throw new NombreSinNumeros("El nombre no debe contener números");
		}
	}

	private HashSet<Gusto> obtenerGustosSeleccionados() {
		HashSet<Gusto> gustosSeleccionados = new HashSet<>();

		if (checkboxPlaya.isSelected()) {
			gustosSeleccionados.add(Gusto.PLAYA);
		}
		if (chekboxCine.isSelected()) {
			gustosSeleccionados.add(Gusto.CINE);
		}
		if (checkBoxSushi.isSelected()) {
			gustosSeleccionados.add(Gusto.SUSHI);
		}
		if (checkBoxPetanca.isSelected()) {
			gustosSeleccionados.add(Gusto.PETANCA);
		}
		if (checkBoxBeatBox.isSelected()) {
			gustosSeleccionados.add(Gusto.BEATBOXING);
		}
		if (checkBoxCosplay.isSelected()) {
			gustosSeleccionados.add(Gusto.COSPLAY);
		}

		return gustosSeleccionados;
	}
}
