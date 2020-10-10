package com.etc.controller;

import com.etc.entity.Student;
import com.etc.feigninters.StudentFeignClient;
import com.etc.service.StudentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService studentService;
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private StudentFeignClient studentFeignClient;

    @HystrixCommand(fallbackMethod = "getdefaultuser")

    @RequestMapping("/getbyid/{sid}")
    public Student getStudent(@PathVariable Integer sid){
        return studentService.getBySid(sid);
    }

    @RequestMapping("/getclass/{cid}")
    public Map<String,Object> getUser(@PathVariable Integer cid){
        Map<String,Object> map = restTemplate.getForObject("http://localhost:8765/class/getbyid/"+cid,Map.class);
        return map;
    }


    private Student getdefaultuser(Integer id){
        Student s=new Student();
        s.setSname("tom");
        s.setSex("不男不女");
        return  s;
    }


    @RequestMapping("/index")
    public ModelAndView getindex(String url){
        ModelAndView mv=new ModelAndView("index");
        mv.addObject("url",url);
        return mv;
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(String user, String url, String password, HttpServletResponse response, HttpSession session) throws IOException {
        System.out.println("参数"+url+user+password);
        if(user.equals("root")&& password.equals("123456")){
            session.setAttribute("user",user);
            if(url != null && !url.equals("")){
                response.sendRedirect(url);
            }
        }
        return "登陆成功";
    }



    @RequestMapping("/getclassinfo/{sid}")
    public Map<String,Object> getClassInfo(@PathVariable Integer sid){
        Student student = studentService.getBySid(sid);
        Map<String,Object> map = new HashMap<>();
        if( student.getScla()!= null){
           map=studentFeignClient.getClassBycla(student.getScla());
          //map = restTemplate.getForObject("http://localhost:8765/class/getcla/"+ student.getScla(),Map.class);
        }
        if(student != null){
            map.put("Sid",student.getSid());
            map.put("Sname",student.getSname());
            map.put("Sex",student.getSex());
            map.put("Age",student.getAge());
        }
        return map;
    }
}
