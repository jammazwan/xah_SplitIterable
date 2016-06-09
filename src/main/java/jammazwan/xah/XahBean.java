package jammazwan.xah;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;

import jammazwan.entity.Employee;

public class XahBean {
	/*
	 * bean takes 7 employees and splits into two groups of 4 and 3 respectively
	 */
	public List<List<Employee>> answer(Exchange exchange) {
		List<Employee> employees = (List<Employee>) exchange.getIn().getBody();
		int size = employees.size() / 2;
		List<List<Employee>> groups = new ArrayList<List<Employee>>();

		List<Employee> group = new ArrayList<Employee>();
		groups.add(group);
		int i = 0;
		for (Employee employee : employees) {
			group.add(employee);
			i++;
			if (i > size) {
				group = new ArrayList<Employee>();
				groups.add(group);
				i=0;
			}

		}
		return groups;
	}

}
