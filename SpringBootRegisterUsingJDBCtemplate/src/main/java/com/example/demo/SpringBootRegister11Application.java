package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
//import com.example.demo.entity.User;

@SpringBootApplication
public class SpringBootRegister11Application implements CommandLineRunner{
	@Autowired
	private UserDao userdao;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRegister11Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//	============== Insertion ==========================
//		User user1 = new User("mayank","mayank@gmail.com","male","New York");
//		User user2 = new User("Nishant", "nishant@gmail.com", "male", "Wave City");
//		boolean status	=	userdao.insertUser(user2);
//		if(status) {
//			System.out.println("User Data Inserted");
//		}else {
//			System.out.println("user not inserted ");
//		}
		
		
//		========== Updation ===========================
//		User user1 = new User("deepak", "deepak@gmail.com", "male", "kanpur");
//		boolean status = userdao.updateUser(user1);
//		if(status) {
//			System.out.println("User Data Updated");
//		}else {
//			System.out.println("User data is not Updated");
//		}
		
		
//		============== Deletion ========================
//		boolean status = userdao.deleteUserByEmail("deepak@gmail.com");
//		if(status) {
//			System.out.println("User Data Deleted");
//		}else {
//			System.out.println("User data is not Deleted");
//		}
		
		
//		=================== Display One User ==================
//		User user = userdao.getUserByEmail("mayank@gmail.com");
//		System.out.println("Name is : " +user.getName());
//		System.out.println("Email  is : " +user.getEmail());
//		System.out.println("Gender  is : " +user.getGender());
//		System.out.println("City is : " +user.getCity());
		
		
//		================= Dislpay All User =====================
		List<User> list = userdao.getAllUsers();
		for(User user: list) {
			System.out.println("Name is : " +user.getName());
			System.out.println("Email  is : " +user.getEmail());
			System.out.println("Gender  is : " +user.getGender());
			System.out.println("City is : " +user.getCity());
			System.out.println("=======================");
		}
	}

}
