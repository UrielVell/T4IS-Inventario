package uv.mx.inventario;

import org.springframework.data.repository.CrudRepository;

public interface IProducto extends CrudRepository<Producto, Integer> {
    
}
