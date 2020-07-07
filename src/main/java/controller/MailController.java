package controller;

import mail.MailService;
import mail.MailServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;


@Controller
@RequestMapping(value = "/email")
public class MailController {
  @RequestMapping(value = "/email.do")
  public ModelAndView board2() {
    ModelAndView modelAndView = new ModelAndView();
    int ran = new Random().nextInt(900000) + 100000;
    modelAndView.setViewName("test/email");
    modelAndView.addObject("random", ran);

    return modelAndView;
  }

  @RequestMapping(value = "/createEmailCheck.do", method = RequestMethod.GET)
  @ResponseBody
  public boolean createEmailCheck(@RequestParam String userEmail, @RequestParam int random, HttpServletRequest request) {

    MailServiceImpl mailService = new MailServiceImpl();
    // 이메일 인증
    int ran = new Random().nextInt(900000) + 100000;
    HttpSession session = request.getSession(true);
    String authCode = String.valueOf(ran);
    session.setAttribute("authCode", authCode);
    session.setAttribute("random", random);
    String subject = "헤헤 인증코드";
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("귀하의 인증 코드는" + authCode + "입니다.");

    return mailService.send(subject, stringBuilder.toString(), "soobineey@gmail.com", userEmail, null);
  }

  @RequestMapping(value = "/emailAuth.do", method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity<String> emailAuth(@RequestParam String authCode, @RequestParam String random, HttpSession session) {
    String originalJoinCode = (String) session.getAttribute("authCode");
    String originalRandom = Integer.toString((Integer) session.getAttribute("random"));

    if (originalJoinCode.equals(authCode) && originalRandom.equals(random)) {
      return new ResponseEntity<String>("complete", HttpStatus.OK);
    } else {
     return new ResponseEntity<String>("false", HttpStatus.OK);
    }
  }


}
