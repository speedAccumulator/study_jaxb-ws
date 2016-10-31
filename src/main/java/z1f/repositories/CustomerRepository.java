package z1f.repositories;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Component;
import org.springframework.util.Assert;


import z1f.origin_models.Customer;

@Component
public class CustomerRepository {
	private static final List<Customer> customers = new ArrayList<Customer>();

	@PostConstruct
	public void initData() {
		Customer customer_1 = new Customer();
		customer_1.setCustId(1);
		customer_1.setCustName("jack");

		customers.add(customer_1);
		
		Customer customer_2 = new Customer();
		customer_2.setCustId(2);
		customer_2.setCustName("kevin");

		customers.add(customer_2);
		
		Customer customer_3 = new Customer();
		customer_3.setCustId(3);
		customer_3.setCustName("Andrew");

		customers.add(customer_3);

	}

	public Customer findCustomer(String custName) {
		Assert.notNull(custName);

		Customer result = null;

		for (Customer customer : customers) {
			if (custName.equals(customer.getCustName())) {
				result = customer;
			}
		}

		return result;
	}
}