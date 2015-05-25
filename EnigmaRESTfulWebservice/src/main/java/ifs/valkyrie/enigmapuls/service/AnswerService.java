/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifs.valkyrie.enigmapuls.service;

import ifs.valkyrie.enigmapuls.model.Answer;
import org.openrdf.OpenRDFException;

/**
 *
 * @author heshanjayasinghe
 */
public interface AnswerService {
    public int AddAnswer(Answer answer)throws ClassNotFoundException,OpenRDFException;

    public int removeAnswer(int answerid)throws ClassNotFoundException,OpenRDFException;
    
    public int editAnswer(Answer answer)throws ClassNotFoundException,OpenRDFException;
    
    public void rateAnswer(int answerid)throws ClassNotFoundException,OpenRDFException;
}
