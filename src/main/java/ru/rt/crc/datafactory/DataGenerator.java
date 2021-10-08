package ru.rt.crc.datafactory;

import java.util.Random;
import java.util.UUID;

public class DataGenerator {

  public String generateInn(boolean isPerson) {
    String inn = "";
    if (!isPerson) {
      int min = 1000000000;
      int max = 1999999999;
      inn  = String.valueOf(new Random().nextInt(max - min) + min);
    }
    else {
      int min = 10000000;
      int max = 99999999;
      String code = String.valueOf(new Random().nextInt(9999 - 1000) + 1000);
      String number = String.valueOf(new Random().nextInt(max - min) + min);
      inn = code + number;
    }
    return inn;
  }

  public String generateDocNumber(){
    String docNumber = UUID.randomUUID().toString();
    return docNumber;
  }

}
