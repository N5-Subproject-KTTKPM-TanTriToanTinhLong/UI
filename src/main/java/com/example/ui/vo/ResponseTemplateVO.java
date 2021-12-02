package com.example.ui.vo;

import com.example.ui.model.Customer;
import com.example.ui.model.Food;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {

    private Customer customer;

    private Food food;

}
