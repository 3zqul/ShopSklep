package Shop;

import Shop.CustomerPackage.Customer;
import Shop.WorkerPackage.Catalog;
import Shop.WorkerPackage.Editor;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Window window = new Window();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
