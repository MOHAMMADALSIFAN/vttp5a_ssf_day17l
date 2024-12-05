package sg.edu.nus.iss.day17lecture.controller;

import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import sg.edu.nus.iss.day17lecture.constant.Constant;
import sg.edu.nus.iss.day17lecture.model.Person;

@Controller
@RequestMapping("/demo")
public class DemoController {

  @GetMapping()
  public String displayDateTime(Model model) throws ParseException {
    String strDate = "2004-08-09 15:30:33";
    SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
    Date testDate = sdf.parse(strDate);
    Long epochMillisecondsDate = testDate.getTime();

    Date testDate2 = new Date(epochMillisecondsDate);
    model.addAttribute("date", testDate2);
    return "demo";
  }

  @Autowired
  @Qualifier(Constant.template01)
  RedisTemplate<String, String> redisTemplate;
 
  @GetMapping("/test")
  @ResponseBody
  public List<String> testHash() {

      List<String> wordList = new ArrayList<>();
      wordList.add("Marina");
      wordList.add("Park");
      wordList.add("Hotel");
      wordList.add("Bridge");
      wordList.add("Merlion");
      wordList.add("Cruise");

      // save the list to hash in redis
      redisTemplate.opsForHash().put("words", "map", wordList.toString());

      // retrieve the list from redis
      Object objWords = redisTemplate.opsForHash().get("words", "map");
      String strObject = objWords.toString();
      strObject = strObject.replace("[", "");
      strObject = strObject.replace("]", "");
      strObject = strObject.replace(" ", "");
      String[] splitWord = strObject.split(",");

      List<String> retrievedList = new ArrayList<>();
      for (String s : splitWord) {
          retrievedList.add(s);
      }

      return retrievedList;
  }
  @GetMapping("/testperson")
    @ResponseBody
    public String testPersonHash() {
        List<Person> personsList = new ArrayList<>();
        Person p = new Person(1, "Darryl", "darrylng@nus.edu.sg", "530363", "97445556");
        personsList.add(p);
        p = new Person(2, "Nancy", "nancy@nus.edu.sg", "119615", "88580067");
        personsList.add(p);

        // serialize using Json-P to JsonArray
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        for (Person p1 : personsList) {
            JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
            jsonObjectBuilder.add("id", p1.getId());
            jsonObjectBuilder.add("fullName", p1.getFullName());
            jsonObjectBuilder.add("email", p1.getEmail());
            jsonObjectBuilder.add("phoneNumber", p1.getPhoneNumber());
            jsonObjectBuilder.add("postalCode", p1.getPostalCode());
            JsonObject jsonObject = jsonObjectBuilder.build();
            jsonArrayBuilder.add(jsonObject);
        }
        JsonArray jsonArray = jsonArrayBuilder.build();

        // save the list to hash in redis - play cheat (please do not do this in exam)
        redisTemplate.opsForHash().put("persons", "map", personsList.toString());

        // save the list to hash in redis - this is the right method to serialize json
        // string
        redisTemplate.opsForHash().put("persons", "map", jsonArray.toString());

        // retrieve the list from redis
        Object objWords = redisTemplate.opsForHash().get("persons", "map");

        // deserialize using Json-P back to collection of persons, List<Person>
        // change return datatype to collection of persons, List<Person>
        // return collection of persons, List<Person>

        return objWords.toString();
    }
    @GetMapping("/testperson/revised")
    @ResponseBody
    public String testPersonHashRevised() {
        List<Person> personsList = new ArrayList<>();
        Person p = new Person(1, "Darryl", "darrylng@nus.edu.sg", "530363", "97445556");
        personsList.add(p);
        p = new Person(2, "Nancy", "nancy@nus.edu.sg", "119615", "88580067");
        personsList.add(p);

        // serialize using Json-P to JsonObject
        for (Person p1 : personsList) {
            JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
            jsonObjectBuilder.add("id", p1.getId());
            jsonObjectBuilder.add("fullName", p1.getFullName());
            jsonObjectBuilder.add("email", p1.getEmail());
            jsonObjectBuilder.add("phoneNumber", p1.getPhoneNumber());
            jsonObjectBuilder.add("postalCode", p1.getPostalCode());
            JsonObject jsonObject = jsonObjectBuilder.build();

            // save the object to hash in redis - this is the right method to serialize json
            // string
            redisTemplate.opsForHash().put("persons", p1.getId().toString(), jsonObject.toString());

        }
        // retrieve the list from redis
        Map<Object, Object> person = redisTemplate.opsForHash().entries("persons");

        for (Map.Entry<Object, Object> entry : person.entrySet()) {
            System.out.println("Key = " + entry.getKey().toString() +
                    ", Value = " + entry.getValue().toString());
        }

        return person.toString();
    }
}

