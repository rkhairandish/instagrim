/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.dundee.computing.aec.instagrim.models;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import uk.ac.dundee.computing.aec.instagrim.lib.AeSimpleSHA1;
import uk.ac.dundee.computing.aec.instagrim.stores.Pic;

/**
 *
 * @author Administrator
 */
public class User {
    Cluster cluster;
    public User(){
        
    }
    
    public boolean RegisterUser(String username, String first_name, String last_name, String email, String Password){
        AeSimpleSHA1 sha1handler=  new AeSimpleSHA1();
        String EncodedPassword=null;
        try {
            EncodedPassword= sha1handler.SHA1(Password);
        }catch (UnsupportedEncodingException | NoSuchAlgorithmException et){
            System.out.println("Can't check your password");
            return false;
        }
        Session session = cluster.connect("instagrim");
        PreparedStatement ps = session.prepare("insert into userprofiles (login,password, email) Values(?,?,?)");
       
        BoundStatement boundStatement = new BoundStatement(ps);
        session.execute( // this is where the query is executed
                boundStatement.bind( // here you are binding the 'boundStatement'
                        username,EncodedPassword, email));
        //We are assuming this always works.  Also a transaction would be good here ! ?????
        
        return true;
    }
    
    
    public String[] returnDetails(String username){
        
        //modified to be an array
        String[] UserDetails = new String[4];
     
        Session session = cluster.connect("instagrim");
        PreparedStatement ps = session.prepare("SELECT first_name, last_name, email, picid from userprofiles where login = ?");
       
        ResultSet rs = null;
        BoundStatement boundStatement = new BoundStatement(ps);
        rs = session.execute( // this is where the query is executed
                boundStatement.bind( // here you are binding the 'boundStatement'
                        username));
                if (rs.isExhausted()) {
            System.out.println("No Details returned");

        } else {
            for (Row row : rs) {
                    UserDetails[0] = row.getString(0);
                    UserDetails[1] = row.getString(1);
                    UserDetails[2] = row.getString(2);
                    UserDetails[3] = row.getString(3);
                    System.out.println(UserDetails[0] + UserDetails[1] + UserDetails[2] + UserDetails[3]);  
                }
            }
    return UserDetails; 
    }
    
    
//    public boolean getUserinfo(String username, String email, String password){ //ask database for user info youve put into it and then sets that info into the store for the session , now that its in the store in the session any mthod can just get it from the store 
//        Session session = cluster.connect("instagrim");
//        PreparedStatement ps = session.prepare("select password from userprofiles where login =?");
//        ResultSet rs = null;
//        BoundStatement boundStatement = new BoundStatement(ps);
//        rs = session.execute( // this is where the query is executed
//                boundStatement.bind( // here you are binding the 'boundStatement'
//                        username));
//        if (rs.isExhausted()) {
//            System.out.println("No Images returned");
//            return false;
//        } else {
//            for (Row row : rs) {
//               
//                String StoredPass = row.getString("password");
//                if (StoredPass.compareTo(EncodedPassword) == 0)
//                    return true;
//            }
//        }
//      return true;
//    }
//        
    public boolean IsValidUser(String username, String Password){
        AeSimpleSHA1 sha1handler=  new AeSimpleSHA1();
        String EncodedPassword=null;
        try {
            EncodedPassword= sha1handler.SHA1(Password);
        }catch (UnsupportedEncodingException | NoSuchAlgorithmException et){
            System.out.println("Can't check your password");
            return false;
        }
        Session session;
        session = cluster.connect("instagrim");
        PreparedStatement ps = session.prepare("select password from userprofiles where login =?");
        ResultSet rs = null;
        BoundStatement boundStatement = new BoundStatement(ps);
        rs = session.execute( // this is where the query is executed
                boundStatement.bind( // here you are binding the 'boundStatement'
                        username));
        if (rs.isExhausted()) {
            System.out.println("No Images returned");
            return false;
        } else {
            for (Row row : rs) {
               
                String StoredPass = row.getString("password");
                if (StoredPass.compareTo(EncodedPassword) == 0)
                    return true;
            }
        }
   
    
    return false;  
    }
       public void setCluster(Cluster cluster) {
        this.cluster = cluster;
    }

//    public void RegisterUser(String username, String email, String password) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

//    public boolean IsValidUser(String username, String password, String email) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
