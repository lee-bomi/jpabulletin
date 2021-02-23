package jpastudy1.jpabulletin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BulletinController {

    @GetMapping("/")
    public String home(){
        return "home.html";
    }

    @GetMapping("/join")
    public String join(){
        return "join.html";
    }

    @GetMapping("/list")
    public String list(Member member){
        return "list.html";
    }
}
