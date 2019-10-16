package com.too.ues.edu.canastabasica;

import com.too.ues.edu.canastabasica.model.Usuario;
import com.too.ues.edu.canastabasica.model.Rol;
import com.too.ues.edu.canastabasica.repo.IUsuarioRepo;
import com.too.ues.edu.canastabasica.repo.RolRepo;
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
	private RolRepo repoR;

	@Autowired
	private BCryptPasswordEncoder encoder;

	
	//Test para crear usuarios en bd
	@Test
	public void createUsuario(){
		Usuario us= new Usuario();				
		//us.setIdUsuario(Long.parseLong("1"));
		us.setEnabled(true);
		us.setPassword(encoder.encode("password"));
		us.setUsername("Prueba");
		us.setNombre("Andrés Castro");
		us.setCorreo("andres@gmail.com");
		Usuario retorno=repo.save(us);
		
		Usuario usDos= new Usuario();				
		//usDos.setIdUsuario(Long.parseLong("2"));
		usDos.setEnabled(true);
		usDos.setPassword(encoder.encode("password"));
		usDos.setUsername("Test");	
		usDos.setNombre("Roberto Ventura");
		usDos.setCorreo("roberto@gmail.com");
		Usuario retornoDos=repo.save(usDos);
	}
   @Test
   public void createRoles(){
	   
	   Rol rol1= new Rol();
	   rol1.setRol("ROLE_ADMIN");
	   Rol rolretorno1=repoR.save(rol1);
	   
	   Rol rol2= new Rol();
	   rol2.setRol("ROLE_USER");
	   Rol rolretorno2=repoR.save(rol2);
	   
   }



	

}
