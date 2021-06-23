import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class PastStudents extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PastStudents frame = new PastStudents();
					frame.setTitle("Past Student details");
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
			ResultSet rs = s.executeQuery("Select fname, lname, mobile, email, cname, aadhar, address, rno, doj, dol from PastStudent");
			while(rs.next()) {
				dtm.addRow(new Object[] {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6), rs.getString(7),rs.getInt(8), rs.getDate(9), rs.getDate(10)});
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public PastStudents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Past Student details");
		setBounds(91, 200, 854, 339);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 181));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 26, 838, 242);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Surname", "Mobile", "Email", "College", "Aadhar", "Address", "Roomno", "DOJ", "DOL"
			}
		));
		table.setFont(new Font("Californian FB", Font.PLAIN, 18));
		table.setBackground(new Color(255, 228, 181));
		table.setRowHeight(30);
		
		tbDetails();
	}

}
