package valkyrie.enigma.enigmaplus.jena_enigma;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.util.FileManager;

public class showFullQuestion  {
    
 //   public void showFullQuestion(String qsid){
    public static void main(String[] args) {
        
    
       int qsid=100115;
        //System.out.println(qsid);
        String fname =" ";
        String answer = " ";
        String auid = " ";
        String afname = " ";
        String adate = " ";
        FileManager.get().addLocatorClassLoader(rdfSearch.class.getClassLoader());
        Model model = FileManager.get().loadModel("C:\\Users\\avinda\\Desktop\\ishara\\project_files\\EnigmaSuperClient\\EnigmaSuperClient\\src\\valkyrie\\enigma\\enigmaplus\\jena_enigma\\enigmardf2.rdf");
        String queryString = "PREFIX sep: <http://www.semanticweb.org/hesh/ontologies/valkyrie/enigmaplus/ontology#>"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                + "PREFIX strg: <http://www.w3.org/2001/XMLSchema#string#>"
                + "SELECT * "
                + "WHERE {"
                + " ?Question sep:qdate ?qd ."
                + " ?Question sep:qid \""+qsid+"\"."
                + " ?Question sep:uid ?uid ."
                + "  OPTIONAL {"
                + "  ?User sep:uid ?uid."
                + "  ?User sep:fname ?fname ."
                + " }"
                + " ?Question sep:title ?title ."
                + " ?Question sep:qshort ?qshort ."
                + " ?Question sep:question ?qlong ."
                + " ?Question sep:qrate ?qrate ."
                + " }";
                      
                
                
        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);

        try {
            ResultSet results = qexec.execSelect();
            while (results.hasNext()) {
                
                QuerySolution soln = results.nextSolution();              
                String qd = soln.getLiteral("qd").getLexicalForm(); 
                String uid = soln.getLiteral("uid").getLexicalForm();
                fname = soln.getLiteral("fname").getLexicalForm();
                String title = soln.getLiteral("title").getLexicalForm();
                String qshort = soln.getLiteral("qshort").getLexicalForm();
                String qlong = soln.getLiteral("qlong").getLexicalForm();
                String qrate = soln.getLiteral("qrate").getLexicalForm(); 
                
                
                
                System.out.print("Date          : ");
                System.out.println(qd);
                System.out.print("UserID        : ");
                System.out.println(uid);
                System.out.print("First Name    : ");
                System.out.println(fname);
                System.out.print("Title         : ");
                System.out.println(title);
                System.out.print("Question      : ");
                System.out.println(qshort);
                System.out.print("Full Question : ");
                System.out.println(qlong);
                
                System.out.print("Rating        : ");
                System.out.println(qrate+"\n");
                
                

            }
            
        } finally {
            qexec.close();
        }
        
        FileManager.get().addLocatorClassLoader(rdfSearch.class.getClassLoader());
        model = FileManager.get().loadModel("/Users/avinda/Desktop/ishara/jena_Enigma/jena_Enigma/src/jena_enigma/enigmardf.rdf");
        queryString = "PREFIX sep: <http://www.semanticweb.org/hesh/ontologies/valkyrie/enigmaplus/ontology#>"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                + "PREFIX strg: <http://www.w3.org/2001/XMLSchema#string#>"
                + "SELECT DISTINCT ?answer ?auid ?afname ?adate "
                + "WHERE {"                
                + " ?Question sep:qid \"" + qsid + "\"."
                + " OPTIONAL {"
                + " ?Answer sep:qid \""+qsid+"\" ."
                + " ?Answer sep:answer ?answer ."
                + " ?Answer sep:adate ?adate ."
                + " ?Answer sep:uid ?auid ."
                + "  OPTIONAL {"
                + "  ?User sep:uid ?auid ."
                + "  ?User sep:fname ?afname ."
                + "  }"
                + " }"                
                + "}";

        
            query = QueryFactory.create(queryString);
            qexec = QueryExecutionFactory.create(query, model);

        try{
            ResultSet results = qexec.execSelect();
            while (results.hasNext()) {
                
                QuerySolution soln = results.nextSolution();
                
                try{
                answer  = soln.getLiteral("answer").getLexicalForm(); 
                auid    = soln.getLiteral("auid").getLexicalForm(); 
                afname  = soln.getLiteral("afname").getLexicalForm(); 
                adate   = soln.getLiteral("adate").getLexicalForm();
                }
                catch(NullPointerException e){
                    System.out.println("Not yet answered "+e);
                }
                
                System.out.print("Answer            : ");
                System.out.println(answer);
                System.out.print("User  ID          : ");
                System.out.println(auid);
                System.out.print("First Name        : ");
                System.out.println(afname);
                System.out.print("Date              : ");
                System.out.println(adate);
            }
        }
        finally {
            qexec.close();
    }
}
    
}
