package at.agschaid.model;

import java.util.Map;
import java.util.Optional;

public class EntityWithMap {

  private String simpleString;
  private Map<String, String> stringMap;

  public String getSimpleString() {
    return simpleString;
  }
  public void setSimpleString(String simpleString) {
    this.simpleString = simpleString;
  }
  public Map<String, String> getStringMap() {
    return stringMap;
  }
  public void setStringMap(Map<String, String> stringMap) {
    this.stringMap = stringMap;
  }
}

