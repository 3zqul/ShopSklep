package Shop;

import javax.swing.*;

public class Window {

	public JFrame frame;
	ImageIcon shoe10 = new ImageIcon("D:\\Shop\\src\\main\\java\\Images\\shoe10.png");

	public Window() {
		initialize();
		Panels panel = new Panels(frame);
		frame.add(panel);
	}



	private void initialize() {
		frame = new JFrame("Shoe Shop");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setIconImage(shoe10.getImage());
		frame.setBounds(100, 100, 1200, 675);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
