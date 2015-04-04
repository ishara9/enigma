
package valkyrie.enigma.enigmaplus.jena_enigma;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.util.FileManager;

public class notifications {
    public void newAnswer(){
         String fname =" ";
    FileManager.get().addLocatorClassLoader(rdfSearch.class.getClassLoader());
        Model model = FileManager.get().loadModel("/Users/avinda/Desktop/ishara/jena_Enigma/jena_Enigma/src/jena_enigma/enigmardf.rdf");
        String queryString = "PREFIX sep: <http://www.semanticweb.org/hesh/ontologies/valkyrie/enigmaplus/ontology#>"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                + "PREFIX strg: <http://www.w3.org/2001/XMLSchema#string#>"
                + "SELECT * "
                + "WHERE {"                
                + " ?Answer sep:adate ?adate ."
                + " ?Answer sep:aid ?aid ."
                + " ?Answer sep:uid ?uid ."
                + "  OPTIONAL {"
                + "  ?User sep:uid ?uid."
                + "  ?User sep:fname ?fname ."
                + " }"
                + " ?Answer sep:answer?answer ."                          
                + " }"
                + "Order by desc(?adate) "
                + "LIMIT 3";        
                
                
        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);

        try {
            ResultSet results = qexec.execSelect();
            while (results.hasNext()) {
                
                QuerySolution soln = results.nextSolution();              
                String adate= soln.getLiteral("adate").getLexicalForm(); 
                String uid = soln.getLiteral("uid").getLexicalForm();
                fname = soln.getLiteral("fname").getLexicalForm();
                String answer = soln.getLiteral("answer").getLexicalForm();
                 
                
                System.out.print("Date          : ");
                System.out.println(adate);
                System.out.print("UserID        : ");
                System.out.println(uid);
                System.out.print("First Name    : ");
                System.out.println(fname);
                System.out.print("Answer        : ");
                System.out.println(answer+"\n");
              

            }
        } finally {
            qexec.close();
        }
        
    }
    
    public void newQuestion(){
         
    FileManager.get().addLocatorClassLoader(rdfSearch.class.getClassLoader());
        Model model = FileManager.get().loadModel("/Users/avinda/Desktop/ishara/jena_Enigma/jena_Enigma/src/jena_enigma/enigmardf.rdf");
        String queryString = "PREFIX sep: <http://www.semanticweb.org/hesh/ontologies/valkyrie/enigmaplus/ontology#>"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                + "PREFIX strg: <http://www.w3.org/2001/XMLSchema#string#>"
                + "SELECT * "
                + "WHERE {"                
                + " ?Question sep:qdate ?qdate ."
                + " ?Question sep:qid ?qid ."
                + " ?Question sep:uid ?uid ."                
                + " ?Question sep:title ?title ."
                + " ?Question sep:qshort ?qshort ."    
                + " }"
                + "Order by desc(?qd) "
                + "LIMIT 3";        
                
                
        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);

        try {
            ResultSet results = qexec.execSelect();
            while (results.hasNext()) {
                
                QuerySolution soln = results.nextSolution();              
                String qdate = soln.getLiteral("qdate").getLexicalForm();
                String qid = soln.getLiteral("qid").getLexicalForm();
                String uid = soln.getLiteral("uid").getLexicalForm();                
                String title = soln.getLiteral("title").getLexicalForm();
                String qshort = soln.getLiteral("qshort").getLexicalForm();
                 
                
                System.out.print("Date          : ");
                System.out.println(qdate);
                System.out.print("UserID        : ");
                System.out.println(uid);
                System.out.print("QID           : ");
                System.out.println(qid);
                System.out.print("Title         : ");
                System.out.println(title);
                System.out.print("Question      : ");
                System.out.println(qshort+"\n");
              

            }
        } finally {
            qexec.close();
        }
        
    }
}
