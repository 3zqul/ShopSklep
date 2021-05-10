package Shop;

import javax.swing.*;

public class Window {

	public JFrame frame;
	ImageIcon logo = new ImageIcon("C:\\Users\\bigos\\IdeaProjects\\ShopSklep\\src\\main\\java\\Pictures\\shoe10");

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
		frame = new JFrame("Shoe Shop");
		frame.setVisible(true);
		frame.setIconImage(logo.getImage());
		frame.setBounds(100, 100, 1200, 675);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
