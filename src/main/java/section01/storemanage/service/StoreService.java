package section01.storemanage.service;

import section01.storemanage.aggregate.Product;
import section01.storemanage.repository.StoreRepository;

import java.util.ArrayList;

public class StoreService {

    private final StoreRepository sr = new StoreRepository();

    public StoreService() {
    }

    public void findAllProducts() {

        ArrayList<Product> findProducts = sr.selectAllProducts();
        System.out.println("상품 조회 확인: ");
        for (Product product : findProducts) {
            System.out.println(product);
        }
    }

    public void findProductsBy(int productID) {

        Product product = sr.
    }
}
