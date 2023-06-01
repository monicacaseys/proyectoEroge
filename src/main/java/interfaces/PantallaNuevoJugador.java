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
import java.awt.Graphics;

import javax.swing.JRadioButton;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
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
	private BufferedImage fondo;

	public PantallaNuevoJugador(Ventana v) {
		this.ventana = v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{35, 93, 181, 161, 22, 126, 120, 0};
		gridBagLayout.rowHeights = new int[]{37, 65, 253, 32, 23, 1, 30, 21, 20, 0, 41, 0, 54, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
								
										JLabel tituloDatos = new JLabel("RELLENAME");
										tituloDatos.setForeground(new Color(0, 0, 0));
										tituloDatos.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 29));
										GridBagConstraints gbc_tituloDatos = new GridBagConstraints();
										gbc_tituloDatos.anchor = GridBagConstraints.WEST;
										gbc_tituloDatos.fill = GridBagConstraints.VERTICAL;
										gbc_tituloDatos.insets = new Insets(0, 0, 5, 5);
										gbc_tituloDatos.gridwidth = 2;
										gbc_tituloDatos.gridx = 3;
										gbc_tituloDatos.gridy = 1;
										add(tituloDatos, gbc_tituloDatos);
						
								JLabel labelNombre = new JLabel("NOMBRE");
								labelNombre.setForeground(new Color(0, 255, 255));
								labelNombre.setBackground(Color.RED);
								labelNombre.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 18));
								GridBagConstraints gbc_labelNombre = new GridBagConstraints();
								gbc_labelNombre.anchor = GridBagConstraints.EAST;
								gbc_labelNombre.insets = new Insets(0, 0, 5, 5);
								gbc_labelNombre.gridx = 2;
								gbc_labelNombre.gridy = 3;
								add(labelNombre, gbc_labelNombre);
						
								textoNombre = new JTextField();
								GridBagConstraints gbc_textoNombre = new GridBagConstraints();
								gbc_textoNombre.fill = GridBagConstraints.HORIZONTAL;
								gbc_textoNombre.insets = new Insets(0, 0, 5, 5);
								gbc_textoNombre.gridx = 3;
								gbc_textoNombre.gridy = 3;
								add(textoNombre, gbc_textoNombre);
								textoNombre.setColumns(10);
				
						JLabel labelEdad = new JLabel("EDAD");
						labelEdad.setBackground(new Color(128, 0, 64));
						labelEdad.setForeground(new Color(0, 255, 255));
						labelEdad.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 18));
						GridBagConstraints gbc_labelEdad = new GridBagConstraints();
						gbc_labelEdad.anchor = GridBagConstraints.NORTHEAST;
						gbc_labelEdad.insets = new Insets(0, 0, 5, 5);
						gbc_labelEdad.gridx = 2;
						gbc_labelEdad.gridy = 4;
						add(labelEdad, gbc_labelEdad);
						
								textoEdad = new JTextField();
								GridBagConstraints gbc_textoEdad = new GridBagConstraints();
								gbc_textoEdad.anchor = GridBagConstraints.NORTH;
								gbc_textoEdad.fill = GridBagConstraints.HORIZONTAL;
								gbc_textoEdad.insets = new Insets(0, 0, 5, 5);
								gbc_textoEdad.gridx = 3;
								gbc_textoEdad.gridy = 4;
								add(textoEdad, gbc_textoEdad);
								textoEdad.setColumns(10);
				
						JLabel labelPersonalidad = new JLabel("PERSONALIDAD");
						labelPersonalidad.setForeground(new Color(0, 230, 230));
						labelPersonalidad.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 18));
						GridBagConstraints gbc_labelPersonalidad = new GridBagConstraints();
						gbc_labelPersonalidad.anchor = GridBagConstraints.EAST;
						gbc_labelPersonalidad.insets = new Insets(0, 0, 5, 5);
						gbc_labelPersonalidad.gridx = 2;
						gbc_labelPersonalidad.gridy = 5;
						add(labelPersonalidad, gbc_labelPersonalidad);
								
										textoPersonalidad = new JTextField();
										GridBagConstraints gbc_textoPersonalidad = new GridBagConstraints();
										gbc_textoPersonalidad.anchor = GridBagConstraints.NORTH;
										gbc_textoPersonalidad.fill = GridBagConstraints.HORIZONTAL;
										gbc_textoPersonalidad.insets = new Insets(0, 0, 5, 5);
										gbc_textoPersonalidad.gridx = 3;
										gbc_textoPersonalidad.gridy = 5;
										add(textoPersonalidad, gbc_textoPersonalidad);
										textoPersonalidad.setColumns(10);
												JButton botonAtras = new JButton("Atrás");
												botonAtras.addMouseListener(new MouseAdapter() {
													@Override
													public void mouseClicked(MouseEvent e) {
														ventana.cambiarAPantalla(PantallaInicio.class);
													}
												});
																				
																						JLabel labelGustos = new JLabel("GUSTOS");
																						labelGustos.setForeground(new Color(0, 255, 255));
																						labelGustos.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 18));
																						GridBagConstraints gbc_labelGustos = new GridBagConstraints();
																						gbc_labelGustos.anchor = GridBagConstraints.SOUTHEAST;
																						gbc_labelGustos.insets = new Insets(0, 0, 5, 5);
																						gbc_labelGustos.gridx = 2;
																						gbc_labelGustos.gridy = 6;
																						add(labelGustos, gbc_labelGustos);
																		
																				checkBoxSushi = new JCheckBox("Sushi");
																				checkBoxSushi.setFont(new Font("Tahoma", Font.BOLD, 14));
																				GridBagConstraints gbc_checkBoxSushi = new GridBagConstraints();
																				gbc_checkBoxSushi.anchor = GridBagConstraints.EAST;
																				gbc_checkBoxSushi.fill = GridBagConstraints.VERTICAL;
																				gbc_checkBoxSushi.insets = new Insets(0, 0, 5, 5);
																				gbc_checkBoxSushi.gridx = 2;
																				gbc_checkBoxSushi.gridy = 7;
																				add(checkBoxSushi, gbc_checkBoxSushi);
																		
																				checkBoxCosplay = new JCheckBox("Cosplay");
																				checkBoxCosplay.setFont(new Font("Tahoma", Font.BOLD, 14));
																				GridBagConstraints gbc_checkBoxCosplay = new GridBagConstraints();
																				gbc_checkBoxCosplay.anchor = GridBagConstraints.WEST;
																				gbc_checkBoxCosplay.fill = GridBagConstraints.VERTICAL;
																				gbc_checkBoxCosplay.insets = new Insets(0, 0, 5, 5);
																				gbc_checkBoxCosplay.gridx = 3;
																				gbc_checkBoxCosplay.gridy = 7;
																				add(checkBoxCosplay, gbc_checkBoxCosplay);
																
																		chekboxCine = new JCheckBox("Cine");
																		chekboxCine.setFont(new Font("Tahoma", Font.BOLD, 14));
																		GridBagConstraints gbc_chekboxCine = new GridBagConstraints();
																		gbc_chekboxCine.anchor = GridBagConstraints.EAST;
																		gbc_chekboxCine.insets = new Insets(0, 0, 5, 5);
																		gbc_chekboxCine.gridx = 2;
																		gbc_chekboxCine.gridy = 8;
																		add(chekboxCine, gbc_chekboxCine);
																
																		checkBoxPetanca = new JCheckBox("Petanca");
																		checkBoxPetanca.setFont(new Font("Tahoma", Font.BOLD, 14));
																		GridBagConstraints gbc_checkBoxPetanca = new GridBagConstraints();
																		gbc_checkBoxPetanca.anchor = GridBagConstraints.WEST;
																		gbc_checkBoxPetanca.fill = GridBagConstraints.VERTICAL;
																		gbc_checkBoxPetanca.insets = new Insets(0, 0, 5, 5);
																		gbc_checkBoxPetanca.gridx = 3;
																		gbc_checkBoxPetanca.gridy = 8;
																		add(checkBoxPetanca, gbc_checkBoxPetanca);
														
																checkboxPlaya = new JCheckBox("Playa");
																checkboxPlaya.setFont(new Font("Tahoma", Font.BOLD, 14));
																GridBagConstraints gbc_checkboxPlaya = new GridBagConstraints();
																gbc_checkboxPlaya.anchor = GridBagConstraints.EAST;
																gbc_checkboxPlaya.fill = GridBagConstraints.VERTICAL;
																gbc_checkboxPlaya.insets = new Insets(0, 0, 5, 5);
																gbc_checkboxPlaya.gridx = 2;
																gbc_checkboxPlaya.gridy = 9;
																add(checkboxPlaya, gbc_checkboxPlaya);
												
														checkBoxBeatBox = new JCheckBox("Beatboxing");
														checkBoxBeatBox.setFont(new Font("Tahoma", Font.BOLD, 14));
														GridBagConstraints gbc_checkBoxBeatBox = new GridBagConstraints();
														gbc_checkBoxBeatBox.insets = new Insets(0, 0, 5, 5);
														gbc_checkBoxBeatBox.anchor = GridBagConstraints.NORTHWEST;
														gbc_checkBoxBeatBox.gridx = 3;
														gbc_checkBoxBeatBox.gridy = 9;
														add(checkBoxBeatBox, gbc_checkBoxBeatBox);
												botonAtras.setBackground(new Color(192, 192, 192));
												botonAtras.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 18));
												GridBagConstraints gbc_botonAtras = new GridBagConstraints();
												gbc_botonAtras.fill = GridBagConstraints.HORIZONTAL;
												gbc_botonAtras.anchor = GridBagConstraints.SOUTH;
												gbc_botonAtras.insets = new Insets(0, 0, 5, 5);
												gbc_botonAtras.gridx = 1;
												gbc_botonAtras.gridy = 11;
												add(botonAtras, gbc_botonAtras);
												
														JButton botonAceptar = new JButton("Aceptar");
														botonAceptar.setBackground(new Color(192, 192, 192));
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
																GridBagConstraints gbc_botonAceptar = new GridBagConstraints();
																gbc_botonAceptar.anchor = GridBagConstraints.SOUTHWEST;
																gbc_botonAceptar.insets = new Insets(0, 0, 5, 5);
																gbc_botonAceptar.gridwidth = 2;
																gbc_botonAceptar.gridx = 3;
																gbc_botonAceptar.gridy = 11;
																add(botonAceptar, gbc_botonAceptar);

		try {
            fondo = ImageIO.read(getClass().getResource("/imagenes/bocaaa.png"));
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
