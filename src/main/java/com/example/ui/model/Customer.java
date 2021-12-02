package com.example.ui.model;

import lombok.*;

@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

    private Long customerId;

    private String nameCustomer;

    private String address;

    private Long foodId;
}
