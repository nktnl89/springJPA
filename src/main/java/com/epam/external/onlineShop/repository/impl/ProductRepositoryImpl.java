package com.epam.external.onlineShop.repository.impl;

import com.epam.external.onlineShop.entity.Product;
import com.epam.external.onlineShop.mapper.ProductMapper;
import com.epam.external.onlineShop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ProductMapper productMapper;
    @Value("${sql.products.findAll}")
    private String QUERY_FIND_ALL;
    @Value("${sql.products.findById}")
    private String QUERY_FIND_BY_ID;
    @Value("${sql.products.insert}")
    private String QUERY_INSERT;
    @Value("${sql.products.deleteById}")
    private String QUERY_DELETE_BY_ID;
    @Value("${sql.products.getCountBasketWithProduct}")
    private String QUERY_GET_COUNT_BASKET;
    @Value("${sql.products.updateProduct}")
    private String QUERY_UPDATE;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    @Cacheable("products")
    public List<Product> findAll() {
        return jdbcTemplate.query(QUERY_FIND_ALL, productMapper);
    }

    @Override
    public Product findById(int id) {
        return (Product) jdbcTemplate.queryForObject(QUERY_FIND_BY_ID, new Object[]{id}, productMapper);
    }

    @Override
    public void save(Product product) {
        jdbcTemplate.update(QUERY_INSERT, product.getImg(), product.getPrice(), product.getText(), product.getCategory().getId());
    }

    @Override
    public int deleteById(int id) {
        jdbcTemplate.update(QUERY_DELETE_BY_ID, id);
        return id;
    }

    @Override
    public int getCountBasketWithProduct(int id) {
        return jdbcTemplate.queryForObject(QUERY_GET_COUNT_BASKET, int.class, id);
    }

    @Override
    public void updateProduct(Product product) {
        jdbcTemplate.update(QUERY_UPDATE, product.getImg(), product.getPrice(), product.getText(), product.getId());
    }
}
