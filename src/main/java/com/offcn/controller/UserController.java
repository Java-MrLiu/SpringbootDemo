package com.offcn.controller;

import com.offcn.pojo.User;
import com.offcn.service.UserService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //查询所有
    @GetMapping("/")
    public String findAll(Model model){
        List<User> userList = userService.findAll();
        System.out.println(userList);
        model.addAttribute("userList", userList);
        return "user/list";
    }
    //用户点击add按钮，跳转到新增页面
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "user/userAdd";
    }

    @RequestMapping("/add")
    public String save(User user){
        userService.add(user);
        return "redirect:/";
    }
    //获取单个用户信息
    @RequestMapping("/toEdit/{id}")
    public String toEdit(Model model, @PathVariable("id") Long id) {
        User user = userService.findOne(id);
        model.addAttribute("user", user);
        return "user/userEdit";
    }

    //保存修改数据
    @RequestMapping("/update")
    public String update(User user) {
        userService.update(user.getId(),user);
        return "redirect:/";
    }

    //删除用户数据
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/";
    }

}
