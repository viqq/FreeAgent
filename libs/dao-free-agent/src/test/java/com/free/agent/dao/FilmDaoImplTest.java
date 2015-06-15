package com.free.agent.dao;

import com.free.agent.model.Film;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by antonPC on 12.06.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:dao.xml"})
@Transactional(value = "transactionManagerTest")
public class FilmDaoImplTest extends TestCase {

    @Autowired
    private FilmDaoUtil dao;

    @Test
    public void createReadUpdateDeleteTest() throws Exception {
        Assert.assertEquals(0, 0);
        assertEquals(0, dao.getAll().size());
        Film film = dao.getEntityManager().merge(new Film(20, "1", "1"));
        dao.getEntityManager().flush();
        assertEquals(1, dao.getAll().size());
        film.setDescription("desc");
        dao.update(film);
        dao.getEntityManager().flush();
        assertEquals("desc", dao.read(film.getId()).getDescription());
        dao.delete(film);
       assertEquals(0, dao.getAll().size());
    }
}

