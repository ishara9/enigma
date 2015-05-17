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

public class Jena_Enigma {
    
    private String name;
    private String password;

   // public void main(String[] args) {
   //     sparqlTst();

        //sortbydate sbd = new sortbydate();
        //sbd.sortbydate();
        
//        showFullQuestion sfq = new showFullQuestion();
//         String qid = "100114";
//        sfq.showFullQuestion(qid);
        
//        profileLoggedUser plu = new profileLoggedUser();
//         String uid ="200201";
//        plu.previousQuestions(uid);
//        plu.previousAnswers(uid);
//        plu.profileView(uid);
        
//        notifications not = new notifications();
//        not.newQuestion();
//        not.newAnswer();

   // }

    public void sparqlTst() {
        FileManager.get().addLocatorClassLoader(Jena_Enigma.class.getClassLoader());
        //  Model model = FileManager.get().loadModel("http://www.heshjseee.comyr.com/Enigma.RDF");
        // model.write(System.out, "RDF/JSON");
        //C:\Users\avinda\Desktop\ishara\jena_Enigma\jena_Enigma\src\jena_enigma\Enigma.RDF
        //C:\Users\avinda\Desktop\ishara\jena_Enigma\jena_Enigma\src\jena_enigma\enigmardf.rdf
        Model model = FileManager.get().loadModel("C:\\Users\\kasun\\Desktop\\ishara\\project_enigma\\EnigmaSuperClient\\EnigmaSuperClient\\src\\valkyrie\\enigma\\enigmaplus\\jena_enigma\\enigmardf.rdf");
        String queryString = "PREFIX sep: <http://www.semanticweb.org/hesh/ontologies/valkyrie/enigmaplus/ontology#>"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                + "PREFIX strg: <http://www.w3.org/2001/XMLSchema#string#>"
                + "SELECT  * "
                + "WHERE {"
                + "?User  sep:email \"kasun@gmail.com\"."
                + "?User sep:password ?y ."
                + "?User sep:fname ?x ."
                + "}";
        Query query = QueryFactory.create(queryString);

        QueryExecution qexec = QueryExecutionFactory.create(query, model);

        try {
            ResultSet results = qexec.execSelect();
            while (results.hasNext()) {
                QuerySolution soln = results.nextSolution();
                name = soln.getLiteral("x").getLexicalForm();
                password = soln.getLiteral("y").getLexicalForm();
                //System.out.println(name);
                //System.out.println("Main class ends here \n");
            }
        } finally {
            qexec.close();
        }

    }
    
    public String getName(){
        return this.name;
    }
    
    public String getPassword(){
        return this.password;
    }
    

}
