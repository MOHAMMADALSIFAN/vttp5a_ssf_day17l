package sg.edu.nus.iss.day17lecture.service;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import sg.edu.nus.iss.day17lecture.constant.Constant;
import sg.edu.nus.iss.day17lecture.model.Carpark;
import sg.edu.nus.iss.day17lecture.model.Jokes;

@Service
public class JokesRestService {


  RestTemplate rt = new RestTemplate();

  public List<Jokes> getRandomJokes(){
    String jokesRawData = rt.getForObject(Constant.jokeUrl, String.class);
    // ResponseEntity<String>jokesRawData = rt.getForEntity(Constant.jokeUrl, String.class);
    // string jokesData = jokesRawData.getBody;
  
    JsonReader jReader = Json.createReader(new StringReader(jokesRawData));
    // JsonObject jObject = jReader.readObject();

    JsonArray jArray = jReader.readArray();
   
    List<Jokes> jokes = new ArrayList<>();
    for(int i = 0; i < jArray.size(); i++){
      JsonObject record = jArray.getJsonObject(i);

     Jokes jk = new Jokes();
      jk.setId(record.getInt("id"));
      jk.setId(record.getString("type"));
      jk.setId(record.getInt("id"));
      jk.setId(record.getInt("id"));

   
     jokes.add(jk);
  }

  return jokes;
  }


}

  

