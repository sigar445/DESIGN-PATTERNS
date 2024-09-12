package org.sigar.Annotations;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class CustomerClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String baseUrl = "http://localhost:8080/api/customers";

    public List<Customer> getCustomersByLastName(String lastName) {
        String url;
        url = baseUrl + "/byLastName/" + lastName;
        // Correctly specify the type of the response using ParameterizedTypeReference
        ResponseEntity<List<Customer>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Customer>>() {}
        );

        return response.getBody();
    }
    public List<Customer> getCustomersByFirstName(String firstName) {
        String url;
        url = baseUrl + "/byFirstName/" + firstName;
        // Correctly specify the type of the response using ParameterizedTypeReference
        ResponseEntity<List<Customer>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Customer>>() {}
        );

        return response.getBody();
    }

    public static void main(String[] args) {
        CustomerClient client = new CustomerClient();
        List<Customer> customerList = client.getCustomersByLastName("wick");
        customerList.forEach(System.out::println);
        System.out.println(client.getCustomersByFirstName("tommy"));
    }
}
