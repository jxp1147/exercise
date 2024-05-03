package com.shookmaker.exercise.uitls;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageData {
    private Integer currentPage;
    private Integer pageSize;
    private Integer totalCount;
}
