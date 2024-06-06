package uv.mx.inventario;

import java.rmi.server.UID;
import java.util.UUID;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import uv.mx.inventario.AgregarProductoRequest;
import uv.mx.inventario.AgregarProductoResponse;

@Endpoint
public class ProductoEntPoint {

    @PayloadRoot(localPart = "AgregarProductoRequest", namespace = "inventario.mx.uv/inventario")
    @ResponsePayload
    public AgregarProductoResponse agregarProducto(@RequestPayload AgregarProductoRequest peticion) {
        IProducto newProducto;
        Producto producto = new Producto();
        AgregarProductoResponse respuesta;
        try {
            producto.setNombre(peticion.getNombre());
            producto.setDescripcion(peticion.getDescripcion());
            producto.setPrecio(peticion.getPrecio());
            producto.setStock(peticion.getStock());
            producto.setTipo(peticion.getTipo());
            newProducto.save(producto);

            return producto;

        } catch (Exception e) {
            return e;
        }

    }

    @PayloadRoot(localPart = "VerificarProductoRequest", namespace = "inventario.mx.uv/inventario")
    @ResponsePayload
    public VerificarProductoResponse agregarProducto(@RequestPayload VerificarProductoRequest peticion) {
        IProducto newProducto;
       
        VerificarProductoResponse respuesta;
        try {
            newProducto.findById(peticion.getId());
            Producto producto = newProducto;
            respuesta.setId(producto.getId());
            respuesta.setnombre(producto.getNombre());
            respuesta.setDescripcion(producto.getDescripcion());
            respuesta.setTipo(producto.getTipo());
            respuesta.setPrecio(producto.getPrecio());
            respuesta.setStock(producto.getStock());
            return respuesta;
           
        } catch (Exception e) {
            return null;
        }
    }

}
