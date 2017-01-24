package main;

import javax.swing.*;
import java.awt.*;

/**
 * @author Bryan Kristiono
 * @since 09/12/15
 */
public class MessageDialog extends JDialog {
	/*		Attributes		*/
	private JFrame frame; 	//Frame for error dialog
	private JPanel panel; 	//Panel containing error text
	private String message; //Text describing error
	private JLabel label; 	//Label containing error message

	/**
	 * Creates a new instance of the class with required information.
	 * @param jFrame 		The main frame that the dialog is displaying over
	 * @param errorMessage 	The message that describes the error that occurred
	 */
	public MessageDialog(JFrame jFrame, String message) {
		super(jFrame, "Announcement", true);
		this.frame = jFrame;
		this.message = "<html>" + message + "</html>";
		this.createComponents();
		this.createDialog();
	}

	/**
	 * Creates panel and label for message.
	 */
	private void createComponents() {
		panel = new JPanel(new BorderLayout());
		panel.setPreferredSize(new Dimension(350, 125));
		label = new JLabel(message, SwingConstants.CENTER);
	}

	/**
	 * Adds text to panel and creates frame.
	 */
	private void createDialog() {
		panel.add(label, BorderLayout.CENTER);
		this.setContentPane(panel);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(frame);
		this.setResizable(false);
		this.setVisible(true);
	}
}
