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

/**
 *
 * @author heshanjayasinghe
 */
public class UserServiceImpl implements UserService{

    private UserDAO userdao;
    @Override
    public User LoginUser(String username, String password) throws ClassNotFoundException, OpenRDFException {
        return userdao.SearchUser(username, password);
       
        
    }
    
}
