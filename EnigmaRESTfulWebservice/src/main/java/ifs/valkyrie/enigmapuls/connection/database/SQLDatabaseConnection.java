/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifs.valkyrie.enigmapuls.connection.database;

import ifs.valkyrie.enigmapuls.connection.ResourceConnection;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author heshanjayasinghe
 */
public interface SQLDatabaseConnection extends ResourceConnection {

    public Connection getConnection() throws SQLException, ClassNotFoundException;

    public void closeConnection() throws SQLException;
}
