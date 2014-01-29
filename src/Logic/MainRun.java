
package Logic;

import Terminals.DispatchAgentTerminal;
import java.util.Calendar;

public class MainRun {
    
    public void execute(){
        
        DispatchAgent kasun = new DispatchAgent();
        kasun.setName("Kasun");
        DispatchAgentTerminal dat = new DispatchAgentTerminal(kasun);
        dat.setVisible(true);
        
        
        Calendar setTime1 = Calendar.getInstance();
        setTime1.add(Calendar.SECOND,3);
        Calendar setTime2 = Calendar.getInstance();
        setTime2.add(Calendar.SECOND,5);
        
        kasun.placeOrder("dumUser1", "colombo", "Apura", Boolean.FALSE, Boolean.TRUE, setTime1);
        kasun.placeOrder("dumUser2", "colombo", "ksjbka", Boolean.FALSE, Boolean.TRUE, setTime2);
    }
    
    
    public static void main(String... args){
        MainRun mr = new MainRun();
        mr.execute();
    }
}
