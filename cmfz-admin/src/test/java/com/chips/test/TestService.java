package com.chips.test;

import com.chips.cmfz.entity.Manager;
import com.chips.cmfz.service.ManagerService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by 16576 on 2018/7/4.
 */
public class TestService {


    @Test
    public void TestService(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");

        ManagerService managerService= (ManagerService) ctx.getBean("managerServiceImpl");

        List<Manager> managers=managerService.selectAllManager();
        for (Manager manager : managers) {
            System.out.println(manager);
        }

    }

    @Test
    public void TestServiceSelectById(){

        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");

        ManagerService managerService= (ManagerService) ctx.getBean("managerServiceImpl");

        Manager manager=managerService.selectManagerByName("test","123456");

        System.out.println(manager);

    }
}
