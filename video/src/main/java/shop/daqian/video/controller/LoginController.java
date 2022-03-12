package shop.daqian.video.controller;

import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.daqian.video.entity.User;
import shop.daqian.video.mapper.CommonMapper;
import shop.daqian.video.mapper.UserMapper;
import shop.daqian.video.vo.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author daqian
 * @create 2022/2/layui 16:17
 */

@RestController
public class LoginController {
    @Autowired
    CommonMapper commonMapper;

    @Autowired
    UserMapper userMapper;

//    @Autowired
//    private PasswordEncoder passwordEncoder;


    @PostMapping("/login")
    public Result login( User param, @RequestParam("captcha") String captcha, HttpServletRequest request, HttpSession session){
        if (!CaptchaUtil.ver(captcha, request)) {
            return Result.fail("验证码错误！");
        }
        User user = commonMapper.login(param);
        if(user != null){
//            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//            // 参数1是请求密码，参数2是数据库中加密的值
//            boolean matches = passwordEncoder.matches(param.getPassword(), user.getPassword());
//            if(matches) {
//                // 登录成功
//                session.setAttribute("account", user.getAccount());
//                return Result.success("登录成功");
//            }
            session.setAttribute("account", user.getAccount());
            return Result.success("登录成功");
        }
        return Result.fail("用户名或密码不正确");
    }
    @PostMapping("/register")
    public Result register(@RequestBody User param){
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        param.setPassword(passwordEncoder.encode(param.getPassword()));
        userMapper.save(param);
        return Result.success("注册成功");
    }
}
