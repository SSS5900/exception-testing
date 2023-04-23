package ru.netology.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    Product product1 = new Product(10, "", 2_000);
    Product product2 = new Product(20, "", 2_000);
    Product product3 = new Product(30, "", 2_000);

//    @Test
//    public void findById() {
//        ShopRepository repo = new ShopRepository();
//        repo.add(product1);
//        repo.add(product2);
//        repo.add(product3);
//
//        int id = 10;
//
//
//
//        Product expected = product1;
//        Product actual = repo.findById(id);
//        Assertions.assertEquals(expected, actual);
//        System.out.println(repo.findById(id));
//
//    }

//    ________________________________________________________________________________________________________
    @Test
    public void removeByIdNotFinded() {

        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        int id = 40;

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(id);
        });
    }

//______________________________________________________________________________________________________________________
    @Test
    public void removeByIdRemoved() {

        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.removeById(product2.getId());

        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);


    }

}
