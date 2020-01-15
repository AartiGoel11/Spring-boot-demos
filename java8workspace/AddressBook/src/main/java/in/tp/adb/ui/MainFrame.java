package in.tp.adb.ui;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import in.tp.adb.controller.AddressBookApplication;
import in.tp.adb.exception.ADBException;
import in.tp.adb.exception.ADBValidationException;
import in.tp.adb.model.Contact;

public class MainFrame extends JFrame implements ActionListener {

	JTable dataTable = null;
	JLabel lblStatus = null;
	JLabel lblDateTime = null;
	boolean shallShowTime = true;

	public MainFrame() {
		setTitle("Address Book");
		setBounds(50, 50, 600, 400);

		JMenuBar mb = new JMenuBar();
		setJMenuBar(mb);

		JMenu fileMenu = mb.add(new JMenu("File"));
		fileMenu.setMnemonic('F');

		fileMenu.add(MenuCommands.New.toString()).addActionListener(this);
		fileMenu.addSeparator();
		fileMenu.add(MenuCommands.Edit.toString()).addActionListener(this);
		fileMenu.add(MenuCommands.Delete.toString()).addActionListener(this);
		fileMenu.addSeparator();
		fileMenu.add(MenuCommands.Exit.toString()).addActionListener(this);

		dataTable = new JTable();
		this.add(new JScrollPane(dataTable));

		lblStatus = new JLabel();
		lblDateTime = new JLabel();

		JPanel statusBar = new JPanel(new GridLayout(1, 3));
		statusBar.add(lblStatus);
		statusBar.add(new JLabel("All Rights Reserved"));
		statusBar.add(lblDateTime);

		this.add(statusBar, BorderLayout.SOUTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent event) {
				shallShowTime = false;
				super.windowClosed(event);
			}
		});

		(new Thread(() -> {
			while (shallShowTime) {
				lblDateTime.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm:ss")));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			}
		})).start();
	}

	public void loadData() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Contact#");
		model.addColumn("Contact Name");
		model.addColumn("Mobile Number");
		model.addColumn("Mail Id");

		List<Contact> contacts;
		try {
			contacts = AddressBookApplication.service.getAllContacts();
			if (contacts != null) {
				contacts.stream().forEach((c) -> {
					model.addRow(new Object[] { c.getContactId(), c.getName(), c.getMobile(), c.getMailId() });
				});
			}
		} catch (ADBException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

		lblStatus.setText(model.getRowCount() + " Record(s) Found!");
		this.dataTable.setModel(model);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		MenuCommands cmd = MenuCommands.valueOf(event.getActionCommand());

		switch (cmd) {
		case New:
			doNew();
			break;
		case Edit:
			doEdit();
			break;
		case Delete:
			doDelete();
			break;
		case Exit:
			this.dispose();
			break;
		}
	}

	private void doNew() {
		ContactFormDialog dialog = new ContactFormDialog(this, null);
		try {
			AddressBookApplication.service.addContact(dialog.getContact());
		} catch (ADBValidationException | ADBException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Could Not Add", JOptionPane.ERROR_MESSAGE);
		}		
		loadData();
	}

	private void doEdit() {
		String contactIdStr = JOptionPane.showInputDialog(this, "Enter a contact Id", "0");
		long contactId = Long.parseLong(contactIdStr);
	
		try {
			Contact contact = AddressBookApplication.service.getContactById(contactId);
			if(contact == null)
				JOptionPane.showMessageDialog(this, "Record Not Found", "Could Not Edit",
						JOptionPane.INFORMATION_MESSAGE);
			else {
				ContactFormDialog dialog = new ContactFormDialog(this,contact);
				try {
					AddressBookApplication.service.updateContact(dialog.getContact());
				} catch (ADBValidationException | ADBException e) {
					JOptionPane.showMessageDialog(this, e.getMessage(), "Could Not Update", JOptionPane.ERROR_MESSAGE);
				}		
				loadData();
			}
		} catch (ADBException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Could Not Delete", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void doDelete() {
		String contactIdStr = JOptionPane.showInputDialog(this, "Enter a contact Id", "Delete");
		long contactId = Long.parseLong(contactIdStr);
		try {
			if (AddressBookApplication.service.getContactById(contactId) == null)
				JOptionPane.showMessageDialog(this, "Record Not Found", "Could Not Delete",
						JOptionPane.INFORMATION_MESSAGE);
			else {
				AddressBookApplication.service.removeContact(contactId);
				loadData();
			}
		} catch (ADBException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Could Not Delete", JOptionPane.ERROR_MESSAGE);
		}
	}

	enum MenuCommands {
		New, Edit, Delete, Exit
	}
}
