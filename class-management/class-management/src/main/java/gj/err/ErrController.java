package gj.err;

import gj.util.formatting.ServiceResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class ErrController {

    private final static Logger logger = LoggerFactory.getLogger(ErrController.class);

    /**
     * 总异常，除业务外的异常
     *
     * @param e 总异常
     * @return 系统异常消息体
     */
    @ExceptionHandler(Exception.class)
    public ServiceResponseBody arithmeticExceptionHandle(Exception e) {
        e.printStackTrace();
        return ServiceResponseBody.systemError("系统异常，请联系管理员");
    }

    /**
     * 文件大小限制异常
     *
     * @param e 文件大小限制异常
     * @return 普通异常消息体
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ServiceResponseBody arithmeticExceptionHandle(MaxUploadSizeExceededException e) {
        return ServiceResponseBody.error("文件大小超出限制");
    }

    /**
     * 接口参数校验异常
     *
     * @param e 接口参数校验异常
     * @return 普通异常消息体
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ServiceResponseBody arithmeticExceptionHandle(ConstraintViolationException e) {
        return ServiceResponseBody.error(getConstraintViolationExceptionErr(e.getMessage()));
    }

    /**
     * 处理参数校验异常消息
     *
     * @param errMessage 异常消息
     * @return 普通异常消息体
     */
    private String getConstraintViolationExceptionErr(String errMessage) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] split = errMessage.split(", ");
        for (String s : split) {
            stringBuilder.append(s.substring(s.indexOf(":") + 2)).append(",");
        }
        return stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
    }

    /**
     * 普通业务异常
     *
     * @param e 普通业务异常
     * @return 普通异常消息体
     */
    @ExceptionHandler(ServiceException.class)
    public ServiceResponseBody arithmeticExceptionHandle(ServiceException e) {
        return ServiceResponseBody.error(e.getMessage());
    }

}
