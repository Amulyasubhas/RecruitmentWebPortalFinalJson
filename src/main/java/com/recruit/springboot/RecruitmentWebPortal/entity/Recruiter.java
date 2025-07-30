// package com.recruit.springboot.RecruitmentWebPortal.entity;

// public enum Recruiter {
//     MISHEL,
//     SHARATH,
//     SHILPA,
//     CHINMAY
// }

package com.recruit.springboot.RecruitmentWebPortal.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Recruiter {
    MISHEL,
    SHARATH,
    SHILPA,
    CHINMAY;

    @JsonCreator
    public static Recruiter fromString(String value) {
        for (Recruiter recruiter : Recruiter.values()) {
            if (recruiter.name().equalsIgnoreCase(value)) {
                return recruiter;
            }
        }
        throw new IllegalArgumentException("Invalid Recruiter: " + value);
    }

    @JsonValue
    public String toValue() {
        return this.name();
    }
}
