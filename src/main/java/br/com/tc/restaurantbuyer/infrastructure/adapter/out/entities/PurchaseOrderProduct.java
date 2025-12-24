package br.com.tc.restaurantbuyer.infrastructure.adapter.out.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Table(name = "purchase_order_product")
@Entity
public class PurchaseOrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JoinColumn(name = "purchase_order_id")
    private PurchaseOrder purchaseOrderId;
    @Column(name = "product_id")
    private long productId;
    private Integer quantityBuy;
    @Column(name = "price")
    private BigDecimal price;

}
