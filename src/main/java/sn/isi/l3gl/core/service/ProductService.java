package sn.isi.l3gl.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sn.isi.l3gl.core.entity.Product;
import sn.isi.l3gl.core.repository.ProductRepository;
import java.util.List;               // ← ajouter cet import

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    //  v0.0.1 
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // v0.1.0 
    /**
     * Retourne la liste de tous les produits en base.
     */
    public List<Product> listProducts() {
        return productRepository.findAll();
    }
}