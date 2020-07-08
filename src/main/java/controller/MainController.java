package controller;

import dto.JoinAndLoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.JoinAndLoginService;

@Controller
public class MainController {
  @Autowired
//  JoinAndLoginService service;
//  JoinAndLoginDTO dto;

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

  @PostMapping("/joined")
  public String joined(@RequestParam String id, @RequestParam String pw) {

//    dto.setId(id);
//    dto.setPw(pw);

//    service.insertMember(dto);

    return "/";
  }
}
