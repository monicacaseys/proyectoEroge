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
		this.ventana=v;
		setLayout(null);
		
		

		JLabel tituloDatos = new JLabel("RELLENAME");
		tituloDatos.setForeground(new Color(255, 255, 255));
		tituloDatos.setBounds(15, 53, 220, 39);
		tituloDatos.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 29));
		add(tituloDatos);

		JLabel labelNombre = new JLabel("NOMBRE");
		labelNombre.setForeground(new Color(0, 255, 255));
		labelNombre.setBackground(Color.RED);
		labelNombre.setBounds(142, 149, 93, 19);
		labelNombre.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 18));
		add(labelNombre);

		textoNombre = new JTextField();
		textoNombre.setBounds(325, 149, 137, 19);
		add(textoNombre);
		textoNombre.setColumns(10);

		JLabel labelEdad = new JLabel("EDAD");
		labelEdad.setBackground(new Color(128, 0, 64));
		labelEdad.setForeground(new Color(0, 255, 255));
		labelEdad.setBounds(152, 167, 73, 39);
		labelEdad.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 18));
		add(labelEdad);

		textoEdad = new JTextField();
		textoEdad.setBounds(325, 177, 137, 19);
		add(textoEdad);
		textoEdad.setColumns(10);

		JLabel labelPersonalidad = new JLabel("PERSONALIDAD");
		labelPersonalidad.setForeground(new Color(0, 230, 230));
		labelPersonalidad.setBounds(54, 200, 161, 30);
		labelPersonalidad.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 18));
		add(labelPersonalidad);

		textoPersonalidad = new JTextField();
		textoPersonalidad.setBounds(325, 206, 137, 19);
		add(textoPersonalidad);
		textoPersonalidad.setColumns(10);

		JLabel labelGustos = new JLabel("GUSTOS");
		labelGustos.setForeground(new Color(0, 255, 255));
		labelGustos.setBounds(102, 245, 93, 32);
		labelGustos.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 18));
		add(labelGustos);
		
		checkboxPlaya = new JCheckBox("Playa");
		checkboxPlaya.setFont(new Font("Tahoma", Font.BOLD, 14));
		checkboxPlaya.setBounds(112, 312, 73, 21);
		add(checkboxPlaya);

		chekboxCine = new JCheckBox("Cine");
		chekboxCine.setFont(new Font("Tahoma", Font.BOLD, 14));
		chekboxCine.setBounds(209, 282, 73, 20);
		add(chekboxCine);

		checkBoxSushi = new JCheckBox("Sushi");
		checkBoxSushi.setFont(new Font("Tahoma", Font.BOLD, 14));
		checkBoxSushi.setBounds(112, 283, 73, 19);
		add(checkBoxSushi);

		
		checkBoxPetanca = new JCheckBox("Petanca");
		checkBoxPetanca.setFont(new Font("Tahoma", Font.BOLD, 14));
		checkBoxPetanca.setBounds(309, 282, 103, 20);
		add(checkBoxPetanca);

		checkBoxBeatBox = new JCheckBox("Beatboxing");
		checkBoxBeatBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		checkBoxBeatBox.setBounds(309, 312, 120, 21);
		add(checkBoxBeatBox);

		checkBoxCosplay = new JCheckBox("Cosplay");
		checkBoxCosplay.setFont(new Font("Tahoma", Font.BOLD, 14));
		checkBoxCosplay.setBounds(209, 312, 87, 21);
		add(checkBoxCosplay);


		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.setBackground(new Color(192, 192, 192));
		botonAceptar.setBounds(342, 381, 120, 30);
		botonAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
		            String nombre = textoNombre.getText();
		            int edad = Integer.parseInt(textoEdad.getText());
		            String personalidad = textoPersonalidad.getText();
		            HashSet<Gusto> gustos = obtenerGustosSeleccionados(); // Método para obtener los gustos seleccionados

		            Jugador nuevoJugador = Jugador.crearNuevoJugador(nombre, edad, personalidad, gustos);
		            // ... hacer algo con el nuevo jugador ...

		            JOptionPane.showMessageDialog(PantallaNuevoJugador.this, "Jugador creado correctamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
		        ventana.cambiarAPantalla(PantallaHistoria.class);
				} catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(PantallaNuevoJugador.this, "Error: La edad debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(PantallaNuevoJugador.this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }
			
		});
		
		
		botonAceptar.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 18));
		add(botonAceptar);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(PantallaNuevoJugador.class.getResource("/imagenes/bocaa - copia.png")));
		lblNewLabel_1.setBounds(0, 0, 600, 500);
		add(lblNewLabel_1);
		
		
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
