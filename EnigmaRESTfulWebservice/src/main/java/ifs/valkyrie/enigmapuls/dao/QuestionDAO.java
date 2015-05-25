/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifs.valkyrie.enigmapuls.dao;

import ifs.valkyrie.enigmapuls.model.Question;

import java.util.List;
import org.openrdf.OpenRDFException;

/**
 *
 * @author heshanjayasinghe
 */
public interface QuestionDAO {
     public int CreateQuestion(Question question)throws ClassNotFoundException,OpenRDFException;
    
    public int UpdateQuestion(Question question)throws ClassNotFoundException,OpenRDFException;
    
    public int DeleteQuestion(long questionid)throws ClassNotFoundException,OpenRDFException;
    
    public Question ReadQuestion(long questionid)throws ClassNotFoundException,OpenRDFException;

    public List<Question> getQuestionList() throws ClassNotFoundException, OpenRDFException;

    public Question ReadQuestion(String entervale);
}
