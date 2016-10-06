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
   Template template = new Template("Hi, ${name}");
    template.set("name", "Someone else");
    assertEquals("Hi, Someone else", template.evaluate());
  }

  @Test
  public void multipleVariables() {
   Template template = new Template("${one}, ${two}, ${three}");
    template.set("one", "1");
    template.set("two", "2");
    template.set("three", "3");
    assertEquals("1, 2, 3", template.evaluate());
  }

  @Test
  public void unknownVariablesAreIgnored() {
    Template template = new Template("Hello, ${name}");
    template.set("name", "Reader");
    template.set("doesnotexist", "Hi");
    assertEquals("Hello, Reader", template.evaluate());
  }
}

