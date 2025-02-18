package com.adc.order.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
