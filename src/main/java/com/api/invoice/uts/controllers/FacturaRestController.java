package com.api.invoice.uts.controllers;

import com.api.invoice.uts.models.entities.Factura;
import com.api.invoice.uts.models.entities.Producto;
import com.api.invoice.uts.services.IclienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FacturaRestController {

    @Autowired
    private IclienteService clienteService;

    @GetMapping("/facturas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Factura show(@PathVariable Long id) {
        return clienteService.findFacturaById(id);
    }


    @GetMapping("/facturas")
    @ResponseStatus(HttpStatus.OK)
    public List<Factura> index() {
        return clienteService.findFacturaAll();
    }


    @DeleteMapping("/facturas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        clienteService.deleteFacturaById(id);
    }


    @GetMapping("/facturas/filtrar-productos/{term}")
    @ResponseStatus(HttpStatus.OK)
    public List<Producto> filtrarProductos(@PathVariable String term) {
        return clienteService.findProductoByNombre(term);
    }


    @PostMapping("/facturas")
    @ResponseStatus(HttpStatus.CREATED)
    public Factura crear(@RequestBody Factura factura) {
        return clienteService.saveFactura(factura);
    }


}

