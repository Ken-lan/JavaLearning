package SwingInvokeAndWaitExample;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.lang.reflect.InvocationTargetException;

/*
 * Restores XYZ database from a selected backup copy.
 */
public class DbRestoreApp {

	private JDialog dialog;
	private JTextArea messageArea;
	private JButton browseButton;
	private JButton restoreButton;
	private JButton closeButton;
	private JButton interruptButton;
	private boolean interruptButtonPressed;
	private boolean flag;
	private boolean status;
	private static final String NEWLINE = "\n";

	public static void main(String [] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				new DbRestoreApp();
			}
		});
	}

	public DbRestoreApp() {

		dialog = new JDialog();
		dialog.setTitle("XYZ Database Restore");
		
		// Text area and scrollpane
		messageArea = new JTextArea(5, 40);
		messageArea.setFont(new Font("SansSerif", Font.PLAIN, 16));
		messageArea.setLineWrap(true);
		messageArea.setEditable(false);
		messageArea.setCursor(null);  
		messageArea.setMargin(new Insets(5, 5, 5, 5));  
		messageArea.setFocusable(false);
		JScrollPane scrollPane = new JScrollPane(messageArea);
		scrollPane.setVerticalScrollBarPolicy(
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setPreferredSize(new Dimension(500, 150)); // dim w, h

		// Buttons
		JPanel panel = new JPanel();
		browseButton = new JButton("Select Database...");
		browseButton.addActionListener(new BrowseButtonListener());
		panel.add(browseButton);
		restoreButton = new JButton("Restore Database");
		restoreButton.addActionListener(new RestoreButtonListener());
		restoreButton.setEnabled(false);
		panel.add(restoreButton);
		interruptButton = new JButton("Interrupt");
		interruptButton.addActionListener(new InterruptButtonListener());
		interruptButton.setEnabled(false);
		panel.add(interruptButton);
		closeButton = new JButton("Close");
		closeButton.addActionListener(new CloseButtonListener());
		panel.add(closeButton);

		// Layout widgets
		Container pane = dialog.getContentPane();
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c1 = new GridBagConstraints();
		c1.fill = GridBagConstraints.HORIZONTAL;
		c1.gridx = 0;
		c1.gridy = 1;
		c1.insets = new Insets(12, 12, 17, 11);  // top, l, bottom, r padding
		pane.add(scrollPane, c1);	
		GridBagConstraints c2 = new GridBagConstraints();
		c2.anchor = GridBagConstraints.CENTER;
		c2.gridx = 0;
		c2.gridy = 2;
		c2.insets = new Insets(0, 0, 11, 0);
		pane.add(panel, c2);
		
		// Finish dialog
		dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		dialog.setLocation(300, 200); // x, y
		dialog.setResizable(false);
		dialog.pack();
		dialog.setVisible(true);
		browseButton.requestFocusInWindow();
	}

	/*
	 * Listener class for browse for backup directory action button.
	 */
	private class BrowseButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String RESTORE_DIR_SELECTED =
					"The database restore directory selected: ";
			String CHOOSER_TITLE =
					"Select a database backup directory to restore from";
	
			JFileChooser chooser = new JFileChooser("C:\\");
			chooser.setDialogTitle(CHOOSER_TITLE);
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

			int state = chooser.showDialog(dialog, "Select");
					
			if (state == JFileChooser.APPROVE_OPTION) {
			
				String selectDir = chooser.getSelectedFile().toString();
				messageArea.append(RESTORE_DIR_SELECTED + selectDir + NEWLINE);
				restoreButton.setEnabled(true);
				restoreButton.requestFocus();
			}
			else if (state == JFileChooser.CANCEL_OPTION) {
				// do nothing
			}
			else { // JFileChooser.ERROR_OPTION if an error occurs.

				System.out.println("JFileChooser.ERROR_OPTION");
			}
		}
	}

	/*
	 * Listener class for restore action button. Restores database. 
	 * Displays status in the message area.
	 */
	private class RestoreButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
		
			System.out.println("actionPerformed isEventDispatchThread: " +
								SwingUtilities.isEventDispatchThread());
		
			final String RESTORE_START =
				"Database restore begins.";
			final String RESTORE_SUCCESS =
				"Database is successfully restored.";
			final String RESTORE_FAILURE = 
				"Database restore failed or interrupted.";
				
			interruptButtonPressed = false;

			final Runnable runInitially = new Runnable() {
			
				public void run() {

					// These GUI actions need to be completed before
					// the doDbRestore()
					restoreButton.setEnabled(false);
					closeButton.setEnabled(false);
					browseButton.setEnabled(false);
					interruptButton.setEnabled(true);
					messageArea.append(RESTORE_START + NEWLINE);
					System.out.println("invokeAndWait isEventDispatchThread: " +
										SwingUtilities.isEventDispatchThread());
				}
			};
 
			// This listener action code is to run in an non event dispatch thread.
			// For that, this is run using the SwingUtilities.invokeAndWait(),
			// which cannot be called from the EDT.
			Thread appThread = new Thread() {
			
				public void run() {
				
					System.out.println("appThread isEventDispatchThread: " +
										SwingUtilities.isEventDispatchThread());
					try {
						SwingUtilities.invokeAndWait(runInitially);
					}
					catch (InterruptedException | InvocationTargetException ex) {
							
						ex.printStackTrace();
					}
					
					boolean restoreStatus = doDbRestore();

					if (restoreStatus) {

						messageArea.append(RESTORE_SUCCESS + NEWLINE);
					}
					else {
						messageArea.append(RESTORE_FAILURE + NEWLINE);
					}

					messageArea.setCaretPosition(messageArea.getText().length() - 1);
					
					Toolkit.getDefaultToolkit().beep();
					browseButton.setEnabled(true);
					closeButton.setEnabled(true);
					interruptButton.setEnabled(false);
				} // run()
			}; // Thread
			
			appThread.start();

		} // actionPerformed()
	}

	private boolean doDbRestore() {
		/*
		 * Runs the database restore routine in a separate thread. 
		 * Returns success/error status.
		 */
		 
		final String RESTORE_PROGRESS = 
				"Database restore in progress (takes few seconds)...";
		final String INTERRUPT_PROGRESS = "Process interrupted by user.";
		flag = true;
		status = true;

		Thread thread = new Thread(new Runnable() {

			public void run() {
	
				messageArea.append(RESTORE_PROGRESS + NEWLINE);
				
				try {
					Thread.sleep(1000 * 20); // 20 secs
				} 
				catch(InterruptedException ex) {
					
					ex.printStackTrace();
					messageArea.append(INTERRUPT_PROGRESS + NEWLINE);
					status = false;
				}
				
				flag = false;
			}
		});
		
		thread.start();
		
		while(flag) {
		
			if (interruptButtonPressed) {
			
				thread.interrupt();
				flag = false;
			}
		}
		
		try {
			thread.join(); // current thread waits until the restore process
						   // thread completes
		}
		catch(InterruptedException ex) {
		
			ex.printStackTrace();
			status = false;
		}
		
		return status;
	}
	
	private class InterruptButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			interruptButtonPressed = true;
		}
	}

	private class CloseButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			dialog.dispose();
			System.exit(0);
		}
	}
}