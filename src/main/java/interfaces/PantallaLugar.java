package interfaces;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class PantallaLugar extends JPanel {
	Ventana ventana;
	private JButton btnCine;
	public PantallaLugar(Ventana v) {
		this.ventana=v;
		
		JButton btnPlaya = new JButton("PLAYA");
		btnPlaya.setBackground(new Color(255, 128, 192));
		btnPlaya.setBounds(180, 120, 231, 39);
		btnPlaya.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 20));
		btnPlaya.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		setLayout(null);
		
		JLabel titulo = new JLabel("ELIGE LUGAR PARA EL ENCUENTRO");
		titulo.setForeground(new Color(64, 0, 128));
		titulo.setBounds(31, 49, 559, 61);
		titulo.setBackground(new Color(128, 255, 0));
		titulo.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 27));
		add(titulo);
		add(btnPlaya);
		
		btnCine = new JButton("CINE");
		btnCine.setBackground(new Color(255, 128, 192));
		btnCine.setBounds(180, 169, 231, 39);
		btnCine.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 20));
		add(btnCine);
		
		JButton btnPetanca = new JButton("PETANCA");
		btnPetanca.setBackground(new Color(255, 128, 192));
		btnPetanca.setBounds(180, 218, 231, 39);
		btnPetanca.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 20));
		add(btnPetanca);
		
		JButton btnBeatbox = new JButton("BEATBOXING");
		btnBeatbox.setBackground(new Color(255, 128, 192));
		btnBeatbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBeatbox.setBounds(180, 267, 231, 38);
		btnBeatbox.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 20));
		add(btnBeatbox);
		
		JButton btnCosplay = new JButton("COSPLAY");
		btnCosplay.setBackground(new Color(255, 128, 192));
		btnCosplay.setBounds(180, 315, 231, 39);
		btnCosplay.setFont(new Font("X-Files", Font.BOLD | Font.ITALIC, 20));
		add(btnCosplay);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PantallaLugar.class.getResource("/imagenes/corazon.png")));
		lblNewLabel.setBounds(0, 0, 600, 500);
		add(lblNewLabel);
	}
}
