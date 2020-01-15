package in.tp.adb.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import in.tp.adb.controller.AddressBookApplication;
import in.tp.adb.exception.ADBValidationException;
import in.tp.adb.model.Contact;

public class ContactFormDialog extends JDialog{

	Contact contact;
	
	JLabel lblContactId=new JLabel("Contact Id"),
			lblName=new JLabel("Name"),
			lblMobile=new JLabel("Mobile"),
			lblMail=new JLabel("Mail Id");
	
	JLabel lblContactIdErr=new JLabel(),
			lblNameErr=new JLabel(),
			lblMobileErr=new JLabel(),
			lblMailErr=new JLabel();
	
	JTextField txtContactId=new JTextField(),
			txtName=new JTextField(),
			txtMobile=new JTextField(),
			txtMail=new JTextField();
	
	JButton bSave = new JButton("Save");
	
	public ContactFormDialog(JFrame owner,Contact contact) {
		super(owner,true);
		this.contact=contact;
		
		JPanel pForm = new JPanel(null);
		JPanel pBottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		add(pForm);
		add(pBottom,BorderLayout.SOUTH);
		
		pBottom.add(bSave);
		
		addComponent(lblContactId, pForm, 20, 20, 250, 20);
		addComponent(txtContactId, pForm, 25, 45, 250, 20);
		addComponent(lblContactIdErr, pForm, 25, 70, 250, 20);
		
		addComponent(lblName, pForm, 20, 100, 250, 20);
		addComponent(txtName, pForm, 25, 125, 250, 20);
		addComponent(lblNameErr, pForm, 25, 150, 250, 20);
		
		addComponent(lblMobile, pForm, 20, 180, 250, 20);
		addComponent(txtMobile, pForm, 25, 205, 250, 20);
		addComponent(lblMobileErr, pForm, 25, 230, 250, 20);
		
		addComponent(lblMail, pForm, 20, 260, 250, 20);
		addComponent(txtMail, pForm, 25, 285, 250, 20);
		addComponent(lblMailErr, pForm, 25, 310, 250, 20);
		
		if(contact!=null) {
			txtContactId.setEditable(false);
			txtContactId.setText(String.valueOf(contact.getContactId()));
			txtName.setText(contact.getName());
			txtMobile.setText(contact.getMobile());
			txtMail.setText(contact.getMailId());
		}
		
		bSave.addActionListener((event)->{
			Contact contactTemp = new Contact();
			contactTemp.setContactId(Long.parseLong(txtContactId.getText()));
			contactTemp.setName(txtName.getText());
			contactTemp.setMobile(txtMobile.getText());
			contactTemp.setMailId(txtMail.getText());
			
			try {
				if(AddressBookApplication.service.isValidContact(contactTemp)) {
					ContactFormDialog.this.contact=contactTemp;
					ContactFormDialog.this.dispose();
				}
			} catch (ADBValidationException e) {
				lblContactIdErr.setText(e.getErrorOfField("contactId"));
				lblNameErr.setText(e.getErrorOfField("name"));
				lblMailErr.setText(e.getErrorOfField("mailId"));
				lblMobileErr.setText(e.getErrorOfField("mobile"));
			}
		});
		
		setTitle("Contact Form");
		setBounds(65,75,300,400);
		setVisible(true);
	}
	
	public Contact getContact() {
		return contact;
	}
	
	private void addComponent(JComponent c,Container ct,int x,int y,int w,int h) {
		c.setBounds(x,y,w,h);
		ct.add(c);
	}	
}
