package sg.edu.nus.iss.day17lecture.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import sg.edu.nus.iss.day17lecture.service.CarparkRestService;


import sg.edu.nus.iss.day17lecture.model.Carpark;


@Controller
@RequestMapping("/carpark")
public class CarparkController {

  @Autowired
  CarparkRestService carparkrestservice;

  @GetMapping("/list")
  public String getallCarpark(Model model) {
    List<Carpark> carparkgetall = new ArrayList<>();
    carparkgetall = carparkrestservice.getcarpark();
    model.addAttribute("carpark", carparkgetall);
      return "carparklist";
  }
  


  
}
