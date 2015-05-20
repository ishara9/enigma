/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifs.valkyrie.enigmapuls.connection.databaseimpl;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.util.FileManager;
import ifs.valkyrie.enigmapuls.connection.database.RDFDatabaseConnection;
import java.sql.DriverManager;

import org.openrdf.OpenRDFException;

/**
 *
 * @author heshanjayasinghe
 */
public class RDFDatabaseConnectionImpl implements RDFDatabaseConnection{
    private Model model;
    private String rdfpath;

    public RDFDatabaseConnectionImpl(String rdfpath) {
        this.rdfpath = rdfpath;
    }
    
    
    
    @Override
    public Model getConnection() throws OpenRDFException, ClassNotFoundException {
        if (model == null) {
            Model model = FileManager.get().loadModel(rdfpath);
        }
        return model;
    }

    @Override
    public void closeConnection() throws OpenRDFException {
       if (model != null) {
            model.close();
            model = null;
        }
    }
    
}
