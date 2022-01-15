package product.service;

import org.springframework.stereotype.Service;
import product.model.Product;

import java.util.*;

@Service
public class ProductService implements IProductService {
    private static final Map<Integer, Product> products;
    Set<Integer> set = products.keySet();

    static {

        products = new HashMap<>();
        products.put(1, new Product(1, "iphone", "apple", "usa"));
        products.put(2, new Product(2, "samsung", "samsung", "korea"));
        products.put(3, new Product(3, "note10", "samsung", "korea"));
        products.put(4, new Product(4, "xiaomi", "xiaomi", "china"));
        products.put(5, new Product(5, "nokia 1509", "nokia", "usa"));
        products.put(6, new Product(6, "iphone 13", "apple", "usa"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        String productName = name.toLowerCase();
        List<Product> productList = new ArrayList<>();
        for (Integer key : set) {
            if (products.get(key).getName().toLowerCase().contains(productName)) {
                productList.add(products.get(key));
            }
        }
        return productList;
    }
}
