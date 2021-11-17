
package br.com.bsi.pi.ticketsbsi.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String photo;
    private String name;
    private String address;
    private Date dateShow;
    private Double price;
    private String description;

    // @ManyToMany
    // @JoinTable(name = "tb_product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    // private Set<Category> categories = new HashSet<>();

    // @OneToMany(mappedBy = "id.product")
    // private Set<OrderItem> items = new HashSet<>();

    public Product() {
    }

    // public Product(Long id, String photo, String name, String address, Date dateShow, Double price, String description,
    //         Set<OrderItem> items) {

    public Product(Long id, String photo, String name, String address, Date dateShow, Double price, String description) {
        this.id = id;
        this.photo = photo;
        this.name = name;
        this.address = address;
        this.dateShow = dateShow;
        this.price = price;
        this.description = description;
        // this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateShow() {
        return dateShow;
    }

    public void setDateShow(Date dateShow) {
        this.dateShow = dateShow;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // public Set<OrderItem> getItems() {
    //     return items;
    // }

    // public void setItems(Set<OrderItem> items) {
    //     this.items = items;
    // }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }



    // public Product(Long id, String name, String description, Double price, String imgUrl) {
    //     super();
    //     this.id = id;
    //     this.name = name;
    //     this.description = description;
    //     this.price = price;
    //     this.imgUrl = imgUrl;
    // }

    // public Long getId() {
    //     return id;
    // }

    // public void setId(Long id) {
    //     this.id = id;
    // }

    // public String getName() {
    //     return name;
    // }

    // public void setName(String name) {
    //     this.name = name;
    // }

    // public String getDescription() {
    //     return description;
    // }

    // public void setDescription(String description) {
    //     this.description = description;
    // }

    // public Double getPrice() {
    //     return price;
    // }

    // public void setPrice(Double price) {
    //     this.price = price;
    // }

    // public String getImgUrl() {
    //     return imgUrl;
    // }

    // public void setImgUrl(String imgUrl) {
    //     this.imgUrl = imgUrl;
    // }

    // public Set<Category> getCategories() {
    //     return categories;
    // }

    // @JsonIgnore
    // public Set<Order> getOrders() {
    //     Set<Order> set = new HashSet<>();
    //     for (OrderItem oi : items) {
    //         set.add(oi.getOrder());
    //     }
    //     return set;
    // }

    // @Override
    // public boolean equals(Object o) {
    //     if (this == o) return true;
    //     if (o == null || getClass() != o.getClass()) return false;
    //     Product user = (Product) o;
    //     return Objects.equals(id, user.id);
    // }

    // @Override
    // public int hashCode() {
    //     return Objects.hash(id);
    // }

}
