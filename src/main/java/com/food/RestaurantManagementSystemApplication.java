package com.food;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.food.entity.Role;
import com.food.payloads.AppConstant;
import com.food.repo.RoleRepo;

@SpringBootApplication
public class RestaurantManagementSystemApplication implements CommandLineRunner {

	
	@Autowired
	private RoleRepo roleRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(RestaurantManagementSystemApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		
		try {
		Role role=new Role();
		role.setId(AppConstant.ROLE_ADMIN);
		role.setRoleName("ROLE_ADMIN");
		
		Role role1=new Role();
		role1.setId(AppConstant.ROLE_NORMAL);
		role1.setRoleName("ROLE_NORMAL");
		
		List<Role> roles=List.of(role,role1);
		
		List<Role> result = this.roleRepo.saveAll(roles);
		
		result.forEach(r->{
			System.out.println(r.getRoleName());
		});
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}

