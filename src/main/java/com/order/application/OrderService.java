package com.order.application;

import com.order.domain.Customer;
import com.order.domain.OrderItem;
import com.order.dto.request.CreateOrderItemRequest;
import com.order.dto.request.CreateOrderRequest;
import com.order.dto.response.CreateOrderResponse;
import com.order.exceptions.BadRequestException;
import com.order.repository.CustomerRepository;
import com.order.repository.OrderItemRepository;
import com.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final OrderItemRepository orderItemRepository;

    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.orderItemRepository = orderItemRepository;
    }

    public CreateOrderResponse createOrder(CreateOrderRequest createOrderRequest) {
        validateCustomerId(createOrderRequest.customerId());
        validateOrderItems(createOrderRequest.items());






    }

    private Customer validateCustomerId(String customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);

        if (customer.isEmpty()) {
            throw new BadRequestException("Cliente não encontrado");
        }

        return customer.get();
    }

    private List<OrderItem> validateOrderItems(List<CreateOrderItemRequest> createOrderItemRequests) {
        List<OrderItem> orderItems = new ArrayList<>();

        for (CreateOrderItemRequest createOrderItemRequest : createOrderItemRequests) {
            String itemId = createOrderItemRequest.itemId();
            Integer quantity = createOrderItemRequest.quantity();

            if (itemId.isEmpty()) {
                throw new BadRequestException("Nenhum item foi encontrado");
            }

            if (quantity == null || quantity <= 0) {
                throw new BadRequestException("Nenhum item foi encontrado");
            }

            Optional<OrderItem> orderItem = orderItemRepository.findById(itemId);

            if (orderItem.isEmpty()) {
                throw new BadRequestException("Nenhum item foi encontrado");
            }

            orderItems.add(orderItem.get());

        }

        return orderItems;
    }
}
