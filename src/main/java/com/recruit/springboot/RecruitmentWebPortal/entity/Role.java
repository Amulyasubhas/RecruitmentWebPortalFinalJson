// package com.recruit.springboot.RecruitmentWebPortal.entity;

// public enum Role {
//     ADMIN,
//     RECRUITER,
//     HR,
//     CANDIDATE
// }

package com.recruit.springboot.RecruitmentWebPortal.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Role {
    ADMIN,
    RECRUITER,
    HR,
    CANDIDATE;

    @JsonCreator
    public static Role fromString(String value) {
        for (Role role : Role.values()) {
            if (role.name().equalsIgnoreCase(value)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid Role: " + value);
    }

    @JsonValue
    public String toValue() {
        return this.name();
    }
}
