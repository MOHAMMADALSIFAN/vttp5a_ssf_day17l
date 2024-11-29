package sg.edu.nus.iss.day17lecture.model;

public class Jokes {

  private Integer id;

  private String type;

  private String setup;

  private String punchline;

  public Jokes() {
  }

  public Jokes(Integer id, String type, String setup, String punchline) {
    this.id = id;
    this.type = type;
    this.setup = setup;
    this.punchline = punchline;
  }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSetup() {
        return setup;
    }

    public void setSetup(String setup) {
        this.setup = setup;
    }

    public String getPunchline() {
        return punchline;
    }

    public void setPunchline(String punchline) {
        this.punchline = punchline;
    }

  
  
}
