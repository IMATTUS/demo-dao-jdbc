package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Main {

	public static void main(String[] args) {

//		testSeller();
		testDepartment();
	}
	
	public static void testDepartment() {
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		System.out.println("\n=== Test 1: Department findAll ===");
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Test 2: Department findById ===");
		Department department = departmentDao.findById(2);
		System.out.println(department);
		
		System.out.println("\n=== Test 3: Department Update ===");
		department = departmentDao.findById(3);
		department.setName("Clothing");
		departmentDao.update(department);
		
		
		System.out.println("\n=== Test 4: Department Insert ===");
		Department newdepartment = new Department(5, "Pharmacy");
		departmentDao.insert(newdepartment);
		System.out.println("Inserted! New Id: " + newdepartment.getId());
		
//		System.out.println("\n=== Test 6: Department Delete ===");
//		System.out.println("Enter ID to delete");
//		Scanner sc = new Scanner(System.in);
//		int id = sc.nextInt();
//		departmentDao.deleteById(id);
//		sc.close();
		list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
	}
	
	public static void testSeller() {
		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== Test 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("\n=== Test 2: seller findByDepartment ===");
		Department department = new Department(2,null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Test 3: seller findAll ===");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Test 4: seller insert ===");
		
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(),4000.0,department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New Id: " + newSeller.getId());
		
		System.out.println("\n=== Test 5: seller update ===");
		seller = sellerDao.findById(1);
		seller.setName("Martha Wayne");
		sellerDao.update(seller);
		
		System.out.println("\n=== Test 6: seller Delete ===");
		System.out.println("Enter ID to delete");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		sc.close();
	}

}
