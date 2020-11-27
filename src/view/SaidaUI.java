package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SaidaUI extends JFrame {

	private JPanel contentPane;
	private JTable tableAle;
	private JTable tableOrd;
	private JTable tableInv;

	public static int CL500 = 1;
	public static int CL1000 = 2;
	public static int CL5000 = 3;
	public static int CL10000 = 4;
	public static int CL50000 = 5;

	public static int ROWQUICK = 0;
	public static int ROWHEAP = 1;
	public static int ROWABB = 2;
	public static int ROWAVL = 3;
	public static int ROWHASING = 4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaidaUI frame = new SaidaUI();
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
	public SaidaUI() {
		setTitle("Tempo gasto por Metodo X Quantidade de Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 300, 623, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//grid dos Metodos
		
		// aleatorio
		JScrollPane scrollPaneAle = new JScrollPane();
		scrolPanel(scrollPaneAle, 4, 56);

		tableAle = new JTable();
		tableAle.setModel(defaultTable());
		criaColunas(tableAle);
		tableAle.setAutoCreateRowSorter(true);
		tableAle.setBackground(Color.WHITE);
		scrollPaneAle.setViewportView(tableAle);

		// ordenado
		JScrollPane scrollPaneOrd = new JScrollPane();
		scrolPanel(scrollPaneOrd, 4, 190);

		tableOrd = new JTable();
		tableOrd.setModel(defaultTable());
		criaColunas(tableOrd);
		tableOrd.setAutoCreateRowSorter(true);
		tableOrd.setBackground(Color.WHITE);
		scrollPaneOrd.setViewportView(tableOrd);

		// inversamente
		JScrollPane scrollPaneInv = new JScrollPane();
		scrolPanel(scrollPaneInv, 4, 325);

		tableInv = new JTable();
		tableInv.setModel(defaultTable());
		criaColunas(tableInv);
		tableInv.setAutoCreateRowSorter(true);
		tableInv.setBackground(Color.WHITE);
		scrollPaneInv.setViewportView(tableInv);

		JLabel lblAleatorio = new JLabel("Aleátorio");
		lblAleatorio.setBounds(14, 38, 145, 14);
		contentPane.add(lblAleatorio);

		JLabel lblOrdenado = new JLabel("Ordenado");
		lblOrdenado.setBounds(14, 174, 145, 14);
		contentPane.add(lblOrdenado);

		JLabel lblNewLabel = new JLabel("Inversamente");
		lblNewLabel.setBounds(14, 311, 110, 14);
		contentPane.add(lblNewLabel);
		
		JSeparator separatorOrd = new JSeparator();
		separatorOrd.setBounds(79, 181, 522, 27);
		contentPane.add(separatorOrd);
		
		JSeparator separatorInv = new JSeparator();
		separatorInv.setBounds(95, 318, 506, 27);
		contentPane.add(separatorInv);
		
		JSeparator separatorInv_1 = new JSeparator();
		separatorInv_1.setBounds(70, 45, 531, 2);
		contentPane.add(separatorInv_1);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(event ->{
			hide();
			
			HomeUI homeUI = new HomeUI();
			homeUI.show();
		});
		btnVoltar.setBounds(503, 11, 89, 23);
		contentPane.add(btnVoltar);
	}

	private void criaColunas(JTable table) {
		table.setValueAt("Quick", 0, 0);
		table.setValueAt("Heap", 1, 0);
		table.setValueAt("ABB", 2, 0);
		table.setValueAt("AVL", 3, 0);
		table.setValueAt("Hashing", 4, 0);

	}

	private DefaultTableModel defaultTable() {
		return new DefaultTableModel(new String[] { "", "500", "1000", "5000", "10000", "50000" }, 5);
	}

	private void scrolPanel(JScrollPane scrollPane, int x, int y) {
		scrollPane.setBounds(x, y, 588, 107);
		contentPane.add(scrollPane);

	}

	public JTable getTableAle() {
		return tableAle;
	}

	public JTable getTableOrd() {
		return tableOrd;
	}

	public JTable getTableInv() {
		return tableInv;
	}
}
