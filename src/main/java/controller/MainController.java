package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

  @RequestMapping("/")
  public String index() {

    return "/index";
  }


  @PostMapping("/login")
  public String login() {

    return "/afterLogin";
  }

  @GetMapping("/goJoin")
  public String join() {

    return "/join";
  }

}
