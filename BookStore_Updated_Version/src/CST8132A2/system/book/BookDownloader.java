package CST8132A2.system.book;

import CST8132A2.system.exception.BookException;

import CST8132A2.system.exception.UserException;
import CST8132A2.system.user.User;
import CST8132A2.system.user.UserPlan;

public interface BookDownloader {

   public static boolean download(User user) throws UserException, BookException{
	
		UserPlan plan = new UserPlan(false, null);
        plan.createPlan("true", "VIP");
        
		return user.getPlan() == plan;
	}
}
