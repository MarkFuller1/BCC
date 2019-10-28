package com.BNU.pages.register;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class testMLayout extends JFrame {

	private JPanel contentPane;
	private JTextField txtDiojdiwof;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testMLayout frame = new testMLayout();
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
	public testMLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLocation(684, 104);
		panel.setSize(290,513);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(59, 301, 151, 22);
		panel.add(comboBox);
		
		JLabel lblAddClassesTaken = new JLabel("Add Classes Taken");
		lblAddClassesTaken.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblAddClassesTaken.setBounds(37, 242, 214, 35);
		panel.add(lblAddClassesTaken);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 100, 617, 536);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblUsername.setBounds(25, 236, 126, 48);
		panel_1.add(lblUsername);
		
		JLabel label = new JLabel("Password");
		label.setFont(new Font("Tahoma", Font.PLAIN, 26));
		label.setBounds(25, 305, 135, 40);
		panel_1.add(label);
		
		txtDiojdiwof = new JTextField();
		txtDiojdiwof.setText("diojdiwof");
		txtDiojdiwof.setBounds(170, 240, 282, 48);
		panel_1.add(txtDiojdiwof);
		txtDiojdiwof.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(170, 309, 282, 40);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(478, 485, 116, 40);
		panel_1.add(btnSave);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 0, 964, 92);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		
		JLabel lblMakeAnAccount = new JLabel("Make an Account");
		lblMakeAnAccount.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblMakeAnAccount.setBounds(398, 28, 249, 38);
		panel_2.add(lblMakeAnAccount);
	}
}
