package gj.err;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${server.error.path:${error.path:/error}}")
public class ErrPathController implements org.springframework.boot.web.servlet.error.ErrorController {

    private static final String PATH = "/随便命名-跟他没有半毛钱关系";

    @RequestMapping
    public String doHandleError() {
        return "WHO ARE YOU";
    }

}
