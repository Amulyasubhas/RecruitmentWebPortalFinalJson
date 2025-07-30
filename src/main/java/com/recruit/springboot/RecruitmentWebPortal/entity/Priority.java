// package com.recruit.springboot.RecruitmentWebPortal.entity;

// public enum Priority {
//     High,
//     Medium,
//     Low
// }

package com.recruit.springboot.RecruitmentWebPortal.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Priority {
    High,
    Medium,
    Low;

    @JsonCreator
    public static Priority fromString(String value) {
        for (Priority priority : Priority.values()) {
            if (priority.name().equalsIgnoreCase(value)) {
                return priority;
            }
        }
        throw new IllegalArgumentException("Invalid Priority: " + value);
    }

    @JsonValue
    public String toValue() {
        return this.name();
    }
}
