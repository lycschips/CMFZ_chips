package com.chips.test;

import com.chips.cmfz.dao.ManagerDao;
import com.chips.cmfz.entity.Manager;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by 16576 on 2018/7/4.
 */
public class TestDao {

    @Test
    public void TestManagerDao(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ManagerDao managerDao= (ManagerDao) ctx.getBean("managerDao");
        List<Manager> managers=managerDao.selectAllManager();
        for (Manager manager : managers) {
            System.out.println(manager);
        }
    }
    @Test
    public void TestManagerSelectbyname(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        ManagerDao managerDao = (ManagerDao) ctx.getBean("managerDao");
        Manager manager=managerDao.selectManagerByName("test");
        System.out.println(manager);
    }
}
