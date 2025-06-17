package com.mycart.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mycart.store.model.OrderItem;
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Long>{
    public List<OrderItem> findByOrder_ordId(Long ORD_ID);
}
