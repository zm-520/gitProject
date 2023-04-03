package zm.Response;

import com.baomidou.mybatisplus.extension.api.R;
import org.apache.poi.ss.formula.functions.T;
import sun.jvm.hotspot.code.ScopeDesc;

public class Result<T> {
    private int code;
    private String msg;
    /**
     应的具体数据
     */
    private T data;
    public Result(int code,String msg,T data){
        this.code=code;
        this.msg=msg;
        this.data=data;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
