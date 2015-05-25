/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifs.valkyrie.enigmapuls.dao;

import ifs.valkyrie.enigmapuls.model.Answer;
import org.openrdf.OpenRDFException;

/**
 *
 * @author heshanjayasinghe
 */
public interface AnswerDAO {
   public int CreateAnswer(Answer answer)throws ClassNotFoundException,OpenRDFException;
    
    public int UpdateAnswer(Answer answer)throws ClassNotFoundException,OpenRDFException;
    
    public int DeleteAnswer(long answerid)throws ClassNotFoundException,OpenRDFException;
    
    public Answer ReadAnswer(long answerid)throws ClassNotFoundException,OpenRDFException; 
}
