import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import simu.framework.IMoottori;
import simu.framework.Tapahtuma;
import simu.test.MoottoriForTest;

public class MainTest {

    private IMoottori moottori;

    @BeforeEach
    public void setUp() {

        moottori = new MoottoriForTest() {
            @Override
            protected void suoritaTapahtuma(Tapahtuma t) {

            }

            @Override
            protected void yritaCTapahtumat() {

            }

            @Override
            protected void alustukset() {

            }

            @Override
            public void setSettings(int[] ints) {

            }

            @Override
            public int[] getSettings() {
                return new int[0];
            }
        };
    }

    @Test
    public void testSetSimulointiaika() {
        moottori.setSimulointiaika(1440);
        assertEquals(1440, moottori.getSimulointiaika());
    }

    @Test
    public void testSetViive() {
        moottori.setViive(100);
        assertEquals(100, moottori.getViive());
    }



}
