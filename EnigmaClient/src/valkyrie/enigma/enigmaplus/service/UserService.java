/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package valkyrie.enigma.enigmaplus.service;

import java.sql.SQLException;
import valkyrie.enigma.enigmaplus.model.User;

/**
 *
 * @author heshanjayasinghe
 */
public interface UserService {
    public User LoginUser(String username, String password)throws ClassNotFoundException;
}
