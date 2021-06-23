import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Formatter;
import java.awt.event.ActionEvent;

public class EmployeePayment extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t4;
	private JTextField t;
	private JTextField t5;
	private JTextField t3;
	private JTable table;
	int val = 0;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeePayment frame = new EmployeePayment();
					frame.setTitle("Pay Employee");
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
			
			PreparedStatement pstmt = conn.prepareStatement("select eid from Employees where fname = ? and job = ?");
			pstmt.setString(1, t1.getText());
			pstmt.setString(2, t3.getText());
			ResultSet rs = pstmt.executeQuery();
			int eid = 0;
			while(rs.next()) {
				eid = rs.getInt("eid");
			}
			
			PreparedStatement pstmt1 = conn.prepareStatement("select month, amount, paidon from EmployeePayment where eid = ?");
			pstmt1.setInt(1, eid);
			ResultSet rs1 = pstmt1.executeQuery();
			
			while(rs1.next()) {
				dtm.addRow(new Object[] {rs1.getString(1),rs1.getString(2), rs1.getDate(3)});
			}
		}
		catch(Exception e) {
			System.out.println("tb"+e);
		}
	}

	public EmployeePayment() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Pay Employee");
		setBounds(250, 110, 546, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 181));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 385, 436, 115);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Month", "Fees", "Paid on"
			}
		));
		table.setFont(new Font("Californian FB", Font.PLAIN, 18));
		table.setBackground(new Color(255, 228, 181));
		table.setRowHeight(30);
		
		JComboBox c = new JComboBox();
		c.setModel(new DefaultComboBoxModel(new String[] {"Job", "Warden", "Cook", "Cleaner", "Guard"}));
		c.setFont(new Font("Californian FB", Font.BOLD, 15));
		c.setBackground(Color.WHITE);
		c.setBounds(348, 33, 88, 26);
		contentPane.add(c);
		
		JLabel l1 = new JLabel("First Name");
		l1.setFont(new Font("Californian FB", Font.BOLD, 20));
		l1.setBounds(58, 80, 102, 26);
		contentPane.add(l1);
		
		t1 = new JTextField();
		t1.setEditable(false);
		t1.setColumns(10);
		t1.setBounds(236, 80, 200, 26);
		contentPane.add(t1);
		
		t2 = new JTextField();
		t2.setEditable(false);
		t2.setColumns(10);
		t2.setBounds(236, 127, 200, 26);
		contentPane.add(t2);
		
		JLabel l5 = new JLabel("Month");
		l5.setFont(new Font("Californian FB", Font.BOLD, 20));
		l5.setBounds(58, 223, 116, 26);
		contentPane.add(l5);
		
		JLabel l3 = new JLabel("Mobile no.");
		l3.setFont(new Font("Californian FB", Font.BOLD, 20));
		l3.setBounds(58, 127, 102, 26);
		contentPane.add(l3);
		
		Formatter fmt = new Formatter();
		Calendar cal = Calendar.getInstance();
		fmt = new Formatter();
		fmt.format("%tB", cal);
		String month = fmt.toString();
		
		JButton b1 = new JButton("PAY");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(e.getSource() == b1) {
						
						java.util.Date date = new java.util.Date();
						java.sql.Date sqlDate = new java.sql.Date(date.getTime());
						
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS?characterEncoding=utf8","root","root");
						
						PreparedStatement pstmt = conn.prepareStatement("select eid from Employees where fname = ? and job = ?");
						pstmt.setString(1, t1.getText());
						pstmt.setString(2, t3.getText());
						ResultSet rs = pstmt.executeQuery();
						int eid = 0;
						while(rs.next()) {
							eid = rs.getInt("eid");
						}
						
						PreparedStatement pstmt2 = conn.prepareStatement("select month from EmployeePayment where eid = ?");
						pstmt2.setInt(1, eid);
						ResultSet rs2 = pstmt2.executeQuery();
						
						int x = 0;
						while(rs2.next()) {
							System.out.println(rs2.getString("month"));
							if(month.equals(rs2.getString("month"))) {
								System.out.println("bb");
								x = 1;
							}
						}
						
						if(x == 1) {
							JOptionPane.showMessageDialog(null,"Already paid for this month");
							t.setText("");
		                	t1.setText("");
	                		t2.setText("");
	                		t3.setText("");
	                		t4.setText("");
	                		t5.setText("");
						}
						else {
							PreparedStatement pstmt1 = conn.prepareStatement("insert into EmployeePayment(eid, month, amount, paidon) values(?, ?,?,?)");
							pstmt1.setInt(1, eid);
							pstmt1.setString(2, month);
							pstmt1.setInt(3, val);
							pstmt1.setDate(4, sqlDate);
			                int cnt = pstmt1.executeUpdate();				                
			                
			                if(cnt==1){
			                	JOptionPane.showMessageDialog(null,"Payment Done");
			                	t.setText("");
			                	t1.setText("");
		                		t2.setText("");
		                		t3.setText("");
		                		t4.setText("");
		                		t5.setText("");
			                }
			                else
			                    JOptionPane.showMessageDialog(null,"Some Issue Occured");
							}
						}	
					}
				catch(Exception e1) {
					System.out.println("ERROR xx"+e1);
					System.out.println("ERROR xx"+e);
				}
			}
		});
		b1.setToolTipText("");
		b1.setFont(new Font("Californian FB", Font.BOLD, 17));
		b1.setBackground(Color.WHITE);
		b1.setBounds(216, 324, 88, 39);
		contentPane.add(b1);
		
		t4 = new JTextField();
		t4.setEditable(false);
		t4.setColumns(10);
		t4.setBounds(236, 223, 200, 26);
		contentPane.add(t4);
		
		t = new JTextField();
		t.setColumns(10);
		t.setBounds(236, 32, 102, 26);
		contentPane.add(t);
		
		JButton b2 = new JButton("Search");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(t.getText().equals(""))
			           JOptionPane.showMessageDialog(null, "Enter Employee Name");
				else if(c.getSelectedItem().toString().equals("Job"))
			           JOptionPane.showMessageDialog(null, "Select Job");
			    else {
			    	try {
						if(e.getSource() == b2) {
							int i = 0;
							Class.forName("com.mysql.jdbc.Driver");
							Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS?characterEncoding=utf8","root","root");
							
							PreparedStatement pstmt = conn.prepareStatement("select fname, mobile, job from Employees where fname = ? and job = ?");
							pstmt.setString(1, t.getText());
							pstmt.setString(2, (String)c.getSelectedItem());
							ResultSet rs = pstmt.executeQuery();
							
							if(c.getSelectedItem().toString().equals("Warden")) {
								val = 10000;
							}
							if(c.getSelectedItem().toString().equals("Cook")) {
								val = 6000;
							}
							if(c.getSelectedItem().toString().equals("Cleaner")) {
								val = 4000;
							}
							if(c.getSelectedItem().toString().equals("Guard")) {
								val = 8000;
							}
							
			                while(rs.next()){
			                	i = 1;
			                	t1.setText(rs.getString(1));
			                	t2.setText(rs.getString(2));
			                	t3.setText(rs.getString(3));
			                	t4.setText(month);
			                	t5.setText(Integer.toString(val));
			                }
			                tbDetails();
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
		b2.setBounds(441, 32, 79, 27);
		contentPane.add(b2);
		
		JLabel lblEmployeeName = new JLabel("Employee Name");
		lblEmployeeName.setFont(new Font("Californian FB", Font.BOLD, 20));
		lblEmployeeName.setBounds(58, 32, 151, 26);
		contentPane.add(lblEmployeeName);
		
		JLabel lblAmountPayable = new JLabel("Amount Payable");
		lblAmountPayable.setFont(new Font("Californian FB", Font.BOLD, 20));
		lblAmountPayable.setBounds(58, 271, 168, 26);
		contentPane.add(lblAmountPayable);
		
		t5 = new JTextField();
		t5.setEditable(false);
		t5.setColumns(10);
		t5.setBounds(236, 271, 200, 26);
		contentPane.add(t5);
		
		JLabel lblJob = new JLabel("Job");
		lblJob.setFont(new Font("Californian FB", Font.BOLD, 20));
		lblJob.setBounds(58, 173, 102, 26);
		contentPane.add(lblJob);
		
		t3 = new JTextField();
		t3.setEditable(false);
		t3.setColumns(10);
		t3.setBounds(236, 176, 200, 26);
		contentPane.add(t3);
	}
}
