package template.test;

import org.junit.Before;
import org.junit.Test;
import template.MissingValueException;
import template.Template;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestTemplate {

  private void assertTemplateEvaluatesTo(String expected){
    assertEquals(expected, template.evaluate());
  }

  private Template template;


  @Before
  public void setUp() {
    template =  new Template("${one}, ${two}, ${three}");
    template.set("one", "1");
    template.set("two", "2");
    template.set("three", "3");
  }

  @Test
  public void multipleVariables() {
    assertTemplateEvaluatesTo("1, 2, 3");
  }

  @Test
  public void unknownVariablesAreIgnored() {
    template.set("doesnotexist", "Hi");
   assertTemplateEvaluatesTo("1, 2, 3");
  }

  @Test
  public void missingValueRaisesExceptionTest() {
    try {

      new Template("${foo}").evaluate();

    } catch (MissingValueException e) {
      assertEquals("No value for ${foo}", e.getMessage());
    }
  }
}

