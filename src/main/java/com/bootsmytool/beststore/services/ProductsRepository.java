package com.bootsmytool.beststore.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootsmytool.beststore.models.Product;

//第一個參數為訪問的實體，第二參數是這個Entity ID的資料型態
public interface ProductsRepository extends JpaRepository<Product, Integer>{

}
