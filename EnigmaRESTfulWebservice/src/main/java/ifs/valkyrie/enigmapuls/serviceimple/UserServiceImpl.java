/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifs.valkyrie.enigmapuls.serviceimple;

import ifs.valkyrie.enigmapuls.dao.UserDAO;
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
    
    @Override
    @Transactional
    public User LoginUser(String username, String password) throws ClassNotFoundException, OpenRDFException {
        return userdao.SearchUser(username, password);
       
        
    }
    
}
