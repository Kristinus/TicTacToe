package listeners;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import main.MessageDialog;
import main.Main;

public class MouseController implements MouseListener {

	private Main main;
	
	public MouseController (Main main) {
		super();
		this.main = main;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		Point location = new Point(e.getX(), e.getY());
		int sym = main.getCurrentSym();
		if (main.isAvailable(location)) {
			main.setPosn(sym, location);
		} else {
			new MessageDialog((JFrame)SwingUtilities.getWindowAncestor(main.getGUI()), "Invalid Input");
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
