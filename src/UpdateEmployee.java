import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class UpdateEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t;
	Date doj;
	private JTextField t6;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateEmployee frame = new UpdateEmployee();
					frame.setTitle("Update/Delete Employee");
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UpdateEmployee() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Update/Delete Employee");
		setBounds(250, 110, 546, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 181));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("First Name");
		l1.setFont(new Font("Californian FB", Font.BOLD, 20));
		l1.setBounds(87, 81, 102, 26);
		contentPane.add(l1);
		
		t1 = new JTextField();
		t1.setColumns(10);
		t1.setBounds(246, 81, 200, 26);
		contentPane.add(t1);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(246, 129, 200, 26);
		contentPane.add(t2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(246, 178, 200, 26);
		contentPane.add(t3);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(246, 226, 200, 26);
		contentPane.add(t4);
		
		JTextArea ta1 = new JTextArea();
		ta1.setBounds(246, 318, 200, 60);
		contentPane.add(ta1);
		
		t5 = new JTextField();
		t5.setColumns(10);
		t5.setBounds(246, 272, 200, 26);
		contentPane.add(t5);
		
		t6 = new JTextField();
		t6.setColumns(10);
		t6.setBounds(246, 404, 200, 26);
		contentPane.add(t6);
		
		JLabel l6 = new JLabel("Address");
		l6.setFont(new Font("Californian FB", Font.BOLD, 20));
		l6.setBounds(87, 317, 102, 26);
		contentPane.add(l6);
		
		JLabel l5 = new JLabel("Aadhar no.");
		l5.setFont(new Font("Californian FB", Font.BOLD, 20));
		l5.setBounds(87, 272, 102, 26);
		contentPane.add(l5);
		
		JLabel l4 = new JLabel("Email ID");
		l4.setFont(new Font("Californian FB", Font.BOLD, 20));
		l4.setBounds(87, 226, 102, 26);
		contentPane.add(l4);
		
		JLabel l3 = new JLabel("Mobile no.");
		l3.setFont(new Font("Californian FB", Font.BOLD, 20));
		l3.setBounds(87, 178, 102, 26);
		contentPane.add(l3);
		
		JLabel l2 = new JLabel("Last Name");
		l2.setFont(new Font("Californian FB", Font.BOLD, 20));
		l2.setBounds(87, 129, 102, 26);
		contentPane.add(l2);
		
		JLabel l7 = new JLabel("Assigned Job");
		l7.setFont(new Font("Californian FB", Font.BOLD, 20));
		l7.setBounds(87, 407, 114, 26);
		contentPane.add(l7);
		
		JLabel l8 = new JLabel("Optional");
		l8.setFont(new Font("Californian FB", Font.PLAIN, 15));
		l8.setBounds(459, 225, 71, 26);
		contentPane.add(l8);
		
		JLabel l = new JLabel("Employee Name");
		l.setFont(new Font("Californian FB", Font.BOLD, 20));
		l.setBounds(87, 29, 149, 26);
		contentPane.add(l);
		
		t = new JTextField();
		t.setColumns(10);
		t.setBounds(246, 29, 102, 26);
		contentPane.add(t);
		
		JComboBox c = new JComboBox();
		c.setModel(new DefaultComboBoxModel(new String[] {"Job", "Warden", "Cook", "Cleaner", "Guard"}));
		c.setFont(new Font("Californian FB", Font.BOLD, 15));
		c.setBackground(Color.WHITE);
		c.setBounds(358, 30, 88, 26);
		contentPane.add(c);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Californian FB", Font.BOLD, 20));
		lblGender.setBounds(87, 444, 102, 26);
		contentPane.add(lblGender);
		
		JRadioButton r1 = new JRadioButton("male");
		r1.setFont(new Font("Californian FB", Font.BOLD, 20));
		r1.setBackground(new Color(255, 228, 181));
		r1.setBounds(246, 447, 84, 23);
		contentPane.add(r1);
		
		JRadioButton r2 = new JRadioButton("female");
		r2.setFont(new Font("Californian FB", Font.BOLD, 20));
		r2.setBackground(new Color(255, 228, 181));
		r2.setBounds(349, 446, 97, 23);
		contentPane.add(r2);
		
		ButtonGroup G = new ButtonGroup();
		G.add(r1);
		G.add(r2);
		
		JButton b2 = new JButton("Search");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == b2) {
					if(t.getText().equals(""))
				           JOptionPane.showMessageDialog(null, "Enter Employee Name");
					else if(c.getSelectedItem().toString().equals("Select Job"))
				           JOptionPane.showMessageDialog(null, "Select job");
				    else {
				    	try {
							if(e.getSource() == b2) {
								int i = 0;
								Class.forName("com.mysql.jdbc.Driver");
								Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS?characterEncoding=utf8","root","root");
								
								PreparedStatement pstmt = conn.prepareStatement("select fname, lname, mobile, email, aadhar, address, job, gender, doj from Employees where fname = ? and job = ?");
								pstmt.setString(1, t.getText());
								pstmt.setString(2, (String)c.getSelectedItem());
								
								ResultSet rs = pstmt.executeQuery();
								
				                while(rs.next()){
				                	i = 1;
				                	doj = new Date(rs.getDate("doj").getTime());
				                	t1.setText(rs.getString(1));
				                	t2.setText(rs.getString(2));
				                	t3.setText(rs.getString(3));
				                	t4.setText(rs.getString(4));
				                	t5.setText(rs.getString(5));
				                	ta1.setText(rs.getString(6));
				                	t6.setText((String)c.getSelectedItem());
				                	
			                		if(rs.getString(8).equals("male")) {
			                			r1.setSelected(true);
			                		}
			                		else {
			                			r2.setSelected(true);
			                		}
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
			}
		});
		b2.setToolTipText("");
		b2.setFont(new Font("Californian FB", Font.BOLD, 14));
		b2.setBackground(Color.WHITE);
		b2.setBounds(451, 29, 79, 27);
		contentPane.add(b2);
		
		JButton b3 = new JButton("DELETE");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(e.getSource() == b3) {
						int i = 0;
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS?characterEncoding=utf8","root","root");
						
						PreparedStatement pstmt1 = conn1.prepareStatement("delete from Employees where fname = ? and job = ?");
						pstmt1.setString(1, t.getText());
						pstmt1.setString(2, (String)c.getSelectedItem());
						pstmt1.executeUpdate();
						
						java.util.Date date = new java.util.Date();
						java.sql.Date sqlDate = new java.sql.Date(date.getTime());
						
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS?characterEncoding=utf8","root","root");
						PreparedStatement pstmt = conn.prepareStatement("insert into PastEmployees(fname, lname, mobile, email, aadhar, address, job, gender, doj, dor) values(?,?,?,?,?,?,?,?,?,?)");
						pstmt.setString(1, t1.getText());
						pstmt.setString(2, t2.getText());
						pstmt.setString(3, t3.getText());
						pstmt.setString(4, t4.getText());
						pstmt.setString(5, t5.getText());
						pstmt.setString(6, ta1.getText());
						pstmt.setString(7, t6.getText());
						pstmt.setString(8, r1.isSelected()==true ? "male" : "female" );
						pstmt.setDate(9, doj);
						pstmt.setDate(10, sqlDate);
						int cnt = pstmt.executeUpdate();
						
		                if(cnt == 1){
		                	i = 1;
		                	JOptionPane.showMessageDialog(null, "Employee deleted");
		                	t1.setText("");
	                		t2.setText("");
	                		t3.setText("");
	                		t4.setText("");
	                		t5.setText("");
	                		ta1.setText("");
	                		t6.setText("");
	                		G.clearSelection();
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
		});
		b3.setToolTipText("");
		b3.setFont(new Font("Californian FB", Font.BOLD, 17));
		b3.setBackground(Color.WHITE);
		b3.setBounds(296, 472, 187, 39);
		contentPane.add(b3);
		
		JButton b1 = new JButton("UPDATE");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(t1.getText().equals(""))
			           JOptionPane.showMessageDialog(null, "Enter First Name");
			    else if(t2.getText().equals(""))
			           JOptionPane.showMessageDialog(null, "Enter Last Name");
			    else if(t3.getText().equals(""))
			           JOptionPane.showMessageDialog(null, "Enter Mobile no.");
			    else if(t5.getText().equals(""))
			           JOptionPane.showMessageDialog(null, "Enter Aadhar no.");
			    else if(ta1.getText().equals(""))
			           JOptionPane.showMessageDialog(null, "Enter Address");
			    else if(t6.getText().equals(""))
			           JOptionPane.showMessageDialog(null, "Enter Job");
			    else if(r1.isSelected()==false && r2.isSelected()==false)
			           JOptionPane.showMessageDialog(null, "Select Gender");
			    else {
			    	try {
						if(e.getSource() == b1) {
							
							Class.forName("com.mysql.jdbc.Driver");
							Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS?characterEncoding=utf8","root","root");
							PreparedStatement pstmt = conn.prepareStatement("update Employees set fname=?,lname=?,mobile=?,email=?,aadhar=?,address=?,job=?,gender=? where fname=? and job=?");
							pstmt.setString(1, t1.getText());
							pstmt.setString(2, t2.getText());
							pstmt.setString(3, t3.getText());
							pstmt.setString(4, t4.getText());
							pstmt.setString(5, t5.getText());
							pstmt.setString(6, ta1.getText());
							pstmt.setString(7, t6.getText());
							pstmt.setString(8, r1.isSelected()==true ? "male" : "female" );
							pstmt.setString(9, t.getText());
							pstmt.setString(10, (String)c.getSelectedItem());
			                int cnt = pstmt.executeUpdate();				                
			                
			                if(cnt==1){
			                	JOptionPane.showMessageDialog(null,"Employee Record Updated");
			                	t1.setText("");
		                		t2.setText("");
		                		t3.setText("");
		                		t4.setText("");
		                		t5.setText("");
		                		ta1.setText("");
		                		G.clearSelection();
			                }
			                else
			                    JOptionPane.showMessageDialog(null,"Record not found");
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
		b1.setBounds(71, 472, 187, 39);
		contentPane.add(b1);
		
		
	}
}
