package sn.isi.l3gl.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sn.isi.l3gl.core.entity.Product;
import sn.isi.l3gl.core.repository.ProductRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    // v0.0.1 
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    //  v0.1.0 
    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    //  v0.2.0 
    public Product updateQuantity(Long id, Integer quantity) {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Produit introuvable avec l'id : " + id));
        product.setQuantity(quantity);
        return productRepository.save(product);
    }

    // v0.3.0 
    /**
     * Compte les produits dont la quantité est inférieure ou égale à 5.
     * Ces produits sont considérés en "stock faible".
     * @return Le nombre de produits en stock faible
     */
    public long countLowStockProducts() {
        return productRepository.countByQuantityLessThanEqual(5);
    }
}