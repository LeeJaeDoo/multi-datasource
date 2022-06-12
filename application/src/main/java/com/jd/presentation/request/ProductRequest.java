package com.jd.presentation.request;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.ExtensionMethod;

/**
 * @author Jaedoo Lee
 */
@Getter
@Setter
@ExtensionMethod(Objects.class)
public class ProductRequest {

    @NotNull(message = "{product.get.notNull.startedAt}")
    private LocalDateTime startedAt;
    @NotNull(message = "{product.get.notNull.finishedAt}")
    private LocalDateTime finishedAt;

    @AssertTrue(message = "{product.get.assertTrue.validPeriod}")
    public boolean hasValidPeriod() {
        return startedAt.nonNull() &&
               finishedAt.nonNull() &&
               getStartedAt().isBefore(getFinishedAt());
    }

}
