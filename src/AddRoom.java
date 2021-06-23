import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddRoom extends JFrame {

	public String y;
	private JPanel contentPane;
	private JTextField t2;
	private JTextField t1;
	private JTextField t3;
	private JTextField t4;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRoom frame = new AddRoom();
					frame.setTitle("Add/Update a Room");
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AddRoom() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Add/Update a Room");
		setBounds(250, 110, 546, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 181));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(268, 86, 139, 26);
		contentPane.add(t2);
		
		JButton b1 = new JButton("SAVE");
		b1.setToolTipText("");
		b1.setFont(new Font("Californian FB", Font.BOLD, 17));
		b1.setBackground(Color.WHITE);
		b1.setBounds(191, 192, 157, 39);
		contentPane.add(b1);
		
		JRadioButton r1 = new JRadioButton("Yes");
		r1.setFont(new Font("Californian FB", Font.BOLD, 20));
		r1.setBackground(new Color(255, 228, 181));
		r1.setBounds(268, 135, 67, 23);
		contentPane.add(r1);
		
		JRadioButton r2 = new JRadioButton("No");
		r2.setFont(new Font("Californian FB", Font.BOLD, 20));
		r2.setBackground(new Color(255, 228, 181));
		r2.setBounds(354, 135, 67, 23);
		contentPane.add(r2);
		
		ButtonGroup G1 = new ButtonGroup();
		G1.add(r1);
		G1.add(r2);
		
		JLabel l3 = new JLabel("Activate ?");
		l3.setFont(new Font("Californian FB", Font.BOLD, 20));
		l3.setBounds(109, 133, 102, 26);
		contentPane.add(l3);
		
		JLabel l2 = new JLabel("Floor no.");
		l2.setFont(new Font("Californian FB", Font.BOLD, 20));
		l2.setBounds(109, 86, 102, 26);
		contentPane.add(l2);
		
		JLabel l1 = new JLabel("Room no.");
		l1.setFont(new Font("Californian FB", Font.BOLD, 20));
		l1.setBounds(109, 38, 102, 26);
		contentPane.add(l1);
		
		t1 = new JTextField();
		t1.setColumns(10);
		t1.setBounds(268, 38, 139, 26);
		contentPane.add(t1);
		
		JLabel l5 = new JLabel("Floor no.");
		l5.setFont(new Font("Californian FB", Font.BOLD, 20));
		l5.setBounds(109, 339, 102, 26);
		contentPane.add(l5);
		
		JLabel l4 = new JLabel("Room no.");
		l4.setFont(new Font("Californian FB", Font.BOLD, 20));
		l4.setBounds(109, 291, 102, 26);
		contentPane.add(l4);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(268, 291, 139, 26);
		contentPane.add(t3);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(268, 339, 139, 26);
		contentPane.add(t4);
		
		JRadioButton r3 = new JRadioButton("Yes");
		r3.setFont(new Font("Californian FB", Font.BOLD, 20));
		r3.setBackground(new Color(255, 228, 181));
		r3.setBounds(268, 388, 67, 23);
		contentPane.add(r3);
		
		JRadioButton r4 = new JRadioButton("No");
		r4.setFont(new Font("Californian FB", Font.BOLD, 20));
		r4.setBackground(new Color(255, 228, 181));
		r4.setBounds(354, 388, 67, 23);
		contentPane.add(r4);
		
		ButtonGroup G2 = new ButtonGroup();
		G2.add(r3);
		G2.add(r4);
		
		JLabel l6 = new JLabel("Activate ?");
		l6.setFont(new Font("Californian FB", Font.BOLD, 20));
		l6.setBounds(109, 386, 102, 26);
		contentPane.add(l6);
		
		JButton b2 = new JButton("UPDATE");
		b2.setToolTipText("");
		b2.setFont(new Font("Californian FB", Font.BOLD, 17));
		b2.setBackground(Color.WHITE);
		b2.setBounds(97, 447, 162, 39);
		contentPane.add(b2);
		
		JButton b3 = new JButton("DELETE");
		b3.setToolTipText("");
		b3.setFont(new Font("Californian FB", Font.BOLD, 17));
		b3.setBackground(Color.WHITE);
		b3.setBounds(271, 447, 162, 39);
		contentPane.add(b3);
		
		JButton b4 = new JButton("Search");
		b4.setToolTipText("");
		b4.setFont(new Font("Californian FB", Font.BOLD, 14));
		b4.setBackground(Color.WHITE);
		b4.setBounds(417, 292, 82, 26);
		contentPane.add(b4);
		
		JPanel p1 = new JPanel();
		p1.setBackground(SystemColor.info);
		p1.setBounds(0, 251, 530, 7);
		contentPane.add(p1);
		p1.setLayout(null);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(t1.getText().equals(""))
			           JOptionPane.showMessageDialog(null, "Enter room no.");
			    else if(t2.getText().equals(""))
			           JOptionPane.showMessageDialog(null, "Enter floor no.");
			    else if(r1.isSelected()==false && r2.isSelected()==false)
	            	JOptionPane.showMessageDialog(null, "Select room status");
			    else {
			    	try {
						if(e.getSource() == b1) {
							
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS?characterEncoding=utf8","root","root");
						
						PreparedStatement pstmt1 = conn.prepareStatement("select rno from Room where rno=?");
						pstmt1.setString(1, t1.getText());
			            ResultSet rs1 = pstmt1.executeQuery();
			            if(rs1.next()){
				            	JOptionPane.showMessageDialog(null,"Room already exists");
				            	t1.setText("");
		                		t2.setText("");
		                		G1.clearSelection();
				            }
				            else {
				            	PreparedStatement pstmt = conn.prepareStatement("insert into Room(rno, floorno, rstatus) values(?,?,?)");
								pstmt.setString(1, t1.getText());
								pstmt.setString(2, t2.getText());
								pstmt.setString(3, r1.isSelected()==true ? "yes" : "no" );
				                int cnt = pstmt.executeUpdate();				                
				                
				                if(cnt==1){
				                	JOptionPane.showMessageDialog(null,"Room " + t1.getText() + " Added");
				                	t1.setText("");
			                		t2.setText("");
			                		G1.clearSelection();
				                }
				                else
				                    JOptionPane.showMessageDialog(null,"Some Issue Occured");
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
		
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    	try {
						if(e.getSource() == b4) {
							int i = 0;
							Class.forName("com.mysql.jdbc.Driver");
							Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS?characterEncoding=utf8","root","root");
							Statement s = conn.createStatement();
							ResultSet rs = s.executeQuery("select * from Room where rno = " + t3.getText());
			                
			                while(rs.next()){
			                	i = 1;
			                	if(rs.getString(4).equals("yes")){
			                		JOptionPane.showMessageDialog(null,"This room is booked");
			                		t3.setText("");
			                		t4.setText("");
			                		G2.clearSelection();
			                	}
			                	else {
			                		int x = rs.getInt(2);
			                		t4.setText(Integer.toString(x));
			                		if(rs.getString(3).equals("yes")) {
			                			r3.setSelected(true);
			                		}
			                		else {
			                			r4.setSelected(true);
			                		}
			                	}
			                }
			                if(i == 0) {
			                	JOptionPane.showMessageDialog(null,"No room record found");
			                	t3.setText("");
			                }
						}
					}
					catch(Exception e1) {
						System.out.println("ERROR "+e1);
						System.out.println("ERROR "+e);
					}
			    }
		});
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                if(e.getSource() == b2) {
        			try {
        					String z = r3.isSelected()==true ? "yes" : "no" ;
        					int i = Integer.parseInt(t3.getText()); 
        					int i1 = Integer.parseInt(t4.getText()); 
        					Class.forName("com.mysql.jdbc.Driver");
        					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS?characterEncoding=utf8","root","root");
        					PreparedStatement pstmt = conn.prepareStatement("update Room set floorno = ?, rstatus = ? where rno = ?");
        					pstmt.setInt(1, i1);
        					pstmt.setString(2, z);
        					pstmt.setInt(3, i);
							int cnt = pstmt.executeUpdate();				                
    					               
    					    if(cnt==1){
    			             	JOptionPane.showMessageDialog(null,"Room " + t3.getText() + " Info. Updated");
    			             	t3.setText("");
    	                		t4.setText("");
    	                		G2.clearSelection();
    		                }
    		                else
    		                    JOptionPane.showMessageDialog(null,"Some Issue Occured");
       				}
        			catch(Exception e1) {
                		System.out.println("ERROR "+e1);
                		System.out.println("ERROR "+e);
                	}
        		}
			}});
		
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                if(e.getSource() == b3) {
        			try {
        					int i = Integer.parseInt(t3.getText()); 
        					Class.forName("com.mysql.jdbc.Driver");
        					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS?characterEncoding=utf8","root","root");
        					PreparedStatement pstmt = conn.prepareStatement("delete from Room where rno = ?");
        					pstmt.setInt(1, i);
							int cnt = pstmt.executeUpdate();				                
    					               
    					    if(cnt==1){
    			             	JOptionPane.showMessageDialog(null,"Room " + t3.getText() + " Deleted");
    			             	t3.setText("");
    	                		t4.setText("");
    	                		G2.clearSelection();
    		                }
    		                else
    		                    JOptionPane.showMessageDialog(null,"Some Issue Occured");
       				}
        			catch(Exception e1) {
                		System.out.println("ERROR "+e1);
                		System.out.println("ERROR "+e);
                	}
        		}
			}});
	}
}
