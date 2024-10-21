package hu.petrik.szuperhosprojekt;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KepregenyTest {
    public KepregenyTest()
    {
        Kepregeny.szuperhosLista = new ArrayList<>();
    }

    @Test
    void szereplok() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("szuperhos.txt").getFile());
        Kepregeny.szereplok(file.getAbsolutePath());
        assertEquals(6, Kepregeny.szuperhosLista.size());
    }
    @Test
    void szuperhosok()
    {
        Kepregeny.szuperhosLista = new ArrayList<>(List.of(new Vasember(),new Batman()));
        String expected = "Vasember: Szupererő: 150; van gyengesége"
                + System.lineSeparator() + "Batman: leleményesség: 100"
                + System.lineSeparator();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        Kepregeny.szuperhosok();

        System.out.flush();
        System.setOut(old);

        String output = baos.toString();
        assertEquals(expected, output);
    }
}