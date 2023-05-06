import com.oct.cntrl.*;
import com.oct.DAO.*;
import com.oct.UI.*;
import com.oct.model.*;
import com.oct.services.*;

import java.util.*;

/**
 * Driver for the project, contains main
 * 
 * @author Octavian Ionescu
 */
public class EventDriver implements FileHandling {
   
    public static void main(String[] args) throws Exception {
        Events events = new Events();
        Utility util = new Utility();
        
        Scanner ch = new Scanner(System.in);
        int sel = Menu.menuExp(ch);
        while(sel != 8){//WHILE sel IS NOT EQUAL TO EXIT CLAUSE
            Controller.implementChoice(sel, ch, events);
            Menu.pressEnterKeyToContinue();
            sel = Menu.menuExp(ch);
        }
        util.close(events);

    }
}
