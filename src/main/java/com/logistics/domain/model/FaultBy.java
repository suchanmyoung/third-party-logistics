package com.logistics.domain.model;

import javax.validation.constraints.NotBlank;

public enum FaultBy {
    Customer("고객사"), Transport("운송사");

    private final String description;

    FaultBy(String description) {
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

}
