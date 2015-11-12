package com.sero.spring.jdbc;

import com.sero.spring.jdbc.TeamDao;
import com.sero.spring.jdbc.Team;
import com.sero.spring.jdbc.MatchscoreDao;
import com.sero.spring.jdbc.Matchscore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/matchscore")
public class MatchscoreController {

    @Autowired
    private MatchscoreDao matchscoreDao;

    @Autowired
    private TeamDao teamDao;

    @RequestMapping("/list")
    public ModelAndView getMatchscores()
    {
        ModelAndView matchscoresMav = new ModelAndView("matchscores");
        matchscoresMav.addObject("teams", teamDao.getAllTeams());
        matchscoresMav.addObject("matchscores", matchscoreDao.getAllMatchscores());

        return matchscoresMav;
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public RedirectView addMatchscore(@RequestParam("hometeam") int homeTeam, @RequestParam("homescore") int homeScore, @RequestParam("awayteam") int awayTeam, @RequestParam("awayscore") int awayScore)
    {
        Matchscore matchscore = new Matchscore();
        matchscore.setHomeTeam(homeTeam);
        matchscore.setHomeScore(homeScore);
        matchscore.setAwayTeam(awayTeam);
        matchscore.setAwayScore(awayScore);

        matchscoreDao.addMatchscore(matchscore);

        return new RedirectView("list", true);
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public RedirectView updateMatchscore(@RequestParam("id") int id, @RequestParam("hometeam") int homeTeam, @RequestParam("homescore") int homeScore, @RequestParam("awayteam") int awayTeam, @RequestParam("awayscore") int awayScore)
    {
        Matchscore matchscore = matchscoreDao.getMatchscore(id);
        matchscore.setHomeTeam(homeTeam);
        matchscore.setHomeScore(homeScore);
        matchscore.setAwayTeam(awayTeam);
        matchscore.setAwayScore(awayScore);

        matchscoreDao.updateMatchscore(matchscore);

        return new RedirectView("list", true);
    }

    @RequestMapping(path = "/delete")
    public RedirectView addMatchscore(@RequestParam("id") int id)
    {
        matchscoreDao.deleteMatchscore(id);

        return new RedirectView("list", true);
    }

}
