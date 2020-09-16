package multimif.grpc.controller;

import multimif.grpc.config.Config;
import multimif.grpc.model.MailSender;
import multimif.grpc.model.User;
import multimif.grpc.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


@RestController
public class UserController {
    private static UserService userService;
    static {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);
        userService = context.getBean(UserService.class);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(HttpSession session,
                              @RequestParam("ids") String id,
                              @RequestParam("pwd") String pwd) {

        // id peut etre soit l'email, soit le pseudo
        User user = userService.authenticate(id, pwd);
        ModelAndView mav;

        if(user == null) {
            mav = new ModelAndView("redirect:/connection");
            mav.getModel().put("connection_failed", true);
        } else {
            mav = new ModelAndView("redirect:/index");
            session.setAttribute("user", user);
        }

        return mav;
    }

    @RequestMapping(value = "/disconnect", method = RequestMethod.GET)
    public ModelAndView disconnect(HttpSession session) {
        session.invalidate();
        return new ModelAndView("redirect:/index");
    }

    @RequestMapping(value = "/registration" , method = RequestMethod.POST)
    public ModelAndView registration (
                             @RequestParam (value = "pseudo", required = true) String pseudo,
                             @RequestParam (value = "email", required = true) String email,
                             @RequestParam (value = "pwd", required = true) String password,
                             @RequestParam (value = "pwdConfirm", required = true) String pwdConfirm){

        User userE = userService.getUserByEmail(email);
        User userP = userService.getUserByPseudo(pseudo);
        ModelAndView mav;

        if (userE != null || userP != null){
            mav = new ModelAndView("redirect:/register");
            mav.getModel().put("already_exist", true);
        } else if (password.equals(pwdConfirm)) {
            User newUser = userService.createUser(pseudo,email,password);
                if(newUser != null){
                    MailSender.generateAndSendEmail(newUser);
                    mav = new ModelAndView("offline_access/waiting_accesscode");
                }else{
                    mav = new ModelAndView("redirect:/register");
                    mav.getModel().put("Registration failed", false);
                }
        } else {
            mav = new ModelAndView("redirect:/register");
            mav.getModel().put("pwd_mismatch", true);
        }

        return mav;
    }



    @RequestMapping(value = "/registrationConfirm" , method = RequestMethod.GET)
    public ModelAndView registration (HttpSession session,
                                      @RequestParam (value = "code", required = true) String code){
        ModelAndView mav;
       User user = userService.getUserByCode(code);
       if(user != null && !user.getDeleted()){
           if(!user.getActivated()){
               user.setActivated(true);
               userService.update(user);
               mav = new ModelAndView("redirect:/index");
                session.setAttribute("user", user);
           }else{
               mav = new ModelAndView("redirect:/index");
           }
       }else{
           mav = new ModelAndView("redirect:/");
       }
       return mav;
    }




}

