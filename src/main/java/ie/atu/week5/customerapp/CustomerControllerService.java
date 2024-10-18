package ie.atu.week5.customerapp;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Service
public class CustomerControllerService {
    private CustomerRepository customerRepository;
    public CustomerControllerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    
    public
    Optional<Customer> customer = customerRepository.findById(id);

}
