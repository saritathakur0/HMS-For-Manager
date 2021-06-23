import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class AddStudent extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
	private JComboBox c1;
	private JButton b1;
	String s;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudent frame = new AddStudent();
					frame.setTitle("Add Students");
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void fetchRooms() {
		int i = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS?characterEncoding=utf8","root","root");
			PreparedStatement pstmt = conn.prepareStatement("select rno from Room where rstatus = ? and booking = ?");
			pstmt.setString(1, "yes");
			pstmt.setString(2, "no");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				i = 1;
				c1.addItem(Integer.toString(rs.getInt(1)));
			}
			if(i == 0) {
				JOptionPane.showMessageDialog(null, "All rooms are already booked");
				b1.setVisible(false);
				setVisible(false);
			}
		}
		catch(Exception e) {}
	}
	
	public AddStudent() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Add Students");
		setBounds(250, 110, 546, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 181));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		c1 = new JComboBox();
		c1.setModel(new DefaultComboBoxModel(new String[] {"Select room"}));
		c1.setBackground(new Color(255, 255, 255));
		c1.setFont(new Font("Californian FB", Font.BOLD, 15));
		c1.setBounds(244, 419, 200, 26);
		contentPane.add(c1);
		
		fetchRooms();
		
		JLabel l1 = new JLabel("First Name");
		l1.setFont(new Font("Californian FB", Font.BOLD, 20));
		l1.setBounds(85, 17, 102, 26);
		contentPane.add(l1);
		
		t1 = new JTextField();
		t1.setColumns(10);
		t1.setBounds(244, 17, 200, 26);
		contentPane.add(t1);
		
		JLabel l2 = new JLabel("Last Name");
		l2.setFont(new Font("Californian FB", Font.BOLD, 20));
		l2.setBounds(85, 65, 102, 26);
		contentPane.add(l2);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(244, 65, 200, 26);
		contentPane.add(t2);
		
		JLabel l3 = new JLabel("Mobile no.");
		l3.setFont(new Font("Californian FB", Font.BOLD, 20));
		l3.setBounds(85, 114, 102, 26);
		contentPane.add(l3);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(244, 114, 200, 26);
		contentPane.add(t3);
		
		JLabel l4 = new JLabel("Email ID");
		l4.setFont(new Font("Californian FB", Font.BOLD, 20));
		l4.setBounds(85, 162, 102, 26);
		contentPane.add(l4);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(244, 162, 200, 26);
		contentPane.add(t4);
		
		JLabel l5 = new JLabel("College Name");
		l5.setFont(new Font("Californian FB", Font.BOLD, 20));
		l5.setBounds(85, 210, 116, 26);
		contentPane.add(l5);
		
		t5 = new JTextField();
		t5.setColumns(10);
		t5.setBounds(244, 210, 200, 26);
		contentPane.add(t5);
		
		JLabel l6 = new JLabel("Aadhar no.");
		l6.setFont(new Font("Californian FB", Font.BOLD, 20));
		l6.setBounds(85, 258, 102, 26);
		contentPane.add(l6);
		
		t6 = new JTextField();
		t6.setColumns(10);
		t6.setBounds(244, 258, 200, 26);
		contentPane.add(t6);
		
		JLabel l7 = new JLabel("Address");
		l7.setFont(new Font("Californian FB", Font.BOLD, 20));
		l7.setBounds(85, 337, 102, 26);
		contentPane.add(l7);
		
		JTextArea ta1 = new JTextArea();
		ta1.setBounds(244, 338, 200, 60);
		contentPane.add(ta1);
		
		JLabel l8 = new JLabel("Room no.");
		l8.setFont(new Font("Californian FB", Font.BOLD, 20));
		l8.setBounds(85, 421, 102, 26);
		contentPane.add(l8);
		
		
		b1 = new JButton("SAVE");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(t1.getText().equals(""))
			           JOptionPane.showMessageDialog(null, "Enter First Name");
			    else if(t2.getText().equals(""))
			           JOptionPane.showMessageDialog(null, "Enter Last Name");
			    else if(t3.getText().equals(""))
			           JOptionPane.showMessageDialog(null, "Enter Mobile no.");
			    else if(t4.getText().equals(""))
			           JOptionPane.showMessageDialog(null, "Enter Email ID");
			    else if(t5.getText().equals(""))
			           JOptionPane.showMessageDialog(null, "Enter College Name");
			    else if(t6.getText().equals(""))
			           JOptionPane.showMessageDialog(null, "Enter Aadhar no.");
			    else if(ta1.getText().equals(""))
			           JOptionPane.showMessageDialog(null, "Enter Address");
			    else if(c1.getSelectedItem().toString().equals("Select Room"))
			           JOptionPane.showMessageDialog(null, "Select Room no.");
			    else {
			    	try {
						if(e.getSource() == b1) {
							
							java.util.Date date = new java.util.Date();
							java.sql.Date sqlDate = new java.sql.Date(date.getTime());
							
							Class.forName("com.mysql.jdbc.Driver");
							Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS?characterEncoding=utf8","root","root");
							PreparedStatement pstmt = conn.prepareStatement("insert into Student(fname, lname, mobile, email, cname, aadhar, image, address, rno, doj) values(?,?,?,?,?,?,?,?,?,?)");
							InputStream is = new FileInputStream(new File(s));
							pstmt.setString(1, t1.getText());
							pstmt.setString(2, t2.getText());
							pstmt.setString(3, t3.getText());
							//pstmt.setInt(3, Integer.valueOf(t3.getText()));
							pstmt.setString(4, t4.getText());
							pstmt.setString(5, t5.getText());
							pstmt.setString(6, t6.getText());
							//pstmt.setInt(6, Integer.valueOf(t6.getText()));
							pstmt.setBlob(7, is);
							pstmt.setString(8, ta1.getText());
							pstmt.setString(9, (String)c1.getSelectedItem());
							pstmt.setDate(10, sqlDate);
			                int cnt = pstmt.executeUpdate();				                
			                
			                if(cnt==1){
			                	PreparedStatement pstmt2 = conn.prepareStatement("update Room set booking = ? where rno = ?");
								pstmt2.setString(1, "yes");
								pstmt2.setInt(2, Integer.valueOf((String) c1.getSelectedItem()));
								pstmt2.executeUpdate();
								
			                	JOptionPane.showMessageDialog(null,"Student Added");
			                	t1.setText("");
		                		t2.setText("");
		                		t3.setText("");
		                		t4.setText("");
		                		t5.setText("");
		                		t6.setText("");
		                		ta1.setText("");
			                }
			                else
			                    JOptionPane.showMessageDialog(null,"Some Issue Occured");
						}
					}
					catch(Exception e1) {
						System.out.println("ERROR "+e1);
						System.out.println("ERROR "+e);
					}
			    }
			}
		});
		b1.setToolTipText("");
		b1.setFont(new Font("Californian FB", Font.BOLD, 17));
		b1.setBackground(Color.WHITE);
		b1.setBounds(206, 471, 157, 39);
		contentPane.add(b1);
		
		JButton file = new JButton("Upload aadhar               ");
		file.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "png", "jpeg");
				fc.addChoosableFileFilter(filter);
				int r = fc.showSaveDialog(null); 
	            if (r == JFileChooser.APPROVE_OPTION){
	            	file.setText("Uploaded");
	            	File selectedFile = fc.getSelectedFile();
	            	String path = selectedFile.getAbsolutePath();
	            	s = path;
	            }
			}
		});
		file.setToolTipText("");
		file.setFont(new Font("Californian FB", Font.BOLD, 17));
		file.setBackground(Color.WHITE);
		file.setBounds(244, 297, 200, 26);
		contentPane.add(file);
	}
}
