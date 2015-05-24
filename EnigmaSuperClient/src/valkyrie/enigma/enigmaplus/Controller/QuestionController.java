package valkyrie.enigma.enigmaplus.Controller;

import com.hp.hpl.jena.datatypes.xsd.XSDDatatype;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.util.FileManager;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import static java.lang.Long.parseLong;
import java.util.logging.Level;
import java.util.logging.Logger;
import valkyrie.enigma.enigmaplus.model.Question;
import valkyrie.enigma.enigmaplus.rdfPath;

public class QuestionController {
    public static int nextQuestion=0;
public Question q;
    public void insert(String title, String qshort, String qlong, long uid, long qid, String qdate) {
        // public static void main(String args[]){
        Model m = ModelFactory.createDefaultModel();
        //  m.read("/Users/avinda/Desktop/ishara/jena_Enigma/jena_Enigma/src/jena_enigma/enigmardf2.rdf", "RDF/XML");
        m.read(rdfPath.rdfPath, "RDF/XML");
        String NS = "http://www.semanticweb.org/hesh/ontologies/valkyrie/enigmaplus/ontology#";

        Resource r = m.createResource(NS + "question"+qid);//Subject
        Property p1 = m.createProperty(NS + "title");
        Property p2 = m.createProperty(NS + "qshort");
        Property p3 = m.createProperty(NS + "question");
        Property p4 = m.createProperty(NS + "uid");
        Property p5 = m.createProperty(NS + "qid");
        Property p6 = m.createProperty(NS + "qrate");
        Property p7 = m.createProperty(NS + "qdate");

        r.removeAll(p1);
        r.removeAll(p2);
        r.removeAll(p3);
        r.removeAll(p4);
        r.removeAll(p5);
        r.removeAll(p6);
        r.removeAll(p7);
//        r.addProperty(p1, "title", XSDDatatype.XSDstring);
//        r.addProperty(p2, "qshort", XSDDatatype.XSDstring);
//        r.addProperty(p3, "qlong", XSDDatatype.XSDstring);
//        r.addProperty(p4, "String.valueOf(uid)", XSDDatatype.XSDstring);

        r.addProperty(p1, title, XSDDatatype.XSDstring);
        r.addProperty(p2, qshort, XSDDatatype.XSDstring);
        r.addProperty(p3, qlong, XSDDatatype.XSDstring);
        r.addProperty(p4, String.valueOf(uid), XSDDatatype.XSDstring);
        r.addProperty(p5, String.valueOf(qid), XSDDatatype.XSDstring);
        r.addProperty(p6, "0", XSDDatatype.XSDstring);
        r.addProperty(p7, qdate, XSDDatatype.XSDstring);
        
        try {
            m.write(new FileOutputStream(rdfPath.rdfPath), "RDF/XML");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(QuestionController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void qRate(long qid,boolean isIncrement){
        int qrate=0;
        int rep=0;
        String uid="";
        Model model = FileManager.get().loadModel(rdfPath.rdfPath);
        String queryString = "PREFIX sep: <http://www.semanticweb.org/hesh/ontologies/valkyrie/enigmaplus/ontology#>"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                + "PREFIX strg: <http://www.w3.org/2001/XMLSchema#string#>"
                + "SELECT * "
                + "WHERE {"
                + " ?Question sep:qid \""+qid+"\"."
                + " ?Question sep:uid ?uid ."
                + "  OPTIONAL {"
                + "  ?User sep:uid ?uid."
                + "  ?User sep:reputation ?rep ."
                + " }"
                + " ?Question sep:qrate ?qrate ."
                + " }";
                      
                
                
        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);

        try {
            ResultSet results = qexec.execSelect();
            while (results.hasNext()) {
                QuerySolution soln = results.nextSolution();
                qrate = Integer.parseInt(soln.getLiteral("qrate").getLexicalForm());
                rep = Integer.parseInt(soln.getLiteral("rep").getLexicalForm());
                uid = soln.getLiteral("uid").getLexicalForm();
            }
        } finally {
            qexec.close();
        }

        
        Model m = ModelFactory.createDefaultModel();
        //  m.read("/Users/avinda/Desktop/ishara/jena_Enigma/jena_Enigma/src/jena_enigma/enigmardf2.rdf", "RDF/XML");
        m.read(rdfPath.rdfPath, "RDF/XML");
        String NS = "http://www.semanticweb.org/hesh/ontologies/valkyrie/enigmaplus/ontology#";

        Resource r = m.createResource(NS + "question"+qid);//Subject
        Resource r2 = m.createResource(NS + "User"+uid);//Subject
        
        Property p1 = m.createProperty(NS + "qrate");  
        Property p2 = m.createProperty(NS + "reputation"); 
        
        r.removeAll(p1);
        r2.removeAll(p2);
        
        if(isIncrement){
        r.addProperty(p1, String.valueOf(++qrate), XSDDatatype.XSDstring);
        r2.addProperty(p2, String.valueOf(++rep), XSDDatatype.XSDstring);
        System.out.println(qrate);
        }
        else{
        r.addProperty(p1, String.valueOf(--qrate), XSDDatatype.XSDstring);   
        r2.addProperty(p2, String.valueOf(--rep), XSDDatatype.XSDstring);
        System.out.println(qrate);
        }
        try {
            m.write(new FileOutputStream(rdfPath.rdfPath), "RDF/XML");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(QuestionController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public long qidCounter() {
        String qid = "0";
        

        Model model = FileManager.get().loadModel(rdfPath.rdfPath);
        String queryString = "PREFIX sep: <http://www.semanticweb.org/hesh/ontologies/valkyrie/enigmaplus/ontology#>"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                + "PREFIX strg: <http://www.w3.org/2001/XMLSchema#string#>"             
                        
                + "SELECT *"
                + "WHERE {"
                + "?Question sep:qid ?maxqid .{"
                + "SELECT (MAX(?qid) AS ?maxqid) "
                + "WHERE {"
                + "?Question sep:qid ?qid . }"
                + "}"
//                + "?Question sep:uid ?u ."//question title, question short, date, user, rate
//                + "?Question sep:title ?t ."
//                + "?Question sep:question  ?ql ."
//                + "?Question sep:qdate ?dt ."
                //+ "ORDER BY DESC(?z) LIMIT 1 ."          
                + "}";
       
        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);

        try {
            com.hp.hpl.jena.query.ResultSet results = qexec.execSelect();
            while (results.hasNext()) {

                QuerySolution soln = results.nextSolution();
                qid = soln.getLiteral("maxqid").getLexicalForm();              
            }

        } finally {
            qexec.close();
        }
        
        return parseLong(qid)+1;
    }
    
    
    public void viewQuestion(long qid){
        
        String qdate;
        String uid;
        String fname;
        String title;
        String qshort;
        String qlong;
        String qrate;

        Model model = FileManager.get().loadModel(rdfPath.rdfPath);
        String queryString = "PREFIX sep: <http://www.semanticweb.org/hesh/ontologies/valkyrie/enigmaplus/ontology#>"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                + "PREFIX strg: <http://www.w3.org/2001/XMLSchema#string#>"
                + "SELECT * "
                + "WHERE {"
                + " ?Question sep:qdate ?qdate ."
                + " ?Question sep:qid \""+qid+"\"."
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
                qdate = soln.getLiteral("qdate").getLexicalForm();
                
                uid = soln.getLiteral("uid").getLexicalForm();
                fname = soln.getLiteral("fname").getLexicalForm();
                title = soln.getLiteral("title").getLexicalForm();
                qshort = soln.getLiteral("qshort").getLexicalForm();
                qlong = soln.getLiteral("qlong").getLexicalForm();
                qrate = soln.getLiteral("qrate").getLexicalForm();
                
                
               q = new Question(qid,qlong,title,qshort,Integer.parseInt(qrate),qdate,"attachment","Picture","Code",parseLong(uid),"categry");

                             
                

            }
            
        } finally {
            qexec.close();
        }
    }
    
    public void qsort(){
        
    }

    
   
//    public static int addQuestion(Question questions) throws ClassNotFoundException, SQLException {
//        Connection conn = DBConnection.getDBConnection().getConnection();
//        Statement stm = conn.createStatement();
//         long qid, String question, String title, String q_short, int rate, String date, String attachment, String picture, String code, long uid) 
//
//        String sql = "Insert into question(question,title,q_short,rate,date,attachment,picture,code,uid,category) values('" + questions.getQuestion() + "','" + questions.getTitle() + "','" + questions.getQ_short() + "','" + questions.getRate() + "','" + questions.getDate() + "','" + questions.getAttachment() + "','" + questions.getPicture() + "','" + questions.getCode() + "','" + questions.getUid() + "','" + questions.getCategory() + "')";
//        int res = stm.executeUpdate(sql);
//        return res;
//    }
//
//    public static Question fillquestion(long num) throws ClassNotFoundException, SQLException {
//        Connection conn = DBConnection.getDBConnection().getConnection();
//        Statement stm = conn.createStatement();
//        if (num == 1) {
//            String sql = "Select qid From question where qid=(SELECT MAX(qid) FROM question)";
//            ResultSet rst = stm.executeQuery(sql);
//            while (rst.next()) {
//                num = Integer.parseInt(rst.getString("qid"));
//            }
//
//        }
//
//        String sql = "Select * From question where qid='" + num + "'";
//        ResultSet rst = stm.executeQuery(sql);
//        if (rst.next()) {
//            Question question = new Question(num, rst.getString("question"), rst.getString("title"), rst.getString("q_short"), Integer.parseInt(rst.getString("rate")), rst.getString("date"), rst.getString("attachment"), rst.getString("picture"), rst.getString("code"), Integer.parseInt(rst.getString("uid")), rst.getString("category"));
//            return question;
//        } else {
//            return null;
//        }
//    }
//public static Question qstRep(long numR) throws ClassNotFoundException, SQLException{
//        Connection connR = DBConnection.getDBConnection().getConnection();
//        Statement stmR = connR.createStatement();
//    String sqlR ="Select * From question where qid='"+numR+"'";
//     ResultSet rst=stmR.executeQuery(sqlR);
//     if(rst.next()){
//     Question question = new Question(numR, rst.getString("question"), rst.getString("title"), rst.getString("q_short"), Integer.parseInt(rst.getString("rate")), rst.getString("date"), rst.getString("attachment"), rst.getString("picture"), rst.getString("code"), Integer.parseInt(rst.getString("uid")), rst.getString("category"));
//            return question;
//     }
//     else{
//     return null;
//     }
//    
//}
//public static Question searchquestion(String Search_title)throws ClassNotFoundException, SQLException{
//        
//        Connection conn = DBConnection.getDBConnection().getConnection();
//        Statement stm = conn.createStatement();
//        String sql = "Select * From question where title='" + Search_title + "'";
//        ResultSet rst = stm.executeQuery(sql);
//               
//        if (rst.next()) {
//            Question question = new Question(Long.parseLong(rst.getString("qid")), rst.getString("question"), rst.getString("title"), rst.getString("q_short"), Integer.parseInt(rst.getString("rate")), rst.getString("date"), rst.getString("attachment"), rst.getString("picture"), rst.getString("code"), Integer.parseInt(rst.getString("uid")), rst.getString("category"));
//            return question;
//        } else {
//            return null;
//        }
//     }
//nipun end
//    public static int deleteCustomer(String id) throws ClassNotFoundException, SQLException{
//        Connection conn = DBConnection.getDBConnection().getConnection();
//        Statement stm = conn.createStatement();
//        String sql="Delete From Customer where id='"+id+"'";
//        return stm.executeUpdate(sql);
//    }
//    public static int updateCustomer(Customer customer) throws ClassNotFoundException, SQLException{
//        Connection conn = DBConnection.getDBConnection().getConnection();
//        Statement stm = conn.createStatement();
//        String sql = "Update Customer set name='"+customer.getName()+"', address='"+customer.getAddress()+"',salary="+customer.getSalary()+" where id='"+customer.getId() +"'";
//        return stm.executeUpdate(sql);
//    }
//    public static ArrayList<Customer> getAllCustomer() throws ClassNotFoundException, SQLException{
//        Connection conn = DBConnection.getDBConnection().getConnection();
//        Statement stm = conn.createStatement();
//        String sql = "Select * From Customer";
//        ResultSet rst = stm.executeQuery(sql);
//        ArrayList<Customer>customerList=new ArrayList<>(); 
//        while(rst.next()) {
//            Customer customer = new Customer(rst.getString("id"), rst.getString("name"), rst.getString("address"), rst.getDouble("salary"));
//            customerList.add(customer);    
//        }
//        return customerList;
//    }
}
