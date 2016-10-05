package template.test;

import org.junit.Test;
import template.Template;

import static org.junit.Assert.assertEquals;

public class TestTemplate {

  @Test
  public void oneVariable() {
    Template template = new Template("Hello, ${name}");
    template.set("name", "Reader");
    assertEquals("Hello, Reader", template.evaluate());
  }

  @Test
  public void differentValues() {
   Template template = new Template("Hello, ${name}");
    template.set("name", "Someone else");
    assertEquals("Hello, Someone else", template.evaluate());
  }
}

