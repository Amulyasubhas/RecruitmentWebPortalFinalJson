package com.recruit.springboot.RecruitmentWebPortal.entity;
public enum WorkTimings {
    NINE_TO_SIX("9AM-6PM"),
    NINE_THIRTY_TO_SIX_THIRTY("9.30AM-6.30PM"),
    ELEVEN_TO_EIGHT("11AM-8PM"),
    TWO_TO_ELEVEN("2PM-11PM");

    private final String displayName;

    WorkTimings(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static WorkTimings fromDisplayName(String displayName) {
        for (WorkTimings timing : WorkTimings.values()) {
            if (timing.getDisplayName().equalsIgnoreCase(displayName)) {
                return timing;
            }
        }
        throw new IllegalArgumentException("Invalid WorkTimings: " + displayName);
    }
}
