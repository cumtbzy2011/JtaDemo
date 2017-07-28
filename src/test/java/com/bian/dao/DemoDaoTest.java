package com.bian.dao;

import com.bian.Application;
import com.bian.util.SpringContextUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * DemoDao Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>02/24/2017</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes={Application.class})
public class DemoDaoTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: list()
     */
    @Test
    public void testList() throws Exception {
        //TODO: Test goes here...
    }

    /**
     * Method: get(Long id)
     */
    @Test
    public void testGet() throws Exception {
//TODO: Test goes here...
    }

    @Test
    public void testAdd() throws Exception{
        DemoDao demoDao = SpringContextUtils.getBean(DemoDao.class);
        demoDao.ste();
    }

}
