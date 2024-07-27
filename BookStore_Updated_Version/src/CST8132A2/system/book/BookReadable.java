package CST8132A2.system.book;

import CST8132A2.system.exception.BookException;
import CST8132A2.system.user.User;
import CST8132A2.system.user.UserPlan;

public interface BookReadable {

    public static boolean read(User read) throws BookException{
    	
        UserPlan plan = new UserPlan(false, null);
       
         if(plan.getIsActive() == true);
         return read.getPlan() == plan;  
    }

}
