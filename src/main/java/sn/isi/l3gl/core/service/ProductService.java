package sn.isi.l3gl.core.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import sn.isi.l3gl.core.entity.Product;
import sn.isi.l3gl.core.repository.ProductRepository;

@Service                   
@RequiredArgsConstructor   
public class ProductService {

    private final ProductRepository productRepository;

    // v0.0.1 
    /**
     * Ajoute un nouveau produit dans l'inventaire.
     * @paramproductLe produit à enregistrer
     * @return Le produit enregistré (avec son ID généré)
     */
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}