/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifs.valkyrie.enigmapuls.dao.impl;

import com.hp.hpl.jena.datatypes.xsd.XSDDatatype;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import ifs.valkyrie.enigmapuls.connection.database.RDFDatabaseConnection;
import ifs.valkyrie.enigmapuls.connection.database.impl.RDFDatabaseConnectionImpl;
import ifs.valkyrie.enigmapuls.dao.UserDAO;
import ifs.valkyrie.enigmapuls.model.User;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openrdf.OpenRDFException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 *
 * @author heshanjayasinghe
 */
@Repository
public class UserDAOImpl implements UserDAO{
    @Autowired
    private RDFDatabaseConnection rdfdatabaseConnection;
    

    
    
    @Override
    public int CreateUser(User user) throws ClassNotFoundException, OpenRDFException {
       String queryString = "PREFIX sep: <http://www.semanticweb.org/hesh/ontologies/valkyrie/enigmaplus/ontology#>"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                + "PREFIX strg: <http://www.w3.org/2001/XMLSchema#string#>"             
                        
                + "SELECT *"
                + "WHERE {"
                + "?User sep:uid ?maxuid .{"
                + "SELECT (MAX(?uid) AS ?maxuid) "
                + "WHERE {"
                + "?User sep:uid ?uid . }"
                + "}"        
                + "}";
       
        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query,rdfdatabaseConnection.getConnection());

        try {
            com.hp.hpl.jena.query.ResultSet results = qexec.execSelect();
            while (results.hasNext()) {

                QuerySolution soln = results.nextSolution();
               // uidString = soln.getLiteral("maxuid").getLexicalForm();              
            }

        } finally {
            qexec.close();
        }
        return 0;
        
        }

    @Override
    public int UpdateUser(User user) throws ClassNotFoundException, OpenRDFException {
        String NS = "http://www.semanticweb.org/hesh/ontologies/valkyrie/enigmaplus/ontology#";

        Resource r = rdfdatabaseConnection.getConnection().createResource(NS + "User");//Subject
        Property p1 = rdfdatabaseConnection.getConnection().createProperty(NS + "fname");
        Property p2 = rdfdatabaseConnection.getConnection().createProperty(NS + "lname");
        Property p3 = rdfdatabaseConnection.getConnection().createProperty(NS + "interested");
        Property p4 = rdfdatabaseConnection.getConnection().createProperty(NS + "email");
        Property p5 = rdfdatabaseConnection.getConnection().createProperty(NS + "designation");
        Property p6 = rdfdatabaseConnection.getConnection().createProperty(NS + "picture");
       


        r.removeAll(p1);
        r.removeAll(p2);
        r.removeAll(p3);
        r.removeAll(p4);
        r.removeAll(p5);
        r.removeAll(p6);
   

        r.addProperty(p1, user.fname , XSDDatatype.XSDstring);
        r.addProperty(p2, user.getLname(), XSDDatatype.XSDstring);
        r.addProperty(p3, user.getInterrested() , XSDDatatype.XSDstring);
        r.addProperty(p4, user.getPic() , XSDDatatype.XSDstring);
        r.addProperty(p5, user.getEmail() , XSDDatatype.XSDstring);
        r.addProperty(p6, user.getProfession() , XSDDatatype.XSDstring);
        
        try {
            rdfdatabaseConnection.getConnection().write(new FileOutputStream(RDFDatabaseConnectionImpl.rdfpath), "RDF/XML");
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }finally{
            rdfdatabaseConnection.closeConnection();
        }
        return 1;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int DeleteUser(long userid) throws ClassNotFoundException, OpenRDFException {
       String NS = "http://www.semanticweb.org/hesh/ontologies/valkyrie/enigmaplus/ontology#";

        Resource r = rdfdatabaseConnection.getConnection().createResource(NS + "User");//Subject
        Property p1 = rdfdatabaseConnection.getConnection().createProperty(NS + "fname");
        Property p2 = rdfdatabaseConnection.getConnection().createProperty(NS + "lname");
        Property p3 = rdfdatabaseConnection.getConnection().createProperty(NS + "interested");
        Property p4 = rdfdatabaseConnection.getConnection().createProperty(NS + "email");
        Property p5 = rdfdatabaseConnection.getConnection().createProperty(NS + "designation");
        Property p6 = rdfdatabaseConnection.getConnection().createProperty(NS + "picture");
       


        r.removeAll(p1);
        r.removeAll(p2);
        r.removeAll(p3);
        r.removeAll(p4);
        r.removeAll(p5);
        r.removeAll(p6);
        return 0;
    }

    @Override
    public User ReadUser(String username, String password) throws ClassNotFoundException, OpenRDFException {
         
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

        QueryExecution qexec = QueryExecutionFactory.create(query, rdfdatabaseConnection.getConnection());
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
            rdfdatabaseConnection.closeConnection();
        }
        return u;
    }

    @Override
    public List<User> getUserList() throws ClassNotFoundException, OpenRDFException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
