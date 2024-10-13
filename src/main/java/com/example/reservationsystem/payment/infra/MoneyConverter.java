package com.example.reservationsystem.payment.infra;

import com.example.reservationsystem.account.domain.Money;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.math.BigDecimal;

@Converter(autoApply = true)
public class MoneyConverter implements AttributeConverter<Money, BigDecimal> {

    @Override
    public BigDecimal convertToDatabaseColumn(Money money) {
        return money != null ? money.getAmount() : BigDecimal.ZERO;
    }

    @Override
    public Money convertToEntityAttribute(BigDecimal amount) {
        return amount != null ? new Money(amount) : Money.ZERO;
    }

}
