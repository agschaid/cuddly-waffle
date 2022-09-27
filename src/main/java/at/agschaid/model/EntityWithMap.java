package at.agschaid.model;

import java.util.Map;
import java.util.Optional;

public class EntityWithMap {

  private String simpleString;
  private Map<String, String> stringMap;
  private Map<String, InnerEntity> objectMap;

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
public Map<String, InnerEntity> getObjectMap() {
  return objectMap;
}
public void setObjectMap(Map<String, InnerEntity> objectMap) {
  this.objectMap = objectMap;
}
}

