package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;


@Controller
public class MailController {
  @Autowired
  private JavaMailSender javaMailService;

  @RequestMapping(value = "/email", method = RequestMethod.GET)
  public ModelAndView board2() {
    ModelAndView modelAndView = new ModelAndView();
    int ran = new Random().nextInt(900000) + 100000;
    modelAndView.setViewName("/join");
    modelAndView.addObject("random", ran);
    System.out.println(ran);

    return modelAndView;
  }

  @RequestMapping(value = "/createEmailCheck", method = RequestMethod.GET)
  @ResponseBody
  public String createEmailCheck(@RequestParam String userEmail, @RequestParam int random, HttpServletRequest request) {

    // 이메일 인증
    HttpSession session = request.getSession(true);
    String authCode = String.valueOf(random);
    System.out.println(authCode);
    System.out.println(userEmail);
    session.setAttribute("authCode", authCode);
    session.setAttribute("random", random);
    String subject = "헤헤 인증코드";
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("귀하의 인증 코드는" + authCode + "입니다.");

    try {
      MimeMessage message = javaMailService.createMimeMessage();
      MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

      messageHelper.setFrom("soobineey@gmail.com");
      messageHelper.setTo(userEmail);
      messageHelper.setSubject(subject);
      messageHelper.setText(stringBuilder.toString());

      javaMailService.send(message);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "/join";
  }

  @RequestMapping(value = "/emailAuth", method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity<String> emailAuth(@RequestParam String authCode, @RequestParam String random, HttpSession session) {
//    String originalJoinCode = (String) session.getAttribute("authCode");
//    String originalRandom = Integer.toString((Integer) session.getAttribute("random"));

    if (authCode.equals(authCode) && random.equals(random)) {
      return new ResponseEntity<String>("complete", HttpStatus.OK);
    } else {
     return new ResponseEntity<String>("false", HttpStatus.OK);
    }
  }


}
