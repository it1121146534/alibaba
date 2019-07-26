package com.czxy.score.controller;


import com.czxy.score.domain.Log;
import com.czxy.score.domain.User;
import com.czxy.score.service.LogService;
import com.czxy.score.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private LogService logService;


    @PostMapping("/add")
    public ResponseEntity<String> add(HttpServletRequest request){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(new Date());

        User user = (User) request.getSession().getAttribute("user");

        Log log = new Log(null,user.getId(),user.getUsername(),"add",time);
        logService.addLog(log);
        System.out.println("... 执行add方法");
        return new ResponseEntity<>("add..OK", HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(HttpServletRequest request){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(new Date());

        User user = (User) request.getSession().getAttribute("user");

        Log log = new Log(null,user.getId(),user.getUsername(),"update",time);
        logService.addLog(log);
        System.out.println("... 执行update方法");
        return new ResponseEntity<>("update..OK",HttpStatus.OK);
    }

    @PostMapping("/del")
    public ResponseEntity<String> del(HttpServletRequest request){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(new Date());

        User user = (User) request.getSession().getAttribute("user");

        Log log = new Log(null,user.getId(),user.getUsername(),"del",time);
        logService.addLog(log);
        System.out.println("... 执行del方法");
        return new ResponseEntity<>("del..OK",HttpStatus.OK);
    }

    @GetMapping("/login")
    public ResponseEntity<User> login(User user, HttpServletRequest request ){
        //1.调用方法
        User login = userService.login(user);
        //2.判断返回结果
        if (login != null){
            request.getSession().setAttribute("user",login);
            return new ResponseEntity<>(user,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
