import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JPasswordField t2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setTitle("Hostel Management System - Login");
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Hostel Management System - Login");
		setBounds(100, 100, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 854, 661);
		contentPane.add(panel);
		panel.setLayout(null);
		
		ImageIcon background_img1 = new ImageIcon("C:\\Users\\Sarita Thakur\\eclipse-workspace\\HMS_sdl\\src\\images\\bg1.jpg");
		Image img1 = background_img1.getImage();
		Image temp_img1 = img1.getScaledInstance(854, 661, Image.SCALE_SMOOTH);
		background_img1 = new ImageIcon(temp_img1);
		
		JLabel l1 = new JLabel("", background_img1, JLabel.CENTER);
		l1.setBounds(0, 0, 854, 661);
		panel.add(l1);
		
		JLabel l2 = new JLabel("Username");
		l2.setFont(new Font("Californian FB", Font.BOLD, 25));
		l2.setBounds(909, 216, 130, 29);
		contentPane.add(l2);
		
		t1 = new JTextField();
		t1.setColumns(10);
		t1.setBackground(Color.WHITE);
		t1.setBounds(913, 256, 217, 29);
		contentPane.add(t1);
		
		JLabel l3 = new JLabel("Password");
		l3.setFont(new Font("Californian FB", Font.BOLD, 25));
		l3.setBounds(912, 308, 130, 29);
		contentPane.add(l3);
		
		t2 = new JPasswordField();
		t2.setEchoChar('*');
		t2.setBounds(913, 348, 217, 29);
		contentPane.add(t2);
		
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
		c1.setBackground(SystemColor.info);
		c1.setBounds(913, 391, 217, 23);
		contentPane.add(c1);
		
		JButton b1 = new JButton("LOGIN");
		b1.setFont(new Font("Californian FB", Font.BOLD, 17));
		b1.setBackground(Color.WHITE);
		b1.setBounds(973, 441, 113, 35);
		contentPane.add(b1);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(t1.getText().equals(""))
			           JOptionPane.showMessageDialog(null, "Enter Username");
			    else if(t2.getText().equals(""))
			           JOptionPane.showMessageDialog(null, "Enter Password");
			    else {
			    	try {
			    		if(e.getSource() == b1) {
			    			Class.forName("com.mysql.jdbc.Driver");
							Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS?characterEncoding=utf8","root","root");
			    			
			    			PreparedStatement pstmt = conn.prepareStatement("select username,pwd from Login where username=? and pwd=?");
							pstmt.setString(1, t1.getText());
							pstmt.setString(2, t2.getText());
				            ResultSet rs = pstmt.executeQuery();
				            if(rs.next()){
				            	String username = t1.getText();
				            	String pwd = t2.getText();
				            	Main h = new Main(/*username, pwd*/);
								h.setLocationRelativeTo(null);
				                h.setVisible(true);
				                dispose();
				            }
				            else
				                JOptionPane.showMessageDialog(null,"Incorrect Username or Password");
				            conn.close();	
			    		}
			    	}
			    	catch(Exception ex) {
			    		System.out.println(e);
			    		System.out.println(ex);
			    	}
			    }
			}
		});
	}
}
