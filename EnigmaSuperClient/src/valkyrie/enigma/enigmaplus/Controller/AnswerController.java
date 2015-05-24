/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package valkyrie.enigma.enigmaplus.Controller;


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
import com.hp.hpl.jena.util.FileManager;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import static java.lang.Long.parseLong;

import java.util.logging.Level;
import java.util.logging.Logger;


import valkyrie.enigma.enigmaplus.model.Answer;
import valkyrie.enigma.enigmaplus.model.Question;
import valkyrie.enigma.enigmaplus.rdfPath;
import valkyrie.enigma.enigmaplus.view.AnswerPanel;

/**
 *
 * @author hesh
 */
public class AnswerController {
    public Answer a;
    public String aid[] = new String[100];
    
    public void addAnswer(long aid, long qid, int arate,long uid, String answer, String adate){    //Answer(int aid, int qid, int vote, String answer, String date)
        Model m = ModelFactory.createDefaultModel();
        m.read(rdfPath.rdfPath, "RDF/XML");
        String NS = "http://www.semanticweb.org/hesh/ontologies/valkyrie/enigmaplus/ontology#";

        Resource r = m.createResource(NS + "answer"+aid);//Subject
      
        Property p1 = m.createProperty(NS + "answer");
        Property p2 = m.createProperty(NS + "uid");
        Property p3 = m.createProperty(NS + "qid");
        Property p4 = m.createProperty(NS + "arate");
        Property p5 = m.createProperty(NS + "adate");
        Property p6 = m.createProperty(NS + "aid");

        r.removeAll(p1);
        r.removeAll(p2);
        r.removeAll(p3);
        r.removeAll(p4);
        r.removeAll(p5);
        r.removeAll(p6);
//        r.removeAll(p7);


        r.addProperty(p1, answer, XSDDatatype.XSDstring);
        r.addProperty(p2, String.valueOf(uid), XSDDatatype.XSDstring);
        r.addProperty(p3, String.valueOf(qid), XSDDatatype.XSDstring);
        r.addProperty(p4, String.valueOf(arate), XSDDatatype.XSDstring);
        r.addProperty(p5, adate, XSDDatatype.XSDstring);
        r.addProperty(p6, String.valueOf(aid), XSDDatatype.XSDstring);
//        r.addProperty(p7, qdate, XSDDatatype.XSDstring);
        
        try {
            m.write(new FileOutputStream(rdfPath.rdfPath), "RDF/XML");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(QuestionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        Connection conn = DBConnection.getDBConnection().getConnection();
//        Statement stm = conn.createStatement();
//        String sql = "Insert into answer(qid,answer,date) values('" + answer.getQid() + "','" + answer.getAnswer() + "','" + answer.getDate() + "')";
//        int res = stm.executeUpdate(sql);
//        return res;
    }
    
    public void viewAnswer(long aid){
        
        String adate;
        String uid;
        String fname;        
        String ans;
        String arate;
        String qid;

        Model model = FileManager.get().loadModel(rdfPath.rdfPath);
        String queryString = "PREFIX sep: <http://www.semanticweb.org/hesh/ontologies/valkyrie/enigmaplus/ontology#>"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                + "PREFIX strg: <http://www.w3.org/2001/XMLSchema#string#>"
                + "SELECT * "
                + "WHERE {"
                + " ?Answer sep:adate ?adate ."
                + " ?Answer sep:aid \""+aid+"\"."
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
               a = new Answer(aid, parseLong(qid), Integer.parseInt(arate), ans, adate);
                             
                
            }
            
        } finally {
            qexec.close();
        }
    }
    
    
        
      public long aidCounter() {
        String aid = "0";
        

        Model model = FileManager.get().loadModel(rdfPath.rdfPath);
        String queryString = "PREFIX sep: <http://www.semanticweb.org/hesh/ontologies/valkyrie/enigmaplus/ontology#>"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                + "PREFIX strg: <http://www.w3.org/2001/XMLSchema#string#>"             
                        
                + "SELECT *"
                + "WHERE {"
                + "?Answer sep:aid ?maxaid .{"
                + "SELECT (MAX(?aid) AS ?maxaid) "
                + "WHERE {"
                + "?Answer sep:aid ?aid . }"
                + "}"
//                + "?Question sep:uid ?u ."//question title, question short, date, user, rate
//                + "?Question sep:title ?t ."
//                + "?Question sep:question  ?ql ."
//                + "?Question sep:qdate ?dt ."
                //+ "ORDER BY DESC(?z) LIMIT 1 ."          
                + "}";
       
        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);

        try {
            com.hp.hpl.jena.query.ResultSet results = qexec.execSelect();
            while (results.hasNext()) {

                QuerySolution soln = results.nextSolution();
                aid = soln.getLiteral("maxaid").getLexicalForm();              
            }

        } finally {
            qexec.close();
        }
        
        return parseLong(aid)+1;
    }
    
//      public static void main(String[] args) {
//        long qid =100127;
    
     public void findAnswers(long qid){
        // String[] aid = new String[100];
         
         Model model = FileManager.get().loadModel(rdfPath.rdfPath);
        String queryString = "PREFIX sep: <http://www.semanticweb.org/hesh/ontologies/valkyrie/enigmaplus/ontology#>"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                + "PREFIX strg: <http://www.w3.org/2001/XMLSchema#string#>"
                + "SELECT * "
                + "WHERE {"          
                + " ?Answer sep:qid \""+qid+"\" ."   
                + " ?Answer sep:aid ?aid ."              
                + " }";
                      
                
                
        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);

        try {
            com.hp.hpl.jena.query.ResultSet results = qexec.execSelect();
            int i=0;
            while (results.hasNext()) {

                QuerySolution soln = results.nextSolution();
                aid[i] = soln.getLiteral("aid").getLexicalForm();
                               
                i++;                                            
                
            }
            
        } finally {
            qexec.close();
        }
         System.out.println(aid[0]);
        
        }
          
     }
    

