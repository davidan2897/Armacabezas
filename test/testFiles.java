/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Domain.Files;
import Domain.Imagenes;
import Domain.auxiliarControles;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author UsuarioPC
 */
public class testFiles {

    public testFiles() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    @Test
    public void array() throws Exception {
        Domain.Files File = new Files();
        ArrayList<Imagenes> imagenesArrayList = new ArrayList<>();
        imagenesArrayList = null;
        ArrayList<Imagenes> imagenesArrayLista = new ArrayList<>();
        imagenesArrayLista = File.ReadXml();
        assertNull(imagenesArrayLista);

        fail("The test case is a prototype.");
    }

    @Test
    public void arrayImagenes() throws Exception {
        Domain.Files File = new Files();

        ArrayList<Imagenes> imagenesArrayListaa = new ArrayList<>();
        imagenesArrayListaa = File.ReadXml();
        assertNotNull(imagenesArrayListaa);

    }

    @Test
    public void arrayImagenesTamaño() throws Exception {
        Domain.Files File = new Files();

        ArrayList<Imagenes> imagenesArrayListaa = new ArrayList<>();
        imagenesArrayListaa = File.ReadXml();
        assertEquals(imagenesArrayListaa.size(), 9);

    }

    @Test
    public void arrayImagenesBuscar() throws Exception {
        Domain.Files File = new Files();

        ArrayList<Imagenes> imagenesArrayListaa = new ArrayList<>();
        imagenesArrayListaa = File.ReadXml();

        assertTrue(imagenesArrayListaa.containsAll(imagenesArrayListaa));

    }

   

}
