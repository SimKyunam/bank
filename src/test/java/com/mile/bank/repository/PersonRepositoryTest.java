package com.mile.bank.repository;


import org.springframework.boot.test.context.SpringBootTest;
import javax.transaction.Transactional;

@SpringBootTest
@Transactional
class PersonRepositoryTest {
//
//    @Autowired
//    private PersonRepository personRepository;
//
//    @Test
//    void findByName(){
//        List<Person> people = personRepository.findByName("tony");
//        assertThat(people.size()).isEqualTo(1);
//
//        Person person = people.get(0);
//        assertAll(
//                () -> assertThat(person.getName()).isEqualTo("tony"),
//                () -> assertThat(person.getHobby()).isEqualTo("reading"),
//                () -> assertThat(person.getAddress()).isEqualTo("서울"),
//                () -> assertThat(person.getBirthday()).isEqualTo(Birthday.of(LocalDate.of(1991, 7, 10))),
//                () -> assertThat(person.getJob()).isEqualTo("officer"),
//                () -> assertThat(person.getPhoneNumber()).isEqualTo("010-2222-5555"),
//                () -> assertThat(person.isDeleted()).isEqualTo(false)
//        );
//    }
//
//    @Test
//    void findByNameIfDeleted(){
//        List<Person> people = personRepository.findByName("andrew");
//
//        assertThat(people.size()).isEqualTo(0);
//    }
//
//    @Test
//    void findByMonthOfBirthday(){
//        List<Person> people = personRepository.findByMonthOfBirthday(7);
//
//        assertThat(people.size()).isEqualTo(2);
//        assertAll(
//            () -> assertThat(people.get(0).getName()).isEqualTo("david"),
//            () -> assertThat(people.get(1).getName()).isEqualTo("tony")
//        );
//    }
//
//    @Test
//    void findPeopleDeleted(){
//        List<Person> people = personRepository.findPeopleDeleted();
//
//        assertThat(people.size()).isEqualTo(1);
//        assertThat(people.get(0).getName()).isEqualTo("andrew");
//    }
}