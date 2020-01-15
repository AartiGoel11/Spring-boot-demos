package in.tp.adb.controller;

import javax.swing.JOptionPane;

import org.apache.log4j.PropertyConfigurator;

import in.tp.adb.exception.ADBException;
import in.tp.adb.service.ContactService;
import in.tp.adb.service.ContactServiceImpl;
import in.tp.adb.ui.MainFrame;

public class AddressBookApplication {

	public static ContactService service = null;
	
	public static void main(String[] a) {
		
		try {
			service = new ContactServiceImpl();
		} catch (ADBException e) {
			JOptionPane.showMessageDialog(
					null,
					e.getMessage());
			System.exit(0);;
		}
		
		MainFrame frame = new MainFrame();
		frame.loadData();
		frame.setVisible(true);
		
	}
}
