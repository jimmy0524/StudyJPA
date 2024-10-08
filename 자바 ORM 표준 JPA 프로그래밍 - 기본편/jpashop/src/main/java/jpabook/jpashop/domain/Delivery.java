package jpabook.jpashop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Delivery {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private String street;
    private String zipcode;
    private DeliveryStatus status;
}
