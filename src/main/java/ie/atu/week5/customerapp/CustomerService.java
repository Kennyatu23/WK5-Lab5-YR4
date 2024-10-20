package ie.atu.week5.customerapp;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    // Constructor-based dependency injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public  Optional<Customer> getCustomerById(String id){
        //Logic to retrieve the customer from the repository
        return customerRepository.findById(id);
    }

    public Customer createCustomer(Customer customer) {
        //Logic to save created customer to the repository
        return customerRepository.save(customer);

    }

    public List<Customer> deleteCustomer(String id) {
        // Checking if customer exists by the id
        if (customerRepository.existsById(id)) {
            //Delete customer using id
            customerRepository.deleteById(id);
        }

        return customerRepository.findAll();

    }

}