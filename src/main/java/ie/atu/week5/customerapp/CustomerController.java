package ie.atu.week5.customerapp;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;
    private List<Customer> customerList = new ArrayList<>();
    private CustomerService customerService;


    public CustomerController(CustomerService customerService, CustomerRepository customerRepository) {
        this.customerService = customerService;
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {

        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Customer>> getCustomerById(@PathVariable String id) {
         customerList = customerService.getCustomerById(id);
        return ResponseEntity.ok(customerList);
    }

    @PostMapping
    public ResponseEntity<List<Customer>> createCustomer(@Valid @RequestBody Customer customer) {
        customerList = customerService.createCustomer(customer);
        return ResponseEntity.ok(customerList);
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity <List<Customer>> updateProduct(@PathVariable String id, @RequestBody Customer updatedCustomer) {

        customerList = customerService.updateCustomer(id, updatedCustomer);
        return ResponseEntity.ok(customerList);

    }



    @DeleteMapping("/{id}")
    public ResponseEntity<List<Customer>> deleteCustomer(@PathVariable String id) {
        customerList = customerService.deleteCustomer(id);
        return ResponseEntity.ok(customerList);
    }
}


/* if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

 */