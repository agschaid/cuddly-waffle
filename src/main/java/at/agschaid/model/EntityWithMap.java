package at.agschaid.model;

import java.util.Map;
import java.util.Optional;

public class EntityWithMap {

  private Optional<String> optionalString;
  private String simpleString;
  private Map<String, String> stringMap;

  public Optional<String> getOptionalString() {
    return optionalString;
  }
  public void setOptionalString(Optional<String> optionalString) {
    this.optionalString = optionalString;
  }
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

