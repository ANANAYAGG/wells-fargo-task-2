package com.example.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "portfolio")
public class Portfolio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;
    
    @Column(name = "portfolio_name", nullable = false)
    private String portfolioName;
    
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
    
    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Security> securities;
    
    // Constructor
    public Portfolio(String portfolioName, Client client) {
        this.portfolioName = portfolioName;
        this.client = client;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    
    // Default constructor
    public Portfolio() {}
    
    // Getters and Setters
    public Long getPortfolioId() { return portfolioId; }
    
    public String getPortfolioName() { return portfolioName; }
    public void setPortfolioName(String portfolioName) { 
        this.portfolioName = portfolioName;
        this.updatedAt = LocalDateTime.now();
    }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    
    public Client getClient() { return client; }
    public void setClient(Client client) { 
        this.client = client;
        this.updatedAt = LocalDateTime.now();
    }
    
    public List<Security> getSecurities() { return securities; }
    public void setSecurities(List<Security> securities) { this.securities = securities; }
}
