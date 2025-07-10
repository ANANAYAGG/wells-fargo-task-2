package com.example.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "security")
public class Security {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long securityId;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "category", nullable = false)
    private String category;
    
    @Column(name = "purchase_date", nullable = false)
    private LocalDate purchaseDate;
    
    @Column(name = "purchase_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal purchasePrice;
    
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", nullable = false)
    private Portfolio portfolio;
    
    // Constructor
    public Security(String name, String category, LocalDate purchaseDate, 
                   BigDecimal purchasePrice, Integer quantity, Portfolio portfolio) {
        this.name = name;
        this.category = category;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
        this.quantity = quantity;
        this.portfolio = portfolio;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    
    // Default constructor
    public Security() {}
    
    // Getters and Setters
    public Long getSecurityId() { return securityId; }
    
    public String getName() { return name; }
    public void setName(String name) { 
        this.name = name;
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getCategory() { return category; }
    public void setCategory(String category) { 
        this.category = category;
        this.updatedAt = LocalDateTime.now();
    }
    
    public LocalDate getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(LocalDate purchaseDate) { 
        this.purchaseDate = purchaseDate;
        this.updatedAt = LocalDateTime.now();
    }
    
    public BigDecimal getPurchasePrice() { return purchasePrice; }
    public void setPurchasePrice(BigDecimal purchasePrice) { 
        this.purchasePrice = purchasePrice;
        this.updatedAt = LocalDateTime.now();
    }
    
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { 
        this.quantity = quantity;
        this.updatedAt = LocalDateTime.now();
    }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    
    public Portfolio getPortfolio() { return portfolio; }
    public void setPortfolio(Portfolio portfolio) { 
        this.portfolio = portfolio;
        this.updatedAt = LocalDateTime.now();
    }
}
