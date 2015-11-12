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
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamDao teamDao;

    @RequestMapping("/list")
    public ModelAndView getTeams() {
        ModelAndView teamMav = new ModelAndView("teams");
        teamMav.addObject("teams", teamDao.getAllTeams());

        return teamMav;
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public RedirectView addTeam(@RequestParam("name") String name) {
        Team team = new Team();
        team.setName(name);

        teamDao.addTeam(team);

        return new RedirectView("list", true);
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public RedirectView updateTeam(@RequestParam("id") int id, @RequestParam("name") String name) {
        Team team = teamDao.getTeam(id);
        team.setName(name);

        teamDao.updateTeam(team);

        return new RedirectView("list", true);
    }

    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    public RedirectView addTeam(@RequestParam("id") int id) {
        teamDao.deleteTeam(id);

        return new RedirectView("list", true);
    }

}
