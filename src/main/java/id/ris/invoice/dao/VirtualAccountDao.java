package id.ris.invoice.dao;

import id.ris.invoice.entity.VirtualAccount;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VirtualAccountDao extends PagingAndSortingRepository<VirtualAccount, String> {
}
