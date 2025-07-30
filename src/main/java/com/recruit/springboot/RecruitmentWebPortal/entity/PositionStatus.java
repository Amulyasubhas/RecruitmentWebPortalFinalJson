package com.recruit.springboot.RecruitmentWebPortal.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PositionStatus {
    Open,
    Close,
    Hold;

    @JsonCreator
    public static PositionStatus fromString(String value) {
        for (PositionStatus status : PositionStatus.values()) {
            if (status.name().equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid PositionStatus: " + value);
    }

    @JsonValue
    public String toValue() {
        return this.name();
    }
}
