package com.example.interview;

import com.example.interview.entity.Equipment;
import com.example.interview.entity.EquipmentComment;
import com.example.interview.entity.EquipmentParameter;
import com.example.interview.entity.EquipmentType;
import com.example.interview.repository.EquipmentRepo;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class InterviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterviewApplication.class, args);
	}

//	@Bean
//	ApplicationRunner init(EquipmentRepo repository) {

//		Equipment equipment1 = new Equipment();
//		equipment1.setType(EquipmentType.FRIDGE);
//		equipment1.setToFix(true);

//		List<EquipmentParameter> parameters1 = new ArrayList<>();
//		parameters1.add(new EquipmentParameter(equipment1.getUuid(),"name","beko"));
//		parameters1.add(new EquipmentParameter(equipment1.getUuid(),"owner","kris"));
//		equipment1.setPropeties(parameters1);
//
//		List<EquipmentComment> comments1 = new ArrayList<>();
//		comments1.add(new EquipmentComment(equipment1.getUuid(),"ready to ship"));
//		comments1.add(new EquipmentComment(equipment1.getUuid(),"fixed by john"));
//		equipment1.setComments(comments1);
//
//		Equipment equipment2 = new Equipment();
//		equipment2.setType(EquipmentType.ELECTRIC_SHAVER);
//		equipment2.setToFix(true);
//
//		List<EquipmentParameter> parameters2 = new ArrayList<>();
//		parameters2.add(new EquipmentParameter(equipment2.getUuid(),"name","philips"));
//		parameters2.add(new EquipmentParameter(equipment2.getUuid(),"owner","boss"));
//		equipment2.setPropeties(parameters2);
//
//		List<EquipmentComment> comments2 = new ArrayList<>();
//		comments2.add(new EquipmentComment(equipment2.getUuid(),"fix itt asap"));
//		comments2.add(new EquipmentComment(equipment2.getUuid(),"john is fixing"));
//		equipment2.setComments(comments2);


//		return args -> {
//			Stream.of(equipment1,equipment2).forEach(equipment -> {
//				repository.save(equipment);
//			});
//			repository.save(equipment1);

//		};
//	}
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}
}
