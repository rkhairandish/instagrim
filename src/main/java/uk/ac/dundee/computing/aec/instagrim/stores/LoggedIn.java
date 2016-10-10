/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.dundee.computing.aec.instagrim.stores;

/**
 *
 * @author Administrator
 */
public class LoggedIn {
    boolean logedin=false;
    String Username=null;
    String email=null;
    public void LogedIn(){
        
    }
    
    //Get and Set Methods for User Details to be displayed in Profile.jsp
    
    public void setUsername(String name){
        this.Username=name;
    }
    public void setEmail(String Email){
        this.email=Email;
    }
    public String getUsername(){
        return Username;
    }
    public String getEmail(){
        return email;
    }
    public void setLogedin(){
        logedin=true;
    }
    public void setLogedout(){
        logedin=false;
    }
    
    public void setLoginState(boolean logedin){
        this.logedin=logedin;
    }
    public boolean getlogedin(){
        return logedin;
    }
}
