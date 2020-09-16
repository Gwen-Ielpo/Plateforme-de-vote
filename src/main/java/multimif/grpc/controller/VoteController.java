package multimif.grpc.controller;

import multimif.grpc.config.Config;
import multimif.grpc.model.Polling;
import multimif.grpc.model.PollingOption;
import multimif.grpc.model.Turn;
import multimif.grpc.model.Vote;
import multimif.grpc.service.PollingOptionService;
import multimif.grpc.service.PollingService;
import multimif.grpc.service.TurnService;
import multimif.grpc.service.VoteService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class VoteController {

    private static VoteService voteService;
    private static PollingService pollingService;
    private static PollingOptionService pollingOptionService;
    private static TurnService turnService;

    static {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);
        voteService = context.getBean(VoteService.class);
        pollingService = context.getBean(PollingService.class);
        pollingOptionService = context.getBean(PollingOptionService.class);
        turnService = context.getBean(TurnService.class);
    }

    @RequestMapping(value = "/addVote" , method = RequestMethod.POST )
    public ModelAndView addVote (@RequestParam (value = "user_id", required = true) String userId,
                                 @RequestParam (value = "option_per_polling", required = true) Long optionPerPolling,
                                 @RequestParam (value = "id_turn", required = true) int idTurn,
                                 @RequestParam (value = "idPolling", required = true) int idPolling,
                                 @RequestParam (value = "points", required = true) int points
    ){
        Polling polling = pollingService.getPollingById(idPolling);
        Turn turn = turnService.getTurnById(idTurn);
        PollingOption pollingOption = pollingOptionService.getPollingOptionById(optionPerPolling);
        voteService.createVote(userId, pollingOption, polling, turn, points);
        return new ModelAndView("vote");
    }

    @RequestMapping(value = "/voteByPolling", method = RequestMethod.POST)
    public ModelAndView voteByPolling(@RequestParam(value = "idPolling", required = true) int idPolling){
        Polling polling = pollingService.getPollingById(idPolling);
        List<Vote> list = voteService.getVotesByPolling(polling);
        ModelAndView model = new ModelAndView("listeVote");
        model.addObject("lists", list);

        return model;
    }

    @RequestMapping(value = "/voteByUser", method = RequestMethod.POST)
    public ModelAndView voteByUser(@RequestParam(value = "idUser", required = true) String idUser){
        List<Vote> list = voteService.getVotesByUser(idUser);
        ModelAndView model = new ModelAndView("listeVote");
        model.addObject("lists", list);

        return model;
    }

    @RequestMapping("/vote")
    public String vote() { return "vote"; }

}
