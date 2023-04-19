package aplication;


import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

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

    }
}
