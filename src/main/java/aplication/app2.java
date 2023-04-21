package aplication;

import db.DbException;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class app2 {
    public static void main(String[] args) {
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: dapartment findById ===");
        Department dep = departmentDao.findById(15);
        System.out.println(dep);

        System.out.println("=== TEST 2: department findAll ===");
        List<Department> list = departmentDao.findAll();
        for (Department deps : list) {
            System.out.println(deps);
        };

        System.out.println("=== TEST 3: department insert ===");
        Department department = new Department(0, "Music");
      //  departmentDao.insert(department);
        System.out.println("Inserted! new id: " + department.getId());

        System.out.println("=== TEST 4: department update ===");
        Department dep2 = departmentDao.findById(1);
        if (dep2 != null) {
            dep2.setName("Food");
            departmentDao.update(dep2);
            System.out.println("Update completed");
        }else {
            throw new DbException("ERROR! Department not found");
        }


        System.out.println("=== TEST 5: department delete ===");
        Scanner scan = new Scanner(System.in);

        System.out.print("Informe um id par excuir no banco de dados: ");
        int id = scan.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed");

    }
}
