package net.javabeat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootSqlDemo implements CommandLineRunner{

  Logger logger = LoggerFactory.getLogger(SpringbootSqlDemo.class);
  
  @Autowired
  PersonService personService;
  
  @Autowired
  PersonRepository personRepository;
  
  public void run(String... args) {
	  
	logger.info("======== Using JDBCTemplate for insert and find");
    Person person = new Person();
    person.setFirstName("Sam");
    person.setLastName("Neil");
    person.setAge(26);
    person.setPlace("LA");
	int genId = personService.addPerson(person);
    
    if ( genId > 0){
	  person.setId(genId);
      logger.info("======== Person with ID: " + person.getId() + " saved successfully");
    }
    
    for(Person p : personService.getAllPerson()){
      logger.info("======== Found Person: " + p.toString());
    }
    
    logger.info("======== Using JPA for insert and find");
    PersonEntity personEntity = new PersonEntity("Neil", "Armweak", 36, "Kathmandu");
    personEntity = personRepository.save(personEntity);
    logger.info("======== Person with ID: " + personEntity.getId() + " saved successfully");
    
    for ( PersonEntity pEntity : personRepository.findAll()){
      logger.info("======== Found Person: " + pEntity.toString());
    }
  }
  
  public static void main(String[] args) {
    SpringApplication.run(SpringbootSqlDemo.class, args);
  }
 
}
