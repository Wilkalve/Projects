package CST8132A2.system.user;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import CST8132A2.system.exception.UserException;

public class UserList {
ArrayList<User> users = new ArrayList<>();
// Add new user to the list
    public void addUser(User newUser) throws UserException{
        users.add(newUser);
    }
    
// Load User 
    public void loadUserList(String file) throws UserException{
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while((line = br.readLine()) != null){

               String[] usr = line.split(",");
               User user = new User ();
               UserPlan plan = new UserPlan(false, null);
               plan.createPlan("true", "TRIAL");
               user = new User (usr[0], usr[1], plan);
               
        	   users.add(user);
        	   
            }
            br.close();
            System.out.println("UserList loaded successfully.");
        } catch(FileNotFoundException fne){
            throw new UserException("" + fne);
        }catch(IOException e){
            throw new UserException("" + e);
        }
      
    }
    
    // Print User list
    public void printUserList() throws UserException{
    
        if(users.isEmpty() || users == null){
            System.out.println("The Users list is empty ");
        }
        else{
            
            for (User usrs : users) {
                    getSizeUser();	
                    System.out.println(usrs);
                    break;
                }
           }
    }
     	// return arraylist size
	public void getSizeUser() throws UserException {
		
		for (int i = 0; i < users.size(); i++) {

			System.out.println((i + 1) + ". " + users.get(i).tostringUser());
		}
	}
    
 // save user list
    public void saveUserList(String fileName) throws UserException{

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))){

            for(User user: users){
                bw.write(user.getEmail() + "," + user.getPassword() + "," + user.getPlan());
                bw.newLine();
                
            }
            bw.close();
            System.out.println("Users successfully save to the list.");
        } catch(IOException e){
            throw new UserException("" + e);
        }
    }
// update user account
    public void updateUser(int index, String password) throws UserException{
        User update = users.get(index);
        update.setPassword(password);
        
    }
    public void updater(int index) {
    	User update = users.get(index);
    }

	public ArrayList<User> getIndex() {
		return users;
	}
    
}
