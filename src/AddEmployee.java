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
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class AddEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	String s;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmployee frame = new AddEmployee();
					frame.setTitle("Add Employee");
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AddEmployee() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Add Employee");
		setBounds(250, 110, 546, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 181));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("First Name");
		l1.setFont(new Font("Californian FB", Font.BOLD, 20));
		l1.setBounds(87, 11, 102, 26);
		contentPane.add(l1);
		
		t1 = new JTextField();
		t1.setColumns(10);
		t1.setBounds(246, 11, 200, 26);
		contentPane.add(t1);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(246, 59, 200, 26);
		contentPane.add(t2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(246, 108, 200, 26);
		contentPane.add(t3);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(246, 156, 200, 26);
		contentPane.add(t4);
		
		JTextArea ta1 = new JTextArea();
		ta1.setBounds(246, 294, 200, 60);
		contentPane.add(ta1);
		
		t5 = new JTextField();
		t5.setColumns(10);
		t5.setBounds(246, 202, 200, 26);
		contentPane.add(t5);
		
		JLabel l6 = new JLabel("Address");
		l6.setFont(new Font("Californian FB", Font.BOLD, 20));
		l6.setBounds(87, 293, 102, 26);
		contentPane.add(l6);
		
		JLabel l5 = new JLabel("Aadhar no.");
		l5.setFont(new Font("Californian FB", Font.BOLD, 20));
		l5.setBounds(87, 202, 102, 26);
		contentPane.add(l5);
		
		JLabel l4 = new JLabel("Email ID");
		l4.setFont(new Font("Californian FB", Font.BOLD, 20));
		l4.setBounds(87, 156, 102, 26);
		contentPane.add(l4);
		
		JLabel l3 = new JLabel("Mobile no.");
		l3.setFont(new Font("Californian FB", Font.BOLD, 20));
		l3.setBounds(87, 108, 102, 26);
		contentPane.add(l3);
		
		JLabel l2 = new JLabel("Last Name");
		l2.setFont(new Font("Californian FB", Font.BOLD, 20));
		l2.setBounds(87, 59, 102, 26);
		contentPane.add(l2);
		
		JLabel l7 = new JLabel("Assigned Job");
		l7.setFont(new Font("Californian FB", Font.BOLD, 20));
		l7.setBounds(87, 377, 114, 26);
		contentPane.add(l7);
		
		JComboBox c1 = new JComboBox();
		c1.setModel(new DefaultComboBoxModel(new String[] {"Select Job", "Warden", "Cook", "Cleaner", "Guard"}));
		c1.setFont(new Font("Californian FB", Font.BOLD, 15));
		c1.setBackground(Color.WHITE);
		c1.setBounds(246, 375, 200, 26);
		contentPane.add(c1);
		
		JLabel l8 = new JLabel("Optional");
		l8.setFont(new Font("Californian FB", Font.PLAIN, 15));
		l8.setBounds(459, 155, 71, 26);
		contentPane.add(l8);
		
		JLabel l9 = new JLabel("Gender");
		l9.setFont(new Font("Californian FB", Font.BOLD, 20));
		l9.setBounds(87, 425, 102, 26);
		contentPane.add(l9);
		
		JRadioButton r1 = new JRadioButton("male");
		r1.setFont(new Font("Californian FB", Font.BOLD, 20));
		r1.setBackground(new Color(255, 228, 181));
		r1.setBounds(246, 428, 84, 23);
		contentPane.add(r1);
		
		JRadioButton r2 = new JRadioButton("female");
		r2.setFont(new Font("Californian FB", Font.BOLD, 20));
		r2.setBackground(new Color(255, 228, 181));
		r2.setBounds(349, 427, 97, 23);
		contentPane.add(r2);
		
		ButtonGroup G = new ButtonGroup();
		G.add(r1);
		G.add(r2);
		
		JButton b1 = new JButton("SAVE");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(t1.getText().equals(""))
			           JOptionPane.showMessageDialog(null, "Enter First Name");
			    else if(t2.getText().equals(""))
			           JOptionPane.showMessageDialog(null, "Enter Last Name");
			    else if(t3.getText().equals(""))
			           JOptionPane.showMessageDialog(null, "Enter Mobile no.");
			    else if(t5.getText().equals(""))
			           JOptionPane.showMessageDialog(null, "Enter College Name");
			    else if(ta1.getText().equals(""))
			           JOptionPane.showMessageDialog(null, "Enter Address");
			    else if(c1.getSelectedItem().toString().equals("Select Room"))
			           JOptionPane.showMessageDialog(null, "Select Job");
			    else if(r1.isSelected()==false && r2.isSelected()==false)
			           JOptionPane.showMessageDialog(null, "Select Gender");
			    else {
			    	try {
						if(e.getSource() == b1) {
							
							java.util.Date date = new java.util.Date();
							java.sql.Date sqlDate = new java.sql.Date(date.getTime());
							
							Class.forName("com.mysql.jdbc.Driver");
							Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS?characterEncoding=utf8","root","root");
							PreparedStatement pstmt = conn.prepareStatement("insert into Employees(fname, lname, mobile, email, aadhar, image, address, job, gender, doj) values(?,?,?,?,?,?,?,?,?,?)");
							InputStream is = new FileInputStream(new File(s));
							pstmt.setString(1, t1.getText());
							pstmt.setString(2, t2.getText());
							pstmt.setString(3, t3.getText());
							//pstmt.setInt(3, Integer.valueOf(t3.getText()));
							pstmt.setString(4, t4.getText());
							pstmt.setString(5, t5.getText());
							pstmt.setBlob(6, is);
							pstmt.setString(7, ta1.getText());
							pstmt.setString(8, (String)c1.getSelectedItem());
							pstmt.setString(9, r1.isSelected()==true ? "male" : "female" );
							pstmt.setDate(10, sqlDate);
			                int cnt = pstmt.executeUpdate();				                
			                
			                if(cnt==1){
			                	JOptionPane.showMessageDialog(null,"Employee Added");
			                	t1.setText("");
		                		t2.setText("");
		                		t3.setText("");
		                		t4.setText("");
		                		t5.setText("");
		                		ta1.setText("");
		                		G.clearSelection();
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
		b1.setBounds(201, 472, 157, 39);
		contentPane.add(b1);
		
		JButton file = new JButton("Upload aadhar            ");
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
		file.setBounds(246, 247, 200, 26);
		contentPane.add(file);	
	}
}
