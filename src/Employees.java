import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Icon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class Employees extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employees frame = new Employees();
					frame.setTitle("Hostel Management System - Manage Employees");
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Employees() {
		setTitle("Hostel Management System - Manage Employees");
		setDefaultCloseOperation(0);
		setBounds(100, 100, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setBackground(SystemColor.info);
		p1.setBounds(0, 0, 854, 661);
		contentPane.add(p1);
		p1.setLayout(null);
		
		
		ImageIcon background_img1 = new ImageIcon("C:\\Users\\Sarita Thakur\\eclipse-workspace\\HMS_sdl\\src\\images\\bg1.jpg");
		Image img1 = background_img1.getImage();
		Image temp_img1 = img1.getScaledInstance(854, 661, Image.SCALE_SMOOTH);
		background_img1 = new ImageIcon(temp_img1);
		
		JLabel l1 = new JLabel("", background_img1, JLabel.CENTER);
		l1.setBounds(0, 0, 854, 661);
		p1.add(l1);
		
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
		
		ImageIcon x1 = new ImageIcon("C:\\Users\\Sarita Thakur\\eclipse-workspace\\HMS_sdl\\src\\images\\newemployee.png");
		Image y1 = x1.getImage();
		Image z1 = y1.getScaledInstance(46, 38, Image.SCALE_SMOOTH);
		x1 = new ImageIcon(z1);
		
		JLabel lb1 = new JLabel("",x1,JLabel.CENTER);
		lb1.setToolTipText("Add a new employee");
		lb1.setBounds(880, 344, 46, 38);
		contentPane.add(lb1);
		
		JButton b1 = new JButton("ADD EMPLOYEE");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddEmployee h = new AddEmployee();
                h.setVisible(true);
			}
		});
		b1.setFont(new Font("Californian FB", Font.BOLD, 17));
		b1.setBackground(Color.WHITE);
		b1.setBounds(942, 344, 218, 39);
		contentPane.add(b1);
		
		JButton b2 = new JButton("UPDATE EMPLOYEE");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateEmployee h = new UpdateEmployee();
                h.setVisible(true);
			}
		});
		b2.setFont(new Font("Californian FB", Font.BOLD, 17));
		b2.setBackground(Color.WHITE);
		b2.setBounds(942, 401, 218, 39);
		contentPane.add(b2);
		
		JButton b3 = new JButton("WORKING EMPLOYEES");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WorkingEmployees l = new WorkingEmployees();
				l.setVisible(true);
			}
		});
		b3.setFont(new Font("Californian FB", Font.BOLD, 17));
		b3.setBackground(Color.WHITE);
		b3.setBounds(942, 457, 218, 39);
		contentPane.add(b3);
		
		JButton b4 = new JButton("PAST EMPLOYEES");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PastEmployees l = new PastEmployees();
				l.setVisible(true);
			}
		});
		b4.setFont(new Font("Californian FB", Font.BOLD, 17));
		b4.setBackground(Color.WHITE);
		b4.setBounds(942, 509, 218, 39);
		contentPane.add(b4);
		
		JButton b5 = new JButton("EMPLOYEE PAYMENT");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeePayment l = new EmployeePayment();
				l.setVisible(true);
			}
		});
		b5.setFont(new Font("Californian FB", Font.BOLD, 17));
		b5.setBackground(Color.WHITE);
		b5.setBounds(942, 566, 218, 39);
		contentPane.add(b5);
		
		ImageIcon x5 = new ImageIcon("C:\\Users\\Sarita Thakur\\eclipse-workspace\\HMS_sdl\\src\\images\\money.png");
		Image y5 = x5.getImage();
		Image z5 = y5.getScaledInstance(46, 38, Image.SCALE_SMOOTH);
		x5 = new ImageIcon(z5);
		
		JLabel lb5 = new JLabel("",x5,JLabel.CENTER);
		lb5.setToolTipText("Employee payment");
		lb5.setBounds(880, 566, 46, 38);
		contentPane.add(lb5);
		
		ImageIcon x4 = new ImageIcon("C:\\Users\\Sarita Thakur\\eclipse-workspace\\HMS_sdl\\src\\images\\leftemployee.png");
		Image y4 = x4.getImage();
		Image z4 = y4.getScaledInstance(46, 38, Image.SCALE_SMOOTH);
		x4 = new ImageIcon(z4);
		
		JLabel lb4 = new JLabel("",x4,JLabel.CENTER);
		lb4.setToolTipText("Display all past employee details");
		lb4.setBounds(880, 509, 46, 38);
		contentPane.add(lb4);
		
		ImageIcon x3 = new ImageIcon("C:\\Users\\Sarita Thakur\\eclipse-workspace\\HMS_sdl\\src\\images\\workingemployee.png");
		Image y3 = x3.getImage();
		Image z3 = y3.getScaledInstance(46, 38, Image.SCALE_SMOOTH);
		x3 = new ImageIcon(z3);
		
		JLabel lb3 = new JLabel("",x3,JLabel.CENTER);
		lb3.setToolTipText("Display all employee details");
		lb3.setBounds(880, 457, 46, 38);
		contentPane.add(lb3);
		
		ImageIcon x2 = new ImageIcon("C:\\Users\\Sarita Thakur\\eclipse-workspace\\HMS_sdl\\src\\images\\update.png");
		Image y2 = x2.getImage();
		Image z2 = y2.getScaledInstance(46, 38, Image.SCALE_SMOOTH);
		x2 = new ImageIcon(z2);
		
		JLabel lb2 = new JLabel("",x2,JLabel.CENTER);
		lb2.setToolTipText("Update an employee record");
		lb2.setBounds(880, 401, 46, 38);
		contentPane.add(lb2);
		
		ImageIcon x6 = new ImageIcon("C:\\Users\\Sarita Thakur\\eclipse-workspace\\HMS_sdl\\src\\images\\back.png");
		Image y6 = x6.getImage();
		Image z6 = y6.getScaledInstance(62, 51, Image.SCALE_SMOOTH);
		x6 = new ImageIcon(z6);
		
		JLabel back = new JLabel("", x6, JLabel.CENTER);
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main m = new Main();
				m.setLocationRelativeTo(null);
                m.setVisible(true);
                dispose();
			}
		});
		back.setToolTipText("");
		back.setBounds(854, 0, 62, 51);
		contentPane.add(back);
	}
}
