package Shop;

import Shop.CustomerPackage.Customer;
import Shop.WorkerPackage.Catalog;
import Shop.WorkerPackage.Editor;

public class Main {

    public static void main(String[] args) {

        Editor editor = new Editor();
        editor.signIn("es", "es");
        editor.addShoe("Essa");
        editor.saveToFile();

//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    Window window = new Window();
//                    window.frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
    }
}
