package service;

import model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();

    void saveProduct(Product product);

    void deleteProduct(int id);

    void editProduct(int id,Product product);

    Product findId(int id);
}
