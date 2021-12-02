package com.example.ui.model;

import lombok.*;

@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Food {

    private Long foodId;

    private String foodName;
}
