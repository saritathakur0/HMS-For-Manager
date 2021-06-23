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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class UpdateStudent extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t6;
	private JTextField t5;
	private JTextField t;
	JComboBox c, c1;
	Date doj;
	int rno;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateStudent frame = new UpdateStudent();
					frame.setTitle("Update Student");
					frame.setResizable(false);
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
			PreparedStatement pstmt = conn.prepareStatement("select rno from Room where rstatus = ? and booking = ?");
			pstmt.setString(1, "yes");
			pstmt.setString(2, "no");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				c1.addItem(Integer.toString(rs.getInt(1)));
			}
			
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
	
	public UpdateStudent() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Update Student");
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
		c1.setBounds(241, 427, 200, 26);
		contentPane.add(c1);
		
		c = new JComboBox();
		c.setBackground(new Color(255, 255, 255));
		c.setModel(new DefaultComboBoxModel(new String[] {"Room"}));
		c.setFont(new Font("Californian FB", Font.BOLD, 15));
		c.setBounds(353, 12, 88, 26);
		contentPane.add(c);
		
		fetchRooms();
		
		JLabel l1 = new JLabel("First Name");
		l1.setFont(new Font("Californian FB", Font.BOLD, 20));
		l1.setBounds(82, 59, 102, 26);
		contentPane.add(l1);
		
		t1 = new JTextField();
		t1.setColumns(10);
		t1.setBounds(241, 59, 200, 26);
		contentPane.add(t1);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(241, 107, 200, 26);
		contentPane.add(t2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(241, 156, 200, 26);
		contentPane.add(t3);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(241, 204, 200, 26);
		contentPane.add(t4);
		
		t6 = new JTextField();
		t6.setColumns(10);
		t6.setBounds(241, 300, 200, 26);
		contentPane.add(t6);
		
		JTextArea ta1 = new JTextArea();
		ta1.setBounds(241, 346, 200, 60);
		contentPane.add(ta1);
		
		JLabel l7 = new JLabel("Address");
		l7.setFont(new Font("Californian FB", Font.BOLD, 20));
		l7.setBounds(82, 345, 102, 26);
		contentPane.add(l7);
		
		JLabel l6 = new JLabel("Aadhar no.");
		l6.setFont(new Font("Californian FB", Font.BOLD, 20));
		l6.setBounds(82, 300, 102, 26);
		contentPane.add(l6);
		
		JLabel l5 = new JLabel("College Name");
		l5.setFont(new Font("Californian FB", Font.BOLD, 20));
		l5.setBounds(82, 252, 116, 26);
		contentPane.add(l5);
		
		JLabel l4 = new JLabel("Email ID");
		l4.setFont(new Font("Californian FB", Font.BOLD, 20));
		l4.setBounds(82, 204, 102, 26);
		contentPane.add(l4);
		
		JLabel l3 = new JLabel("Mobile no.");
		l3.setFont(new Font("Californian FB", Font.BOLD, 20));
		l3.setBounds(82, 156, 102, 26);
		contentPane.add(l3);
		
		JLabel l2 = new JLabel("Last Name");
		l2.setFont(new Font("Californian FB", Font.BOLD, 20));
		l2.setBounds(82, 107, 102, 26);
		contentPane.add(l2);
		
		JLabel l8 = new JLabel("Room no.");
		l8.setFont(new Font("Californian FB", Font.BOLD, 20));
		l8.setBounds(82, 429, 102, 26);
		contentPane.add(l8);
		
		JButton b1 = new JButton("UPDATE");
		b1.setToolTipText("");
		b1.setFont(new Font("Californian FB", Font.BOLD, 17));
		b1.setBackground(Color.WHITE);
		b1.setBounds(63, 464, 191, 39);
		contentPane.add(b1);
		
		t5 = new JTextField();
		t5.setColumns(10);
		t5.setBounds(241, 252, 200, 26);
		contentPane.add(t5);
		
		t = new JTextField();
		t.setColumns(10);
		t.setBounds(241, 11, 102, 26);
		contentPane.add(t);
		
		JButton b2 = new JButton("Search");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(t.getText().equals(""))
			           JOptionPane.showMessageDialog(null, "Enter Student Name");
				else if(c.getSelectedItem().toString().equals("Select Room"))
			           JOptionPane.showMessageDialog(null, "Select Room");
			    else {
			    	try {
						if(e.getSource() == b2) {
							int i = 0;
							String x = (String)c.getSelectedItem();
							int y = Integer.valueOf(x);
							c1.addItem(Integer.toString(y));
							Class.forName("com.mysql.jdbc.Driver");
							Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS?characterEncoding=utf8","root","root");
							
							PreparedStatement pstmt = conn.prepareStatement("select fname, lname, mobile, email, cname, aadhar, address, rno, doj from Student where fname = ? and rno = ?");
							pstmt.setString(1, t.getText());
							pstmt.setInt(2, y);
							ResultSet rs = pstmt.executeQuery();
							
			                while(rs.next()){
			                	doj = new Date(rs.getDate("doj").getTime());
			                	System.out.println("1st"+doj);
			                	i = 1;
			                	t1.setText(rs.getString(1));
			                	t2.setText(rs.getString(2));
			                	t3.setText(rs.getString(3));
			                	t4.setText(rs.getString(4));
			                	t5.setText(rs.getString(5));
			                	t6.setText(rs.getString(6));
			                	ta1.setText(rs.getString(7));
			                	rno = rs.getInt("rno");
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
		b2.setToolTipText("");
		b2.setFont(new Font("Californian FB", Font.BOLD, 14));
		b2.setBackground(Color.WHITE);
		b2.setBounds(446, 11, 79, 27);
		contentPane.add(b2);
		
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
			    else if(c1.getSelectedItem().toString().equals("Select room"))
			           JOptionPane.showMessageDialog(null, "Select Room no.");
			    else {
			    	try {
						if(e.getSource() == b1) {
							
							Class.forName("com.mysql.jdbc.Driver");
							Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS?characterEncoding=utf8","root","root");
							PreparedStatement pstmt = conn.prepareStatement("update Student set fname=?,lname=?,mobile=?,email=?,cname=?,aadhar=?,address=?,rno=? where fname=? and rno=?");
							pstmt.setString(1, t1.getText());
							pstmt.setString(2, t2.getText());
							pstmt.setString(3, t3.getText());
							pstmt.setString(4, t4.getText());
							pstmt.setString(5, t5.getText());
							pstmt.setString(6, t6.getText());
							pstmt.setString(7, ta1.getText());
							pstmt.setInt(8, Integer.valueOf((String)c1.getSelectedItem()));
							pstmt.setString(9, t.getText());
							pstmt.setInt(10, Integer.valueOf((String)c.getSelectedItem()));
							
			                int cnt = pstmt.executeUpdate();	
			                
			                PreparedStatement pstmt1 = conn.prepareStatement("update Room set booking=? where rno=?");
							pstmt1.setString(1, "yes");
							pstmt1.setInt(2, Integer.parseInt((String) c1.getSelectedItem()));
							pstmt1.executeUpdate();
			                
			                if(cnt==1){
			                	JOptionPane.showMessageDialog(null,"Student Record Updated");
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
			                
			                if( rno != Integer.parseInt((String) c1.getSelectedItem())) {
			                	Class.forName("com.mysql.jdbc.Driver");
								Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS?characterEncoding=utf8","root","root");
								PreparedStatement pstmt11 = conn1.prepareStatement("update Room set booking=? where rno=?");
								pstmt11.setString(1, "no");
								pstmt11.setInt(2, rno);
								pstmt11.executeUpdate();
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
		
		JLabel l = new JLabel("Student Name");
		l.setFont(new Font("Californian FB", Font.BOLD, 20));
		l.setBounds(82, 11, 130, 26);
		contentPane.add(l);
		
		JButton b3 = new JButton("DELETE");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(e.getSource() == b3) {
						int i = 0;
						String x = (String)c.getSelectedItem();
						int y = Integer.valueOf(x);
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS?characterEncoding=utf8","root","root");
						
						PreparedStatement pstmt1 = conn1.prepareStatement("delete from Student where fname = ? and rno = ?");
						pstmt1.setString(1, t.getText());
						pstmt1.setInt(2, y);
						int cnt = pstmt1.executeUpdate();
						
						java.util.Date date = new java.util.Date();
						java.sql.Date sqlDate = new java.sql.Date(date.getTime());
						
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS?characterEncoding=utf8","root","root");
						PreparedStatement pstmt = conn.prepareStatement("insert into PastStudent(fname, lname, mobile, email, cname, aadhar, address, rno, doj, dol) values(?,?,?,?,?,?,?,?,?,?)");
						pstmt.setString(1, t1.getText());
						pstmt.setString(2, t2.getText());
						pstmt.setString(3, t3.getText());
						pstmt.setString(4, t4.getText());
						pstmt.setString(5, t5.getText());
						pstmt.setString(6, t6.getText());
						pstmt.setString(7, ta1.getText());
						pstmt.setString(8, (String)c1.getSelectedItem());
						pstmt.setDate(9, doj);
						pstmt.setDate(10, sqlDate);
		                int cnt1 = pstmt.executeUpdate();
						
		                if(cnt1 == 1){
		                	PreparedStatement pstmt3 = conn1.prepareStatement("update Room set booking=? where rno=?");
		                	pstmt3.setString(1, "no");
		                	pstmt3.setInt(2, y);
		                	pstmt3.executeUpdate();
		                	
		                	i = 1;
		                	JOptionPane.showMessageDialog(null, "Student record deleted");
		                	t1.setText("");
	                		t2.setText("");
	                		t3.setText("");
	                		t4.setText("");
	                		t5.setText("");
	                		t6.setText("");
	                		ta1.setText("");
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
		b3.setBounds(278, 464, 191, 39);
		contentPane.add(b3);
	}
}
