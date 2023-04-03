package zm.advice;

import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import zm.Response.ExceptionEnum;
import zm.Response.Result;

//@RestControllerAdvice
////@ControllerAdvice
//public class MyControllerAdvice {
//    @ExceptionHandler(BizException.class)
//    public Result catchException(Exception e){
//        return new Result(ExceptionEnum.FAIL.getCode(),e.getMessage());
//    }
//
//}
