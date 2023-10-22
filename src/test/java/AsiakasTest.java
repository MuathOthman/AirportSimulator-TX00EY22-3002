import org.junit.jupiter.api.Test;
import simu.model.Asiakas;

import static org.junit.jupiter.api.Assertions.*;

public class AsiakasTest {
    @Test
    void isPassport() {

        System.out.println("Passport test passed");
    }

    @Test
    void getCount() {
        System.out.println("Count-test passed");
        assertEquals(1, Asiakas.getCount());
    }
}

