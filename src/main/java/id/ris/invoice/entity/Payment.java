package id.ris.invoice.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Payment extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "id_virtual_account")
    private VirtualAccount virtualAccount;

    @NotNull
    @NotEmpty
    private LocalDateTime transactionTime;

    @NotNull
    @NotEmpty
    private String providerReference;

    @NotNull
    @Min(1)
    private BigDecimal amount;
}
