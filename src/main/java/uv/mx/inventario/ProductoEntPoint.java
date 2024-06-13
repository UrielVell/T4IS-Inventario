package uv.mx.inventario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import uv.mx.inventario.gen.*;


@Endpoint
public class ProductoEntPoint {

    @Autowired
    private IProducto newProducto;

    @PayloadRoot(localPart = "AgregarProductoRequest", namespace = "https://inventario.mx.uv/inventario")
    @ResponsePayload
    public AgregarProductoResponse agregarProducto(@RequestPayload AgregarProductoRequest peticion) {
        
        Producto producto = new Producto();
        AgregarProductoResponse respuesta = new AgregarProductoResponse();
            producto.setNombre(peticion.getNombre());
            producto.setDescripcion(peticion.getDescripcion());
            producto.setPrecio(peticion.getPrecio());
            producto.setStock(peticion.getStock());
            producto.setTipo(peticion.getTipo());
            newProducto.save(producto);
            respuesta.setMensaje("Producto agregado.");

            return respuesta;

    }

    @PayloadRoot(localPart = "VerificarProductoRequest", namespace = "https://inventario.mx.uv/inventario")
    @ResponsePayload
    public VerificarProductoResponse agregarProducto(@RequestPayload VerificarProductoRequest peticion) {
       
        VerificarProductoResponse respuesta = new VerificarProductoResponse();
        try {
            Producto producto = newProducto.findById(peticion.getId()).get();
            respuesta.setId(producto.getId());
            respuesta.setNombre(producto.getNombre());
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
