package com.useractivitymanagement.service;

import com.useractivitymanagement.entity.User;
import com.useractivitymanagement.exceptions.UserNotFoundException;
import com.useractivitymanagement.repository.UserRepo;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@SpringBootTest
// @RunWith(Parameterized.class)
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    /*
     assertEquals(expectedvalue, actualvalue, deltavalue) deltavalue --> Differences from the actual value that is accepted
     assertNotEquals()
     assertTrue(object to be checked)
     assertNull()
     assertNotNull()
     assertArrayEquals()
     assertSame() --> Used to check the references and not the actual value)
     assertNotSame()
     assertThat()
    */

    private User user;

    @org.junit.BeforeClass
    public static void beforeClass() {
        System.out.println("This executes before any test cases");
    }

    @org.junit.Before
    public void setUp() {
        user = new User();
        System.out.println("Running a test...");
    }

    @Autowired
    private UserRepo userRepo;

    @Parameterized.Parameter(0)
    public String email;

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object[][] {
                { "jane.smith@example.com" },
                { "john.doe@example.com" }
        });
    }

    @org.junit.Test //(expected = UserNotFoundException.class)
    public void findByEmailEquals() {
        assertTrue(userRepo.findByEmailEquals(email).isPresent());
    }

    @org.junit.Test
    public void updateUserByEmail() {
    }

    @org.junit.AfterClass
    public static void afterClass() {
        System.out.println("This executes after any test cases");
    }
}