/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alumno
 */
@Entity
@Table(catalog = "tienda", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s")
    , @NamedQuery(name = "Stock.findByCodigoStock", query = "SELECT s FROM Stock s WHERE s.codigoStock = :codigoStock")
    , @NamedQuery(name = "Stock.findByCantidad", query = "SELECT s FROM Stock s WHERE s.cantidad = :cantidad")})
public class Stock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer codigoStock;
    private Integer cantidad;
    @JoinColumn(name = "Producto_codigoProducto", referencedColumnName = "codigoProducto")
    @ManyToOne(optional = false)
    private Producto productocodigoProducto;

    public Stock() {
    }

    public Stock(Integer codigoStock) {
        this.codigoStock = codigoStock;
    }

    public Integer getCodigoStock() {
        return codigoStock;
    }

    public void setCodigoStock(Integer codigoStock) {
        this.codigoStock = codigoStock;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProductocodigoProducto() {
        return productocodigoProducto;
    }

    public void setProductocodigoProducto(Producto productocodigoProducto) {
        this.productocodigoProducto = productocodigoProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoStock != null ? codigoStock.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock other = (Stock) object;
        if ((this.codigoStock == null && other.codigoStock != null) || (this.codigoStock != null && !this.codigoStock.equals(other.codigoStock))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Stock[ codigoStock=" + codigoStock + " ]";
    }
    
}
