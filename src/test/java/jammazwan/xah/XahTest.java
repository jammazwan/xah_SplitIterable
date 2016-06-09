package jammazwan.xah;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jammazwan.entity.Employee;

public class XahTest extends CamelSpringTestSupport {

	@Override
	protected AbstractXmlApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("META-INF/spring/camel-context.xml");
	}

	@Test
	public void testXah() throws Exception {
		MockEndpoint mock = getMockEndpoint("mock:assert");
		mock.expectedMessageCount(6);

		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("Honolulu", "Ajax Coders", "Jan", "Fersing"));
		employees.add(new Employee("Honolulu", "Ajax Coders", "Mort", "Miller"));
		employees.add(new Employee("Honolulu", "Ajax Coders", "Mary", "Smith"));
		employees.add(new Employee("Honolulu", "Ajax Coders", "Jacob", "Applebaum"));
		employees.add(new Employee("Honolulu", "Ajax Coders", "Tommy", "Dokortnick"));
		employees.add(new Employee("Honolulu", "Ajax Coders", "Barry", "Manning"));

		template.requestBody("direct:xah", employees, String.class);
		mock.assertIsSatisfied();
	}

}
