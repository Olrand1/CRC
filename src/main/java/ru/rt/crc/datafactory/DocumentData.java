package ru.rt.crc.datafactory;

import org.testng.annotations.DataProvider;

public class DocumentData extends DataGenerator {

  @DataProvider
  public Object ContractData(){
    String docNumber = generateDocNumber();
    Object contact = new Object[]{docNumber};
    return contact;
  }

}
