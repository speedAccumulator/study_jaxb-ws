package z1f.webServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import z1f.repositories.CustomerRepository;

import z1f.origin_models.GetCustomerRequest;
import z1f.origin_models.GetCustomerResponse;

@Endpoint
public class CustomerEndpoint {
	private static final String NAMESPACE_URI = "http://z1f/models";

	private CustomerRepository customerRepository;

	@Autowired
	public CustomerEndpoint(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCustomerRequest")
	@ResponsePayload
	public GetCustomerResponse getCustomer(@RequestPayload GetCustomerRequest request) {
		GetCustomerResponse response = new GetCustomerResponse();
		response.setCustomer(customerRepository.findCustomer(request.getCustName()));

		return response;
	}
}