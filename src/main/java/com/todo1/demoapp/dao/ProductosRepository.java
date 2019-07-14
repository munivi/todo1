package com.todo1.demoapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.todo1.demoapp.model.Producto;

/**
 * Interface CRUD para la persistencia de Productos
 * @author Mustarroz
 *
 */
@Repository
@Transactional
public interface ProductosRepository extends CrudRepository<Producto, Long> {
}
