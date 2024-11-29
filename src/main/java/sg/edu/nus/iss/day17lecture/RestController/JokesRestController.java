package sg.edu.nus.iss.day17lecture.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.day17lecture.model.Jokes;
import sg.edu.nus.iss.day17lecture.service.JokesRestService;

@RestController
@RequestMapping("/api/jokes")
public class JokesRestController {
    
  @Autowired
  JokesRestService jokesRestService;

  @GetMapping()
    public ResponseEntity<List<Jokes>> getjokes() {
        List<Jokes> jokes = new ArrayList<>();

        jokes = jokesRestService.getRandomJokes();

        return ResponseEntity.ok().body(jokes);
    }
  
}
