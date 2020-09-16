package multimif.grpc.controller;

import multimif.grpc.config.Config;
import multimif.grpc.model.AbstractPollingStrategy;
import multimif.grpc.model.Polling;
import multimif.grpc.model.User;
import multimif.grpc.service.PollingService;
import multimif.grpc.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;


@Controller
public class NavController {

    private static PollingService pollingService;
    private static UserService userService;
    static {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);
        pollingService = context.getBean(PollingService.class);
        userService = context.getBean(UserService.class);
    }


    @RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
    public ModelAndView index(HttpSession session) {
        User user = (User) session.getAttribute("user");
        ModelAndView mav;
        if(user != null) {
            // l'utilisateur est connecte
            mav = new ModelAndView("online_access/index_online");
            mav.getModel().put("user", user);
        } else {
            // l'utilisateur n'est pas connecte
            mav = new ModelAndView("offline_access/index_offline");
        }
        return mav;
    }

    @RequestMapping(value = "/connection", method = RequestMethod.GET)
    public ModelAndView connection() {
        ModelAndView mav = new ModelAndView("offline_access/connection");
        return mav;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView mav = new ModelAndView("offline_access/register");
        return mav;
    }

    @RequestMapping(value = "/polllist", method = RequestMethod.GET)
    public ModelAndView listPollings(HttpSession session) {

        User user = (User) session.getAttribute("user");
        List<Polling> activePollings = pollingService.getActivePollings();
        ModelAndView mav;

        if(user == null) {
            // l'utilisateur n'est pas connecté
            mav = new ModelAndView("offline_access/poll_list_offline");
        } else {
            mav = new ModelAndView("online_access/poll_list_online");
        }
        mav.addObject("pollings", activePollings);
        return mav;
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView profile(HttpSession session) {
        // profil de l'utilisateur
        User user = (User) session.getAttribute("user");
        ModelAndView mav = new ModelAndView("online_access/profile");
        mav.addObject("user", user);
        return mav;
    }

    @RequestMapping(value = "/myvoteslist", method = RequestMethod.GET)
    public ModelAndView myVotesList() {
        // liste des scrutins auxquels l'utilisateur a participe
        return null;
    }

    @RequestMapping(value = "/createnewpoll", method = RequestMethod.GET)
    public ModelAndView formNewPoll() {
        ModelAndView mav = new ModelAndView("online_access/form_new_poll");
        List<AbstractPollingStrategy.PollingType> types = Arrays.asList(
                AbstractPollingStrategy.PollingType.values()
        );
        mav.addObject("listTypes", types);
        return mav;
    }

    @RequestMapping(value = "/mypolllist", method = RequestMethod.GET)
    public ModelAndView myListPoll(HttpSession session) {
        ModelAndView mav = new ModelAndView("online_access/my_poll_list_online");
        User owner = (User) session.getAttribute("user");
        List<Polling> pollings = pollingService.getPollingsOwnedBy(owner);
        mav.getModel().put("listP", pollings);
        return mav;
    }

}
