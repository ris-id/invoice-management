package id.ris.invoice.dao;

import id.ris.invoice.entity.Payment;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PaymentDao extends PagingAndSortingRepository<Payment, String> {
}
