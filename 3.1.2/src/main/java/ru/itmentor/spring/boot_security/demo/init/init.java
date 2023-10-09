package ru.itmentor.spring.boot_security.demo.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itmentor.spring.boot_security.demo.dao.RoleDao;
import ru.itmentor.spring.boot_security.demo.model.Role;
import ru.itmentor.spring.boot_security.demo.model.User;
import ru.itmentor.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.Collections;
@Component
public class init {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleDao roleRepository;

    @PostConstruct
    public void init() {
        Role role = new Role("ROLE_USER");
        roleRepository.save(role);

        Role role1 = new Role("ROLE_ADMIN");
        roleRepository.save(role1);

        User user = new User();
        user.setFirstName("user");
        user.setLastName("user");
        user.setUsername("user");
        user.setPassword("pass");
        user.setRoles(Collections.singletonList(role));
        userService.save(user);

        User user1 = new User();
        user1.setFirstName("admin");
        user1.setLastName("admin");
        user1.setUsername("admin");
        user1.setPassword("pass");
        user1.setRoles(Collections.singletonList(role1));
        userService.save(user1);
    }
}
