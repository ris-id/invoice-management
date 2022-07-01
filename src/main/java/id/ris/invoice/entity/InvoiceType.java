package id.ris.invoice.entity;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@SQLDelete(sql = "UPDATE invoice_type SET status_record = 'INACTIVE' WHERE id=?")
@Where(clause = "status_record='ACTIVE'")
public class InvoiceType extends BaseEntity {
    @NotEmpty
    @Size(min = 3, max = 100)
    private String code;

    @NotEmpty()
    @Size(min = 3, max = 100)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "invoice_type_provider",
            joinColumns = @JoinColumn(name = "id_invoice_type"),
            inverseJoinColumns = @JoinColumn(name = "id_payment_provider"))
    private Set<PaymentProvider> paymentProviders = new HashSet<>();
}
