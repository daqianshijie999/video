package shop.daqian.video.controller;

import com.wf.captcha.utils.CaptchaUtil;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import shop.daqian.video.entity.User;
import shop.daqian.video.mapper.CommonMapper;
import shop.daqian.video.mapper.UserMapper;
import shop.daqian.video.utils.ResultUtil;
import shop.daqian.video.vo.Result;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author daqian
 * @create 2022/1/1 16:10
 */
//@RestController
//@CrossOrigin //跨域
@Controller
public class CommonController {
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CaptchaUtil.out(request, response);
    }
    @GetMapping("/test")
    public void test(HttpServletResponse response, HttpServletRequest request, HttpSession session){
        System.out.println("response.getHeaderNames()=="+response.getHeaderNames());
        System.out.println("request.getHeaderNames()=="+request.getHeaderNames());
        System.out.println("session.getId()=="+session.getId());
        System.out.println("session.userInfo()=="+session.getAttribute("userInfo"));
    }
}
