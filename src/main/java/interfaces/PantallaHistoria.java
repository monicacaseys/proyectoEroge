package interfaces;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.Insets;
import java.util.Arrays;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaHistoria extends JPanel {

	    private Ventana ventana;
	   
	private JLabel historiaLabel;
	private String[] historia = { //acortar texto
			"El dia 2 de Abril, en  el planeta Tierra se abrio una brecha que liberó a seres de otra dimensión.",
		/*	"Estos seres eran diferentes a todo lo que la humanidad había visto antes.",
			"Había seres con formas inusuales y criaturas con habilidades sobrenaturales.",
			"Todos estos seres compartían algo en común",
			"Su lucha contra el patriarcado y el heterosexismo que dominaba el mundo humano.",
			"Así nació \"The Breach\", un lugar seguro",
			"Donde estos seres podían vivir juntos sin ser discriminados por su apariencia.",
			"En este mundo encontrarás una gran variedad de personajes únicos y fascinantes.",
			"A través de tus relaciones, aprenderá más sobre la aceptación de la diversidad sexual.",
			"¿Estás liste para unirte a esta lucha por la igualdad y la aceptación en \"The Breach\"? ",
			"¡Que comience el jeugo!"*/ };
	private int indiceParteHistoria = 0;

	public PantallaHistoria(Ventana v) {
		this.ventana = v;
		setLayout(new BorderLayout());
		setBackground(Color.BLACK);

		JPanel contenedorTexto = new JPanel(new BorderLayout());
		contenedorTexto.setBackground(Color.BLACK);

		final JLabel historiaLabel = new JLabel();
		historiaLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		historiaLabel.setForeground(Color.WHITE);
		historiaLabel.setHorizontalAlignment(SwingConstants.CENTER);

		Border borde = BorderFactory.createLineBorder(Color.RED, 2);
		contenedorTexto.setBorder(borde);
		contenedorTexto.add(historiaLabel, BorderLayout.CENTER);

		add(contenedorTexto, BorderLayout.CENTER);
		
		final JButton continuarButton = new JButton("Continuar");
		continuarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaEscena.class);
			}
		});
		continuarButton.setForeground(new Color(255, 0, 0));
		continuarButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		contenedorTexto.add(continuarButton, BorderLayout.SOUTH);

		// Crear y iniciar un hilo para mostrar la historia gradualmente
		Thread historiaThread = new Thread(new Runnable() {
			@Override
			public void run() {
				mostrarHistoria(historiaLabel);
				 SwingUtilities.invokeLater(new Runnable() {
			            @Override
			            public void run() {
			                continuarButton.setEnabled(true); // Habilitar el botón Continuar después de mostrar la historia
			            }
			        });
			}
		});
		historiaThread.start();
	}

	private void mostrarHistoria(JLabel historiaLabel) {
		try {
			for (int i = 0; i < historia.length; i++) {
				String parteHistoria = historia[i];
				String[] lineas = parteHistoria.split("\n");

				for (String linea : lineas) {
					mostrarLinea(linea, historiaLabel);
					Thread.sleep(200); // Pausa de 2 segundos entre cada línea
				}

				if (i < historia.length - 1) {
					Thread.sleep(200); // Pausa de 2 segundos entre cada parte de la historia
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void mostrarLinea(String linea, JLabel historiaLabel) {
		StringBuilder textoVisible = new StringBuilder();
		for (int i = 0; i < linea.length(); i++) {
			char c = linea.charAt(i);
			textoVisible.append(c);

			historiaLabel.setText(textoVisible.toString());
			try {
				Thread.sleep(50); // Pausa de 50 milisegundos entre cada carácter
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		textoVisible.append(" "); 
		historiaLabel.setText(textoVisible.toString());
		try {
			Thread.sleep(100); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

