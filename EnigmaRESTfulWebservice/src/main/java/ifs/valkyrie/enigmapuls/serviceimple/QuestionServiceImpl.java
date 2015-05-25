/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifs.valkyrie.enigmapuls.serviceimple;

import ifs.valkyrie.enigmapuls.dao.QuestionDAO;
import ifs.valkyrie.enigmapuls.dao.UserDAO;
import ifs.valkyrie.enigmapuls.model.Question;
import ifs.valkyrie.enigmapuls.service.QuestionService;
import org.openrdf.OpenRDFException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author heshanjayasinghe
 */
public class QuestionServiceImpl implements QuestionService{
 @Autowired
    private QuestionDAO questiondao;
    @Override
    public Question SearchSortedQuestion(int questionid) throws ClassNotFoundException, OpenRDFException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Question SearchQuestiontitle(int entervale) throws ClassNotFoundException, OpenRDFException {
        return questiondao.ReadQuestion(entervale); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int AddQuestion(Question question) throws ClassNotFoundException, OpenRDFException {
        return questiondao.CreateQuestion(question); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int removeQuestion(int questionid) throws ClassNotFoundException, OpenRDFException {
        return questiondao.DeleteQuestion(questionid);//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int editQuestion(Question question) throws ClassNotFoundException, OpenRDFException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void rateQuestion(int questionid) throws ClassNotFoundException, OpenRDFException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
