package com.BNU.pages.teachersByClass;

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

public class testTeachersBbyClassView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testTeachersBbyClassView frame = new testTeachersBbyClassView();
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
	public testTeachersBbyClassView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(10, 10));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(300, 100));
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search By Class");
		lblNewLabel.setBounds(41, 164, 205, 43);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(41, 218, 205, 43);
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(300, 100));
		contentPane.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("Search By Class");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(41, 164, 205, 43);
		panel_1.add(label);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(41, 218, 205, 43);
		panel_1.add(comboBox_1);
		
		JLabel lblImage = new JLabel("Image");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblImage, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.NORTH);
		panel_2.setPreferredSize(new Dimension(150, 150));
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("< Class Name >");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 35));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_2, BorderLayout.CENTER);
	}
}
