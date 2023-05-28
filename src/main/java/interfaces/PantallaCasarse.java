package interfaces;

import javax.swing.JPanel;

import clases.Jugador;
import clases.Personaje;

import javax.swing.JLabel;
import java.awt.Font;

public class PantallaCasarse extends JPanel {
    private Ventana ventana;
    private Jugador jugador;
    private Personaje personaje;

    public PantallaCasarse(Ventana v, Jugador jugador, Personaje personaje) {
        this.ventana = v;
        this.jugador = jugador;
        this.personaje = personaje;
        setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 15));
        lblNewLabel.setBounds(28, 273, 560, 193);
        add(lblNewLabel);

        // Obtener el nombre del jugador y el nombre del personaje con el que se casa
        String nombreJugador = jugador.getNombre();
        String nombrePersonaje = personaje.getNombre();

        // Crear el mensaje
        String mensaje = nombreJugador + " y " + nombrePersonaje + " serán felices y comerán perdices.";

        // Configurar el texto en lblNewLabel
        lblNewLabel.setText(mensaje);
        
        JLabel lblNewLabel_1 = new JLabel("FIN DE LA AVENTURA");
        lblNewLabel_1.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 15));
        lblNewLabel_1.setBounds(130, 45, 206, 49);
        add(lblNewLabel_1);
    }
}

