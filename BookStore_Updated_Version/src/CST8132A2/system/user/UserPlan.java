package CST8132A2.system.user;

import CST8132A2.system.exception.UserException;
import CST8132A2.system.util.SystemUtil;

public class UserPlan {

    public enum planType{
        TRIAL, STANDARD, VIP
    }

    private boolean isActive;
    private planType plan;

    public UserPlan(boolean active, planType plan) {
   this.isActive = active;
   this.plan = plan;
    	
	}

	// create plan type
    public UserPlan createPlan(String active, String plan) throws UserException{
        SystemUtil util = new SystemUtil();
        if(!util.isValid(active)) {
        	throw new UserException("plan cannot be empty, null or blank.");
        }
        
        switch(active.toLowerCase()) {
        case "false":
        	this.isActive = false;
        	break;
        case "true":
        	this.isActive = true;
        	break;
        	default:
        		throw new UserException(" Invalid Activation type " + active);
        }
        
        boolean result = Boolean.valueOf(active);
        
        if(!util.isValid(plan)){
            throw new UserException("plan cannot be empty, null or blank.");
        }
        
        switch(plan.toUpperCase()){
            case "TRIAL":
            this.plan = planType.TRIAL;
           
            break;

            case "STANDARD":
            this.plan = planType.STANDARD;
            break;

            case "VIP":
            this.plan = planType.VIP;
            break;

            default:
            throw new UserException(" Invalid Plan type" + plan);
        }
        
        planType type = planType.valueOf(plan);
		return new UserPlan(result, type);
    }

    public planType getPlan(){
        return plan;
    }

    public void setPlan(planType plan){
        this.plan = plan;
    }

    public boolean getIsActive(){
        return isActive;
    }

    public void setIsActive(boolean isActive){
        this.isActive = isActive;
    }
    public String toStringPlan(){
        return ", IsActive: " + isActive + ", Plan: " + plan;
    }

}
