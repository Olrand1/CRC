package ru.rt.crc.api;

import com.jayway.restassured.RestAssured;

public class EndPoints {

  public static final String URL              = "http://crc-staging.dev.digital.rt.ru";

  public static final String LOGIN            = "/api/login";
  public static final String LOGOUT           = "/api/logout";

  public static final String CONTRACTORS_LIST = "/api/contractors/list";
  public static final String CONTRACTORS      = "/api/contractors";

  public static final String DOCUMENT_LIST    = "/api/document/list";


  public static final String TASKS            = "/api/process/tasks";

}

