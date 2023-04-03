package zm.Response;
public enum ExceptionEnum {

    SUCCESS(1,"success"),
    FAIL(0,"失败");
    private final int code;
    private  final String msg;

    ExceptionEnum(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
