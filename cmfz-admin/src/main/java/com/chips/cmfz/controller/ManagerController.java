package com.chips.cmfz.controller;

import com.chips.cmfz.entity.Manager;
import com.chips.cmfz.service.ManagerService;
import com.chips.cmfz.utils.CreateValidateCodeUtil;
import com.sun.deploy.net.URLEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

 /**
 * Created by 16576 on 2018/7/4.
 */

@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;


    @RequestMapping("/login")
    public String managerLogin(String mgrname, String mgrpwd, String enCode, String checkremember,
                               HttpServletResponse response, HttpServletRequest request) throws UnsupportedEncodingException {
        HttpSession session = request.getSession();
        String vCode = (String) session.getAttribute("code");
        if (enCode == null || !vCode.equals(enCode)) return "login";
        Manager manager = managerService.selectManagerByName(mgrname, mgrpwd);
        if (manager != null) {
            if (checkremember != null) {
                Cookie cookie = new Cookie("checkremember", java.net.URLEncoder.encode(mgrname,"UTF-8"));
                cookie.setMaxAge(1200);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
            return "index";
        }
        return "login";
    }

    @RequestMapping("/getVcode")
    public void validateCode(HttpSession session, HttpServletResponse response) throws IOException {
        //创建工具对象，并生成验证码
        CreateValidateCodeUtil vCode = new CreateValidateCodeUtil(100, 30, 1);

        //保存到Session作用域
        session.setAttribute("code", vCode.getCode());

        //使用response获得指向客户端的流对象，并输出
        vCode.write(response.getOutputStream());

    }

}
