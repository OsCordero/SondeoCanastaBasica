package com.too.ues.edu.canastabasica;

import com.too.ues.edu.canastabasica.model.Usuario;
import com.too.ues.edu.canastabasica.repo.IUsuarioRepo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private IUsuarioRepo repo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	
	//Test para crear usuario en bd
	@Test
	public void creartUsuario(){
		Usuario us= new Usuario();				
		us.setEnabled(true);
		us.setPassword(encoder.encode("password"));
		us.setUsername("Jose");		
		Usuario retorno=repo.save(us);
	}

	

}
