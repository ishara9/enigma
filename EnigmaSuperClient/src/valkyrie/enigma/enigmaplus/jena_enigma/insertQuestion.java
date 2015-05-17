package valkyrie.enigma.enigmaplus.jena_enigma;

import com.hp.hpl.jena.datatypes.xsd.XSDDatatype;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class insertQuestion {

   public void insert(String title, String qshort, String qlong, long uid) {
   // public static void main(String args[]){
        Model m = ModelFactory.createDefaultModel();
        //  m.read("/Users/avinda/Desktop/ishara/jena_Enigma/jena_Enigma/src/jena_enigma/enigmardf2.rdf", "RDF/XML");
        m.read("/Users/avinda/Desktop/ishara/project_files/EnigmaSuperClient/EnigmaSuperClient/src/valkyrie/enigma/enigmaplus/jena_enigma/enigmardf2.rdf", "RDF/XML");
        String NS = "http://www.semanticweb.org/hesh/ontologies/valkyrie/enigmaplus/ontology#";

        Resource r = m.createResource(NS + "question10");//like subject
        Property p1 = m.createProperty(NS + "title");
        Property p2 = m.createProperty(NS + "qshort");
        Property p3 = m.createProperty(NS + "question");
        Property p4 = m.createProperty(NS + "uid");
//        Property p5 =m.createProperty(NS+"designation");
//        Property p6 =m.createProperty(NS+"reputation");

        r.removeAll(p1);
        r.removeAll(p2);
        r.removeAll(p3);
        r.removeAll(p4);
//        r.removeAll(p5);
//        r.removeAll(p6);
//         r.addProperty(p1, "title", XSDDatatype.XSDstring);
//        r.addProperty(p2, "qshort", XSDDatatype.XSDstring);
//        r.addProperty(p3, "qlong", XSDDatatype.XSDstring);
//        r.addProperty(p4, "String.valueOf(uid)", XSDDatatype.XSDstring);

        r.addProperty(p1, title, XSDDatatype.XSDstring);
        r.addProperty(p2, qshort, XSDDatatype.XSDstring);
        r.addProperty(p3, qlong, XSDDatatype.XSDstring);
        r.addProperty(p4, String.valueOf(uid), XSDDatatype.XSDstring);
//        r.addProperty(p5, "Engineer", XSDDatatype.XSDstring);
//        r.addProperty(p6, "15", XSDDatatype.XSDstring);
        try {
            m.write(new FileOutputStream("/Users/avinda/Desktop/ishara/project_files/EnigmaSuperClient/EnigmaSuperClient/src/valkyrie/enigma/enigmaplus/jena_enigma/enigmardf2.rdf"), "RDF/XML");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Jena_Enigma.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
