package hello.thymeleaf.basic;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/basic")
@RequiredArgsConstructor
public class BasicController {

    @GetMapping("/text-basic")
    public String textBasic(Model model){
        model.addAttribute("data","Hello <b>Spring</b>; World");
        return "basic/text-basic";
    }

    @GetMapping("/text-unescaped")
    public String textUnescaped(Model model){
        model.addAttribute("data","Hello <b>Spring</b> World");
        return "basic/text-unescaped";
    }

    @GetMapping("/variable")
    public String variable(Model model){
        User userA = new User("userA",10);
        User userB = new User("userB",10);
        List<User> list = new ArrayList<>();
        list.add(userA);
        list.add(userB);
        Map<String, User> map = new HashMap<>();
        map.put("userA",userA);
        map.put("userB",userB);
        model.addAttribute("user", userA);
        model.addAttribute("users", list);
        model.addAttribute("userNMap", map);
        return "/basic/variable";
    }

    @Data
    static class User{
        private String username;
        private int age;
        public User(String userA, int i) {
        }
    }
}
