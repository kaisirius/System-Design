package LLD.Problems.CarRentalSystem.models;

public class Customer {
  private String id;
  private String name;
  private String phoneNo;
  private String licenseNo;

  public Customer(String id, String name, String phoneNo, String licenseNo) {
    this.id = id;
    this.name = name;
    this.phoneNo = phoneNo;
    this.licenseNo = licenseNo;
  }

  public String getId() {
    return id;
  }
  
  public String getName() {
    return name;
  }

  public String getPhoneNo() {
    return phoneNo;
  }

  public String getLicenseNo() {
    return licenseNo;
  }
}
