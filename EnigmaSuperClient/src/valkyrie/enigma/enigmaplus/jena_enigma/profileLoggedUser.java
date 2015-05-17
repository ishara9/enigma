
package valkyrie.enigma.enigmaplus.jena_enigma;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.util.FileManager;


public class profileLoggedUser {
   public void previousQuestions(String UserID){
       FileManager.get().addLocatorClassLoader(rdfSearch.class.getClassLoader());
        Model model = FileManager.get().loadModel("/Users/avinda/Desktop/ishara/jena_Enigma/jena_Enigma/src/jena_enigma/enigmardf.rdf");
        String queryString = "PREFIX sep: <http://www.semanticweb.org/hesh/ontologies/valkyrie/enigmaplus/ontology#>"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                + "PREFIX strg: <http://www.w3.org/2001/XMLSchema#string#>"
                + "SELECT DISTINCT ?qid ?title ?qshort ?qdate ?qrate "
                + "WHERE {"
                + " ?User sep:uid \""+UserID+"\" ."                
                + " OPTIONAL {"
                + " ?Question sep:uid \""+UserID+"\"."                
                + " ?Question sep:qid ?qid ."                
                + "}"                
                + " ?Question sep:title ?title ."
                + " ?Question sep:qshort ?qshort ."
                + " ?Question sep:qdate ?qdate ."
                + " ?Question sep:qrate ?qrate ."                
                + "}";
                     
                
                
        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);

        try {
            ResultSet results = qexec.execSelect();
            while (results.hasNext()) {
                
                QuerySolution soln = results.nextSolution(); 
                
                String qid = soln.getLiteral("qid").getLexicalForm();                
                String title = soln.getLiteral("title").getLexicalForm();
                String qshort = soln.getLiteral("qshort").getLexicalForm();
                String qdate = soln.getLiteral("qdate").getLexicalForm();
                String qrate = soln.getLiteral("qrate").getLexicalForm(); 
                
                               
                System.out.print("QID           : ");
                System.out.println(qid);               
                System.out.print("Title         : ");
                System.out.println(title);
                System.out.print("Question      : ");
                System.out.println(qshort);
                System.out.print("Date          : ");
                System.out.println(qdate);                
                System.out.print("Rating        : ");
                System.out.println(qrate+"\n");
                
                

            }
            
        } finally {
            qexec.close();
        }
   }
   
   public void previousAnswers(String UserID){
       FileManager.get().addLocatorClassLoader(rdfSearch.class.getClassLoader());
        Model model = FileManager.get().loadModel("/Users/avinda/Desktop/ishara/jena_Enigma/jena_Enigma/src/jena_enigma/enigmardf.rdf");
        String queryString = "PREFIX sep: <http://www.semanticweb.org/hesh/ontologies/valkyrie/enigmaplus/ontology#>"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                + "PREFIX strg: <http://www.w3.org/2001/XMLSchema#string#>"
                + "SELECT DISTINCT ?aid ?adate ?avote ?answer "
                + "WHERE {"
                + " ?User sep:uid \""+UserID+"\" ."                
                + " OPTIONAL {"
                + " ?Answer sep:uid \""+UserID+"\"."                
                + " ?Answer sep:aid ?aid ."    
                + " ?Answer sep:adate ?adate ."
                + " ?Answer sep:avote ?avote ."  
                + " ?Answer sep:answer ?answer ." 
                + " }"
                + "}";
                     
                
                
        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);

        try {
            ResultSet results = qexec.execSelect();
            while (results.hasNext()) {
                
                QuerySolution soln = results.nextSolution(); 
             
                String aid = soln.getLiteral("aid").getLexicalForm();
                String adate = soln.getLiteral("adate").getLexicalForm();
                String avote = soln.getLiteral("avote").getLexicalForm();               
                String answer = soln.getLiteral("answer").getLexicalForm(); 
                                
                System.out.print("AnswerID      : ");
                System.out.println(aid);               
                System.out.print("Date          : ");
                System.out.println(adate);
                System.out.print("Answer        : ");
                System.out.println(answer);
                System.out.print("Rating        : ");
                System.out.println(avote+"\n");               
                               
            }
            
        } finally {
            qexec.close();
        }
   }
   
   public void profileView(String UserID){
       String interested="";
       String availability="";
       
       FileManager.get().addLocatorClassLoader(rdfSearch.class.getClassLoader());
        Model model = FileManager.get().loadModel("/Users/avinda/Desktop/ishara/jena_Enigma/jena_Enigma/src/jena_enigma/enigmardf.rdf");
        String queryString = "PREFIX sep: <http://www.semanticweb.org/hesh/ontologies/valkyrie/enigmaplus/ontology#>"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                + "PREFIX strg: <http://www.w3.org/2001/XMLSchema#string#>"
                + "SELECT REDUCED *  "
                + "WHERE {"
                + " ?User sep:uid \""+UserID+"\" ."           
                + " ?User sep:fname ?fname ."
                + " ?User sep:lname ?lname ."
                + " ?User sep:designation ?designation ."
                + " ?User sep:email ?email ."
                + " ?User sep:reputation ?reputation ."
                + " ?User sep:interested ?interested ."
                + " ?User sep:availability ?availability ." 
                + "}";
                     
                
                
        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);

        try {
            ResultSet results = qexec.execSelect();
            while (results.hasNext()) {
                
                QuerySolution soln = results.nextSolution(); 
                
                            
                String fname = soln.getLiteral("fname").getLexicalForm();
                
                String lname = soln.getLiteral("lname").getLexicalForm();
                String designation = soln.getLiteral("designation").getLexicalForm();
                String email = soln.getLiteral("email").getLexicalForm();
                String reputation = soln.getLiteral("reputation").getLexicalForm(); 
                
                try{
                interested = soln.getLiteral("interested").getLexicalForm(); 
                }
                catch(NullPointerException e){
                    System.out.println("Interested field not found");
                }
                
                try{
                availability = soln.getLiteral("availability").getLexicalForm(); 
                }
                catch(NullPointerException e){
                    System.out.println("availability field not found");
                }
                               
                System.out.print("UserID            : ");
                System.out.println(UserID);               
                System.out.print("First Name        : ");
                System.out.println(fname);
                System.out.print("Last Name         : ");
                System.out.println(lname);
                System.out.print("Designation       : ");
                System.out.println(designation);                
                System.out.print("Reputation        : ");
                System.out.println(reputation);
                System.out.print("Email             : ");
                System.out.println(email);
                System.out.print("Interested        : ");
                System.out.println(interested);
                System.out.print("Availability      : ");
                System.out.println(availability);
                
                

            }
            
        } finally {
            qexec.close();
        }
   }
}
