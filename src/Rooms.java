import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Rooms extends JFrame {

	private JPanel contentPane;
	private JTextField xt1;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rooms frame = new Rooms();
					frame.setTitle("Hostel Management System - Manage Rooms");
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Rooms() {
		setDefaultCloseOperation(0);
		setTitle("Hostel Management System - Manage Rooms");
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
		
		ImageIcon x1 = new ImageIcon("C:\\Users\\Sarita Thakur\\eclipse-workspace\\HMS_sdl\\src\\images\\addroom.png");
		Image y1 = x1.getImage();
		Image z1 = y1.getScaledInstance(46, 38, Image.SCALE_SMOOTH);
		x1 = new ImageIcon(z1);
		
		JLabel lb1 = new JLabel("",x1,JLabel.CENTER);
		lb1.setToolTipText("Add/Update a room");
		lb1.setBounds(882, 390, 46, 38);
		contentPane.add(lb1);
		
		JButton b1 = new JButton("ADD ROOM");
		b1.setToolTipText("");
		b1.setFont(new Font("Californian FB", Font.BOLD, 17));
		b1.setBackground(Color.WHITE);
		b1.setBounds(944, 389, 218, 39);
		contentPane.add(b1);
		
		JButton b2 = new JButton("VIEW ROOMS");
		b2.setToolTipText("Add / Activate / Deactivate a Room");
		b2.setFont(new Font("Californian FB", Font.BOLD, 17));
		b2.setBackground(Color.WHITE);
		b2.setBounds(944, 449, 218, 39);
		contentPane.add(b2);
		
		ImageIcon x2 = new ImageIcon("C:\\Users\\Sarita Thakur\\eclipse-workspace\\HMS_sdl\\src\\images\\viewroom.png");
		Image y2 = x2.getImage();
		Image z2 = y2.getScaledInstance(46, 38, Image.SCALE_SMOOTH);
		x2 = new ImageIcon(z2);
		
		JLabel lb2 = new JLabel("", x2, JLabel.CENTER);
		lb2.setToolTipText("Display all rooms details");
		lb2.setBounds(882, 449, 46, 38);
		contentPane.add(lb2);
		
		ImageIcon x3 = new ImageIcon("C:\\Users\\Sarita Thakur\\eclipse-workspace\\HMS_sdl\\src\\images\\back.png");
		Image y3 = x3.getImage();
		Image z3 = y3.getScaledInstance(62, 51, Image.SCALE_SMOOTH);
		x3 = new ImageIcon(z3);
		
		JLabel back = new JLabel("", x3, JLabel.CENTER);
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
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == b1) {
					AddRoom h = new AddRoom();
	                h.setVisible(true);
				}
			}
		});
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == b2) {
					ViewRoom h = new ViewRoom();
	                h.setVisible(true);
				}
			}
		});
	}
}

	
	