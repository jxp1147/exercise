package com.shookmaker.exercise.uitls;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageDataById {
    private Integer id;
    private PageData pageData;
}
