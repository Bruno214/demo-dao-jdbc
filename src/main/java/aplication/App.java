package aplication;


import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;
import java.util.Date;

public class App {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();
        Seller sellerProcurado = sellerDao.findById(8);

        if (sellerProcurado != null) {
            System.out.println(sellerProcurado);
        }else {
            System.out.println("O seller procurado não esta na base de dados");
        }

    }
}
