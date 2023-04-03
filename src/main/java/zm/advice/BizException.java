package zm.advice;


public class BizException extends RuntimeException {
    //编码
    private int code;
    //返回信息
    private String msg;
    public BizException(int code,String msg){
        this.code=code;
        this.msg=msg;
    }
}
