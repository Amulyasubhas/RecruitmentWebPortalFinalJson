// package com.recruit.springboot.RecruitmentWebPortal.entity;

// public enum Source {
//     LINKEDIN,
//     REFERENCE
// }

package com.recruit.springboot.RecruitmentWebPortal.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Source {
    LINKEDIN,
    REFERENCE;

    @JsonCreator
    public static Source fromString(String value) {
        for (Source source : Source.values()) {
            if (source.name().equalsIgnoreCase(value)) {
                return source;
            }
        }
        throw new IllegalArgumentException("Invalid Source: " + value);
    }

    @JsonValue
    public String toValue() {
        return this.name();
    }
}
