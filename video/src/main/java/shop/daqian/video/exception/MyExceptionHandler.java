package shop.daqian.video.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import shop.daqian.video.vo.Result;

@ControllerAdvice
public class MyExceptionHandler {

//    @ResponseBody
//    @ExceptionHandler(Exception.class)
//    public Result<Object> myHandler(Exception e){
//        return Result.fail("系统错误：" + e.getMessage());
//    }
}
