package bank.view;

import bank.controller.Bank;
import view.AddPersonalAccountDialog;

public class BankAddPersonalAccountDialog extends AddPersonalAccountDialog{
	
	private BankWindow parentframe;
	public javax.swing.JRadioButton JRadioButton_Chk = new javax.swing.JRadioButton();
	public javax.swing.JRadioButton JRadioButton_Sav = new javax.swing.JRadioButton();

	public javax.swing.JTextField JTextField_BD = new javax.swing.JTextField();
	public javax.swing.JLabel JLabel7 = new javax.swing.JLabel();

	public BankAddPersonalAccountDialog(BankWindow parent) {
		super(parent);
		parentframe = parent;
		JRadioButton_Chk.setText("Checkings");
		JRadioButton_Chk.setActionCommand("Checkings");
		getContentPane().add(JRadioButton_Chk);
		JRadioButton_Chk.setBounds(36,12,84,24);
		JRadioButton_Sav.setText("Savings");
		JRadioButton_Sav.setActionCommand("Savings");
		getContentPane().add(JRadioButton_Sav);
		JRadioButton_Sav.setBounds(36,36,84,24);
		
		JLabel7.setText("Birthdate");
		getContentPane().add(JLabel7);
		JLabel7.setForeground(java.awt.Color.black);
		JLabel7.setBounds(12,204,96,24);
		
		JLabel6.setBounds(12,228,48,24);
		JTextField_EM.setBounds(84,228,156,20);
		getContentPane().add(JTextField_BD);
		JTextField_BD.setBounds(84,204,156,20);
		
		SymMouse aSymMouse = new SymMouse();
		JRadioButton_Chk.addMouseListener(aSymMouse);
		JRadioButton_Sav.addMouseListener(aSymMouse);
	}
	
	class SymMouse extends java.awt.event.MouseAdapter
	{
		public void mouseClicked(java.awt.event.MouseEvent event)
		{
			Object object = event.getSource();
			if (object == JRadioButton_Chk)
				JRadioButtonChk_mouseClicked(event);
			else if (object == JRadioButton_Sav)
				JRadioButtonSav_mouseClicked(event);
		}
	}

	void JRadioButtonChk_mouseClicked(java.awt.event.MouseEvent event)
	{
		//When Checking radio is clicked make this radio on 
		//and make Saving account radio off
		JRadioButton_Chk.setSelected(true);
		JRadioButton_Sav.setSelected(false);
		
		
	}

	void JRadioButtonSav_mouseClicked(java.awt.event.MouseEvent event)
	{
		//When Saving radio is clicked make this radio on 
		//and make Checking account radio off
		JRadioButton_Chk.setSelected(false);
		JRadioButton_Sav.setSelected(true);
	 
	}
	
	@Override
	public void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
	{
		parentframe.param.setAccountNumber(JTextField_ACNR.getText());
		parentframe.param.setCustomerName(JTextField_NAME.getText());
		parentframe.param.setStreetName(JTextField_STR.getText());
		parentframe.param.setCity(JTextField_CT.getText());
		parentframe.param.setZip(JTextField_ZIP.getText());
		parentframe.param.setState(JTextField_ST.getText());
		parentframe.param.setCustomerEmail(JTextField_EM.getText());
		parentframe.param.setBirthdate(JTextField_BD.getText());
		
		System.out.println("asda" + parentframe.param.getCustomerName());
		if (JRadioButton_Chk.isSelected()) {
    	   parentframe.param.setAccountType("Ch");
           Bank.createPersonalCheckingAccount(parentframe.param);
           System.out.println("here");
		}
		else {
    	   parentframe.param.setAccountType("S");
           Bank.createPersonalSavingAccount(parentframe.param);
		}
		
		parentframe.proceedFromDialog=true;
		dispose();
			 
	}

}
