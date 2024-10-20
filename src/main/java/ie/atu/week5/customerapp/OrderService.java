package ie.atu.week5.customerapp;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {

        this.orderRepository = orderRepository;
    }

    public Optional<Order> getOrdersByCustomerId(String id) {
        //Logic to retrieve the order from the repository
        return orderRepository.findById(id);
    }

    public Order createOrder(Order order) {
        //Logic to save created order to the repository
        return orderRepository.save(order);

    }

    public List<Order> deleteOrder(String id) {
        // Checking if Order exists in repository by the id
        if (orderRepository.existsById(id)) {
            //Delete Order from repository using id
            orderRepository.deleteById(id);
        }

        return orderRepository.findAll();

    }

}
