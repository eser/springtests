package com.sero.spring.jdbc;

import java.io.Serializable;
import java.util.List;

import com.sero.spring.jdbc.Team;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TeamDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void addTeam(Team team) {
        Serializable returnVal = getCurrentSession().save(team);

        System.out.println(returnVal);
    }

    @Transactional
    public Team getTeam(int id) {
        Criteria criteria = getCurrentSession().createCriteria(Team.class);
        criteria.add(Restrictions.eq("id", id));
        return (Team)criteria.uniqueResult();
    }

    @Transactional
    public void updateTeam(Team team) {
        getCurrentSession().update(team);
    }

    @Transactional
    public void deleteTeam(int id) {
        Team team = this.getTeam(id);
        getCurrentSession().delete(team);
    }

    @Transactional
    public List<Team> getAllTeams() {
        Criteria criteria = getCurrentSession().createCriteria(Team.class);
        return criteria.list();
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
