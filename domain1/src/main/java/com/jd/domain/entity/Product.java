package com.jd.domain.entity;

import com.jd.common.InvestmentStatus;
import com.jd.exception.ErrorMessage;
import com.jd.exception.ProductException;
import com.jd.util.BigDecimalUtils;
import com.jd.util.CollectionUtils;

import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.ExtensionMethod;

/**
 * @author Jaedoo Lee
 */
@Entity
@Table(name = "product")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ExtensionMethod({CollectionUtils.class, BigDecimalUtils.class})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    protected LocalDateTime createdAt;

    private String title;

    @Column(name = "total_investing_amount", nullable = false)
    private BigDecimal totalInvestingAmount;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Investor> investors;

    @Column(name = "started_at", nullable = false)
    private LocalDateTime startedAt;

    @Column(name = "finished_at", nullable = false)
    private LocalDateTime finishedAt;

    public InvestmentStatus getStatus() {
        if (LocalDateTime.now().isBefore(startedAt)) {
            return InvestmentStatus.WAITING;
        } else if (LocalDateTime.now().isAfter(finishedAt)) {
            return InvestmentStatus.FINISHING;
        }

        return InvestmentStatus.RECRUTING;
    }

    public BigDecimal getInvestingAmount() {
        return investors.map(Investor::getInvestedAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public long getInvestorCnt() {
        return investors.size();
    }

    public int getPeriod() {
        return Period.between(finishedAt.toLocalDate(), startedAt.toLocalDate()).getDays();
    }

    public void addInvesting(Investor investing) {
        this.investors.add(investing);
    }

    public void validateInvesting(BigDecimal newInvestingAmount) {
        if (getFinishedAt().isBefore(LocalDateTime.now()) || getInvestingAmount().isSameOrGreaterThan(getTotalInvestingAmount())) {
            throw new ProductException(ErrorMessage.PRODUCT_SOLD_OUT);
        }
        if (getInvestingAmount().add(newInvestingAmount).isGreaterThan(getTotalInvestingAmount())) {
            throw new ProductException(ErrorMessage.INVALID_INVESTING_AMOUNT);
        }
    }

}
