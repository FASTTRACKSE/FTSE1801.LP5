package ftse1801.managerSale.repository;

import org.springframework.data.repository.CrudRepository;

import ftse1801.managerSale.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
