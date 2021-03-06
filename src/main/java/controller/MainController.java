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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@Controller
public class MainController {
  HashMap<String, String> loginCheck = new HashMap<String, String>();

  JoinAndLoginServiceImpl service = new JoinAndLoginServiceImpl();

  @RequestMapping("/")
  public String index() {

    return "/index";
  }


  @PostMapping("/login")
  public String login(JoinAndLoginDTO dto, HttpServletResponse response) {
    String saveId = loginCheck.get("id");
    String savePw = loginCheck.get("pw");


    if (saveId.equals(dto.getId()) && savePw.equals(dto.getPw())) {
      return "/afterLogin";
    } else {
      response.setContentType("text/html; charset=UTF-8");
      try {
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<script>alert('아이디나 비밀번호가 일치하지 않습니다.');</script>");
        printWriter.flush();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return "/index";
    }
  }

//  @RequestMapping("/loginFail")
//  public String loginFail(HttpServletResponse response) {
//    response.setContentType("text/html; charset=UTF-8");
//    try {
//      PrintWriter printWriter = response.getWriter();
//      System.out.println("<script>alert('아이디나 비밀번호가 일치하지 않습니다.');</script>");
//      printWriter.flush();
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//    return "/index";
//  }

  @GetMapping("/goJoin")
  public String join() {

    return "/join";
  }

  @PostMapping("/joined")
  public String joined(HttpServletRequest request, HttpServletResponse response, JoinAndLoginDTO dto) {
    System.out.println("왔어 왔어 우리가 왔어 스프링~");
    System.out.println(dto.getId());
    System.out.println(dto.getPw());

    loginCheck.put("id", dto.getId());
    loginCheck.put("pw", dto.getPw());

//    service.insertMember(dto);

    return "/index";
  }
}
