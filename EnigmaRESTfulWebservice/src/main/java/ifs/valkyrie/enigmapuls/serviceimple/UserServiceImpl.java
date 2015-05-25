/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifs.valkyrie.enigmapuls.serviceimple;

import ifs.valkyrie.enigmapuls.dao.AnswerDAO;
import ifs.valkyrie.enigmapuls.dao.QuestionDAO;
import ifs.valkyrie.enigmapuls.dao.UserDAO;
import ifs.valkyrie.enigmapuls.model.Answer;
import ifs.valkyrie.enigmapuls.model.Question;
import ifs.valkyrie.enigmapuls.model.User;
import ifs.valkyrie.enigmapuls.service.UserService;
import org.openrdf.OpenRDFException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author heshanjayasinghe
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userdao;
    @Autowired
    private AnswerDAO answerdao;
    @Autowired
    private QuestionDAO questiondao;
    @Override
    @Transactional
    public User LoginUser(String username, String password) throws ClassNotFoundException, OpenRDFException {
        return userdao.ReadUser(username, password);
       
        
    }

    @Override
    public int SignupUser(User user) throws ClassNotFoundException, OpenRDFException {
        return userdao.CreateUser(user); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Question FindQuestions(long uid) throws ClassNotFoundException, OpenRDFException {
        return questiondao.ReadQuestion(uid); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Answer FindAnswers(int uid) throws ClassNotFoundException, OpenRDFException {
        return answerdao.ReadAnswer(uid); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EditUser(User user) throws ClassNotFoundException, OpenRDFException {
        return userdao.UpdateUser(user); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User FindReputedUsers(String[] Category) throws ClassNotFoundException, OpenRDFException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
