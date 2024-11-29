package sg.edu.nus.iss.day17lecture.model;

public class Carpark {

  private int carparkId;

  private String carparkName;

  private String carparkCategory;

  private String rate1;

  private String rate2;

  private String saturdayRate;

  private String sundayAndPublicholidayRate;

  public Carpark() {
  }


  public Carpark(int carparkId, String carparkName, String carparkCategory, String rate1, String rate2,
      String saturdayRate, String sundayAndPublicholidayRate) {
    this.carparkId = carparkId;
    this.carparkName = carparkName;
    this.carparkCategory = carparkCategory;
    this.rate1 = rate1;
    this.rate2 = rate2;
    this.saturdayRate = saturdayRate;
    this.sundayAndPublicholidayRate = sundayAndPublicholidayRate;
  }

  public int  getCarparkId() {
    return carparkId;
  }

  public void setCarparkId(int carparkId) {
    this.carparkId = carparkId;
  }

  public String getCarparkName() {
    return carparkName;
  }

  public void setCarparkName(String carparkName) {
    this.carparkName = carparkName;
  }

  public String getRate1() {
    return rate1;
  }

  public void setRate1(String rate1) {
    this.rate1 = rate1;
  }

  public String getRate2() {
    return rate2;
  }

  public void setRate2(String rate2) {
    this.rate2 = rate2;
  }

  public String getSaturdayRate() {
    return saturdayRate;
  }

  public void setSaturdayRate(String saturdayRate) {
    this.saturdayRate = saturdayRate;
  }

  public String getSundayAndPublicholidayRate() {
    return sundayAndPublicholidayRate;
  }

  public void setSundayAndPublicholidayRate(String sundayAndPublicholidayRate) {
    this.sundayAndPublicholidayRate = sundayAndPublicholidayRate;
  }


  public String getCarparkCategory() {
    return carparkCategory;
  }


  public void setCarparkCategory(String carparkCategory) {
    this.carparkCategory = carparkCategory;
  }



}
