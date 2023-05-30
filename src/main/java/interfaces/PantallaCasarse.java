package interfaces;

import javax.swing.JPanel;

import clases.Jugador;
import clases.Personaje;
import utils.PersonajeDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.ImageIcon;
import java.awt.Color;

public class PantallaCasarse extends JPanel {
    private Ventana ventana;
    private Jugador jugador;
    private Personaje personaje;

    public PantallaCasarse(Ventana v, final Jugador jugador, final Personaje personaje) {
        this.ventana = v;
        this.jugador = jugador;
        this.personaje = personaje;
        setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 19));
        lblNewLabel.setBounds(32, 204, 669, 125);
        add(lblNewLabel);

        // Obtener el nombre del jugador y el nombre del personaje con el que se casa
        String nombreJugador = jugador.getNombre();
        String nombrePersonaje = personaje.getNombre();

        // Crear el mensaje
        String mensaje = nombreJugador + " y " + nombrePersonaje + " serán felices y comerán perdices.";

        // Configurar el texto en lblNewLabel
        lblNewLabel.setText(mensaje);
        
        JLabel lblNewLabel_1 = new JLabel("FIN DE LA AVENTURA");
        lblNewLabel_1.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel_1.setBounds(120, 113, 275, 49);
        add(lblNewLabel_1);
        
        JButton botonExit = new JButton("EXIT");
        botonExit.setBackground(new Color(240, 240, 240));
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
        botonExit.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 15));
        botonExit.setBounds(578, 475, 93, 33);
        add(botonExit);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(PantallaCasarse.class.getResource("/imagenes/bodaa.jpg")));
        lblNewLabel_2.setBounds(0, -49, 800, 846);
        add(lblNewLabel_2);
    }
}

