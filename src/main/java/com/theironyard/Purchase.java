package com.theironyard;
import javax.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Created by amalabukar on 1/9/17.
 */
@Entity
@Table(name = "purchase")
public class Purchase {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String date;

    @Column(nullable = false)
    String creditCard;

    @Column(nullable = false)
    int cvv;

    @Column(nullable = false)
    String category;

    @ManyToOne
    com.theironyard.Customer customer;



    public Purchase(String date, String creditCard, int cvv, String category, com.theironyard.Customer customer) {
        this.date = date;
        this.creditCard = creditCard;
        this.cvv = cvv;
        this.category = category;
        this.customer = customer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public com.theironyard.Customer getCustomer() {
        return customer;
    }

    public void setCustomer(com.theironyard.Customer customer) {
        this.customer = customer;
    }

    public Purchase() {
    }

}
