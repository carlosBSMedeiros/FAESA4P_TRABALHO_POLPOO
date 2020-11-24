package view;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controllers.Main;
import utils.InOut;

public class HomeUI extends JFrame {

	private String tamanhoArquivo;
	private String metodo;
	private static Main main;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeUI frame = new HomeUI();
					main = new Main();
					frame.setVisible(true);
					
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomeUI() {

		tamanhoArquivo = "Todos";
		metodo = "Todos";

		getContentPane().setLayout(null);

		JLabel lblimg = new JLabel("");
		lblimg.setBounds(331, 62, 267, 259);
		lblimg.setIcon(new ImageIcon("C:\\el\\Fabio.Helmer\\treinamento\\javaFaesa\\trabalho\\FAESA4P_TRABALHO_POLPOO\\src\\view\\home.png"));
		getContentPane().add(lblimg);

		JComboBox comboBoxMetodo = new JComboBox();
		comboBoxMetodo.setBounds(170, 40, 160, 32);
		comboBoxMetodo.addItem("Todos");
		comboBoxMetodo.addItem("Quick");
		comboBoxMetodo.addItem("Heap");
		comboBoxMetodo.addItem("ABB");
		comboBoxMetodo.addItem("AVL");
		comboBoxMetodo.addItem("Hasing");
		getContentPane().add(comboBoxMetodo);
		comboBoxMetodo.addActionListener(event -> {
			metodo = comboBoxMetodo.getSelectedItem().toString();
		});

		JComboBox comboBoxTamanhoArquivo = new JComboBox();
		comboBoxTamanhoArquivo.setBounds(170, 98, 160, 32);
		comboBoxTamanhoArquivo.addItem("Todos");
		comboBoxTamanhoArquivo.addItem("500");
		comboBoxTamanhoArquivo.addItem("1000");
		comboBoxTamanhoArquivo.addItem("10000");
		comboBoxTamanhoArquivo.addItem("50000");
		getContentPane().add(comboBoxTamanhoArquivo);
		comboBoxTamanhoArquivo.addActionListener(event -> {
			tamanhoArquivo = comboBoxTamanhoArquivo.getSelectedItem().toString();
		});

		JLabel lblmetodo = new JLabel("M�todo");
		lblmetodo.setBounds(43, 49, 46, 14);
		getContentPane().add(lblmetodo);

		JLabel lblTamanhoDoArquivo = new JLabel("Tamanho do Arquivo");
		lblTamanhoDoArquivo.setBounds(43, 107, 117, 14);
		getContentPane().add(lblTamanhoDoArquivo);

		JButton btnInciar = new JButton("Start");
		btnInciar.addActionListener(event -> {
			main.main(metodo, tamanhoArquivo);
			InOut.outputInformacao("Fim da execusão", "Concluído");
			hide();
			
			SaidaUI saidaUI = new SaidaUI();
			saidaUI.getTable().setValueAt(22.2, saidaUI.ROWQUICK,saidaUI.CL500);
			saidaUI.getTable().setValueAt(1.2,  saidaUI.ROWQUICK,saidaUI.CL50000);
			saidaUI.getTable().setValueAt(1.2,  saidaUI.ROWAVL,saidaUI.CL10000);
			saidaUI.show();
		});

		btnInciar.setBounds(170, 159, 160, 32);
		getContentPane().add(btnInciar);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 300, 614, 371);

	}
}
