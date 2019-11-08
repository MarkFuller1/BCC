package BNU.data;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainModel {
	// North Layout
	private JPanel north_Panel;
	private JLabel txt_Title;
	private JPanel north_center_Panel;
	private JButton log_out;

	// west panel
	private JPanel west_Panel;
	private JLabel txt_SearchClass;
	private JComboBox cb_SearchClass;
	public String[] west_cb_data;
	
	// center layout
	private JLabel txt_Image;
	private JPanel center_Panel;
	private JLabel txt_Messages;

	// east layout
	private JPanel east_Panel;
	private JLabel txt_SearchProfessor;
	private JComboBox cb_SearchProfessor;
	public String[] east_cb_data;
	
	private JButton btn_Message;
	private JPanel north_east_Panel;

	public JPanel getNorth_center_Panel() {
		return north_center_Panel;
	}

	public void setNorth_center_Panel(JPanel north_center_Panel) {
		this.north_center_Panel = north_center_Panel;
	}

	public JPanel getNorth_east_Panel() {
		return north_east_Panel;
	}

	public void setNorth_east_Panel(JPanel north_east_Panel) {
		this.north_east_Panel = north_east_Panel;
	}

	public String[] getWest_cb_data() {
		return west_cb_data;
	}

	public void setWest_cb_data(String[] west_cb_data) {
		this.west_cb_data = west_cb_data;
	}

	public String[] getEast_cb_data() {
		return east_cb_data;
	}

	public void setEast_cb_data(String[] east_cb_data) {
		this.east_cb_data = east_cb_data;
	}

	public JButton getBtn_Message() {
		return btn_Message;
	}

	public void setBtn_Message(JButton btn_Message) {
		this.btn_Message = btn_Message;
	}

	public JPanel getNorth_Panel() {
		return north_Panel;
	}

	public void setNorth_Panel(JPanel north_Panel) {
		this.north_Panel = north_Panel;
	}

	public JPanel getWest_Panel() {
		return west_Panel;
	}

	public void setWest_Panel(JPanel west_Panel) {
		this.west_Panel = west_Panel;
	}

	public JPanel getEast_Panel() {
		return east_Panel;
	}

	public void setEast_Panel(JPanel east_Panel) {
		this.east_Panel = east_Panel;
	}

	public JLabel getTxt_Title() {
		return txt_Title;
	}

	public void setTxt_Title(JLabel txt_Title) {
		this.txt_Title = txt_Title;
	}

	public JLabel getTxt_SearchClass() {
		return txt_SearchClass;
	}

	public void setTxt_SearchClass(JLabel txt_SearchClass) {
		this.txt_SearchClass = txt_SearchClass;
	}

	public JLabel getTxt_SearchProfessor() {
		return txt_SearchProfessor;
	}

	public void setTxt_SearchProfessor(JLabel txt_SearchProfessor) {
		this.txt_SearchProfessor = txt_SearchProfessor;
	}

	public JComboBox getCb_SearchProfessor() {
		return cb_SearchProfessor;
	}

	public void setCb_SearchProfessor(JComboBox cb_SearchProfessor) {
		this.cb_SearchProfessor = cb_SearchProfessor;
	}

	public JComboBox getCb_SearchClass() {
		return cb_SearchClass;
	}

	public void setCb_SearchClass(JComboBox cb_SearchClass) {
		this.cb_SearchClass = cb_SearchClass;
	}

	public JLabel getTxt_Image() {
		return txt_Image;
	}

	public void setTxt_Image(JLabel txt_Image) {
		this.txt_Image = txt_Image;
	}

	public JLabel getTxt_Messages() {
		return txt_Messages;
	}

	public void setTxt_Messages(JLabel txt_Messages) {
		this.txt_Messages = txt_Messages;
	}

	public JPanel getCenter_Panel() {
		return center_Panel;
	}

	public void setCenter_Panel(JPanel center_Panel) {
		this.center_Panel = center_Panel;
	}

	public JButton getLog_out() {
		return log_out;
	}

	public void setLog_out(JButton log_out) {
		this.log_out = log_out;
	}

	
	
}
