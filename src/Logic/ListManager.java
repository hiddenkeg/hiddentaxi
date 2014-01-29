package Logic;

import java.util.ArrayList;
import java.util.HashMap;


public class ListManager {
    // need a synchronized map for scheduled list
    /*
    Note that this implementation is not synchronized. If multiple threads access a hash map concurrently,
    and at least one of the threads modifies the map structurally, it must be synchronized externally. 
    (A structural modification is any operation that adds or deletes one or more mappings;
    merely changing the value associated with a key that an instance already contains is not a structural modification.)
    This is typically accomplished by synchronizing on some object that naturally encapsulates the map.
    If no such object exists, the map should be "wrapped" using the Collections.synchronizedMap method.
    This is best done at creation time, to prevent accidental unsynchronized access to the map:

    Map m = Collections.synchronizedMap(new HashMap(...));
    */
    static HashMap<String,Order> scheduledList = new HashMap<>();
    static ArrayList<Order> mainManualList = new ArrayList<>();
    static ArrayList<Order> autoList = new ArrayList<>();
    static ArrayList<Order> webManualList = new ArrayList<>();
    static ArrayList<Order> processingList = new ArrayList<>();
    
    
    static void addScheduledList(String orderId,Order order){
        // reserve a taxi here
        scheduledList.put(orderId,order);
    }
    static Order removeScheduledList(String orderId){
        
        return scheduledList.get(orderId);
    }
    static void addMainManualList(Order newOrder){
        // add logic
        mainManualList.add(newOrder);
    }
    static Order removeMainManualList(){
        return mainManualList.remove(mainManualList.size()-1);
    }
    static void addAutoList(Order newOrder){
        // dispatch the order here and wait in the list for a reposnse (check if coming from scheduled list cause a taxi is already arranged?)
        autoList.add(newOrder);
    }
    static Order removeAutodList(){
        // remove and add to processing list after sucessfull response
        return autoList.remove(autoList.size()-1);
    }
    static void addWebManualList(Order newOrder){
        // add and wait for dispatchers command to move
        webManualList.add(newOrder);
    }
    static Order removeWebManualList(){
        // remove and add to main manual list upon dispatchers response
        return webManualList.remove(webManualList.size()-1);
    }
    static void addProcessingList(Order newOrder){
        // update the list in display
        processingList.add(newOrder);
    }
    static Order removeProcessingList(){
        // remove and add record
        return processingList.remove(processingList.size()-1);
    }

       
    
}
