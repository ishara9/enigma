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
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.util.FileManager;

/**
 *
 * @author heshanjayasinghe
 */
public class search {
    public static void main(String[] args) {
        sparqlTst();
    }
    
    private static void sparqlTst() {
        FileManager.get().addLocatorClassLoader(Jena_Enigma.class.getClassLoader());
        Model model = FileManager.get().loadModel("/Users/heshanjayasinghe/Documents/A-enigmaProject/jena_Enigma/src/jena_enigma/Enigma.RDF");
         model.write(System.out, "RDF/JSON");
        String queryString = "PREFIX sep: <http://www.heshjayasinghe.webatu.com/Enigma.RDF#>"
               // + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
              //  + "PREFIX strg: <http://www.w3.org/2001/XMLSchema#string#>"
                + "SELECT  ?x "
                + "WHERE {"

                + "?User  sep:email \"heshjse@gmail.com\"."
                + "?User sep:password \"123\"."
         
                + "?User sep:fname ?x ."
                + "}";
        Query query = QueryFactory.create(queryString);
     
        QueryExecution qexec = QueryExecutionFactory.create(query, model);

        try {
            ResultSet results = qexec.execSelect();
            while (results.hasNext()) {
                QuerySolution soln = results.nextSolution();
                Literal name = soln.getLiteral("x");
            //   System.out.println(name);
            }
        } finally {
            qexec.close();
        }

    }
}
