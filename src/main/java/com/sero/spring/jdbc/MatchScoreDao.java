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
public class MatchScoreDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void addMatchScore(MatchScore matchScore){
        Serializable returnVal = getCurrentSession().save(matchScore);

        System.out.println(returnVal);
    }

    @Transactional
    public List<MatchScore> getAllMatchScores(){
        Criteria criteria = getCurrentSession().createCriteria(MatchScore.class);
        return criteria.list();
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
