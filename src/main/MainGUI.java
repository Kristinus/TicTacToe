package main;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import listeners.MouseController;


public class MainGUI extends JPanel {
	
	private Main main;
	private MainComponent component;
	
	MainGUI (Main main) {
		super();
		this.main = main;
		createComponents();
		createPanel();
		this.main.setGUI(this);
		registerControllers();
	}
	
	/**
	 * Initialize and set values to all needed components.
	 */
	private void createComponents() {
		//Sub-Views
		component = new MainComponent(main);
	}
	
	/**
	 * Set up the components in the panel layout.
	 */
	private void createPanel() {
		this.setLayout(new BorderLayout());
		this.add(component, BorderLayout.CENTER);
	}
	
	public MainComponent getComponent() {
		return this.component;
	}
	
	/**
	 * Register listeners to sub-components.
	 */
	private void registerControllers() {
		MouseController controller = new MouseController(main);
		component.addMouseListener(controller);
	}
	
	/**
	 * Updates the sub-components as well as labels.
	 */
	public void update() {
		component.repaint();
	}
}
