package com.lafin.housekeeper.service;

import com.lafin.housekeeper.dto.request.ProductAddRequest;
import com.lafin.housekeeper.dto.request.RoomAddRequest;
import com.lafin.housekeeper.entity.Product;
import com.lafin.housekeeper.entity.Room;
import com.lafin.housekeeper.repository.ProductRepository;
import com.lafin.housekeeper.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> list() {
        return productRepository.findAll();
    }

    public Product add(ProductAddRequest productAddRequest) {
        var product = new Product();
        product.setRoomId(productAddRequest.getRoomId());
        product.setName(productAddRequest.getName());
        product.setCount(productAddRequest.getCount());
        product.setMinimumCount(productAddRequest.getMinimumCount());
        product.setOrderCount(productAddRequest.getOrderCount());

        return productRepository.save(product);
    }
}