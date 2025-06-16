package com.mycart.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mycart.store.model.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
