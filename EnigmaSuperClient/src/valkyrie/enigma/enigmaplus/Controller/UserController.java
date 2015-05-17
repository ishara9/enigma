
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
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import valkyrie.enigma.enigmaplus.jena_enigma.Jena_Enigma;

import valkyrie.enigma.enigmaplus.model.User;

public class UserController {
    
    public User u1;

    private static String loggedUser;

//    public static int addUser(User user, UserCat cat) throws ClassNotFoundException, SQLException {
//        Connection conn = DBConnection.getDBConnection().getConnection();
//        Statement stm = conn.createStatement();
//        System.out.println("ok in UC");
//        String sql = "Insert into user(fname,lname,email,password,profession,interrested,expertis) values('" + user.getFname() + "','" + user.getLname() + "','" + user.getEmail() + "','" + user.getPassword() + "','" + user.getProfession() + "','" + user.getInterrested() + "','" + user.getExpertis() + "')";
//        int res = stm.executeUpdate(sql);
//        System.out.println("ok user");
//        String sql2 = "Insert into usercat(email,category,subcategory) values('" + cat.getEmail() + "','" + cat.getCategory() + "','" + cat.getSubcategory() + "')";
//        int res2 = stm.executeUpdate(sql2);
//        System.out.println("ok ucat");
//        return res;
//    }

    public static User Loginuser(String username, String password) throws ClassNotFoundException, SQLException {
        Model model = FileManager.get().loadModel("/Users/heshanjayasinghe/Documents/A-enigmaProject/26_3_2015/EnigmaSuperClient/EnigmaSuperClient/src/valkyrie/enigma/enigmaplus/jena_enigma/enigmardf2.rdf");
        String queryString = "PREFIX sep: <http://www.semanticweb.org/hesh/ontologies/valkyrie/enigmaplus/ontology#>"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                + "PREFIX strg: <http://www.w3.org/2001/XMLSchema#string#>"
                + "SELECT  * "
                + "WHERE {"
                // + "?User  sep:email \"kasun@gmail.com\"."
                + "?User sep:password ?pass ."
                + "?User sep:fname ?fname ."
                + "?User sep:uid ?uid ."
                + "}";
        Query query = QueryFactory.create(queryString);

        QueryExecution qexec = QueryExecutionFactory.create(query, model);
        User u = null;
        try {
            com.hp.hpl.jena.query.ResultSet results = qexec.execSelect();
            while (results.hasNext()) {
                QuerySolution soln = results.nextSolution();
                String name = soln.getLiteral("fname").getLexicalForm();
                String pass = soln.getLiteral("pass").getLexicalForm();
                String uid = soln.getLiteral("uid").getLexicalForm();
                if ((name.equals(username)) && (pass.equals(password))) {
                    u = new User();

                    u.setFname(name);
                    loggedUser = uid;
                    u.setUid(parseInt(uid));

                }
            }
        } finally {
            qexec.close();
        }
        return u;
    }

    public long getUserLogged() {
        return parseLong(loggedUser);
    }

//    public static User profileView(int UID) throws ClassNotFoundException, SQLException {
//        Connection conn = DBConnection.getDBConnection().getConnection();
//        Statement stm = conn.createStatement();
//        String sql = "Select fname,lname,email,profession,reputation,expertis FROM user Where uid = '" + UID + "'";
//        ResultSet rst = stm.executeQuery(sql);
//        User u = null;
//
//        if (rst.next()) {
//            u = new User();
//            u.setFname(rst.getString("fname"));
//            u.setLname(rst.getString("lname"));
//            u.setEmail(rst.getString("email"));
//            u.setProfession(rst.getString("profession"));
//            u.setReputation(rst.getInt("reputation"));
//            u.setExpertis(rst.getString("expertis"));
//        }
//        return u;
//    }
    public void editUser(long uid, String fname, String lname, String email, String interested, String designation,String path){
        
        Model m = ModelFactory.createDefaultModel();
        //  m.read("/Users/avinda/Desktop/ishara/jena_Enigma/jena_Enigma/src/jena_enigma/enigmardf2.rdf", "RDF/XML");
        m.read("/Users/heshanjayasinghe/Documents/A-enigmaProject/26_3_2015/EnigmaSuperClient/EnigmaSuperClient/src/valkyrie/enigma/enigmaplus/jena_enigma/enigmardf2.rdf", "RDF/XML");
        String NS = "http://www.semanticweb.org/hesh/ontologies/valkyrie/enigmaplus/ontology#";

        Resource r = m.createResource(NS + "User"+uid);//Subject
        Property p1 = m.createProperty(NS + "fname");
        Property p2 = m.createProperty(NS + "lname");
        Property p3 = m.createProperty(NS + "interested");
        Property p4 = m.createProperty(NS + "email");
        Property p5 = m.createProperty(NS + "designation");
        Property p6 = m.createProperty(NS + "picture");
       


        r.removeAll(p1);
        r.removeAll(p2);
        r.removeAll(p3);
        r.removeAll(p4);
        r.removeAll(p5);
        r.removeAll(p6);
   
//        r.addProperty(p1, "title", XSDDatatype.XSDstring);
//        r.addProperty(p2, "qshort", XSDDatatype.XSDstring);
//        r.addProperty(p3, "qlong", XSDDatatype.XSDstring);
//        r.addProperty(p4, "String.valueOf(uid)", XSDDatatype.XSDstring);

        r.addProperty(p1, fname , XSDDatatype.XSDstring);
        r.addProperty(p2, lname, XSDDatatype.XSDstring);
        r.addProperty(p3, interested , XSDDatatype.XSDstring);
        r.addProperty(p4, email , XSDDatatype.XSDstring);
        r.addProperty(p5, designation , XSDDatatype.XSDstring);
        r.addProperty(p6, path , XSDDatatype.XSDstring);
        
        try {
            m.write(new FileOutputStream("/Users/heshanjayasinghe/Documents/A-enigmaProject/26_3_2015/EnigmaSuperClient/EnigmaSuperClient/src/valkyrie/enigma/enigmaplus/jena_enigma/enigmardf2.rdf"), "RDF/XML");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Jena_Enigma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void getUser(long uid){
   //   public static void main(String[] args) {
        
    
 //       int uid=200201;
        String lname;
        String fname;
        String designation;
        String reputation;
        String email;
        String availability;
        String interested;
        String picture;

        Model model = FileManager.get().loadModel("/Users/heshanjayasinghe/Documents/A-enigmaProject/26_3_2015/EnigmaSuperClient/EnigmaSuperClient/src/valkyrie/enigma/enigmaplus/jena_enigma/enigmardf2.rdf");
        String queryString = "PREFIX sep: <http://www.semanticweb.org/hesh/ontologies/valkyrie/enigmaplus/ontology#>"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                + "PREFIX strg: <http://www.w3.org/2001/XMLSchema#string#>"
                + "SELECT * "
                + "WHERE {"
                + " ?User sep:fname ?fname ."
                + " ?User sep:uid \""+uid+"\"."
                + " ?User sep:lname ?lname ."
//                + "  OPTIONAL {"
//                + "  ?User sep:uid ?uid."
//                + "  ?User sep:fname ?fname ."
//                + " }"
                + " ?User sep:designation ?designation ."
                + " ?User sep:reputation ?reputation ."
                + " ?User sep:email ?email ."
                + " ?User sep:availability ?availability ."
                + " ?User sep:interested ?interested ."
                + " ?User sep:picture ?picture ."
                
                + " }";
                      
                
                
        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);

        try {
            com.hp.hpl.jena.query.ResultSet results = qexec.execSelect();
            while (results.hasNext()) {

                QuerySolution soln = results.nextSolution();
               
                lname = soln.getLiteral("lname").getLexicalForm();
                fname = soln.getLiteral("fname").getLexicalForm();
                designation = soln.getLiteral("designation").getLexicalForm();
                reputation = soln.getLiteral("reputation").getLexicalForm();
                email = soln.getLiteral("email").getLexicalForm();
                availability = soln.getLiteral("availability").getLexicalForm();
                interested = soln.getLiteral("interested").getLexicalForm();
                picture = soln.getLiteral("picture").getLexicalForm();
                
                String UserID = String.valueOf(uid);
                
                
               u1 = new User( Integer.parseInt(UserID), fname,lname ,email,"password",interested,"experties","Cat","SubCat", designation, Integer.parseInt(reputation), Boolean.valueOf(availability),  "up_prof", "down_prof", "par_prof", picture );
               
               // System.out.println(lname+" "+fname+ " "+designation+" "+reputation+" "+email+" "+availability+" "+Integer.parseInt(UserID)+" "+Integer.parseInt(reputation)+" "+Boolean.valueOf(availability));
//               User(int uid, String fname, String lname, String email, String password, String interrested, String expertis, String cat, String subcat, String profession, int reputation, int availability, String up_prof, String down_prof, String par_prof, String pic);
//               User u2 = new User(uid, fname, lname, email, email, fname, email, qdate, qdate, reputation, reputation, availability, email, designation, email, email)
            }
            
        } finally {
            qexec.close();
        }
        
    }
}
