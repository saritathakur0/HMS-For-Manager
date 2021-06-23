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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class EditUsername extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t3;
	private JPasswordField t2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditUsername frame = new EditUsername();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public EditUsername() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(280, 200, 450, 348);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 181));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("Username");
		l1.setFont(new Font("Californian FB", Font.BOLD, 20));
		l1.setBounds(41, 57, 102, 26);
		contentPane.add(l1);
		
		t1 = new JTextField();
		t1.setColumns(10);
		t1.setBounds(200, 57, 200, 26);
		contentPane.add(t1);
		
		JLabel l2 = new JLabel("Password");
		l2.setFont(new Font("Californian FB", Font.BOLD, 20));
		l2.setBounds(41, 105, 102, 26);
		contentPane.add(l2);
		
		JLabel l3 = new JLabel("New Username");
		l3.setFont(new Font("Californian FB", Font.BOLD, 20));
		l3.setBounds(41, 154, 135, 26);
		contentPane.add(l3);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(200, 154, 200, 26);
		contentPane.add(t3);
		
		JCheckBox c1 = new JCheckBox("       Show Password");
		c1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c1.isSelected()) {
					t2.setEchoChar((char)0);
				}
				else {
					t2.setEchoChar('*');
				}
			}
		});
		c1.setFont(new Font("Californian FB", Font.PLAIN, 15));
		c1.setBackground(new Color(255, 228, 181));
		c1.setBounds(132, 204, 217, 23);
		contentPane.add(c1);
		
		JButton b1 = new JButton("SAVE");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		    		if(e.getSource() == b1) {
		    			if(t1.getText().equals(""))
					           JOptionPane.showMessageDialog(null, "Enter Username");
					    else if(t2.getText().equals(""))
					           JOptionPane.showMessageDialog(null, "Enter Password");
					    else if(t3.getText().equals(""))
					           JOptionPane.showMessageDialog(null, "Enter new username");
					    else {
					    	Class.forName("com.mysql.jdbc.Driver");
							Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS?characterEncoding=utf8","root","root");
			    			
			    			PreparedStatement pstmt = conn.prepareStatement("select username,pwd from Login where username=? and pwd=?");
							pstmt.setString(1, t1.getText());
							pstmt.setString(2, t2.getText());
				            ResultSet rs = pstmt.executeQuery();
				            if(rs.next()){
				            	PreparedStatement pstmt1 = conn.prepareStatement("select username,pwd from Login where username=?");
								pstmt1.setString(1, t3.getText());
					            ResultSet rs1 = pstmt1.executeQuery();
					            if(rs1.next()) {
					            	JOptionPane.showMessageDialog(null,"Username already exists");
					            }
					            else {
					            	PreparedStatement pstmt2 = conn.prepareStatement("update Login set username = ? where username = ? and pwd = ?");
									pstmt2.setString(1, t3.getText());
									pstmt2.setString(2, t1.getText());
									pstmt2.setString(3, t2.getText());
						            int cnt = pstmt2.executeUpdate();
						            
						            if(cnt == 1) {
						            	JOptionPane.showMessageDialog(null,"Profile Updated");
						            	t1.setText("");
				                		t2.setText("");
				                		t3.setText("");
				                		c1.setSelected(false);
						            }
						            	
					            }
				            }
				            else
				                JOptionPane.showMessageDialog(null,"Incorrect Username or Password");
				            conn.close();	
					    }
		    		}
				}
		    	catch(Exception ex) {
		    		System.out.println(e);
		    		System.out.println(ex);
		    	}
			}
		});
		b1.setFont(new Font("Californian FB", Font.BOLD, 17));
		b1.setBackground(Color.WHITE);
		b1.setBounds(168, 259, 102, 39);
		contentPane.add(b1);
		
		t2 = new JPasswordField();
		t2.setEchoChar('*');
		t2.setBounds(200, 108, 200, 26);
		contentPane.add(t2);
	}
}
