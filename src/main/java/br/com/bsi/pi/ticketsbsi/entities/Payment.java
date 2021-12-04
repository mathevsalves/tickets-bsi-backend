
package br.com.bsi.pi.ticketsbsi.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_payment")
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 100)
    @Column(name = "name", nullable = false)
    private String name;

    @Size(min = 16, max = 16)
    @Column(name = "number", nullable = false, length = 16)
    private String number;

    @Size(min = 5, max = 5)
    @Column(name = "validated", nullable = false, length = 5)
    private String validated;

    @Size(min = 3, max = 3)
    @Column(name = "cvv", nullable = false, length = 3)
    private String cvv;

    @Size(min = 11, max = 11)
    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Email
    @Column(name = "email", nullable = false)
    private String email;

    @JsonIgnore
    @OneToOne(mappedBy = "payment", cascade = CascadeType.DETACH)
    private Order order;

    public Payment() {}

    public Payment(Long id, String name, String number, String validated, String cvv, String cpf, String email) {
        this.id = id;
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

    public String getcpf() {
        return cpf;
    }

    public void setcpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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
        Payment other = (Payment) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
