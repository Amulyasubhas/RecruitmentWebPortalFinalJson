package com.recruit.springboot.RecruitmentWebPortal.converter;
import com.recruit.springboot.RecruitmentWebPortal.entity.WorkTimings;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class WorkTimingsConverter implements AttributeConverter<WorkTimings, String> {

    @Override
    public String convertToDatabaseColumn(WorkTimings attribute) {
        return attribute != null ? attribute.getDisplayName() : null;
    }

    @Override
    public WorkTimings convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;
        for (WorkTimings wt : WorkTimings.values()) {
            if (wt.getDisplayName().equals(dbData)) {
                return wt;
            }
        }
        throw new IllegalArgumentException("Unknown work timings: " + dbData);
    }
}

