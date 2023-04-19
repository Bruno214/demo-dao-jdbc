package model.impl;

import model.dao.SellerDao;
import model.entities.Seller;

import java.util.List;

public class SellerDaoJDBC implements SellerDao {
    @Override
    public void insert(Seller seller) {

    }

    @Override
    public void update(Seller seller) {

    }

    @Override
    public void deleteById(int id) {
        System.out.println("apaguei o id: " + id);
    }

    @Override
    public Seller findById(int id) {
        return null;
    }

    @Override
    public List<Seller> findAll() {
        return null;
    }
}
