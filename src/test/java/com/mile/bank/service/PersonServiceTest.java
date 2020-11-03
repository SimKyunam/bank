package com.mile.bank.service;


import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class PersonServiceTest {
//    @InjectMocks //대상이 되는 객체에 사용
//    private PersonService personService;
//
//    @Mock //대상이 되는 객체에서 사용할 객체 주입
//    private PersonRepository personRepository;
//
//    @Test
//    void getAll(){
//        when(personRepository.findAll(any(Pageable.class)))
//            .thenReturn(new PageImpl<>(Lists.newArrayList(new Person("martin"), new Person("dennis"), new Person("tony"))));
//
//        Page<Person> result = personService.getAll(PageRequest.of(0, 3));
//
//        assertThat(result.getNumberOfElements()).isEqualTo(3);
//        assertThat(result.getContent().get(0).getName()).isEqualTo("martin");
//        assertThat(result.getContent().get(1).getName()).isEqualTo("dennis");
//        assertThat(result.getContent().get(2).getName()).isEqualTo("tony");
//    }
//
//    @Test
//    void getPeopleByName(){
//        //Mockito 사용하는 이유 단위 테스트를 위해서..
//        //Ex) personRepository.findByName()에서 에러가 발생해도 getPeopleByName()에 문제가 없으면 통과
//        when(personRepository.findByName("martin"))
//            .thenReturn(Lists.newArrayList(new Person("martin")));
//
//        List<Person> result = personService.getPeopleByName("martin");
//
//        assertThat(result.size()).isEqualTo(1);
//        assertThat(result.get(0).getName()).isEqualTo("martin");
//    }
//
//    @Test
//    void getPerson(){
//        when(personRepository.findById(1L))
//            .thenReturn(Optional.of(new Person("martin")));
//
//        Person person = personService.getPerson(1L);
//
//        assertThat(person.getName()).isEqualTo("martin");
//    }
//
//    @Test
//    void getPersonIfNotFound(){
//        when(personRepository.findById(1L))
//            .thenReturn(Optional.empty());
//
//        Person person = personService.getPerson(1L);
//
//        assertThat(person).isNull();
//    }
//
//    @Test
//    void put(){
//        //return이 없는 경우 테스트를 검증하기가 어렵다.
//        //그래서 verify()를 이용하여 실제 실행이 있는지 체크를 한다.
//        //times는 실행 횟수, any를 통해 값을 넣는 행위를 임의로 한다.
//        personService.put(mockPersonDto());
//
//        verify(personRepository, times(1)).save(argThat(new IsPersonWillBeInserted()));
//    }
//
//    @Test
//    void modifyIfPersonNotFound(){
//        when(personRepository.findById(1L))
//            .thenReturn(Optional.empty());
//
//        assertThrows(PersonNotFoundException.class, () -> personService.modify(1L, mockPersonDto()));
//    }
//
//    @Test
//    void modifyIfNameIsDifferent(){
//        when(personRepository.findById(1L))
//            .thenReturn(Optional.of(new Person("tony")));
//
//        assertThrows(RenameNotPermittedException.class, () -> personService.modify(1L, mockPersonDto()));
//    }
//
//    @Test
//    void modify(){
//        when(personRepository.findById(1L))
//            .thenReturn(Optional.of(new Person("martin")));
//
//        personService.modify(1L, mockPersonDto());
//
//        verify(personRepository, times(1)).save(argThat(new IsPersonWillBeUpdated()));
//    }
//
//    @Test
//    void modifyByNameIfPersonNotFound(){
//        when(personRepository.findById(1L))
//            .thenReturn(Optional.empty());
//
//        assertThrows(PersonNotFoundException.class, () -> personService.modify(1L, "daniel"));
//    }
//
//    @Test
//    void modifyByName(){
//        when(personRepository.findById(1L))
//            .thenReturn(Optional.of(new Person("martin")));
//
//        personService.modify(1L, "daniel");
//
//        verify(personRepository, times(1)).save(argThat(new IsNameWillBeUpdated()));
//    }
//
//    @Test
//    void deleteIfPersonNotFound(){
//        when(personRepository.findById(1L))
//            .thenReturn(Optional.empty());
//
//        assertThrows(PersonNotFoundException.class, () -> personService.delete(1L));
//    }
//
//    @Test
//    void delete(){
//        when(personRepository.findById(1L))
//            .thenReturn(Optional.of(new Person("martin")));
//
//        personService.delete(1L);
//
//        verify(personRepository, times(1)).save(argThat(new IsPersonWillBeDeleted()));
//    }
//
//    private PersonDto mockPersonDto(){
//        return PersonDto.of("martin", "programming", "판교", LocalDate.now(), "programmer", "010-1111-2222");
//    }
//
//    private static class IsPersonWillBeInserted implements ArgumentMatcher<Person>{
//
//        @Override
//        public boolean matches(Person person) {
//            return equals(person.getName(), "martin")
//                && equals(person.getHobby(), "programming")
//                && equals(person.getAddress(), "판교")
//                && equals(person.getBirthday(), Birthday.of(LocalDate.now()))
//                && equals(person.getJob(), "programmer")
//                && equals(person.getPhoneNumber(), "010-1111-2222");
//        }
//
//        private boolean equals(Object actual, Object expected){
//            return expected.equals(actual);
//        }
//    }
//
//    private static class IsPersonWillBeUpdated implements ArgumentMatcher<Person> {
//        @Override
//        public boolean matches(Person person) {
//            return equals(person.getName(), "martin")
//                && equals(person.getHobby(), "programming")
//                && equals(person.getAddress(), "판교")
//                && equals(person.getBirthday(), Birthday.of(LocalDate.now()))
//                && equals(person.getJob(), "programmer")
//                && equals(person.getPhoneNumber(), "010-1111-2222");
//        }
//
//        private boolean equals(Object actual, Object expected){
//            return expected.equals(actual);
//        }
//    }
//
//    private static class IsNameWillBeUpdated implements ArgumentMatcher<Person> {
//
//        @Override
//        public boolean matches(Person person) {
//            return person.getName().equals("daniel");
//        }
//    }
//
//    private static class IsPersonWillBeDeleted implements ArgumentMatcher<Person> {
//
//        @Override
//        public boolean matches(Person person) {
//            return person.isDeleted();
//        }
//    }
}