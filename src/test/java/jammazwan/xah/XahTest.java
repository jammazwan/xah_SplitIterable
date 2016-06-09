package jammazwan.xah;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jammazwan.entity.Employee;

public class XahTest extends CamelSpringTestSupport {

	@Override
	protected AbstractXmlApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("META-INF/spring/camel-context.xml");
	}

	public List<Employee> setup() {
		List<Employee> coders = new ArrayList<Employee>();
		coders.add(new Employee("Honolulu", "Ajax Coders", "Jan", "Fersing"));
		coders.add(new Employee("Honolulu", "Ajax Coders", "Mort", "Miller"));
		coders.add(new Employee("Honolulu", "Ajax Coders", "Mary", "Smith"));
		coders.add(new Employee("Honolulu", "Ajax Coders", "Jacob", "Applebaum"));
		coders.add(new Employee("Honolulu", "Ajax Coders", "Tommy", "Dokortnick"));
		coders.add(new Employee("Honolulu", "Ajax Coders", "Barry", "Manning"));
		coders.add(new Employee("Honolulu", "Ajax Coders", "William", "Warren"));
		return coders;
	}

	@Test
	public void testXahA() throws Exception {
		MockEndpoint mock = getMockEndpoint("mock:assert1");
		List<Employee> coders = setup();
		mock.expectedMessageCount(7);

		template.requestBody("direct:xah1", coders, String.class);
		mock.assertIsSatisfied();
	}

	@Test
	public void testXahB() throws Exception {
		/*
		 * bean takes 7 coders and splits into two groups of 4 and 3 respectively
		 */
		MockEndpoint mock = getMockEndpoint("mock:assert2");
		List<Employee> coders = setup();
		mock.expectedMessageCount(2);

		template.requestBody("direct:xah2", coders, String.class);
		mock.assertIsSatisfied();
	}

	@Test
	public void testXahC() throws Exception {
		/*
		 * expression takes 7 coders and splits into four groups of no greater than 2
		 */
		MockEndpoint mock = getMockEndpoint("mock:assert3");
		List<Employee> coders = setup();
		mock.expectedMessageCount(4);

		template.requestBody("direct:xah3", coders, String.class);
		mock.assertIsSatisfied();
	}

}
