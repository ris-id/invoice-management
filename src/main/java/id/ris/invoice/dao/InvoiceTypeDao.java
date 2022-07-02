package id.ris.invoice.dao;

import id.ris.invoice.entity.InvoiceType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InvoiceTypeDao extends PagingAndSortingRepository<InvoiceType, String> {
}
