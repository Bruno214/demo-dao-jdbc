package aplication;


import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class App {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: seller findById ===");
        Seller sellerProcurado = sellerDao.findById(2);

        if (sellerProcurado != null) {
            System.out.println(sellerProcurado);
        }else {
            System.out.println("O seller procurado não esta na base de dados");
        }


        System.out.println("\n=== TEST 2: seller findByDepartment ===");
        Department department = new Department(2, "Computers");
        List<Seller> sellers = sellerDao.findByDepartment(department);

        for (Seller obj : sellers) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 3: seller findAll ===");
        sellers = sellerDao.findAll();

        for(Seller obj : sellers) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 4: seller insert ===");
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");


        try {
            Seller testeSeller = new Seller(1,"Fernanda Silva", "fernanda@gmail.com",
                    new Date(data.parse("10/09/1999").getTime()), 5000,department);

            //sellerDao.insert(testeSeller);
          //  System.out.println(testeSeller.getId());

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


        System.out.println("\n=== TEST 5: seller update ===");

        Seller testeSeller = sellerDao.findById(17);
        if (testeSeller != null) {
            testeSeller.setName("Marta Waine");
            sellerDao.update(testeSeller);
            System.out.println("update Completed!");
        }

        System.out.println("\n=== TEST 5: seller delete ===");
        sellerDao.deleteById(13);
    }
}
