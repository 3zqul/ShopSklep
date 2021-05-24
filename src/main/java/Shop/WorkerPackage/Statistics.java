package Shop.WorkerPackage;

import Shop.CustomerPackage.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    int accountCount;
    int orderCount;
    int offerCount;
    String mostPopularShoe;
    String mostPopularSize;

    public Statistics() {}

    public int updateAccountCount(){
        Administrator admin = new Administrator();
        admin.readCustomerData();
        this.accountCount= admin.returnCustomerMapSize();
        return accountCount;
    }

    public int updateOrderCount(){
        Administrator admin = new Administrator();
        admin.readOrderData();
        this.orderCount = admin.returnOrderMap().size();
        return orderCount;
    }

    public int updateOfferCount(){
        Administrator admin = new Administrator();
        admin.readOfferData();
        this.offerCount = admin.returnOfferMap().size();
        return offerCount;
    }

    public String updateMostPopularShoe(){

        Map<String, Integer> nameStastistic = new HashMap<>();
        Administrator admin = new Administrator();
        Catalog catalog = new Catalog();
        admin.readOrderData();
        admin.readOfferData();
        admin.returnOrderMap();
        catalog.readShoeList(admin.returnOfferMap());

        Map<Integer, Integer> idMap = new HashMap<>();
        for(int i =0 ; i<catalog.shoeList.size(); i++) {
            idMap.put(catalog.shoeList.get(i).shoeID,0);
        }
        int essa;
        for(int i =1 ; i<=catalog.shoeList.size(); i++){
            for(int j =1 ; j<=admin.orderMap.size(); j++){
                if(i==admin.orderMap.get(j).returnShoeID()){
                    essa = idMap.get(i);
                    essa+=1;
                    idMap.put(i, essa++);
                }
            }
        }
        for(int i = 1; i<=idMap.size();i++){
            System.out.println(idMap.get(i));
        }
        System.out.println();
        Map<Integer, Integer> shoesMap = new HashMap<>();
        int j=1;
        int[] tab = new int[4];
        for(int i = 1; i<=catalog.shoeList.size(); i++){
            tab[j-1]+=idMap.get(i);
            shoesMap.put(j, tab[j-1]);
            if((i%8)==0){
                j++;
            }
        }
        for(int i = 1; i<j;i++){
            System.out.println(shoesMap.get(i));
        }
        return mostPopularShoe;
    }
}
