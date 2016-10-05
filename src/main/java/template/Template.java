package template;

import java.util.HashMap;
import java.util.Map;

public class Template {

  private String templateText;
  private Map<String,String> variablesValues;

  public Template(String t) {
    this.variablesValues = new HashMap<String, String>();
    this.templateText = t;
  }

  public void set(String name, String value) {
    this.variablesValues.put(name, value);
  }

  public String evaluate() {
    String result = templateText;
    for(Map.Entry<String,String> entry : variablesValues.entrySet()){
       result = result.replaceAll("\\$\\{"+entry.getKey()+"\\}", entry.getValue());
    }

    return result;
  }
}
