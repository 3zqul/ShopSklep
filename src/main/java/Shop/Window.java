package Shop;

import javax.swing.*;

public class Window {

	public JFrame frame;

	public Window() {
		initialize();
		Panels panels = new Panels();
		frame.add(panels);
	}

	public void switchPanel(JPanel panel){

		frame.removeAll();
		frame.add(panel);
		frame.repaint();
		frame.revalidate();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 1200, 675);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
