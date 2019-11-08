package BNU.presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Choice;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class testTeachersByClassView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testTeachersByClassView frame = new testTeachersByClassView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public testTeachersByClassView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Professor Name");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 33));
		lblNewLabel.setBounds(356, 11, 243, 57);
		contentPane.add(lblNewLabel);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(10, 11, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setBounds(926, 11, 48, 14);
		contentPane.add(lblEmail);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 321, 964, 429);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JButton btnNewButton = new JButton("New button");
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel_2.add(btnNewButton_1);
		
		JLabel lblClassesTaught = new JLabel("Classes Taught");
		lblClassesTaught.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		lblClassesTaught.setBounds(213, 265, 143, 33);
		contentPane.add(lblClassesTaught);
		
		JLabel lblRating = new JLabel("Rating");
		lblRating.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		lblRating.setBounds(505, 265, 65, 33);
		contentPane.add(lblRating);
		
		JLabel lblNumberOfReviews = new JLabel("Number Of Reviews");
		lblNumberOfReviews.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		lblNumberOfReviews.setBounds(698, 265, 185, 33);
		contentPane.add(lblNumberOfReviews);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(133, 108, 672, 106);
		contentPane.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_3 = new JLabel("a");
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("b");
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("c");
		panel_3.add(lblNewLabel_1);
	}
}
