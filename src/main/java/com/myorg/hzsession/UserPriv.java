package com.myorg.hzsession;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserPriv implements Serializable {

  private String userId;
  private String name;
  private List<String> stringList = new ArrayList<String>();

  public String getUserId () {
    return userId;
  }

  public void setUserId (String userId) {
    this.userId = userId;
  }

  public String getName () {
    return name;
  }

  public void setName (String name) {
    this.name = name;
  }

  public List<String> getStringList () {
    return stringList;
  }

  public void setStringList (List<String> stringList) {
    this.stringList = stringList;
  }
}
