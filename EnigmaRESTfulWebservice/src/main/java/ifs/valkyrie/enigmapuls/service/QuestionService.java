/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifs.valkyrie.enigmapuls.service;

import ifs.valkyrie.enigmapuls.model.Question;
import org.openrdf.OpenRDFException;

/**
 *
 * @author heshanjayasinghe
 */
public interface QuestionService {
    public Question SearchSortedQuestion(int questionid)throws ClassNotFoundException,OpenRDFException;
    
    public Question SearchQuestiontitle(int entervale)throws ClassNotFoundException,OpenRDFException;
    
    public int AddQuestion(Question question)throws ClassNotFoundException,OpenRDFException;

    public int removeQuestion(int questionid)throws ClassNotFoundException,OpenRDFException;
    
    public int editQuestion(Question question)throws ClassNotFoundException,OpenRDFException;
    
    public void rateQuestion(int questionid)throws ClassNotFoundException,OpenRDFException;
}
