# Aplikasi Invoice Management #

Aplikasi ini dipakai untuk mengelola invoice dan menyambungkan dengan berbagai metode pembayaran masa kini. diantara
metode pembayaran yang akan di support antara lain :

* Virtual Account Bank
    * Bank BRI
    * Bank CIMB
    * Bank BSI

* e-Wallet
    * OVO
    * GoPay

* QR Payment
    * QRIS

# Cara Setup Database #

1. Jalankan postgresql di docker

```
	docker run --rm \
	--name invoice-db \
	-e POSTGRES_USER=invoice \
	-e POSTGRES_PASSWORD=mhBMHAevM2YLcLDAHwpb \
	-e POSTGRES_DB=invoicedb \
	-e PGDATA=/var/lib/postgresql/data/pgdata \
	-v "/d/data ali/development/ris.id/invoice-management/invoicedb-data:/var/lib/postgresql/data" \
	-p 5432:5432 \
	postgres:13
```