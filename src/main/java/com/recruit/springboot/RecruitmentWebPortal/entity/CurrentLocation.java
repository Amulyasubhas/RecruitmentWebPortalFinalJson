// package com.recruit.springboot.RecruitmentWebPortal.entity;

// public enum CurrentLocation {
//     BANGALORE,
//     UDUPI,
//     MUMBAI,
//     CHENNAI
// }


package com.recruit.springboot.RecruitmentWebPortal.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CurrentLocation {
    BANGALORE,
    UDUPI,
    MUMBAI,
    CHENNAI;

    @JsonCreator
    public static CurrentLocation fromString(String value) {
        for (CurrentLocation location : CurrentLocation.values()) {
            if (location.name().equalsIgnoreCase(value)) {
                return location;
            }
        }
        throw new IllegalArgumentException("Invalid CurrentLocation: " + value);
    }

    @JsonValue
    public String toValue() {
        return this.name();
    }
}
