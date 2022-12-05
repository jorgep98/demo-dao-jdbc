package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("\n=== Test 1: Department findById ===");
		
		Department dep = departmentDao.findById(1);
		
		System.out.println(dep);
		
		System.out.println("\n=== Test 2: Department findAll ===");
		
		List<Department> list = departmentDao.findAll();
		
		for (Department obj : list ) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Test 3: Department insert ===");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Department inserted! " + newDepartment.getId());
		
		System.out.println("\n=== Test 4: Department update ===");
		dep = departmentDao.findById(1);
		dep.setName("Engeneering");
		departmentDao.update(dep);
		System.out.println("Update Completed");
		
		System.out.println("\n=== Test 6: Department Delete ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete complete!");
		

	}

}
