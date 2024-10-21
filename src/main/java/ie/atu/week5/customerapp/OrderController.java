package ie.atu.week5.customerapp;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository orderRepository;
    private List<Order> orderList = new ArrayList<>();

    public OrderController(OrderRepository orderRepository) {

        this.orderRepository = orderRepository;
    }

    @GetMapping
    public List<Order> getAllOrders() {

        return orderRepository.findAll();
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Order>> getOrdersByCustomerId(@PathVariable String customerId) {
        List<Order> orders = orderRepository.findByCustomerId(customerId);
        return ResponseEntity.ok(orders);
    }
/*
    @PostMapping
    public ResponseEntity<Order> createOrder(@Valid @RequestBody Order order) {
       // orderList = OrderRepository.createOrder(order);
      // return ResponseEntity.ok(orderList);
    }
*/
   // @DeleteMapping("/{id}")
    public ResponseEntity <List<Order>>deleteOrder(@PathVariable String id) {
       // orderList = orderRepository.deleteById(id);
        return ResponseEntity.ok(orderList);
    }
}
