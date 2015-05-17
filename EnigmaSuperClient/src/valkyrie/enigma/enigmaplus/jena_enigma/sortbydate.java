/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valkyrie.enigma.enigmaplus.jena_enigma;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.util.FileManager;

/**
 *
 * @author avinda
 */
public class sortbydate {
        public String[] sArray = new String[10];
        public String[] sArray2 = new String[10];
        int i = 0;
    public void sortbydate(){
  //  public static void main(String[] args) {
        

        String fname = " ";
        FileManager.get().addLocatorClassLoader(rdfSearch.class.getClassLoader());
        Model model = FileManager.get().loadModel("/Users/heshanjayasinghe/Documents/A-enigmaProject/26_3_2015/EnigmaSuperClient/EnigmaSuperClient/src/valkyrie/enigma/enigmaplus/jena_enigma/enigmardf2.rdf");
        String queryString = "PREFIX sep: <http://www.semanticweb.org/hesh/ontologies/valkyrie/enigmaplus/ontology#>"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                + "PREFIX strg: <http://www.w3.org/2001/XMLSchema#string#>"
                + "SELECT * "
                + "WHERE {"
                + " ?Question sep:qdate ?qdate ."
                + " ?Question sep:qid ?qid ."
                + " ?Question sep:uid ?uid ."
                + "  OPTIONAL {"
                + "  ?User sep:uid ?uid."
                + "  ?User sep:fname ?fname ."
                + " }"
                + " ?Question sep:title ?title ."
                + " ?Question sep:qshort ?qshort ."
                + " ?Question sep:qrate ?qrate ."
                + " }"
                + "Order by desc(?qdate) "
                + "LIMIT 10";

        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);

        try {
            ResultSet results = qexec.execSelect();
            while (results.hasNext()) {

                QuerySolution soln = results.nextSolution();

                sArray[i++] = soln.getLiteral("qid").getLexicalForm();
//                String qdate = soln.getLiteral("qdate").getLexicalForm();
//                String uid = soln.getLiteral("uid").getLexicalForm();
//                fname = soln.getLiteral("fname").getLexicalForm();
//                String title = soln.getLiteral("title").getLexicalForm();
//                String qshort = soln.getLiteral("qshort").getLexicalForm();
//                String qrate = soln.getLiteral("qrate").getLexicalForm();
//
//                System.out.print("Date          : ");
//                System.out.println(qdate);
//                System.out.print("UserID        : ");
//                System.out.println(uid);
//                System.out.print("First Name    : ");
//                System.out.println(fname);
//                System.out.print("Title         : ");
//                System.out.println(title);
//                System.out.print("Question      : ");
//                System.out.println(qshort);
//                System.out.print("Rating        : ");
//                System.out.println(qrate + "\n");

            }
        } finally {
            qexec.close();
        }
    }
    
     public void sortbyUser(long uid){
 
        String fname = " ";
        FileManager.get().addLocatorClassLoader(rdfSearch.class.getClassLoader());
        Model model = FileManager.get().loadModel("/Users/heshanjayasinghe/Documents/A-enigmaProject/26_3_2015/EnigmaSuperClient/EnigmaSuperClient/src/valkyrie/enigma/enigmaplus/jena_enigma/enigmardf2.rdf");
        String queryString = "PREFIX sep: <http://www.semanticweb.org/hesh/ontologies/valkyrie/enigmaplus/ontology#>"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                + "PREFIX strg: <http://www.w3.org/2001/XMLSchema#string#>"
                + "SELECT ?qid  "
                + "WHERE {"
                + " ?Question sep:qdate ?qdate ."
                + " ?Question sep:qid ?qid. "
                + " ?Question sep:uid \""+uid+"\" ."
                + " }"
                + "Order by desc(?qdate) "
                + "LIMIT 10";

        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);

        try {
            ResultSet results = qexec.execSelect();
            while (results.hasNext()) {

                QuerySolution soln = results.nextSolution();

                sArray2[i++] = soln.getLiteral("qid").getLexicalForm();
//                String qdate = soln.getLiteral("qdate").getLexicalForm();
//            //    String uid = soln.getLiteral("uid").getLexicalForm();
//                fname = soln.getLiteral("fname").getLexicalForm();
//                String title = soln.getLiteral("title").getLexicalForm();
//                String qshort = soln.getLiteral("qshort").getLexicalForm();
//                String qrate = soln.getLiteral("qrate").getLexicalForm();
//
//                System.out.print("Date          : ");
//                System.out.println(qdate);
//                System.out.print("UserID        : ");
//                System.out.println(uid);
//                System.out.print("First Name    : ");
//                System.out.println(fname);
//                System.out.print("Title         : ");
//                System.out.println(title);
//                System.out.print("Question      : ");
//                System.out.println(qshort);
//                System.out.print("Rating        : ");
//                System.out.println(qrate + "\n");

            }
        } finally {
            qexec.close();
        }
    }
}
