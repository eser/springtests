package com.sero.spring.jdbc;

import com.sero.spring.jdbc.TeamDao;
import com.sero.spring.jdbc.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/matchscore")
public class MatchScoreController {

    @Autowired
    private MatchScoreDao matchScoreDao;

    @Autowired
    private TeamDao teamDao;

    @RequestMapping("/list")
    public ModelAndView getMatchScores()
    {
        ModelAndView matchScoresMav = new ModelAndView("matchscores");
        matchScoresMav.addObject("teams", teamDao.getAllTeams());
        // matchScoresMav.addObject("matchscores", matchScoreDao.getAllMatchScores());

        return matchScoresMav;
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public RedirectView addMatchScore(@RequestParam("hometeam") int homeTeam, @RequestParam("homescore") int homeScore, @RequestParam("awayteam") int awayTeam, @RequestParam("awayscore") int awayScore)
    {
        MatchScore matchScore = new MatchScore();
        matchScore.setHomeTeam(homeTeam);
        matchScore.setHomeScore(homeScore);
        matchScore.setAwayTeam(awayTeam);
        matchScore.setAwayScore(awayScore);

        matchScoreDao.addMatchScore(matchScore);

        return new RedirectView("list", true);
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public RedirectView updateMatchScore(@RequestParam("id") int id, @RequestParam("hometeam") int homeTeam, @RequestParam("homescore") int homeScore, @RequestParam("awayteam") int awayTeam, @RequestParam("awayscore") int awayScore)
    {
        MatchScore matchScore = matchScoreDao.getMatchScore(id);
        matchScore.setHomeTeam(homeTeam);
        matchScore.setHomeScore(homeScore);
        matchScore.setAwayTeam(awayTeam);
        matchScore.setAwayScore(awayScore);

        matchScoreDao.updateMatchScore(matchScore);

        return new RedirectView("list", true);
    }

    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    public RedirectView addMatchScore(@RequestParam("id") int id)
    {
        matchScoreDao.deleteMatchScore(id);

        return new RedirectView("list", true);
    }

}
