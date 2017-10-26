package com.product.project.entities;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "MANUFACTURER", nullable = false)
    private String manufacturer;
    @Column(name = "PRICE", nullable = false)
    private BigDecimal price;
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductEntity productEntity = (ProductEntity) o;

        if (getId() != null ? !getId().equals(productEntity.getId()) : productEntity.getId() != null) return false;
        if (getName() != null ? !getName().equals(productEntity.getName()) : productEntity.getName() != null) return false;
        if (getManufacturer() != null ? !getManufacturer().equals(productEntity.getManufacturer()) : productEntity.getManufacturer() != null)
            return false;
        if (getPrice() != null ? !getPrice().equals(productEntity.getPrice()) : productEntity.getPrice() != null) return false;
        return getDescription() != null ? getDescription().equals(productEntity.getDescription()) : productEntity.getDescription() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getManufacturer() != null ? getManufacturer().hashCode() : 0);
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
