import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JScrollPane;

public class PastEmployees extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PastEmployees frame = new PastEmployees();
					frame.setTitle("Past Employee details");
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void tbDetails() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS?characterEncoding=utf8","root","root");
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("Select fname, lname, mobile, email, aadhar, address, job, gender, doj, dor from PastEmployees");
			while(rs.next()) {
				dtm.addRow(new Object[] {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8), rs.getDate(9), rs.getDate(10)});
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public PastEmployees() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Past Employee details");
		setBounds(91, 200, 854, 339);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 181));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 27, 838, 242);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setEnabled(false);
		table.setBackground(new Color(255, 228, 181));
		table.setFont(new Font("Californian FB", Font.PLAIN, 18));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Name", "Surname", "Mobile", "Email", "Aadhar", "Address", "Job", "Gender", "DOJ", "DOR"
			}
		));
		table.setRowHeight(30);
		
		tbDetails();
	}
}
