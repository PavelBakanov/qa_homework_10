package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Users;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;
import java.io.Reader;

public class JsonFileTests {

    private final ClassLoader cl = JsonFileTests.class.getClassLoader();
    private static final ObjectMapper om = new ObjectMapper();


    @Test
    public void jsonFileParsingTest() throws Exception {
        try (Reader reader = new InputStreamReader(
                cl.getResourceAsStream("users.json")
        )) {
            Users users = om.readValue(reader, Users.class);
            Assertions.assertThat(users.getDataBaseVersion()).isEqualTo(1.025);

            Assertions.assertThat(users.getUsers().get(0).getId()).isEqualTo(1);
            Assertions.assertThat(users.getUsers().get(0).getName()).isEqualTo("John Doe");
            Assertions.assertThat( users.getUsers().get(0).getAge()).isEqualTo(30);

            Assertions.assertThat(users.getUsers().get(1).getId()).isEqualTo(2);
            Assertions.assertThat(users.getUsers().get(1).getName()).isEqualTo("Jane Doe");
            Assertions.assertThat(users.getUsers().get(1).getAge()).isEqualTo(25);

            Assertions.assertThat(users.getUsers().get(2).getId()).isEqualTo(3);
            Assertions.assertThat(users.getUsers().get(2).getName()).isEqualTo("Bob Smith");
            Assertions.assertThat( users.getUsers().get(2).getAge()).isEqualTo(35);
        }
    }
}
