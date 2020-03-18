import org.springframework.web.bind.annotation.RequestMapping;

public class Controller {
    @RequestMapping("/")
    public String display()
    {
        return "index";
    }
}
