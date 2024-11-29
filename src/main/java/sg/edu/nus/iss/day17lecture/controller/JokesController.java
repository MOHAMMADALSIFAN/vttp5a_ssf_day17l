package sg.edu.nus.iss.day17lecture.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.nus.iss.day17lecture.model.Jokes;
import sg.edu.nus.iss.day17lecture.service.JokesRestService;


@Controller
@RequestMapping("/jokes")
public class JokesController {

  @Autowired
  JokesRestService jokerestservice;

  @GetMapping()
  public String getJokesRandom(Model model) {
    List<Jokes>getalljokes = new ArrayList<>();
    getalljokes = jokerestservice.getRandomJokes();
    model.addAttribute("jokes",getalljokes);
      return "jokes";
  }
  
  
}
