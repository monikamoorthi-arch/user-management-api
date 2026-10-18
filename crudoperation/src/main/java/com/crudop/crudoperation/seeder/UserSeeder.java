package com.crudop.crudoperation.seeder;

import com.crudop.crudoperation.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserSeeder implements CommandLineRunner {

    @Autowired
    private Usersrepository usersrepository;

    public void run(String... args) throws Exception{
        if(usersrepository.count() == 0){
            List<User> demousers = List.of(
                    new User(null,"Swetha", "swethat@gmail.com"),
                    new User(null, "Sibi", "sibi@gmail.com"),
                    new User(null, "jenifer", "jenifer@gamil.com"),
                    new User(null, "Princy", "princy@gmail.com")
            );
            usersrepository.saveAll(demousers);
            System.out.println("seeded demo users");
        }else{
            System.out.println("demo users already exist");
        }

    }
}
