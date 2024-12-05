package sg.edu.nus.iss.day17lecture.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class Session{

  @NotBlank
  @Size(min=3, max=100 , message= "Min 3 & Max 100 Characters, Name is Mandatory")
  private String fullName;

@DateTimeFormat(pattern = "yyyy-MM-dd")
@Past(message = "Date of Birth is mandatory & must be in past")
  private Date dateOfBirth;

  public Session() {
  }

  public Session(String fullName, Date dateOfBirth) {
    this.fullName = fullName;
    this.dateOfBirth = dateOfBirth;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public  Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth( Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  @Override
  public String toString() {
    return fullName + "," + dateOfBirth;
  }

  

}