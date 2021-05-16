package Shop;

import Shop.WorkerPackage.Catalog;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

//        Catalog catalog = new Catalog();
//        catalog.readShoeList();

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
