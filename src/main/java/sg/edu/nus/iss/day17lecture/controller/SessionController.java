package sg.edu.nus.iss.day17lecture.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.nus.iss.day17lecture.model.Session;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/session")
public class SessionController {

  @GetMapping("")
  public String sessionCreate(Model model) {
    Session se = new Session();
    model.addAttribute("session", se);
    return "index";
  }

  @PostMapping("/sessions")
  public String postSessionCreate(
      @Valid @ModelAttribute("session") Session se,
      BindingResult result,
      HttpSession hs,
      Model model) {
    List<Session> sessions = null;
    if (hs.getAttribute("session") == null) {
      sessions = new ArrayList<>();
    } else {
      sessions = (List<Session>) hs.getAttribute("session");
    }
    sessions.add(se);

    hs.setAttribute("session", sessions);
    model.addAttribute("sessions", sessions);
    return "sessionlist";
  }

  @GetMapping("/list")
  public String showsessions(HttpSession hs, Model model) {
    List<Session> sessions = null;
    if (hs.getAttribute("session") == null) {
      sessions = new ArrayList<>();
    } else {
      sessions = (List<Session>) hs.getAttribute("session");
    }
    model.addAttribute("sessions", sessions);
    return "sessionlist";
  }
  @GetMapping("/home")
  public String homePage() {
      return "home";
  }
  @GetMapping("/clear")
  public String clearSession(HttpSession httpSession) {
      httpSession.removeAttribute("session");
      httpSession.invalidate();

      return "redirect:/session/home";
  }
}
