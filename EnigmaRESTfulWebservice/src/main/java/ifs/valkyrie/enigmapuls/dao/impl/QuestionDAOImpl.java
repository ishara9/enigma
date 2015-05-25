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
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import ifs.valkyrie.enigmapuls.connection.database.RDFDatabaseConnection;
import ifs.valkyrie.enigmapuls.connection.database.impl.RDFDatabaseConnectionImpl;
import ifs.valkyrie.enigmapuls.dao.QuestionDAO;
import ifs.valkyrie.enigmapuls.model.Question;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import static java.lang.Long.parseLong;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openrdf.OpenRDFException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author heshanjayasinghe
 */
public class QuestionDAOImpl implements QuestionDAO{
    @Autowired
    private RDFDatabaseConnection rdfdatabaseConnection;
    
    @Override
    public int CreateQuestion(Question question) throws ClassNotFoundException, OpenRDFException {
        Question q = new Question();
        String NS = "http://www.semanticweb.org/hesh/ontologies/valkyrie/enigmaplus/ontology#";

        Resource r = rdfdatabaseConnection.getConnection().createResource(NS + "question");//Subject
        Property p1 = rdfdatabaseConnection.getConnection().createProperty(NS + "title");
        Property p2 = rdfdatabaseConnection.getConnection().createProperty(NS + "qshort");
        Property p3 = rdfdatabaseConnection.getConnection().createProperty(NS + "question");
        Property p4 = rdfdatabaseConnection.getConnection().createProperty(NS + "uid");
        Property p5 = rdfdatabaseConnection.getConnection().createProperty(NS + "qid");
        Property p6 = rdfdatabaseConnection.getConnection().createProperty(NS + "qrate");
        Property p7 = rdfdatabaseConnection.getConnection().createProperty(NS + "qdate");

        r.removeAll(p1);
        r.removeAll(p2);
        r.removeAll(p3);
        r.removeAll(p4);
        r.removeAll(p5);
        r.removeAll(p6);
        r.removeAll(p7);

        r.addProperty(p1, q.getQuestion(), XSDDatatype.XSDstring);
        r.addProperty(p2, q.getQ_short(), XSDDatatype.XSDstring);
        r.addProperty(p3, q.getPicture(), XSDDatatype.XSDstring);
        r.addProperty(p4, String.valueOf(""), XSDDatatype.XSDstring);
        r.addProperty(p5, String.valueOf(""), XSDDatatype.XSDstring);
        r.addProperty(p6, "0", XSDDatatype.XSDstring);
       
        
        try {
            rdfdatabaseConnection.getConnection().write(new FileOutputStream(RDFDatabaseConnectionImpl.rdfpath), "RDF/XML");
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        return 0;
    }

    @Override
    public int UpdateQuestion(Question question) throws ClassNotFoundException, OpenRDFException {
        Question q = new Question();
         String NS = "http://www.semanticweb.org/hesh/ontologies/valkyrie/enigmaplus/ontology#";

        Resource r = rdfdatabaseConnection.getConnection().createResource(NS + "question");//Subject
        Property p1 = rdfdatabaseConnection.getConnection().createProperty(NS + "title");
        Property p2 = rdfdatabaseConnection.getConnection().createProperty(NS + "qshort");
        Property p3 = rdfdatabaseConnection.getConnection().createProperty(NS + "question");
        Property p4 = rdfdatabaseConnection.getConnection().createProperty(NS + "uid");
        Property p5 = rdfdatabaseConnection.getConnection().createProperty(NS + "qid");
        Property p6 = rdfdatabaseConnection.getConnection().createProperty(NS + "qrate");
        Property p7 = rdfdatabaseConnection.getConnection().createProperty(NS + "qdate");

        r.removeAll(p1);
        r.removeAll(p2);
        r.removeAll(p3);
        r.removeAll(p4);
        r.removeAll(p5);
        r.removeAll(p6);
        r.removeAll(p7);

        r.addProperty(p1, q.getQuestion(), XSDDatatype.XSDstring);
        r.addProperty(p2, q.getQ_short(), XSDDatatype.XSDstring);
        r.addProperty(p3, q.getPicture(), XSDDatatype.XSDstring);
        r.addProperty(p4, String.valueOf(""), XSDDatatype.XSDstring);
        r.addProperty(p5, String.valueOf(""), XSDDatatype.XSDstring);
        r.addProperty(p6, "0", XSDDatatype.XSDstring);
        try {
            rdfdatabaseConnection.getConnection().write(new FileOutputStream(RDFDatabaseConnectionImpl.rdfpath), "RDF/XML");
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }finally{
            rdfdatabaseConnection.closeConnection();
        }
        return 1;}

    @Override
    public int DeleteQuestion(long questionid) throws ClassNotFoundException, OpenRDFException {
        String NS = "http://www.semanticweb.org/hesh/ontologies/valkyrie/enigmaplus/ontology#";

        Resource r = rdfdatabaseConnection.getConnection().createResource(NS + "question");//Subject
        Property p1 = rdfdatabaseConnection.getConnection().createProperty(NS + "title");
        Property p2 = rdfdatabaseConnection.getConnection().createProperty(NS + "qshort");
        Property p3 = rdfdatabaseConnection.getConnection().createProperty(NS + "question");
        Property p4 = rdfdatabaseConnection.getConnection().createProperty(NS + "uid");
        Property p5 = rdfdatabaseConnection.getConnection().createProperty(NS + "qid");
        Property p6 = rdfdatabaseConnection.getConnection().createProperty(NS + "qrate");
        Property p7 = rdfdatabaseConnection.getConnection().createProperty(NS + "qdate");

        r.removeAll(p1);
        r.removeAll(p2);
        r.removeAll(p3);
        r.removeAll(p4);
        r.removeAll(p5);
        r.removeAll(p6);
        r.removeAll(p7);
        return 1;
    }

    @Override
    public Question ReadQuestion(long questionid) throws ClassNotFoundException, OpenRDFException {
        String queryString = "PREFIX sep: <http://www.semanticweb.org/hesh/ontologies/valkyrie/enigmaplus/ontology#>"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                + "PREFIX strg: <http://www.w3.org/2001/XMLSchema#string#>"             
                        
                + "SELECT *"
                + "WHERE {"
                + "?Question sep:qid ?maxqid .{"
                + "SELECT (MAX(?qid) AS ?maxqid) "
                + "WHERE {"
                + "?Question sep:qid ?qid . }"
                + "}"
//                + "?Question sep:uid ?u ."//question title, question short, date, user, rate
//                + "?Question sep:title ?t ."
//                + "?Question sep:question  ?ql ."
//                + "?Question sep:qdate ?dt ."
                //+ "ORDER BY DESC(?z) LIMIT 1 ."          
                + "}";
       
        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, rdfdatabaseConnection.getConnection());

        try {
            com.hp.hpl.jena.query.ResultSet results = qexec.execSelect();
            while (results.hasNext()) {

                QuerySolution soln = results.nextSolution();
                String qid = soln.getLiteral("maxqid").getLexicalForm();              
            }

        } finally {
            qexec.close();
        }
        return null;
        
        
    }

    @Override
    public List<Question> getQuestionList() throws ClassNotFoundException, OpenRDFException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Question ReadQuestion(String entervale) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
