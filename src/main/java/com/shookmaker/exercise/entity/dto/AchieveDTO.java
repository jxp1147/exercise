package com.shookmaker.exercise.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AchieveDTO {
    private Integer id;

    private String achieveName;

    @Override
    public String toString() {
        return "Achieves{" +
            "id=" + id +
            ", achieveName=" + achieveName +
        "}";
    }
}
