package template.test;

import org.junit.Before;
import org.junit.Test;
import template.Template;

import static org.junit.Assert.assertTrue;

public class TestTemplatePerformance {


  private Template template;

  @Before
  public void setUp() {
    buildTemplate();
    populateTemplate();
  }

  private void populateTemplate() {
    for (int var = 1; var < 100; var++) {
      template.set("var" + var, "value of var" + var);
    }
  }

  private void buildTemplate() {
    StringBuffer text = new StringBuffer(50000);
    for (int i = 0, var = 1; i < 1000; i++, var++) {
      text.append(" template ");
      if (i % 1000 / 50 == 0) {
        text.append("${var").append(var).append("}");
      }
    }
    template = new Template(text.toString());
  }

  @Test
  public void templateWith100WordsAnd20VariablesTest() {
    long expected = 200L;

    long time = System.currentTimeMillis();
    template.evaluate();
    time = System.currentTimeMillis() - time;

    assertTrue("rendering took "+ time+" ms while the target was "+expected+" ms", time <= expected);
  }
}
