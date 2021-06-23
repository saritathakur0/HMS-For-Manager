import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;

public class Main extends JFrame {
//setBounds(91, 45, 854, 661);
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setTitle("Hostel Management System - Home");
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(0);
		setTitle("Hostel Management System - Home");
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
		
		ImageIcon background_img2 = new ImageIcon("C:\\Users\\Sarita Thakur\\eclipse-workspace\\HMS_sdl\\src\\images\\profile.png");
		Image img2 = background_img2.getImage();
		Image temp_img2 = img2.getScaledInstance(136, 126, Image.SCALE_SMOOTH);
		background_img2 = new ImageIcon(temp_img2);
		
		JLabel l2 = new JLabel("", background_img2, JLabel.CENTER);
		l2.setBounds(954, 104, 136, 126);
		contentPane.add(l2);
		
		JLabel l3 = new JLabel("MANAGER");
		l3.setFont(new Font("Californian FB", Font.BOLD, 22));
		l3.setBounds(968, 251, 112, 29);
		contentPane.add(l3);
		
		ImageIcon x1 = new ImageIcon("C:\\Users\\Sarita Thakur\\eclipse-workspace\\HMS_sdl\\src\\images\\room.png");
		Image y1 = x1.getImage();
		Image z1 = y1.getScaledInstance(46, 38, Image.SCALE_SMOOTH);
		x1 = new ImageIcon(z1);
		
		JLabel lb1 = new JLabel("",x1,JLabel.CENTER);
		lb1.setToolTipText("Add / Activate / Deactivate/ View Room");
		lb1.setBounds(879, 383, 46, 38);
		contentPane.add(lb1);
		
		JButton b1 = new JButton("MANAGE ROOMS");
		b1.setToolTipText("");
		b1.setFont(new Font("Californian FB", Font.BOLD, 17));
		b1.setBackground(Color.WHITE);
		b1.setBounds(941, 383, 218, 39);
		contentPane.add(b1);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rooms l = new Rooms();
				l.setLocationRelativeTo(null);
                l.setVisible(true);
                dispose();
			}
		});
		
		ImageIcon x2 = new ImageIcon("C:\\Users\\Sarita Thakur\\eclipse-workspace\\HMS_sdl\\src\\images\\newstudent.png");
		Image y2 = x2.getImage();
		Image z2 = y2.getScaledInstance(46, 38, Image.SCALE_SMOOTH);
		x2 = new ImageIcon(z2);
		
		JLabel lb2 = new JLabel("", x2, JLabel.CENTER);
		lb2.setToolTipText("Add/ Update/ Delete/ View Student record");
		lb2.setBounds(879, 440, 46, 38);
		contentPane.add(lb2);
		
		JButton b2 = new JButton("MANAGE STUDENTS");
		b2.setToolTipText("");
		b2.setFont(new Font("Californian FB", Font.BOLD, 17));
		b2.setBackground(Color.WHITE);
		b2.setBounds(941, 440, 218, 39);
		contentPane.add(b2);
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Students l = new Students();
				l.setLocationRelativeTo(null);
                l.setVisible(true);
                dispose();
			}
		});
		
		ImageIcon x3 = new ImageIcon("C:\\Users\\Sarita Thakur\\eclipse-workspace\\HMS_sdl\\src\\images\\newemployee.png");
		Image y3 = x3.getImage();
		Image z3 = y3.getScaledInstance(46, 38, Image.SCALE_SMOOTH);
		x3 = new ImageIcon(z3);
		
		JLabel lb3 = new JLabel("", x3, JLabel.CENTER);
		lb3.setToolTipText("Add/ Update/ Delete/ View Employees record");
		lb3.setBounds(881, 497, 46, 38);
		contentPane.add(lb3);
		
		JButton b3 = new JButton("MANAGE EMPLOYEES");
		b3.setToolTipText("");
		b3.setFont(new Font("Californian FB", Font.BOLD, 17));
		b3.setBackground(Color.WHITE);
		b3.setBounds(943, 497, 218, 39);
		contentPane.add(b3);
		
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employees l = new Employees();
				l.setLocationRelativeTo(null);
                l.setVisible(true);
                dispose();
			}
		});
		
		JPanel p2 = new JPanel();
		p2.setBackground(SystemColor.info);
		p2.setBounds(854, 1, 329, 32);
		contentPane.add(p2);
		p2.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 329, 32);
		p2.add(menuBar);
		
		JMenu m1 = new JMenu("       EDIT PROFILE       ");
		m1.setFont(new Font("Californian FB", Font.BOLD, 17));
		m1.setBounds(854, 1, 329, 32);
		JMenuItem editun = new JMenuItem("Edit Username              ");
		editun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditUsername l = new EditUsername();
                l.setVisible(true);
               // String x1 = l.returnun();
               // returnUN(x1, y);
			}
		});
		editun.setFont(new Font("Californian FB", Font.BOLD, 16));
		m1.add(editun);
		JMenuItem editpwd = new JMenuItem("Edit Password              ");
		editpwd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditPassword l = new EditPassword();
                l.setVisible(true);
			}
		});
		editpwd.setFont(new Font("Californian FB", Font.BOLD, 16));
		m1.add(editpwd);
		menuBar.add(m1);
		
		JMenu m2 = new JMenu("           EXIT            ");
		m2.setBackground(SystemColor.menu);
		m2.setFont(new Font("Californian FB", Font.BOLD, 17));
		m2.setBounds(854, 1, 329, 32);
		JMenuItem logout = new JMenuItem("Logout                  ");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setLocationRelativeTo(null);
                l.setVisible(true);
			}
		});
		logout.setFont(new Font("Californian FB", Font.BOLD, 16));
		editun.setFont(new Font("Californian FB", Font.BOLD, 16));
		m2.add(logout);
		JMenuItem quit = new JMenuItem("Quit                  ");
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		quit.setFont(new Font("Californian FB", Font.BOLD, 16));
		editpwd.setFont(new Font("Californian FB", Font.BOLD, 16));
		m2.add(quit);
		menuBar.add(m2);
		
		
	}
}
