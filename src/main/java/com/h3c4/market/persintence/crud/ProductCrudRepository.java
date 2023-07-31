package com.h3c4.market.persintence.crud;

import com.h3c4.market.persintence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<Producto,Integer> {


    //@Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    //Productos que se estan agotando y su estado
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);



}
