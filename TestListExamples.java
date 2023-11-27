import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

public class TestListExamples {
  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testFilter() {
    List<String> input = Arrays.asList("apple", "banana", "moon", "sun");
    List<String> expected = Arrays.asList("moon");
    IsMoon moon = new IsMoon(); 
    List<String> result = ListExamples.filter(input, moon); 
    assertEquals(expected, result);
  }

  @Test(timeout = 500)
  public void testFilterNone() {
    List<String> input = Arrays.asList("apple", "banana", "sun");
    List<String> expected = Arrays.asList();
    IsMoon moon = new IsMoon(); 
    List<String> result = ListExamples.filter(input, moon); 
    assertEquals(expected, result);
  }

  @Test(timeout = 500)
  public void testFilterMultiple() {
    List<String> input = Arrays.asList("apple", "moon", "banana", "sun", "Moon");
    List<String> expected = Arrays.asList("moon", "Moon");
    IsMoon moon = new IsMoon(); 
    List<String> result = ListExamples.filter(input, moon); 
    assertEquals(expected, result);
  }
}
