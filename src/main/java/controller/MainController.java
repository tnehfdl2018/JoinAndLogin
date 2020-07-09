package controller;

import dto.JoinAndLoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.JoinAndLoginService;
import service.JoinAndLoginServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MainController {

  JoinAndLoginServiceImpl service = new JoinAndLoginServiceImpl();

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
  public String joined(HttpServletRequest request, HttpServletResponse response, JoinAndLoginDTO dto) {
    System.out.println("왔어 왔어 우리가 왔어 스프링~");
    System.out.println(dto.getId());
    System.out.println(dto.getPw());


    service.insertMember(dto);

    return "/index";
  }
}
