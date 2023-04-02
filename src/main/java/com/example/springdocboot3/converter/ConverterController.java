package com.example.springdocboot3.converter;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

@RestController
@RequestMapping("converter")
public class ConverterController {
  private HttpSession session;

  public ConverterController(HttpSession session) {
    this.session = session;
  }

  @GetMapping("/{userId}")
  public User doSomething(@PathVariable("userId") User user, @RequestParam("userIdParam") User userParam, @CookieValue("userIdCookie") User userCookie) {
    System.out.println("requestParam: " + userParam);
    System.out.println("cookieValue: " + userCookie);
    return user;
  }

  @GetMapping("sessionAttribute")
  public User sessionAttribute(@SessionAttribute("settionUser") User user, @SessionAttribute("sessionUserId") String userId) {
    System.out.println(userId);
    return user;
  }

  // TODO: ここからテスト中
  @PostMapping("sessionAttribute")
  public void postSessionAttribute() {
    session.setAttribute("settionUser", "sessionUser");
    session.setAttribute("sessionUserId", "sessionUserId");
  }

  @GetMapping("/requestAttribute")
  public User requestAttribute(@RequestAttribute("userIdAttribute") User user) {
    return user;
  }

  @PostMapping("object")
  public ObjectA test(@RequestHeader("userId") User user, @RequestBody ObjectA request) {
    System.out.println(user);
    return request;
  }
}
