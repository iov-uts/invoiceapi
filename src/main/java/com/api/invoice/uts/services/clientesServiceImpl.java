package com.api.invoice.uts.services;

import com.api.invoice.uts.models.dao.IFacturaDao;
import com.api.invoice.uts.models.dao.IProductoDao;
import com.api.invoice.uts.models.dao.IclienteDao;
import com.api.invoice.uts.models.entities.Cliente;
import com.api.invoice.uts.models.entities.Factura;
import com.api.invoice.uts.models.entities.Producto;
import com.api.invoice.uts.models.entities.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class clientesServiceImpl implements IclienteService {

    @Autowired
    private IclienteDao clienteDao;
    @Autowired
    private IFacturaDao facturaDao;

    @Autowired
    private IProductoDao productoDao;


    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findById(Long id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        return clienteDao.save(cliente);
    }

    @Override
    public void delete(Long id) {
        clienteDao.deleteById(id);

    }

    @Override
    @Transactional
    public List<Region> findAllRegiones() {
        return clienteDao.findAllRegiones();
    }

    @Override
    public Factura findFacturaById(Long id) {
        return facturaDao.findById(id).orElse(null);
    }

    @Override
    public List<Factura> findFacturaAll() {
        return (List<Factura>) facturaDao.findAll();
    }

    @Override
    public Factura saveFactura(Factura factura) {
        return facturaDao.save(factura);
    }

    @Override
    public void deleteFacturaById(Long id) {
        facturaDao.deleteById(id);
    }

    @Override
    public List<Producto> findProductoByNombre(String term) {
        return productoDao.findByNombreContainingIgnoreCase(term);
    }
}
