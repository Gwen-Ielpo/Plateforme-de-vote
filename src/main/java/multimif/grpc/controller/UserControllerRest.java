package multimif.grpc.controller;

import multimif.grpc.config.Config;
import multimif.grpc.crypto.Crypto;
import multimif.grpc.model.PassTestPower;
import multimif.grpc.model.User;
import multimif.grpc.service.UserService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserControllerRest {

    private static UserService userService;
    static {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);
        userService = context.getBean(UserService.class);
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.PUT)
    public String updatePass( HttpSession session,
                              @RequestParam(value = "id", required = true) int  id,
                              @RequestParam (value = "newPass", required = true) String newPass,
                              @RequestParam (value = "oldPass", required = true) String oldPass) throws JSONException {

        User user = userService.getUserById(id);
        JSONObject u = new JSONObject();
        if (user != null && user.getActivated() && !user.getDeleted()){
            if((user.getPassword().equals (Crypto.hash(oldPass))) && PassTestPower.testPassword(newPass)>0){//test password
                user.setPassword(newPass);
                userService.update(user);
                u.put("status","success");

                return u.toString();
            }else{
                u.put("status","failed: votre ancien mot de passe ne correspond pas ");
                return u.toString();
            }
        }else{
            u.put("status","failed: Erreur");
            return u.toString();
        }

    }

    @RequestMapping(value = "/editProfileEmail", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<String> editEmail(HttpSession session,
                                            @RequestParam(value = "newEmail", required = true) String newEmail)throws JSONException {
        User userInSession =  (User) session.getAttribute("user");
        User userOldEmail =  userService.getUserByEmail(userInSession.getEmail());
        User user = userService.getUserByEmail(newEmail);
        JSONObject u = new JSONObject();

        if(user == null && userOldEmail!=null){
            userOldEmail.setEmail(newEmail);
            userService.update(userOldEmail);
            session.setAttribute("user",userOldEmail);
            u.put("status : ","Success:Email modifié");
            return new ResponseEntity<>(u.toString(), HttpStatus.OK);
        }else{
            u.put("status : ","Failed:Erreur modification");
            return new ResponseEntity<>(u.toString(), HttpStatus.NOT_MODIFIED);

        }
    }





}
