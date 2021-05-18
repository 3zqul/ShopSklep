package Shop;

import Shop.WorkerPackage.Catalog;
import Shop.WorkerPackage.Shoe;

import java.util.ArrayList;

public class CatalogForPanels extends Catalog {

    ArrayList<Shoe> shoeList = new ArrayList<>();

    public CatalogForPanels(ArrayList<Shoe> shoeList){
        this.shoeList=shoeList;
    }
}
