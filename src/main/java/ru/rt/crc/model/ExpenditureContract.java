package ru.rt.crc.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class ExpenditureContract {
  @Getter
  @Setter
  Date dateStart;
  Date dateEnd;
  String docNumber;

}
