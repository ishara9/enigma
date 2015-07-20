/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifs.valkyrie.enigmapuls.service;

import ifs.valkyrie.enigmapuls.model.Answer;
import ifs.valkyrie.enigmapuls.model.Question;
import ifs.valkyrie.enigmapuls.model.User;
import org.openrdf.OpenRDFException;

/**
 *
 * @author heshanjayasinghe
 */
public interface UserService {
    
    public User LoginUser(String username, String password)throws ClassNotFoundException,OpenRDFException;
    
    public User SignupUser(User user)throws ClassNotFoundException,OpenRDFException;
    
    public int EditUser(User user)throws ClassNotFoundException,OpenRDFException;
    
    public User FindReputedUsers(String Category[])throws ClassNotFoundException,OpenRDFException;
    
    public Question FindQuestions(long uid)throws ClassNotFoundException,OpenRDFException;
    
    public Answer FindAnswers(int uid)throws ClassNotFoundException,OpenRDFException;
    
    
}
