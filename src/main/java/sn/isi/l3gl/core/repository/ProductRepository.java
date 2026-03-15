package sn.isi.l3gl.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.isi.l3gl.core.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // JpaRepository fournit déjà : save(), findAll(), findById(), deleteById()...

    // Méthode personnalisée pour countLowStockProducts (on l'utilisera en v0.3.0)
    // Spring la génère automatiquement depuis le nom de la méthode
    long countByQuantityLessThanEqual(Integer quantity);
}