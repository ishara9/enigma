/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valkyrie.enigma.enigmaplus.jena_enigma;

import arq.update;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.update.GraphStoreFactory;
import com.hp.hpl.jena.update.UpdateExecutionFactory;
import com.hp.hpl.jena.update.UpdateFactory;
import com.hp.hpl.jena.update.UpdateProcessor;
import com.hp.hpl.jena.update.UpdateRequest;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 *
 * @author heshanjayasinghe
 */
public class insertdata {

    public static void main(String[] args) {
        new insertdata().addLecturerTriples("user6","hesh","hesh@gmail.com");
    }

    public boolean addLecturerTriples(String user,String fname,String email ) {

        try {
            Model m = ModelFactory.createDefaultModel();
            m.read("/Users/heshanjayasinghe/Documents/A-enigmaProject/jena_Enigma/src/jena_enigma/Enigma.RDF", "RDF/XML");

            ArrayList<String> subject = new ArrayList<String>();
            ArrayList<String> predicate = new ArrayList<String>();
            ArrayList<String> object = new ArrayList<String>();

            subject.add("<http://www.heshjayasinghe.webatu.com/Enigma.RDF#" + user + "> \n"+
                    "<http://www.w3.org/2001/XMLSchema#string/> Enigma:fname "+fname+" ;\n"
                    + "Enigma:email "+email+"."
                    );
            predicate.add("<http://www.heshjayasinghe.webatu.com/Enigma.RDF#type>");
            object.add("<http://www.heshjayasinghe.webatu.com/Enigma.RDF#User>");
     
            for (int i = 0; i < subject.size(); i++) {
                String qry = "PREFIX Enigma: <http://www.heshjayasinghe.webatu.com/Enigma.RDF#/> \n"+
                        "INSERT DATA"
                        + "{"
                        + subject.get(i) + "\n"
                        + predicate.get(i) + "\n"
                        + object.get(i) + "\n"
                        + "}";

                System.out.println(qry);
                UpdateRequest update = UpdateFactory.create(qry);
                UpdateProcessor processor = UpdateExecutionFactory.create(update, GraphStoreFactory.create(m));
                processor.execute();

                m.write(new FileOutputStream("/Users/heshanjayasinghe/Documents/A-enigmaProject/jena_Enigma/src/jena_enigma/Enigma.RDF"), "RDF/XML");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
