package com.sero.spring.jdbc;

import java.io.Serializable;
import java.util.List;

import com.sero.spring.jdbc.Matchscore;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
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
public class MatchscoreDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void addMatchscore(Matchscore matchscore){
        Serializable returnVal = getCurrentSession().save(matchscore);

        System.out.println(returnVal);
    }

    @Transactional
    public Matchscore getMatchscore(int id) {
        Criteria criteria = getCurrentSession().createCriteria(Matchscore.class);
        criteria.add(Restrictions.eq("id", id));
        return (Matchscore)criteria.uniqueResult();
    }

    @Transactional
    public void updateMatchscore(Matchscore matchscore) {
        getCurrentSession().update(matchscore);
    }

    @Transactional
    public void deleteMatchscore(int id) {
        Matchscore matchscore = this.getMatchscore(id);
        getCurrentSession().delete(matchscore);
    }

    @Transactional
    public List<Matchscore> getAllMatchscores(){
        Criteria criteria = getCurrentSession().createCriteria(Matchscore.class);
        return criteria.list();
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
