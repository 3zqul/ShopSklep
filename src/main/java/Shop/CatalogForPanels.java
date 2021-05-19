package Shop;

import Shop.WorkerPackage.Catalog;
import Shop.WorkerPackage.Shoe;

import java.util.ArrayList;

public class CatalogForPanels extends Catalog {

    ArrayList<Shoe> aShoeList = new ArrayList<>();

    public void assign(){

        aShoeList = shoeList;
    }

}