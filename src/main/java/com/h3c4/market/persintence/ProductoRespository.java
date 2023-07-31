package com.h3c4.market.persintence;

import com.h3c4.market.domain.Product;
import com.h3c4.market.domain.repository.ProductRespository;
import com.h3c4.market.persintence.crud.ProductCrudRepository;
import com.h3c4.market.persintence.entity.Producto;
import com.h3c4.market.persintence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


// Este es el repositorio que se comunica con la base de datos
@Repository
public class ProductoRespository implements ProductRespository {

    @Autowired
    private ProductCrudRepository productCrudRepository;
    @Autowired
    private ProductMapper mapper;


    @Override
    public List<Product> getAll(){
        //hace la consulta a la bd y la guarda en una lista de productos
       List<Producto> productos = (List<Producto>) productCrudRepository.findAll();
       // mapea la lista de productos a una lista de product
         return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int idCategory){
        List<Producto> productos = productCrudRepository.findByIdCategoriaOrerByNombreAsc(idCategory);
        return Optional.of(mapper.toProducts(productos));

    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity){
       Optional< List<Producto>> productos = productCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
         return productos.map(prods -> mapper.toProducts(prods));

    }

    @Override
    public Optional<Product> getProduct(int productId){
        Optional<Producto> producto = productCrudRepository.findById(productId);
        return producto.map(prod -> mapper.toProduct(prod));
    }


    @Override
    public Product save(Product product){
           Producto producto = mapper.toProducto(product);
           return mapper.toProduct(productCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId){
        productCrudRepository.deleteById(productId);
    }
}
