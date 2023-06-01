package interfaces;

import javax.swing.JPanel;

import clases.Jugador;
import clases.Personaje;
import utils.PersonajeDAO;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Color;

public class PantallaCasarse extends JPanel {
    private Ventana ventana;
    private Jugador jugador;
    private Personaje personaje;
    private BufferedImage fondo;

    public PantallaCasarse(Ventana v, final Jugador jugador, final Personaje personaje) {
        this.ventana = v;
        this.jugador = jugador;
        this.personaje = personaje;
        setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setForeground(new Color(128, 0, 64));
        lblNewLabel.setBackground(new Color(192, 192, 192));
        lblNewLabel.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel.setBounds(40, 452, 719, 125);
        add(lblNewLabel);

        // Obtener el nombre del jugador y el nombre del personaje con el que se casa
        String nombreJugador = jugador.getNombre();
        String nombrePersonaje = personaje.getNombre();

        // Crear el mensaje
        String mensaje = nombreJugador + " y " + nombrePersonaje + " serán felices y comerán perdices.";

        // Configurar el texto en lblNewLabel
        lblNewLabel.setText(mensaje);
        
        JLabel lblNewLabel_1 = new JLabel("FIN DE LA AVENTURA");
        lblNewLabel_1.setForeground(new Color(128, 0, 64));
        lblNewLabel_1.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 24));
        lblNewLabel_1.setBounds(271, 221, 313, 49);
        add(lblNewLabel_1);
        
        JButton botonExit = new JButton("EXIT");
        botonExit.setBackground(new Color(192, 192, 192));
        botonExit.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		//guardar informacion
        		PersonajeDAO personajeDAO = new PersonajeDAO();
				HashMap<Personaje, Integer> mapaPersonajes = new HashMap<>();
				mapaPersonajes.put(personaje, 1); // Agregar el personaje con valor 1 (representando la cantidad)
				personajeDAO.guardarDatosJugadorYPersonajes(jugador, mapaPersonajes);
				
        		ventana.cambiarAPantalla(PantallaInicio.class);
        	}
        });
        botonExit.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 17));
        botonExit.setBounds(634, 543, 111, 49);
        add(botonExit);
        

		try {
            fondo = ImageIO.read(getClass().getResource("/imagenes/bodaa.jpg"));
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
}

