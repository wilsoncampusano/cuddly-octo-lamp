package template;

public class Template {

  private String templateText;
  private String variableValue;

  public Template(String t) {
    this.templateText = t;
  }

  public void set(String name, String value) {
    this.variableValue = value;
  }

  public String evaluate() {
    return this.templateText.replaceAll("\\$\\{name\\}", variableValue);
  }
}
