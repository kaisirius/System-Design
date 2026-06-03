package LLD.Problems.VendingMachine.models;

public class Item {
  private String sku;
  private String prodName;
  private String companyName;
  private double price;
  private String code;

  public Item(String sku, String prodName, String companyName, double price, String code) {
    this.sku = sku;
    this.prodName = prodName;
    this.companyName = companyName;
    this.price = price;
    this.code = code;
  }

  public String getSKU() {
    return this.sku;
  }

  public String getProdName() {
    return this.prodName;
  }

  public String getCompanyName() {
    return this.companyName;
  }

  public double getPrice() {
    return this.price;
  }

  public String getCode() {
    return this.code;
  }

}
