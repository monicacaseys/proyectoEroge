package interfaces;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import clases.Jugador;
import enums.Gusto;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import javax.swing.JCheckBox;

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
	
	public PantallaNuevoJugador(Ventana v) {
		this.ventana=v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 154, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 40, 37, 36, 38, 37, 0, 0, 0, 0, -33, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel tituloDatos = new JLabel("RELLENAME");
		tituloDatos.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 23));
		GridBagConstraints gbc_tituloDatos = new GridBagConstraints();
		gbc_tituloDatos.gridwidth = 2;
		gbc_tituloDatos.insets = new Insets(0, 0, 5, 5);
		gbc_tituloDatos.gridx = 1;
		gbc_tituloDatos.gridy = 1;
		add(tituloDatos, gbc_tituloDatos);

		JLabel labelNombre = new JLabel("NOMBRE");
		labelNombre.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 16));
		GridBagConstraints gbc_labelNombre = new GridBagConstraints();
		gbc_labelNombre.insets = new Insets(0, 0, 5, 5);
		gbc_labelNombre.gridx = 1;
		gbc_labelNombre.gridy = 2;
		add(labelNombre, gbc_labelNombre);

		textoNombre = new JTextField();
		GridBagConstraints gbc_textoNombre = new GridBagConstraints();
		gbc_textoNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textoNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textoNombre.gridx = 2;
		gbc_textoNombre.gridy = 2;
		add(textoNombre, gbc_textoNombre);
		textoNombre.setColumns(10);

		JLabel labelEdad = new JLabel("EDAD");
		labelEdad.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 16));
		GridBagConstraints gbc_labelEdad = new GridBagConstraints();
		gbc_labelEdad.insets = new Insets(0, 0, 5, 5);
		gbc_labelEdad.gridx = 1;
		gbc_labelEdad.gridy = 3;
		add(labelEdad, gbc_labelEdad);

		textoEdad = new JTextField();
		GridBagConstraints gbc_textoEdad = new GridBagConstraints();
		gbc_textoEdad.insets = new Insets(0, 0, 5, 5);
		gbc_textoEdad.fill = GridBagConstraints.HORIZONTAL;
		gbc_textoEdad.gridx = 2;
		gbc_textoEdad.gridy = 3;
		add(textoEdad, gbc_textoEdad);
		textoEdad.setColumns(10);

		JLabel labelPersonalidad = new JLabel("PERSONALIDAD");
		labelPersonalidad.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 16));
		GridBagConstraints gbc_labelPersonalidad = new GridBagConstraints();
		gbc_labelPersonalidad.insets = new Insets(0, 0, 5, 5);
		gbc_labelPersonalidad.gridx = 1;
		gbc_labelPersonalidad.gridy = 4;
		add(labelPersonalidad, gbc_labelPersonalidad);

		textoPersonalidad = new JTextField();
		GridBagConstraints gbc_textoPersonalidad = new GridBagConstraints();
		gbc_textoPersonalidad.insets = new Insets(0, 0, 5, 5);
		gbc_textoPersonalidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_textoPersonalidad.gridx = 2;
		gbc_textoPersonalidad.gridy = 4;
		add(textoPersonalidad, gbc_textoPersonalidad);
		textoPersonalidad.setColumns(10);

		JLabel labelGustos = new JLabel("GUSTOS");
		labelGustos.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 16));
		GridBagConstraints gbc_labelGustos = new GridBagConstraints();
		gbc_labelGustos.insets = new Insets(0, 0, 5, 5);
		gbc_labelGustos.gridx = 1;
		gbc_labelGustos.gridy = 5;
		add(labelGustos, gbc_labelGustos);
		
		checkboxPlaya = new JCheckBox("Playa");
		GridBagConstraints gbc_checkboxPlaya = new GridBagConstraints();
		gbc_checkboxPlaya.insets = new Insets(0, 0, 5, 5);
		gbc_checkboxPlaya.gridx = 1;
		gbc_checkboxPlaya.gridy = 7;
		add(checkboxPlaya, gbc_checkboxPlaya);

		chekboxCine = new JCheckBox("Cine");
		GridBagConstraints gbc_chekboxCine = new GridBagConstraints();
		gbc_chekboxCine.insets = new Insets(0, 0, 5, 5);
		gbc_chekboxCine.gridx = 1;
		gbc_chekboxCine.gridy = 6;
		add(chekboxCine, gbc_chekboxCine);

		checkBoxSushi = new JCheckBox("Sushi");
		GridBagConstraints gbc_checkBoxSushi = new GridBagConstraints();
		gbc_checkBoxSushi.insets = new Insets(0, 0, 5, 5);
		gbc_checkBoxSushi.gridx = 2;
		gbc_checkBoxSushi.gridy = 6;
		add(checkBoxSushi, gbc_checkBoxSushi);

		
		checkBoxPetanca = new JCheckBox("Petanca");
		GridBagConstraints gbc_checkBoxPetanca = new GridBagConstraints();
		gbc_checkBoxPetanca.insets = new Insets(0, 0, 5, 5);
		gbc_checkBoxPetanca.gridx = 2;
		gbc_checkBoxPetanca.gridy = 7;
		add(checkBoxPetanca, gbc_checkBoxPetanca);

		checkBoxBeatBox = new JCheckBox("Beatboxing");
		GridBagConstraints gbc_checkBoxBeatBox = new GridBagConstraints();
		gbc_checkBoxBeatBox.insets = new Insets(0, 0, 5, 5);
		gbc_checkBoxBeatBox.gridx = 1;
		gbc_checkBoxBeatBox.gridy = 8;
		add(checkBoxBeatBox, gbc_checkBoxBeatBox);

		checkBoxCosplay = new JCheckBox("Cosplay");
		GridBagConstraints gbc_checkBoxCosplay = new GridBagConstraints();
		gbc_checkBoxCosplay.insets = new Insets(0, 0, 5, 5);
		gbc_checkBoxCosplay.gridx = 2;
		gbc_checkBoxCosplay.gridy = 8;
		add(checkBoxCosplay, gbc_checkBoxCosplay);


		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombre = textoNombre.getText();
				int edad = Integer.parseInt(textoEdad.getText());
				String personalidad = textoPersonalidad.getText();
				HashSet<Gusto> gustos = obtenerGustosSeleccionados(); // Método para obtener los gustos seleccionados

				Jugador nuevoJugador = Jugador.crearNuevoJugador(nombre, edad, personalidad, gustos);
				// ... hacer algo con el nuevo jugador ...

				 JOptionPane.showMessageDialog(PantallaNuevoJugador.this, "Jugador creado correctamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		
		botonAceptar.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_botonAceptar = new GridBagConstraints();
		gbc_botonAceptar.gridwidth = 2;
		gbc_botonAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_botonAceptar.gridx = 1;
		gbc_botonAceptar.gridy = 9;
		add(botonAceptar, gbc_botonAceptar);
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
