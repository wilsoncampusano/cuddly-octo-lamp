package template;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    String result = replaceVariables();
    checkForMissingValues(result);
    return result;
  }

  private String replaceVariables() {
    String result = templateText;
    for(Map.Entry<String,String> entry : variablesValues.entrySet())
      result = result.replaceAll("\\$\\{"+entry.getKey()+"\\}", entry.getValue());
    return result;
  }

  private void checkForMissingValues(String result) {
    Matcher m = Pattern.compile("\\$\\{.+\\}").matcher(result);
    if(m.find())
      throw new MissingValueException("No value for "+m.group());
  }
}
