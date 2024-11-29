package sg.edu.nus.iss.day17lecture.service;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import sg.edu.nus.iss.day17lecture.constant.Constant;
import sg.edu.nus.iss.day17lecture.model.Carpark;
import sg.edu.nus.iss.day17lecture.repo.HashRepo;

@Service
public class CarparkRestService {

  @Autowired
  HashRepo hashrepo;
  

  RestTemplate rt = new RestTemplate();

  public List<Carpark> getcarpark(){
    String carparkData = rt.getForObject(Constant.carparkURL, String.class);
  
    JsonReader jReader = Json.createReader(new StringReader(carparkData));
    JsonObject jObject = jReader.readObject();

    JsonArray jArray = jObject.getJsonObject("result").getJsonArray("records");
   
    List<Carpark> carpark = new ArrayList<>();
    for(int i = 0; i < jArray.size(); i++){
      JsonObject record = jArray.getJsonObject(i);

     Carpark cp = new Carpark();
      cp.setCarparkId(record.getInt("_id"));
      cp.setCarparkName(record.getString("carpark"));
      cp.setCarparkCategory(record.getString("category"));
      cp.setRate1(record.getString("weekdays_rate_1"));
      cp.setRate2(record.getString("weekdays_rate_2"));
      cp.setSaturdayRate(record.getString("saturday_rate"));
      cp.setSundayAndPublicholidayRate(record.getString("sunday_publicholiday_rate"));
    //  hashrepo.setMap("carpark", cp.getCarparkName(), carpark.toString());
     carpark.add(cp);
  }

  return carpark;
  }


}
