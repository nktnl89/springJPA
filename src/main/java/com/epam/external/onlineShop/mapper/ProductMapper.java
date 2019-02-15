package com.epam.external.onlineShop.mapper;

import com.epam.external.onlineShop.entity.Product;
import com.epam.external.onlineShop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProductMapper implements RowMapper<Product> {
    @Autowired
    private CategoryService categoryService;

    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Product(
                resultSet.getInt("product_id"),
                resultSet.getString("img_src"),
                resultSet.getString("text"),
                resultSet.getDouble("price"),
                categoryService.getCategoryById(resultSet.getInt("category_category_id"))
        );
    }
}
