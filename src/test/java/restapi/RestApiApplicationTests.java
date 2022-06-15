package restapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestApiApplicationTests {

	@Test
	void testcase1(){
		//
		int num1=20;int num2=30;
		sample obj= new sample();
		int expected=50;
		
		int actual=obj.add(num1, num2);
		
		assertEquals(expected, actual);
	}
	
	class sample{
		int add(int a, int b) {
			return a+b;
		}
	}
}
