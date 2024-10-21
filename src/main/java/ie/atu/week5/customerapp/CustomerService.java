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
    public  List<Customer> getCustomerById(String id) {
        customerRepository.findById(id);
        //Logic to retrieve the customer from the repository
        return customerRepository.findAll();
    }

    public List<Customer> createCustomer(Customer customer) {
        customerRepository.save(customer);
        //Logic to save created customer to the repository
        return customerRepository.findAll();

    }

    public List<Customer> updateCustomer(Long id, Customer updatedCustomer) {
        // Fetch the list of customers from the repository
        List<Customer> customers = customerRepository.findAll();

        // Find the customer by  ID and update it
        for (Customer existingCustomer : customers) {
            if (existingCustomer.getId().equals(id)) {
                // Update the existing customer fields
                existingProduct.setProductName(updatedProduct.getProductName());
                existingProduct.setProductDescription(updatedProduct.getProductDescription());
                existingProduct.setProductPrice(updatedProduct.getProductPrice());
                existingProduct.setProductCode(updatedProduct.getProductCode());
                // break;  // Exit loop once the product is found and updated
            }
        }

        // Save the updated product list back to the repository
        customerRepository.saveAll(customers);

        // Return the updated product list
        return customers;
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
