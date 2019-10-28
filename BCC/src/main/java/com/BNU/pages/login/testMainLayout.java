package com.BNU.pages.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;

public class testMainLayout extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testMainLayout frame = new testMainLayout();
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
	public testMainLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		setSize(1000,800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBcc = new JLabel("BCC");
		lblBcc.setFont(new Font("Segoe UI", Font.PLAIN, 50));
		lblBcc.setBounds(436, 11, 96, 50);
		contentPane.add(lblBcc);
		
		JLabel lblSearchByClass = new JLabel("Search By Class");
		lblSearchByClass.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblSearchByClass.setBounds(59, 244, 143, 50);
		contentPane.add(lblSearchByClass);
		
		JLabel lblSearchByProcessor = new JLabel("Search by Professor");
		lblSearchByProcessor.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblSearchByProcessor.setBounds(762, 251, 185, 37);
		contentPane.add(lblSearchByProcessor);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(59, 298, 163, 22);
		contentPane.add(comboBox);
		
		JLabel lblImage = new JLabel("Image");
		lblImage.setBounds(448, 266, 31, 14);
		contentPane.add(lblImage);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(762, 298, 163, 22);
		contentPane.add(comboBox_1);
		
		JLabel lblBaylorComputerScience = new JLabel("Baylor Computer Science Reviews by Students");
		lblBaylorComputerScience.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblBaylorComputerScience.setBounds(288, 117, 436, 50);
		contentPane.add(lblBaylorComputerScience);
		
		JButton btnNewButton = new JButton("Messages");
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnNewButton.setBounds(25, 23, 126, 38);
		contentPane.add(btnNewButton);
	}

}
