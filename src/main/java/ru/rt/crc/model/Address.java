package ru.rt.crc.model;

public class Address {

  String locationType;
  String location;
  String addressType;
  String address;
  String rentArea;

  public Address(String locationType, String location, String addressType, String address, String rentArea) {
    this.locationType = locationType;
    this.location = location;
    this.addressType = addressType;
    this.address = address;
    this.rentArea = rentArea;
  }

  public Address(String locationType, String location, String addressType, String address) {
    this.locationType = locationType;
    this.location = location;
    this.addressType = addressType;
    this.address = address;
  }

  public Address(String locationType, String location, String rentArea) {
    this.locationType = locationType;
    this.location = location;
    this.rentArea = rentArea;
  }

  public Address(String locationType, String location) {
    this.locationType = locationType;
    this.location = location;
  }

  public String getLocationType() {
    return locationType;
  }

  public String getLocation() {
    return location;
  }

  public String getAddressType() {
    return addressType;
  }

  public String getAddress() {
    return address;
  }

  public String getRentArea() {
    return rentArea;
  }
}
