package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Label;
import java.awt.Font;

public class SaidaUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	public static int CL500 = 1;
	public static int CL1000 = 2;
	public static int CL5000 = 3;
	public static int CL10000 = 4;
	public static int CL50000 = 5;
	
	public static int ROWQUICK = 0;
	public static int ROWHEAP = 1;
	public static int ROWABB = 2;
	public static int ROWAVL = 3;
	public static int ROWHASING =4;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 300, 614, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(4, 105, 588, 107);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(new String[] { "", "500", "1000", "5000", "10000", "50000" },5));
		table.setValueAt("Quick", 0, 0);
		table.setValueAt("Heap", 1, 0);
		table.setValueAt("ABB", 2, 0);
		table.setValueAt("AVL", 3, 0);
		table.setValueAt("Hashing", 4, 0);
		
		
		table.setAutoCreateRowSorter(true);
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		
		Label label = new Label("Tempo gasto por Metodo X Quantidade de Registro");
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Dialog", Font.PLAIN, 16));
		label.setBounds(6, 73, 584, 22);
		contentPane.add(label);
	}

	public JTable getTable() {
		return table;
	}

}
