package Logic;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class Order {
    static int scheduleCounter=0;
    
    private String orderId;
    private User orderUser;
    private String status;
    private String destination;
    private String origin;
    private Boolean immediate;
    private Boolean auto;
    
    Timer timer;
    
    public Order(User user,String origin, String destination, Boolean immediate,Boolean auto){
        // need to initialize id here
        this.orderUser = user;
        this.origin = origin;
        this.destination=destination;
        this.immediate=immediate;
        this.auto=auto;
    }
    
    public Order(User user,String origin, String destination, Boolean immediate,Boolean auto,Calendar scheduledTime){
        scheduleCounter++;
        this.orderId = String.valueOf(scheduleCounter);
        // need to initialize id here
        this.orderUser = user;
        this.origin = origin;
        this.destination=destination;
        this.immediate=immediate;
        this.auto=auto;
        
        Date timeLeft = scheduledTime.getTime();
        timer = new Timer(this.orderId);
        timer.schedule(new TimeUp(orderId), timeLeft);
    }
    
    class TimeUp extends TimerTask {
        String orderId;
        @Override
        public void run() {
            System.out.format("Time's up! for order " +this.orderId+"\n");
            Order tempOrder = ListManager.removeScheduledList(this.orderId);
            System.out.println(tempOrder.orderId);
            ListManager.addAutoList(tempOrder);
            System.out.println("Added to auto list");
            // remove that extact object from list and add to auto
            timer.cancel(); //Terminate the timer thread
        }
        // overload run method to get order's id into this class
        TimeUp(String orderId){
            System.out.println(orderId);
            this.orderId=orderId;
        }
    }
    
    
    public String getOrderId(){
        return orderId;
    }
    public void setOrderId(String orderId){
        this.orderId=orderId;
    }
    public User getOrderUser(){
        return orderUser;
    }
    public void setOrderUser(User orderUser){
        this.orderUser = orderUser;
    }  
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status=status;
    }
    public String getDesination(){
        return destination;
    }
    public void setDestination(String destination){
        this.destination=destination;
    }
    public String getOrgin(){
        return origin;
    }
    public void setOrgin(String origin){
        this.origin=origin;
    }
    public Boolean getImmediate(){
        return immediate;
    }
    public void setImmediate(Boolean immediate){
        this.immediate=immediate;
    }
    public Boolean getAuto(){
        return auto;
    }
    public void setAuto(Boolean auto){
        this.auto=auto;
    }
    
}
