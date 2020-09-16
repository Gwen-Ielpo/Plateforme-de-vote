package multimif.grpc.controller;

import multimif.grpc.config.Config;
import multimif.grpc.model.AbstractPollingStrategy;
import multimif.grpc.model.Polling;
import multimif.grpc.model.User;
import multimif.grpc.service.PollingService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
public class PollingController {

    private static final PollingService pollingService;

    static {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);
        pollingService = context.getBean(PollingService.class);
    }

    @RequestMapping(value = "/createpoll", method = RequestMethod.POST)
    public ModelAndView createPolling(HttpSession session,
                                      @RequestParam Map<String, String> params) {

        User owner = (User) session.getAttribute("user");
        String title = params.get("title");
        String creationDate = params.get("creationDate");
        String endDate = params.get("endDate");
        String desc = params.get("description");
        String type = params.get("pollType");

        // les choix sont de la forme 'choiceN' avec N un nombre
        List<String> optionsName = new ArrayList<>();
        params.forEach((name, value) -> {
            if (name.contains("choice")) {
                optionsName.add(value);
            }
        });

        AbstractPollingStrategy strategy =
                AbstractPollingStrategy.getStrategyForType(type);
        Polling p = strategy.createPolling(title, desc, creationDate, endDate,
                owner, optionsName);


        String url = "redirect:/boardpolling?pid=" + p.getId().toString();
        ModelAndView mav = new ModelAndView(url);
        return mav;
    }

    @RequestMapping(value = "/boardpolling", method = RequestMethod.GET)
    public ModelAndView viewPollingBoard(HttpSession session,
                                         @RequestParam("pid") Long pollingId) {
        ModelAndView mav;
        Polling p = pollingService.getPollingById(pollingId);
        if (p == null) {
            throw new IllegalArgumentException("Il n'existe pas de scrutin" +
                    " ayant pour id " + pollingId.toString());
        }
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // l'utilisateur n'est pas connecté
            mav = new ModelAndView("offline_access/poll_board_offline");
        } else if (user.equals(p.getOwner())) {
            // l'utilisateur est propriétaire du scrutin
            mav = new ModelAndView("online_access/poll_board_master");
        } else {
            mav = new ModelAndView("online_access/poll_board_online");
        }
        mav.addObject("polling", p);

        return mav;
    }

}


