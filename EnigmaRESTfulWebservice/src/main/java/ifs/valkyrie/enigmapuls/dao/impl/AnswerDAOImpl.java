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
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.util.FileManager;
import ifs.valkyrie.enigmapuls.connection.database.RDFDatabaseConnection;
import ifs.valkyrie.enigmapuls.connection.database.impl.RDFDatabaseConnectionImpl;
import ifs.valkyrie.enigmapuls.dao.AnswerDAO;
import ifs.valkyrie.enigmapuls.model.Answer;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import static java.lang.Long.parseLong;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openrdf.OpenRDFException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author heshanjayasinghe
 */
public class AnswerDAOImpl implements AnswerDAO{
     @Autowired
    private RDFDatabaseConnection rdfdatabaseConnection;
    
    @Override
    public int CreateAnswer(Answer answer) throws ClassNotFoundException, OpenRDFException {
        Answer ansr = new Answer();
        String NS = "http://www.semanticweb.org/hesh/ontologies/valkyrie/enigmaplus/ontology#";

        Resource r = rdfdatabaseConnection.getConnection().createResource(NS + "answer");//Subject
      
        Property p1 = rdfdatabaseConnection.getConnection().createProperty(NS + "answer");
        Property p2 = rdfdatabaseConnection.getConnection().createProperty(NS + "uid");
        Property p3 = rdfdatabaseConnection.getConnection().createProperty(NS + "qid");
        Property p4 = rdfdatabaseConnection.getConnection().createProperty(NS + "arate");
        Property p5 = rdfdatabaseConnection.getConnection().createProperty(NS + "adate");
        Property p6 = rdfdatabaseConnection.getConnection().createProperty(NS + "aid");

        r.removeAll(p1);
        r.removeAll(p2);
        r.removeAll(p3);
        r.removeAll(p4);
        r.removeAll(p5);
        r.removeAll(p6);
//        r.removeAll(p7);


        
        r.addProperty(p2, ansr.getAnswer(), XSDDatatype.XSDstring);
        r.addProperty(p3, ansr.getDate(), XSDDatatype.XSDstring);
        
//        r.addProperty(p7, qdate, XSDDatatype.XSDstring);
        
        try {
            rdfdatabaseConnection.getConnection().write(new FileOutputStream(RDFDatabaseConnectionImpl.rdfpath), "RDF/XML");
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
         return 0;
    }

    @Override
    public int UpdateAnswer(Answer answer) throws ClassNotFoundException, OpenRDFException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int DeleteAnswer(long answerid) throws ClassNotFoundException, OpenRDFException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Answer ReadAnswer(long answerid) throws ClassNotFoundException, OpenRDFException {
        String adate;
        String uid;
        String fname;        
        String ans;
        String arate;
        String qid;

        Model model = FileManager.get().loadModel(RDFDatabaseConnectionImpl.rdfpath);
        String queryString = "PREFIX sep: <http://www.semanticweb.org/hesh/ontologies/valkyrie/enigmaplus/ontology#>"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                + "PREFIX strg: <http://www.w3.org/2001/XMLSchema#string#>"
                + "SELECT * "
                + "WHERE {"
                + " ?Answer sep:adate ?adate ."
                + " ?Answer sep:aid \"\"."
                + " ?Answer sep:uid ?uid ."
                + " ?Answer sep:qid ?qid ."
                + "  OPTIONAL {"
                + "  ?User sep:uid ?uid."
                + "  ?User sep:fname ?fname ."
                + " }"                
                + " ?Answer sep:answer ?ans ."
                + " ?Answer sep:arate ?arate ."
                + " }";
                      
                
                
        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);

        try {
            com.hp.hpl.jena.query.ResultSet results = qexec.execSelect();
            while (results.hasNext()) {

                QuerySolution soln = results.nextSolution();
                adate = soln.getLiteral("adate").getLexicalForm();
                
                uid = soln.getLiteral("uid").getLexicalForm();
                qid = soln.getLiteral("qid").getLexicalForm();
                fname = soln.getLiteral("fname").getLexicalForm();                
                ans = soln.getLiteral("ans").getLexicalForm();
                arate = soln.getLiteral("arate").getLexicalForm();
                
                
               //a = new Answer(qid,ans,,Integer.parseInt(arate),adate,,parseLong(uid),"categry");//Answer(long aid, long qid, int vote, String answer, String date)
             //  a = new Answer(aid, parseLong(qid), Integer.parseInt(arate), ans, adate);
                             
                
            }
            
        } finally {
            qexec.close();
        }
         return null;
    }
    
}
