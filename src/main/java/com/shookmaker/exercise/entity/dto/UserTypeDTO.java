package com.shookmaker.exercise.entity.dto;

public class UserTypeDTO {


    private Integer id;

    private String typeName;

    private Integer typeValue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    public Integer getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(Integer typeValue) {
        this.typeValue = typeValue;
    }

    @Override
    public String toString() {
        return "UserType{" +
            "id=" + id +
            ", typeName=" + typeName +
            ", typeValue=" + typeValue +
        "}";
    }
}
