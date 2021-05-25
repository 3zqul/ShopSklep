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
        catalog.readShoeList(admin.returnOfferMap());
        Map<Integer, Integer> idMap = new HashMap<>();
        for(int i =0 ; i<catalog.shoeList.size(); i++) {
            idMap.put(catalog.shoeList.get(i).shoeID,0);
        }
        int idToMap;
        for(int i =1 ; i<=catalog.shoeList.size(); i++){
            for(int j =1 ; j<=admin.orderMap.size(); j++){
                if(i==admin.orderMap.get(j).returnShoeID()){
                    idToMap = idMap.get(i);
                    idToMap+=1;
                    idMap.put(i, idToMap++);
                }
            }
        }
        for(int i = 1; i<=idMap.size();i++){
        }
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
        int index=0, max=0;
        for(int i = 0; i<tab.length; i++){
            if(tab[i]>max){
                max = tab[i];
                index=i;
            }
        }
        mostPopularShoe =catalog.shoeList.get(index*8+1).shoeName;
        System.out.println(mostPopularShoe);
        return mostPopularShoe;
    }

    public String updateMostPopularSize(){

        Map<String, Integer> nameStastistic = new HashMap<>();
        List<String> sizeList = new ArrayList<>();
        sizeList.add("45");
        sizeList.add("38");
        sizeList.add("39");
        sizeList.add("40");
        sizeList.add("41");
        sizeList.add("42");
        sizeList.add("43");
        sizeList.add("44");
        Administrator admin = new Administrator();
        Catalog catalog = new Catalog();
        admin.readOrderData();
        admin.readOfferData();
        catalog.readShoeList(admin.returnOfferMap());
        Map<Integer, Integer> idMap = new HashMap<>();
        int[] sizeTab={0,0,0,0,0,0,0,0}; //45,38...44
        for(int i =1 ; i<=admin.orderMap.size(); i++){
            sizeTab[admin.orderMap.get(i).returnShoeID()%8]+=1;
        }
        int index=0, max=0;
        for(int i = 0; i<sizeTab.length; i++){
            if(sizeTab[i]>max){
                max = sizeTab[i];
                index=i;
            }
        }
        mostPopularSize =sizeList.get(index);
        System.out.println(mostPopularSize);

        return mostPopularSize;
    }
}