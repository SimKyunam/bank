package com.mile.bank.controller;

import org.springframework.boot.test.context.SpringBootTest;
import javax.transaction.Transactional;

/**
 * Created by mileNote on 2020-09-15
 * Blog : https://milenote.tistory.com
 * Github : https://github.com/SimKyunam
 */
@SpringBootTest
@Transactional
class PersonControllerTest {
//    @Autowired
//    private PersonRepository personRepository;
//    @Autowired
//    private ObjectMapper objectMapper;
//    @Autowired
//    private WebApplicationContext wac;
//
//    private MockMvc mockMvc;
//
//    @BeforeEach
//    void beforeEach(){
//        mockMvc = MockMvcBuilders.webAppContextSetup(wac)
//                .addFilters(new CharacterEncodingFilter("UTF-8", true))
//                .alwaysDo(print())
//                .build();
//    }
//
//    @Test
//    void getAll() throws Exception{
//        mockMvc.perform(
//            MockMvcRequestBuilders.get("/api/person")
//                .param("page", "1")
//                .param("size", "2"))
//            .andExpect(status().isOk())
//            .andExpect(jsonPath("$.totalPages").value(3)) //List객체 -> Page객체로 변경됌
//            .andExpect(jsonPath("$.totalElements").value(6))
//            .andExpect(jsonPath("$.numberOfElements").value(2))
//            .andExpect(jsonPath("$.content.[0].name").value("dennis"))
//            .andExpect(jsonPath("$.content.[1].name").value("sophia"));
//    }
//
//    @Test
//    void getPerson() throws Exception {
//        mockMvc.perform(
//            MockMvcRequestBuilders.get("/api/person/1"))
//            .andExpect(status().isOk())
//            .andExpect(jsonPath("$.name").value("martin"))
//            .andExpect(jsonPath("$.hobby").isEmpty())
//            .andExpect(jsonPath("$.address").isEmpty())
//            .andExpect(jsonPath("$.birthday").value("1991-08-15"))
//            .andExpect(jsonPath("$.job").isEmpty())
//            .andExpect(jsonPath("$.phoneNumber").isEmpty())
//            .andExpect(jsonPath("$.deleted").value(false))
//            .andExpect(jsonPath("$.age").isNumber())
//            .andExpect(jsonPath("$.birthdayToday").isBoolean());
//    }
//
//    @Test
//    void postPerson() throws Exception{
//        PersonDto dto = PersonDto.of("martin", "programming", "판교", LocalDate.now(), "programmer", "010-1111-2222");
//
//        mockMvc.perform(
//            post("/api/person")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .content(toJsonString(dto)))
//            .andExpect(status().isCreated());
//
//        Person result = personRepository.findAll(Sort.by(Sort.Direction.DESC, "id")).get(0);
//        assertAll(
//            () -> assertThat(result.getName()).isEqualTo("martin"),
//            () -> assertThat(result.getHobby()).isEqualTo("programming"),
//            () -> assertThat(result.getAddress()).isEqualTo("판교"),
//            () -> assertThat(result.getBirthday()).isEqualTo(Birthday.of(LocalDate.now())),
//            () -> assertThat(result.getJob()).isEqualTo("programmer"),
//            () -> assertThat(result.getPhoneNumber()).isEqualTo("010-1111-2222")
//        );
//    }
//
//    @Test
//    void postPersonIfNameIsNull() throws Exception{
//        PersonDto dto = new PersonDto();
//
//        mockMvc.perform(
//            MockMvcRequestBuilders.post("/api/person")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(toJsonString(dto)))
//            .andExpect(status().isBadRequest())
//            .andExpect(jsonPath("$.code").value(400))
//            .andExpect(jsonPath("$.message").value("이름은 필수값입니다."));
//    }
//
//    @Test
//    void postPersonIfNameIsEmpty() throws Exception{
//        PersonDto dto = new PersonDto();
//        dto.setName("");
//
//        mockMvc.perform(
//          MockMvcRequestBuilders.post("/api/person")
//            .contentType(MediaType.APPLICATION_JSON)
//            .content(toJsonString(dto)))
//        .andExpect(status().isBadRequest())
//        .andExpect(jsonPath("$.code").value(400))
//        .andExpect(jsonPath("$.message").value("이름은 필수값입니다."));
//    }
//
//    @Test
//    void postPersonIfNameIsBlankString() throws Exception{
//        PersonDto dto = new PersonDto();
//        dto.setName(" ");
//
//        mockMvc.perform(
//            MockMvcRequestBuilders.post("/api/person")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(toJsonString(dto)))
//            .andExpect(status().isBadRequest())
//            .andExpect(jsonPath("$.code").value(400))
//            .andExpect(jsonPath("$.message").value("이름은 필수값입니다."));
//    }
//
//    @Test
//    void modifyPersonIfNameIsDifferent() throws Exception{
//        PersonDto dto = PersonDto.of("james", "programming", "판교", LocalDate.now(), "programmer", "010-1111-2222");
//
//        mockMvc.perform(
//            MockMvcRequestBuilders.put("/api/person/1")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .content(toJsonString(dto)))
//            .andExpect(status().isBadRequest())
//            .andExpect(jsonPath("$.code").value("400"))
//            .andExpect(jsonPath("$.message").value("이름을 변경 허용하지 않습니다."));
//    }
//
//    @Test
//    void modifyPersonIfPersonNotFound() throws Exception{
//        PersonDto dto = PersonDto.of("martin", "programming", "판교", LocalDate.now(), "programmer", "010-1111-2222");
//
//        mockMvc.perform(
//            MockMvcRequestBuilders.put("/api/person/10")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(toJsonString(dto)))
//            .andExpect(status().isBadRequest())
//            .andExpect(jsonPath("$.code").value(400))
//            .andExpect(jsonPath("$.message").value("Person Entity가 존재하지 않습니다."));
//    }
//
//    @Test
//    void modifyPerson() throws Exception{
//        PersonDto dto = PersonDto.of("martin", "programming", "판교", LocalDate.now(), "programmer", "010-1111-2222");
//
//        mockMvc.perform(
//                MockMvcRequestBuilders.put("/api/person/1")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(toJsonString(dto)))
//                .andExpect(status().isOk());
//
//        Person result = personRepository.findById(1L).get();
//
//        assertAll(
//            () -> assertThat(result.getName()).isEqualTo("martin"),
//            () -> assertThat(result.getHobby()).isEqualTo("programming"),
//            () -> assertThat(result.getAddress()).isEqualTo("판교"),
//            () -> assertThat(result.getBirthday()).isEqualTo(Birthday.of(LocalDate.now())),
//            () -> assertThat(result.getJob()).isEqualTo("programmer"),
//            () -> assertThat(result.getPhoneNumber()).isEqualTo("010-1111-2222")
//        );
//    }
//
//    @Test
//    void modifyName() throws Exception{
//        mockMvc.perform(
//            MockMvcRequestBuilders.patch("/api/person/1")
//                .param("name", "martinModified"))
//            .andExpect(status().isOk());
//
//        assertThat(personRepository.findById(1L).get().getName()).isEqualTo("martinModified");
//    }
//
//    @Test
//    void deletePerson() throws Exception{
//        mockMvc.perform(
//            MockMvcRequestBuilders.delete("/api/person/1"))
//            .andExpect(status().isOk());
//
//        assertTrue(personRepository.findPeopleDeleted().stream().anyMatch(person -> person.getId().equals(1L)));
//    }
//
//    private String toJsonString(PersonDto personDto) throws JsonProcessingException {
//        return objectMapper.writeValueAsString(personDto);
//    }
}