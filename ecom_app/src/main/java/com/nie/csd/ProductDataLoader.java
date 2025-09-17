package com.nie.csd;

import com.nie.csd.models.Products;
import com.nie.csd.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class ProductDataLoader implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        if (productRepository.count() == 0) {
            Products p1 = new Products();
            p1.setName("Apple iPhone 15");
            p1.setDescription("Latest Apple iPhone 15 with A16 chip");
            p1.setCategory("Electronics");
            p1.setTags("smartphone,apple,iphone");
            p1.setPrice(99999.99f);
            p1.setStock(10);

            Products p2 = new Products();
            p2.setName("Samsung Galaxy S24");
            p2.setDescription("Samsung flagship phone with AMOLED display");
            p2.setCategory("Electronics");
            p2.setTags("smartphone,samsung,galaxy");
            p2.setPrice(84999.99f);
            p2.setStock(15);

            Products p3 = new Products();
            p3.setName("Sony WH-1000XM5");
            p3.setDescription("Noise Cancelling Wireless Headphones");
            p3.setCategory("Accessories");
            p3.setTags("headphones,sony,wireless");
            p3.setPrice(29999.99f);
            p3.setStock(25);

            Products p4 = new Products();
            p4.setName("Nike Air Max 270");
            p4.setDescription("Comfortable running shoes");
            p4.setCategory("Footwear");
            p4.setTags("shoes,nike,running");
            p4.setPrice(12999.99f);
            p4.setStock(30);

            Products p5 = new Products();
            p5.setName("Dell XPS 13");
            p5.setDescription("13-inch laptop with Intel i7 processor");
            p5.setCategory("Computers");
            p5.setTags("laptop,dell,xps");
            p5.setPrice(119999.99f);
            p5.setStock(5);

            productRepository.save(p1);
            productRepository.save(p2);
            productRepository.save(p3);
            productRepository.save(p4);
            productRepository.save(p5);
        }
    }
}
