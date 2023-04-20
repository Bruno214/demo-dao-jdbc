package aplication;


import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.ArrayList;
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
        Department department = new Department(2, null);
        List<Seller> sellers = sellerDao.findByDepartment(department);

        for (Seller obj : sellers) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 3: seller findAll ===");
        sellers = sellerDao.findAll();

        for(Seller obj : sellers) {
            System.out.println(obj);
        }
    }
}
