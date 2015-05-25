/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifs.valkyrie.enigmapuls.model;

/**
 *
 * @author heshanjayasinghe
 */
public class Notification {
    long qid;
    String title;
    String q_short;
    String date;
    String[] AskerID;
    
     public Notification(long qid,String title, String q_short, String date, String[] AskerID) {
        this.qid = qid;
        this.title = title;
        this.q_short = q_short;        
        this.date = date;
        this.AskerID = AskerID;
       
    }
     
    public long getQid(){
        return this.qid;
    } 
    
    public String getTitle(){
        return this.title;
    }
    
    public String getQ_short(){
        return this.q_short;
    }
    
    public String getDate(){
        return this.date;
    }
    
    public String[] getAskerID(){
        return this.AskerID;
    }
    
}
