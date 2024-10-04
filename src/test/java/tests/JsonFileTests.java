package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Users;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;
import java.io.Reader;

public class JsonFileTests {

    private ClassLoader cl = JsonFileTests.class.getClassLoader();
    private static final ObjectMapper om = new ObjectMapper();


    @Test
    public void jsonFileParsingTest() throws Exception {
        try (Reader reader = new InputStreamReader(
                cl.getResourceAsStream("users.json")
        )) {

            Users users = om.readValue(reader, Users.class);

            Assertions.assertEquals(1.025, users.getDataBaseVersion());
            System.out.println(users.getDataBaseVersion());

            Assertions.assertEquals(1, users.getUsers().get(0).getId());
            Assertions.assertEquals("John Doe", users.getUsers().get(0).getName());
            Assertions.assertEquals(30, users.getUsers().get(0).getAge());

            Assertions.assertEquals(2, users.getUsers().get(1).getId());
            Assertions.assertEquals("Jane Doe", users.getUsers().get(1).getName());
            Assertions.assertEquals(25, users.getUsers().get(1).getAge());

            Assertions.assertEquals(3, users.getUsers().get(2).getId());
            Assertions.assertEquals("Bob Smith", users.getUsers().get(2).getName());
            Assertions.assertEquals(35, users.getUsers().get(2).getAge());
        }
    }
}
