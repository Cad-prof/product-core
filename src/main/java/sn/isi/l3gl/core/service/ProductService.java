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

    // v0.1.0 
    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    // v0.2.0 
    /**
     * Met à jour la quantité en stock d'un produit.
     * @paramidL'identifiant du produit
     * @paramquantityLa nouvelle quantité
     * @return Le produit mis à jour
     */
    public Product updateQuantity(Long id, Integer quantity) {
        // 1. Chercher le produit par son ID (ou lancer une erreur s'il n'existe pas)
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Produit introuvable avec l'id : " + id));

        // 2. Modifier la quantité
        product.setQuantity(quantity);

        // 3. Sauvegarder et retourner le produit modifié
        return productRepository.save(product);
    }
}