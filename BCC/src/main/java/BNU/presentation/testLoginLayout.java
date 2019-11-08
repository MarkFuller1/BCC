package BNU.presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;

public class testLoginLayout extends JFrame {
	private JTextField txtEnterUsername;
	private JTextField txtEnterPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testLoginLayout frame = new testLoginLayout();
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
	public testLoginLayout() {
		setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//setBounds(100, 100, 1000, 800);
		setSize(1000,800);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Welcome to Baylor Class Connect");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel.setBounds(359, 184, 275, 41);
		getContentPane().add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblUsername.setBounds(342, 257, 112, 41);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblPassword.setBounds(342, 309, 112, 41);
		getContentPane().add(lblPassword);
		
		txtEnterUsername = new JTextField();
		txtEnterUsername.setText("Enter Username");
		txtEnterUsername.setBounds(452, 268, 187, 20);
		getContentPane().add(txtEnterUsername);
		txtEnterUsername.setColumns(10);
		
		txtEnterPassword = new JTextField();
		txtEnterPassword.setText("Enter Password");
		txtEnterPassword.setColumns(10);
		txtEnterPassword.setBounds(453, 320, 186, 20);
		getContentPane().add(txtEnterPassword);

		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnNewButton.setBounds(342, 383, 297, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnCreateAccount = new JButton("CREATE ACCOUNT");
		btnCreateAccount.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnCreateAccount.setBounds(342, 439, 297, 23);
		getContentPane().add(btnCreateAccount);
	}
}
