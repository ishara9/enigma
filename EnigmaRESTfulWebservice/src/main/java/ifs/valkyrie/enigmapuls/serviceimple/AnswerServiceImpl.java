/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifs.valkyrie.enigmapuls.serviceimple;

import ifs.valkyrie.enigmapuls.dao.AnswerDAO;
import ifs.valkyrie.enigmapuls.model.Answer;
import ifs.valkyrie.enigmapuls.service.AnswerService;
import org.openrdf.OpenRDFException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author heshanjayasinghe
 */
public class AnswerServiceImpl implements AnswerService{
@Autowired
    private AnswerDAO answerdao;
    @Override
    public int AddAnswer(Answer answer) throws ClassNotFoundException, OpenRDFException {
        return answerdao.CreateAnswer(answer); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int removeAnswer(int answerid) throws ClassNotFoundException, OpenRDFException {
        return answerdao.DeleteAnswer(answerid); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int editAnswer(Answer answer) throws ClassNotFoundException, OpenRDFException {
        return answerdao.UpdateAnswer(answer); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void rateAnswer(int answerid) throws ClassNotFoundException, OpenRDFException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
