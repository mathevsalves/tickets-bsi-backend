package br.com.bsi.pi.ticketsbsi.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Date moment;

    // private Integer orderStatus;

    // @ManyToOne
    // @JoinColumn(name = "client_id")
    // private User client;

    // @OneToMany(mappedBy = "id.order")
    // private Set<OrderItem> items = new HashSet<>();

    // @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    // private Payment payment;

    private Long idShow;
    private String name;
    private String number;
    private String validated;
    private String cvv;
    private String cpf;
    private String email;

    public Order() {
    }


    // public Order(Long id, Date moment, OrderStatus orderStatus, User client) {
    // this.id = id;
    // this.moment = moment;
    // setOrderStatus(orderStatus);
    // this.client = client;
    // }

    public Order(Long id, Date moment, Long idShow, String name, String number, String validated, String cvv,
                 String cpf, String email) {
        this.id = id;
        this.moment = moment;
        this.idShow = idShow;
        this.name = name;
        this.number = number;
        this.validated = validated;
        this.cvv = cvv;
        this.cpf = cpf;
        this.email = email;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    // public OrderStatus getOrderStatus() {
    // return OrderStatus.valueOf(orderStatus);
    // }

    // public void setOrderStatus(OrderStatus orderStatus) {
    // if(orderStatus != null)
    // this.orderStatus = orderStatus.getCode();
    // }

    // public User getClient() {
    // return client;
    // }

    // public void setClient(User client) {
    // this.client = client;
    // }

    // public Payment getPayment() {
    // return payment;
    // }

    // public void setPayment(Payment payment) {
    // this.payment = payment;
    // }

    // public Set<OrderItem> getItems() {
    // return items;
    // }

    // public Double getTotal() {
    // double sum = 0.0;
    // for (OrderItem oi : items) {
    // sum += oi.getSubTotal();
    // }
    // return sum;
    // }

    public Long getIdShow() {
        return idShow;
    }

    public void setIdShow(Long idShow) {
        this.idShow = idShow;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getValidated() {
        return validated;
    }

    public void setValidated(String validated) {
        this.validated = validated;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
