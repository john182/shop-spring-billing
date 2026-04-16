package com.shop.billing.domain.model.invoice;

import com.shop.billing.domain.model.DomainException;
import com.shop.billing.domain.model.IdGenerator;
import io.micrometer.common.util.StringUtils;
import lombok.*;

import java.util.UUID;

@Setter(AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class PaymentSettings {

    @EqualsAndHashCode.Include
    private UUID id;
    private UUID creditCardId;
    private String gatewayCode;
    private PaymentMethod method;

    public static PaymentSettings brandNew(PaymentMethod method, UUID creditCardId) {
        return new PaymentSettings(
                IdGenerator.generateTimeBasedUUID(),
                creditCardId,
                null,
                method
        );
    }

    void assignGatewayCode(String gatewayCode) {
        if (StringUtils.isBlank(gatewayCode)) {
            throw new IllegalArgumentException();
        }
        if (this.getGatewayCode() != null) {
            throw new DomainException("Gateway code already assigned");
        }
        setGatewayCode(gatewayCode);
    }
}
