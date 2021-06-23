import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class ViewAadhar extends JFrame {

	private JPanel contentPane;
	JLabel l1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAadhar frame = new ViewAadhar();
					frame.setTitle("Aadhar");
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	void aadhar(ImageIcon newImage) {
		l1.setIcon(newImage);
	}

	public ViewAadhar() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Aadhar");
		setBounds(250, 110, 546, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		l1 = new JLabel("");
		l1.setBounds(0, 0, 530, 511);
		contentPane.add(l1);
	}
}
