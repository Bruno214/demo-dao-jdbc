package aplication;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.ArrayList;
import java.util.List;

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
        departmentDao.insert(department);
        System.out.println("Inserted! new id: " + department.getId());

    }
}
