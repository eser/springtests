package com.sero.spring.jdbc;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.sero.spring.jdbc.*;

public class TeamDaoTest {

    TeamDao teamDao;

    @Before
    public void setUp() {
    }

    @Test
    public void testFindByname() {
        Team team = teamDao.getTeam(2);

        Assert.assertNotNull(team);
        Assert.assertEquals(2, team.getId());
        Assert.assertEquals("Arsenal", team.getName());

    }

    @After
    public void tearDown() {
    }

}
