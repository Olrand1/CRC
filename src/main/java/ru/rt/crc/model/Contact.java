package ru.rt.crc.model;

public class Contact {

  String contactName;
  String contactPhone;
  String contactEmail;

  public Contact(String contactName,String contactPhone,String contactEmail) {
    this.contactName = contactName;
    this.contactPhone = contactPhone;
    this.contactEmail = contactEmail;
  }

  public Contact(String contactName, String contactEmail) {
    this.contactName = contactName;
    this.contactEmail = contactEmail;
  }

  public String getContactName() {
    return contactName;
  }

  public String getContactPhone() {
    return contactPhone;
  }

  public String getContactEmail() {
    return contactEmail;
  }
}
