package tests;

import com.davidev.Main;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Main.class,webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ExtendWith(SqlServerContainerExtension.class)
public class ApplicationStartupTest {

    @Test
    public void contextLoads() {
    }
}
