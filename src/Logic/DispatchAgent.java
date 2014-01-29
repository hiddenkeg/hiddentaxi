package Logic;

import java.util.Calendar;


public class DispatchAgent {
    private String name;        // need to discuss if the agent general attributes go here

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void placeOrder(String userId,String origin, String destination, Boolean immediate,Boolean auto,Calendar scheduledTime){
        // need to find the user here, for now i'm creating one
        User user = new User(userId);
        System.out.println(user.userId+" from "+origin+" to "+destination);
        if(!immediate){
            System.out.println("Adding Order");
            Order temp = new Order(user,origin,destination,immediate,auto,scheduledTime);
            ListManager.addScheduledList(temp.getOrderId(),temp);
        }
        else if(auto){
            Order temp = new Order(user,origin,destination,immediate,auto);
            ListManager.addAutoList(temp);
        }
        else{
            Order temp = new Order(user,origin,destination,immediate,auto);
            ListManager.addMainManualList(temp);
        }
    }
    
    public void processManualList(){
        Order currentOrder = ListManager.removeMainManualList();
        
        // prosses the order
        
        ListManager.addProcessingList(currentOrder);
    }
    
}
