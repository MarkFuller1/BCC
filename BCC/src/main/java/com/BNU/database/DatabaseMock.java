package com.BNU.database;

public class DatabaseMock implements dbWrapper{
	
	@Override
	public String[] getAllProfessors() {
		String [] professors = new String[3];
		professors[0] = "Professor one";
		professors[1] = "Professor two";
		professors[2] = "Professor three";
		
		return professors;
	}

	@Override
	public String[] getAllClasses() {
		String [] classes = new String[3];
		classes[0] = "class one";
		classes[1] = "class two";
		classes[2] = "class three";
		
		return classes;
	}

	@Override
	public String[] getPossibleClasses() {
		String [] classes = new String[16];
		classes[0] = "CSI 1430";
		classes[1] = "CSI 1440";
		classes[2] = "CSI 2350";		
		classes[3] = "CSI 2334";
		classes[4] = "CSI 3334";
		classes[5] = "CSI 3471";		
		classes[6] = "CSI 3344";
		classes[7] = "CSI 3336";
		classes[8] = "CSI 3335";		
		classes[9] = "CSI 3372";
		classes[10] = "CSI 3439";
		classes[11] = "CSI 4337";	
		classes[12] = "CSI 4321";
		classes[13] = "PHI 1310";
		classes[14] = "CSI 43C9";
		classes[15] = "CSI 4330";
		return classes;
	}
}
