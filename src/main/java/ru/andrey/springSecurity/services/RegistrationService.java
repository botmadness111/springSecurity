package ru.andrey.springSecurity.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.andrey.springSecurity.models.Person;
import ru.andrey.springSecurity.repositories.PeopleRepository;

@Service
public class RegistrationService {
    private final PasswordEncoder passwordEncoder;

    private final PeopleRepository peopleRepository;

    public RegistrationService(PasswordEncoder passwordEncoder, PeopleRepository peopleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.peopleRepository = peopleRepository;
    }

    @Transactional
    public void register(Person person) {
        String encodedPassword = passwordEncoder.encode(person.getPassword());
        person.setPassword(encodedPassword);

        person.setRole("ROLE_USER");

        peopleRepository.save(person);
    }
}
