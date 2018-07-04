package com.chips.cmfz.controller;

import com.chips.cmfz.entity.Manager;
import com.chips.cmfz.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 16576 on 2018/7/4.
 */

@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;


    @RequestMapping("/login")
    public String managerLogin(String mgrname, String mgrpwd) {
        Manager manager = managerService.selectManagerByName(mgrname, mgrpwd);
        if (manager != null) {
            return "index";
        }
        return null;
    }
}
