package id.ris.invoice.dao;

import id.ris.invoice.entity.InvoiceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Sql(scripts = {"/sql/delete-invoice-type.sql", "/sql/insert-inactive-invoice-type.sql"})
public class InvoiceTypeDaoTests {

    @Autowired
    InvoiceTypeDao invoiceTypeDao;

    @Test
    public void testInsertInvoiceType() throws Exception {
        InvoiceType invoiceType = new InvoiceType();
        invoiceType.setCode("IT-001");
        invoiceType.setName("Invoice Type Test");
        Assertions.assertNull(invoiceType.getId());
        invoiceTypeDao.save(invoiceType);
        Assertions.assertNotNull(invoiceType.getId());
        Assertions.assertNotNull(invoiceType.getCreatedAt());
        Assertions.assertNotNull(invoiceType.getUpdatedAt());
        Assertions.assertEquals(invoiceType.getCreatedAt(), invoiceType.getUpdatedAt());
        Thread.sleep(1000);
        invoiceType.setName("Test Update");
        invoiceType = invoiceTypeDao.save(invoiceType);
        Assertions.assertNotEquals(invoiceType.getCreatedAt(), invoiceType.getUpdatedAt());
    }

    @Test
    public void testQuerySoftDelete() {
        Long jmlRecord = invoiceTypeDao.count();
        System.out.println("Jumlah record : " + jmlRecord);
        Assertions.assertEquals(1, jmlRecord);
    }

    @Test
    public void testSoftDelete() {
        InvoiceType invoiceType = invoiceTypeDao.findById("test-002").get();
        invoiceTypeDao.delete(invoiceType);

        Long jmlRecord = invoiceTypeDao.count();
        System.out.println("Jumlah record : " + jmlRecord);
        Assertions.assertEquals(0, jmlRecord);
    }
}
