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
    private boolean loggedin=false;
    private String Username=null;
    private String first_name=null;
    private String last_name=null;
    private String email=null;
    public boolean gotuserpic=false;
    public void LoggedIn(){
        
    }
    
    //Get and Set Methods for User Details to be displayed in Profile.jsp
    
    public void setUsername(String name){
        this.Username=name;
    }

    public void setfirst_name(String first_name){
        this.first_name=first_name;
    }
    
    public void setlast_name(String last_name){
       this.last_name=last_name;
    }

    public void setEmail(String Email){
        this.email=Email;
    }
    public String getUsername(){
        return Username;
    }
    
        public String getfirst_name(){
        return first_name;
    }
        
        public String getlast_name(){
        return last_name;
    }
    public String getEmail(){
        return email;
    }
    public void setLoggedin(){
        loggedin=true;
    }
    public void setLoggedout(){
        loggedin=false;
    }
    
    public void setLoginState(boolean logedin){
        this.loggedin=logedin;
    }
    public boolean getlogedin(){
        return loggedin;
    }

    public void setEmail(String[] email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
