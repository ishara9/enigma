package ifs.valkyrie.enigmapuls.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import ifs.valkyrie.enigmapuls.model.Answer;
import ifs.valkyrie.enigmapuls.model.Question;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import ifs.valkyrie.enigmapuls.model.User;
import ifs.valkyrie.enigmapuls.service.AnswerService;
import ifs.valkyrie.enigmapuls.service.QuestionService;
import ifs.valkyrie.enigmapuls.service.UserService;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;
import org.openrdf.OpenRDFException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Path("/user")
public class UserREST {

    @Autowired
    private UserService userservice;
    @Autowired
    private QuestionService quesservice;
    @Autowired
    private AnswerService answerservice;

    @GET
    @Path("/print")
    public String printMessage() {
        return "ok";

    }

    @GET
    @Path("/login")
    public String getUsers(
            @QueryParam("username") String username,
            @QueryParam("password") String password) {
        String name = null;
        try {
            User user = userservice.LoginUser(username, password);
            name = user.getFname();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (OpenRDFException ex) {
            ex.printStackTrace();
        }
        return name;

    }

    @GET
    @Path("/signup")
    public User getUsersdeatils(@QueryParam("user") User user) {
        String name = null;
        try {
            User users = userservice.SignupUser(user);
          //  name = user.getFname();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (OpenRDFException ex) {
            ex.printStackTrace();
        }
        return user;

    }
    
    
    
    @POST
    @Path("/logintest")
    public String LoginUsers(
            @QueryParam("username") String username,
            @QueryParam("password") String password) {
        String name = null;
        try {
            User user = new User();
            user.setFname("kasun");
            user.setLname("gunathilaka");
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(user);
            return json;
        } catch (NullPointerException ex) {
            System.out.println(ex);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }
    @POST
    @Path("/findquestion")
    public String FindQuestions(
            @QueryParam("qid") int questionid) {
        
        try {
            Question questions = quesservice.SearchQuestiontitle(questionid);
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(questions);
            return json;
        } catch (NullPointerException ex) {
            System.out.println(ex);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }
}
