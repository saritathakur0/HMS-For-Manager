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
import java.awt.SystemColor;

public class EditPassword extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JPasswordField t3;
	private JPasswordField t4;
	private JPasswordField t2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditPassword frame = new EditPassword();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EditPassword() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(280, 200, 450, 348);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 181));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("Username");
		l1.setFont(new Font("Californian FB", Font.BOLD, 20));
		l1.setBounds(44, 36, 102, 26);
		contentPane.add(l1);
		
		t1 = new JTextField();
		t1.setColumns(10);
		t1.setBounds(203, 36, 200, 26);
		contentPane.add(t1);
		
		JLabel l2 = new JLabel("Password");
		l2.setFont(new Font("Californian FB", Font.BOLD, 20));
		l2.setBounds(44, 84, 102, 26);
		contentPane.add(l2);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("Californian FB", Font.BOLD, 20));
		lblNewPassword.setBounds(44, 133, 135, 26);
		contentPane.add(lblNewPassword);
		
		JLabel l4 = new JLabel("Confirm");
		l4.setFont(new Font("Californian FB", Font.BOLD, 20));
		l4.setBounds(44, 180, 135, 26);
		contentPane.add(l4);
		
		t3 = new JPasswordField();
		t3.setEchoChar('*');
		t3.setBounds(203, 133, 200, 26);
		contentPane.add(t3);
		
		t4 = new JPasswordField();
		t4.setEchoChar('*');
		t4.setBounds(203, 180, 200, 26);
		contentPane.add(t4);
		
		t2 = new JPasswordField();
		t2.setEchoChar('*');
		t2.setBounds(203, 87, 200, 26);
		contentPane.add(t2);
		
		JCheckBox c1 = new JCheckBox("       Show Password");
		c1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c1.isSelected()) {
					t2.setEchoChar((char)0);
					t3.setEchoChar((char)0);
					t4.setEchoChar((char)0);
				}
				else {
					t2.setEchoChar('*');
					t3.setEchoChar('*');
					t4.setEchoChar('*');
				}
			}
		});
		c1.setFont(new Font("Californian FB", Font.PLAIN, 15));
		c1.setBackground(new Color(255, 228, 181));
		c1.setBounds(112, 223, 217, 23);
		contentPane.add(c1);
		
		JButton b1 = new JButton("SAVE");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    		if(e.getSource() == b1) {
		    			if(t1.getText().equals(""))
					           JOptionPane.showMessageDialog(null, "Enter Username");
					    else if(t2.getText().equals(""))
					           JOptionPane.showMessageDialog(null, "Enter Password");
					    else if(t3.getText().equals(""))
					           JOptionPane.showMessageDialog(null, "Enter new username");
					    else {
					    	try {
						    	Class.forName("com.mysql.jdbc.Driver");
								Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS?characterEncoding=utf8","root","root");
				    			
				    			PreparedStatement pstmt = conn.prepareStatement("select username,pwd from Login where username=? and pwd=?");
								pstmt.setString(1, t1.getText());
								pstmt.setString(2, t2.getText());
					            ResultSet rs = pstmt.executeQuery();
					            if(rs.next()){
					            	String x = t3.getText();
					            	String y = t4.getText();
					            	if(x.equals(y)) {
					            		PreparedStatement pstmt2 = conn.prepareStatement("update Login set pwd = ? where username = ? and pwd = ?");
										pstmt2.setString(1, t3.getText());
										pstmt2.setString(2, t1.getText());
										pstmt2.setString(3, t2.getText());
							            int cnt = pstmt2.executeUpdate();
							            
							            if(cnt == 1) {
							            	JOptionPane.showMessageDialog(null,"Profile Updated");
							            	t1.setText("");
							            	t2.setText("");
							            	t3.setText("");
							            	t4.setText("");
							            	c1.setSelected(false);
							            }
					            	}
					            	else
					            		JOptionPane.showMessageDialog(null,"New Passwords do not match");
					            }
					            else
					                JOptionPane.showMessageDialog(null,"Incorrect Username or Password");
					            conn.close();	
					    	}
					    	catch(Exception ex) {
					    		System.out.println(e);
					    		System.out.println(ex);
					    	}
					    }
		    		}
			}
		});
		b1.setFont(new Font("Californian FB", Font.BOLD, 17));
		b1.setBackground(Color.WHITE);
		b1.setBounds(168, 259, 102, 39);
		contentPane.add(b1);
	}
}
