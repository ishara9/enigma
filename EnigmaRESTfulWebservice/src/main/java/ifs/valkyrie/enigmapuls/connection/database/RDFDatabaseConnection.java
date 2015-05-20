/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifs.valkyrie.enigmapuls.connection.database;

import com.hp.hpl.jena.rdf.model.Model;
import ifs.valkyrie.enigmapuls.connection.ResourceConnection;
import org.openrdf.OpenRDFException;

/**
 *
 * @author heshanjayasinghe
 */
public interface RDFDatabaseConnection extends ResourceConnection {

    public Model getConnection() throws OpenRDFException, ClassNotFoundException;

    public void closeConnection() throws OpenRDFException;
}
