/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifs.valkyrie.enigmapuls.dao;

import ifs.valkyrie.enigmapuls.model.User;
import java.util.List;
import org.openrdf.OpenRDFException;


/**
 *
 * @author heshanjayasinghe
 */
public interface UserDAO {
    
    public int CreateUser(User user)throws ClassNotFoundException,OpenRDFException;
    
    public int UpdateUser(User user)throws ClassNotFoundException,OpenRDFException;
    
    public int DeleteUser(long userid)throws ClassNotFoundException,OpenRDFException;
    
    public User ReadUser(String username, String password)throws ClassNotFoundException,OpenRDFException;

    public List<User> getUserList() throws ClassNotFoundException, OpenRDFException;
}
