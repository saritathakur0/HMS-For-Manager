import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Formatter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
public class StudentFees extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t4;
	private JTextField t;
	private JTextField t5;
	private JTextField t3;
	private JTable table;
	private JComboBox c;
	String month;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentFees frame = new StudentFees();
					frame.setTitle("Collect Student fees");
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
			pstmt.setString(2, "yes");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				c.addItem(Integer.toString(rs.getInt(1)));
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
			
			PreparedStatement pstmt = conn.prepareStatement("select sid from Student where fname = ? and rno = ?");
			pstmt.setString(1, t1.getText());
			pstmt.setInt(2, Integer.valueOf(t3.getText()));
			ResultSet rs = pstmt.executeQuery();
			int sid = 0;
			while(rs.next()) {
				sid = rs.getInt("sid");
			}
			
			PreparedStatement pstmt1 = conn.prepareStatement("select month, amount, paidon from StudentFees where sid = ?");
			pstmt1.setInt(1, sid);
			ResultSet rs1 = pstmt1.executeQuery();
			
			while(rs1.next()) {
				dtm.addRow(new Object[] {rs1.getString(1),rs1.getString(2), rs1.getDate(3)});
			}
		}
		catch(Exception e) {
			System.out.println("tb"+e);
		}
	}

	public StudentFees() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Collect Student fees");
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
		
		c = new JComboBox();
		c.setModel(new DefaultComboBoxModel(new String[] {"Room"}));
		c.setFont(new Font("Californian FB", Font.BOLD, 15));
		c.setBackground(Color.WHITE);
		c.setBounds(348, 33, 88, 26);
		contentPane.add(c);
		
		fetchRooms();
		
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
		
		JButton b1 = new JButton("PAY");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(e.getSource() == b1) {
						
						java.util.Date date = new java.util.Date();
						java.sql.Date sqlDate = new java.sql.Date(date.getTime());
						
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS?characterEncoding=utf8","root","root");
						
						PreparedStatement pstmt = conn.prepareStatement("select sid from Student where fname = ? and rno = ?");
						pstmt.setString(1, t1.getText());
						pstmt.setInt(2, Integer.valueOf(t3.getText()));
						ResultSet rs = pstmt.executeQuery();
						int sid = 0;
						while(rs.next()) {
							sid = rs.getInt("sid");
						}
						
						PreparedStatement pstmt2 = conn.prepareStatement("select month from StudentFees where sid = ?");
						pstmt2.setInt(1, sid);
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
							JOptionPane.showMessageDialog(null,"Fees already paid for this month");
							t.setText("");
		                	t1.setText("");
	                		t2.setText("");
	                		t3.setText("");
	                		t4.setText("");
	                		t5.setText("");
						}
						else {
							PreparedStatement pstmt1 = conn.prepareStatement("insert into StudentFees(sid, month, amount, paidon) values(?, ?,?,?)");
							pstmt1.setInt(1, sid);
							pstmt1.setString(2, month);
							pstmt1.setInt(3, Integer.valueOf(t5.getText()));
							pstmt1.setDate(4, sqlDate);
			                int cnt = pstmt1.executeUpdate();				                
			                
			                if(cnt==1){
			                	JOptionPane.showMessageDialog(null,"Paid");
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
		
		Formatter fmt = new Formatter();
		Calendar cal = Calendar.getInstance();
		fmt = new Formatter();
		fmt.format("%tB", cal);
		month = fmt.toString();
		
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
							Class.forName("com.mysql.jdbc.Driver");
							Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS?characterEncoding=utf8","root","root");
							
							PreparedStatement pstmt = conn.prepareStatement("select fname, mobile, rno from Student where fname = ? and rno = ?");
							pstmt.setString(1, t.getText());
							pstmt.setInt(2, y);
							ResultSet rs = pstmt.executeQuery();
							
			                while(rs.next()){
			                	i = 1;
			                	t1.setText(rs.getString(1));
			                	t2.setText(rs.getString(2));
			                	t3.setText(rs.getString(3));
			                	t4.setText(month);
			                	t5.setText("5000");
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
		b2.setToolTipText("Add / Activate / Deactivate a Room");
		b2.setFont(new Font("Californian FB", Font.BOLD, 14));
		b2.setBackground(Color.WHITE);
		b2.setBounds(441, 32, 79, 27);
		contentPane.add(b2);
		
		JLabel l = new JLabel("Student Name");
		l.setFont(new Font("Californian FB", Font.BOLD, 20));
		l.setBounds(58, 32, 130, 26);
		contentPane.add(l);
		
		JLabel l6 = new JLabel("Amount to be payed");
		l6.setFont(new Font("Californian FB", Font.BOLD, 20));
		l6.setBounds(58, 271, 168, 26);
		contentPane.add(l6);
		
		t5 = new JTextField();
		t5.setEditable(false);
		t5.setColumns(10);
		t5.setBounds(236, 271, 200, 26);
		contentPane.add(t5);
		
		JLabel l8 = new JLabel("Room no.");
		l8.setFont(new Font("Californian FB", Font.BOLD, 20));
		l8.setBounds(58, 173, 102, 26);
		contentPane.add(l8);
		
		t3 = new JTextField();
		t3.setEditable(false);
		t3.setColumns(10);
		t3.setBounds(236, 176, 200, 26);
		contentPane.add(t3);
	}
}
