
import static bludiste.Bludiste.loadMap;
import static bludiste.Bludiste.printMap;
import static bludiste.Bludiste.quitMap;
import java.io.IOException;
import java.lang.reflect.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import maps.*;
import objects.statics.*;
import objects.*;

/**
 * Homework2: uloha c. 2 z IJA
 * Trida testujici implementaci zadani 2. ukolu.
 */
public class BTest {

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void bTest1() throws IOException { 
        Map map = quitMap();
        map = loadMap("simple1010.txt");
        map.createHead(1); 
        
        /**test jestli muzu vkrocit do zdi*/
        assertFalse("Nelze jit do zdi", map.head.moveClear());
    }
}
