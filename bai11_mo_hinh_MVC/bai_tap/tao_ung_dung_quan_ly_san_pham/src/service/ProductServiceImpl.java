package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer,Product> listProduct;
    static {
        listProduct = new HashMap<>();
        listProduct.put(1,new Product(1,"xe đạp","1000","còn mới","honda"));
        listProduct.put(2,new Product(2,"xe máy","2000","còn mới","yamaha"));
        listProduct.put(3,new Product(3,"máy bay","3000","còn mới","honda"));
        listProduct.put(4,new Product(4,"tên lửa","4000","còn mới","honda"));
        listProduct.put(5,new Product(5,"tàu ngầm","5000","còn mới","honda"));

    }


    @Override
    public List<Product> getAllProduct() {
        return new ArrayList<>(listProduct.values());
    }

    @Override
    public void saveProduct(Product product) {
        listProduct.put(product.getId(),product);
    }

    @Override
    public void deleteProduct(int id) {
        listProduct.remove(id);
    }

    @Override
    public void editProduct(int id, Product product) {

    }

    @Override
    public Product findId(int id) {
        return listProduct.get(id);
    }
}
