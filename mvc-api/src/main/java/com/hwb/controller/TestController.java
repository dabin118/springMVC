package com.hwb.controller;

import com.hwb.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/test")
public class TestController {


    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("res","hhhhh");
        return "hello";
    }

    @RequestMapping("/v1/get")
    public void get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getParameter("param");//等
        req.getSession();//等
        req.getSession().setAttribute("res","执行了v1/get方法");
        req.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(req,resp);
    }

    @RequestMapping("/v2/get")
    public ModelAndView get2(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //ModelAndView 模型和视图
        ModelAndView mv = new ModelAndView();

        //封装对象，放在ModelAndView中。Model
        mv.addObject("res","v2/get!");
        //封装要跳转的视图，放在ModelAndView中
        mv.setViewName("hello"); //: /WEB-INF/jsp/hello.jsp
        return mv;
    }

    @RequestMapping("/get/{id}")
    public String getParam(@PathVariable int id,Model model){

        model.addAttribute("res",id);
        return "hello";
    }


    @RequestMapping("/get")
    public String getModel(User user, Model model){

        model.addAttribute("res",user.toString());
        return "hello";
    }

    @RequestMapping("/redirect")
    public String redirect(){
        return "redirect";


    }

}
