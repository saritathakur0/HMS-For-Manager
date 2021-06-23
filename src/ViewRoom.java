import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class ViewRoom extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewRoom frame = new ViewRoom();
					frame.setTitle("All Rooms");
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
			ResultSet rs = s.executeQuery("Select * from Room");
			while(rs.next()) {
				dtm.addRow(new Object[] {rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4)});
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public ViewRoom() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("All Rooms");
		setBounds(250, 110, 546, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 181));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 33, 510, 320);
		scrollPane.setFont(new Font("Californian FB", Font.PLAIN, 18));
		scrollPane.setBackground(new Color(255, 228, 181));
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setFont(new Font("Californian FB", Font.PLAIN, 18));
		table.setBackground(new Color(255, 228, 181));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Room no.", "Floor no.", "Activate", "Booked"
			}
		));
		table.setRowHeight(30);
		
		tbDetails();
	}

}
