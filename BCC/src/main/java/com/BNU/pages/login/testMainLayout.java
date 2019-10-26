package com.BNU.pages.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][100.00,grow][][][][][][][][][14.00,grow][][][][]", "[][][][][]"));
		
		JLabel lblBcc = new JLabel("BCC");
		contentPane.add(lblBcc, "cell 8 0");
		
		JLabel lblMesages = new JLabel("Mesages");
		contentPane.add(lblMesages, "cell 16 0");
		
		JLabel lblSearchByClass = new JLabel("Search By Class");
		contentPane.add(lblSearchByClass, "cell 4 3");
		
		JLabel lblSearchByProcessor = new JLabel("Search by Professor");
		contentPane.add(lblSearchByProcessor, "cell 13 3");
		
		JComboBox comboBox = new JComboBox();
		contentPane.add(comboBox, "cell 4 4,growx");
		
		JLabel lblImage = new JLabel("Image");
		contentPane.add(lblImage, "cell 8 4");
		
		JComboBox comboBox_1 = new JComboBox();
		contentPane.add(comboBox_1, "cell 13 4,growx");
	}

}
