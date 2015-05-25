/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valkyrie.enigma.enigmaplus.Controller;

/**
 *
 * @author heshanjayasinghe
 */
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.util.FileManager;
import valkyrie.enigma.enigmaplus.EnigmaMain;
import valkyrie.enigma.enigmaplus.rdfPath;


public class titleController {

    public titleController() {
        
        Model model = FileManager.get().loadModel(rdfPath.rdfPath);
        String queryString = "PREFIX sep: <http://www.semanticweb.org/hesh/ontologies/valkyrie/enigmaplus/ontology#>"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                + "PREFIX strg: <http://www.w3.org/2001/XMLSchema#string#>"
                + "SELECT * "
                + "WHERE {"
                + " ?Question sep:title ?title ."               
                + " }";
            //    + "LIMIT 10";

        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);

        try {
            ResultSet results = qexec.execSelect();
            while (results.hasNext()) {

                QuerySolution soln = results.nextSolution();
                    EnigmaMain.titlelist.add(soln.getLiteral("title").getLexicalForm());
                    System.out.println(soln.getLiteral("title").getLexicalForm());
               
            }
        } finally {
            qexec.close();
        }
        
    }
    
    public static void main(String[] args) {
        
        titleController tc = new titleController();
//        for(String title:EnigmaMain.titlelist){            
//            System.out.println(title);            
//        } 
        
    }
    
    
}

