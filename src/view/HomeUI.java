package view;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import controllers.Main;
import utils.InOutCronometro;
import utils.InOutInterface;


public class HomeUI extends JFrame {

	private String tamanhoArquivo;
	private String metodo;
	private static Main main;
	static InOutCronometro cronometro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeUI frame = new HomeUI();
					main = new Main();
					cronometro = new InOutCronometro();

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

		JLabel lblmetodo = new JLabel("Método");
		lblmetodo.setBounds(43, 49, 46, 14);
		getContentPane().add(lblmetodo);

		JLabel lblTamanhoDoArquivo = new JLabel("Tamanho do Arquivo");
		lblTamanhoDoArquivo.setBounds(43, 107, 117, 14);
		getContentPane().add(lblTamanhoDoArquivo);

		JButton btnInciar = new JButton("Start");
		btnInciar.addActionListener(event -> {
			cronometro.limpaArquivo();
			main.main(metodo, tamanhoArquivo);
			InOutInterface.outputInformacao("Fim da execusão", "Concluído");
			hide();

			SaidaUI saidaUI = new SaidaUI();
			povoaTabela(saidaUI);
			saidaUI.show();
		});

		btnInciar.setBounds(170, 159, 160, 32);
		getContentPane().add(btnInciar);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 300, 386, 320);

	}

	private void povoaTabela(SaidaUI saidaUI) {
		List<String[]> tempos = cronometro.leitorTempo();

		for (String[] strings : tempos) {
			JTable table = null;

			switch (strings[2]) {
			case "alea":
				table = saidaUI.getTableAle();
				break;
			case "ord":
				table = saidaUI.getTableOrd();
				break;
			case "inv":
				table = saidaUI.getTableInv();
				break;

			default:
				break;
			}

			encontraLinha(strings, saidaUI, table);

		}

	}

	private void encontraLinha(String[] strings, SaidaUI saidaUI, JTable table) {
		switch (strings[0]) {
		case "Quick":
			entrocaTamanho(strings, saidaUI.ROWQUICK, saidaUI, table);
			break;
		case "Heap":
			entrocaTamanho(strings, saidaUI.ROWHEAP, saidaUI, table);
			break;

		default:
			break;
		}

	}

	private void entrocaTamanho(String[] strings, int linha, SaidaUI saidaUI, JTable table) {
		switch (strings[1]) {
		case "500":
			table.setValueAt(strings[3], linha, saidaUI.CL500);
			break;
		case "1000":
			table.setValueAt(strings[3], linha, saidaUI.CL1000);
			break;
		case "5000":
			table.setValueAt(strings[3], linha, saidaUI.CL5000);
			break;
		case "10000":
			table.setValueAt(strings[3], linha, saidaUI.CL10000);
			break;
		case "50000":
			table.setValueAt(strings[3], linha, saidaUI.CL50000);
			break;

		default:
			break;
		}

	}

}
