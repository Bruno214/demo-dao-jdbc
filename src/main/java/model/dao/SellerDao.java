package model.dao;

import model.entities.Seller;

import java.util.List;

public interface SellerDao {

    // insere um departamento no banco de dados
    void insert(Seller seller);

    // atualiza um departamento no banco de dados
    void update(Seller seller);

    // recebe um id e exclui no banco de dados
    void deleteById(int id);

    // faz uma pesquisa no banco de dados por id, e retorna este departamento
    Seller findById(int id);

    // retorna uma lista de Departamentos
    List<Seller> findAll();
}
