package model.dao;

import model.entities.Department;
import java.util.List;

public interface DepartmentDao {

    // insere um departamento no banco de dados
    void insert(Department department);

    // atualiza um departamento no banco de dados
    void update(Department department);

    // recebe um id e exclui no banco de dados
    void deleteById(int id);

    // faz uma pesquisa no banco de dados por id, e retorna este departamento
    Department findById(int id);

    // retorna uma lista de Departamentos
    List<Department>  findAll();
}
