/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifs.valkyrie.enigmapuls.dao.impl;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import ifs.valkyrie.enigmapuls.connection.database.RDFDatabaseConnection;
import ifs.valkyrie.enigmapuls.dao.UserDAO;
import ifs.valkyrie.enigmapuls.model.User;
import static java.lang.Integer.parseInt;
import java.util.List;
import org.openrdf.OpenRDFException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 *
 * @author heshanjayasinghe
 */
@Repository
public class UserDAOImpl implements UserDAO{
    
    private RDFDatabaseConnection rdfdatabaseConnection;
    
    public RDFDatabaseConnection getrdfdatabaseConnection() {
        return rdfdatabaseConnection;
    }

    public void setDatabaseConnection(RDFDatabaseConnection rdfdatabaseConnection) {
        this.rdfdatabaseConnection = rdfdatabaseConnection;
    }
    
    
    @Override
    public int AddUser(User user) throws ClassNotFoundException, OpenRDFException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int UpdateUser(User user) throws ClassNotFoundException, OpenRDFException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int DeleteUser(long userid) throws ClassNotFoundException, OpenRDFException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User SearchUser(String username, String password) throws ClassNotFoundException, OpenRDFException {
         
        String queryString = "PREFIX sep: <http://www.semanticweb.org/hesh/ontologies/valkyrie/enigmaplus/ontology#>"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                + "PREFIX strg: <http://www.w3.org/2001/XMLSchema#string#>"
                + "SELECT  * "
                + "WHERE {"
                + "?User sep:password ?pass ."
                + "?User sep:fname ?fname ."
                + "?User sep:uid ?uid ."
                + "}";
        Query query = QueryFactory.create(queryString);

        QueryExecution qexec = QueryExecutionFactory.create(query, getrdfdatabaseConnection().getConnection());
        User u = null;
        try {
            com.hp.hpl.jena.query.ResultSet results = qexec.execSelect();
            while (results.hasNext()) {
                QuerySolution soln = results.nextSolution();
                String name = soln.getLiteral("fname").getLexicalForm();
                String pass = soln.getLiteral("pass").getLexicalForm();
                String uid = soln.getLiteral("uid").getLexicalForm();
                if ((name.equals(username)) && (pass.equals(password))) {
                    u = new User();
                    u.setFname(name);
                    u.setUid(parseInt(uid));
                }else{
                u=null;
                }
            }
        } finally {
            qexec.close();
            getrdfdatabaseConnection().closeConnection();
        }
        return u;
    }

    @Override
    public List<User> getUserList() throws ClassNotFoundException, OpenRDFException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
