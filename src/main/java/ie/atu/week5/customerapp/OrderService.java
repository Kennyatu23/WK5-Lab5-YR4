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

    public List<Order> getOrdersByCustomersId(String id) {
        orderRepository.findById(id);
        return orderRepository.findAll();
    }

    public List<Order> createOrder(Order order) {
        //Logic to save created order to the repository
        orderRepository.save(order);
        return orderRepository.findAll();

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
