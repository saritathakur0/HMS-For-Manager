import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class LivingStudents extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField t;
	private JComboBox c;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LivingStudents frame = new LivingStudents();
					frame.setTitle("Students details");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void fetchRooms() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS?characterEncoding=utf8","root","root");
			
			PreparedStatement pstmt1 = conn.prepareStatement("select rno from Room where rstatus = ? and booking = ?");
			pstmt1.setString(1, "yes");
			pstmt1.setString(2, "yes");
			ResultSet rs1 = pstmt1.executeQuery();
			
			while(rs1.next()) {
				c.addItem(Integer.toString(rs1.getInt(1)));
			}
		}
		catch(Exception e) {}
	}
	
	public void tbDetails() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS?characterEncoding=utf8","root","root");
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("Select fname, lname, mobile, email, cname, aadhar, address, rno, doj from Student");
			while(rs.next()) {
				dtm.addRow(new Object[] {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6), rs.getString(7),rs.getInt(8), rs.getDate(9)});
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public LivingStudents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Students details");
		setBounds(91, 200, 854, 400);
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
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Surname", "Mobile", "Email", "College", "Aadhar", "Address", "Roomno", "DOJ"
			}
		));
		table.setFont(new Font("Californian FB", Font.PLAIN, 18));
		table.setBackground(new Color(255, 228, 181));
		table.setRowHeight(30);
		
		JLabel l = new JLabel("Student Name");
		l.setFont(new Font("Californian FB", Font.BOLD, 20));
		l.setBounds(163, 305, 130, 26);
		contentPane.add(l);
		
		t = new JTextField();
		t.setColumns(10);
		t.setBounds(322, 305, 102, 26);
		contentPane.add(t);
		
		c = new JComboBox();
		c.setModel(new DefaultComboBoxModel(new String[] {"Room"}));
		c.setFont(new Font("Californian FB", Font.BOLD, 15));
		c.setBackground(Color.WHITE);
		c.setBounds(434, 306, 88, 26);
		contentPane.add(c);
		
		fetchRooms();
		
		JButton b = new JButton("View Aadhar");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(t.getText().equals(""))
			           JOptionPane.showMessageDialog(null, "Enter Student Name");
				else if(c.getSelectedItem().toString().equals("Select Room"))
			           JOptionPane.showMessageDialog(null, "Select Room");
			    else {
			    	try {
						if(e.getSource() == b) {
							int i = 0;
							String x = (String)c.getSelectedItem();
							int y = Integer.valueOf(x);
							c.addItem(Integer.toString(y));
							Class.forName("com.mysql.jdbc.Driver");
							Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS?characterEncoding=utf8","root","root");
							
							PreparedStatement pstmt = conn.prepareStatement("select image from Student where fname = ? and rno = ?");
							pstmt.setString(1, t.getText());
							pstmt.setInt(2, y);
							ResultSet rs = pstmt.executeQuery();
							
			                while(rs.next()){
			                	i = 1;
			                	byte[] img = rs.getBytes("image");
								ImageIcon image = new ImageIcon(img);
								Image im = image.getImage();
								Image myImg = im.getScaledInstance(546, 550, Image.SCALE_SMOOTH);
								ImageIcon newImage = new ImageIcon(myImg);
								
								ViewAadhar h = new ViewAadhar();
								h.aadhar(newImage);
				                h.setVisible(true);
			                }
			                
			                if(i == 0) {
			                	JOptionPane.showMessageDialog(null, "Record not found");
			                }
						}
					}
					catch(Exception e1) {
						System.out.println("ERROR "+e1);
						System.out.println("ERROR "+e);
					}
			    }
			}
		});
		b.setToolTipText("");
		b.setFont(new Font("Californian FB", Font.BOLD, 15));
		b.setBackground(Color.WHITE);
		b.setBounds(527, 305, 130, 27);
		contentPane.add(b);
		
		tbDetails();
	}
}
