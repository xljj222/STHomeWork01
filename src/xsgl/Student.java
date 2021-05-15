package xsgl;

public class Student {	 
  private int id;	    
  private String name;  
  private String birDate;
  private Boolean gender;
  public Student() {
  }

  public Student(int id, String name, String birDate, Boolean gender) {
    this.id = id;
    this.name = name;
    this.birDate = birDate;
    this.gender= gender;
  }
  
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getbirDate() {
    return birDate;
  }

  public void setbirDate(String birDate) {
    this.birDate = birDate;
  }
  
  public Boolean getGender() {
    return gender;
  }

  public void setGender(Boolean gender) {
    this.gender = gender;
  }

  public static int  get(int n) {
			
    return n;
  }
  }

	

