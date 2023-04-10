package gj.util.formatting;

public class ServiceResponseBody {

    public static Integer CODE_SUCCESS = 200;

    public static Integer CODE_NORMAL_ERROR = 500;

    public static Integer CODE_SYSTEM_ERROR = 510;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 返回消息
     */
    private String message;
    /**
     * 返回数据
     */
    private Object data;

    public ServiceResponseBody(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ServiceResponseBody success() {
        return new ServiceResponseBody(CODE_SUCCESS, null, null);
    }

    public static ServiceResponseBody successMessage(String message) {
        return new ServiceResponseBody(CODE_SUCCESS, message, null);
    }

    public static ServiceResponseBody success(Object data) {
        return new ServiceResponseBody(CODE_SUCCESS, null, data);
    }

    public static ServiceResponseBody success(String message, Object data) {
        return new ServiceResponseBody(CODE_SUCCESS, message, data);
    }

    public static ServiceResponseBody error() {
        return new ServiceResponseBody(CODE_NORMAL_ERROR, null, null);
    }

    public static ServiceResponseBody error(String message) {
        return new ServiceResponseBody(CODE_NORMAL_ERROR, message, null);
    }

    public static ServiceResponseBody error(Object data) {
        return new ServiceResponseBody(CODE_NORMAL_ERROR, null, data);
    }

    public static ServiceResponseBody error(String message, Object data) {
        return new ServiceResponseBody(CODE_NORMAL_ERROR, message, data);
    }

    public static ServiceResponseBody systemError(String message) {
        return new ServiceResponseBody(CODE_SYSTEM_ERROR, message, null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
