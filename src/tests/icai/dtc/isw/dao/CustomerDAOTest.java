package tests.icai.dtc.isw.dao;

import icai.dtc.isw.dao.CustomerDAO;
import icai.dtc.isw.domain.Review;
import junit.framework.TestCase;
import icai.dtc.isw.domain.Movil;


import java.util.ArrayList;

public class CustomerDAOTest extends TestCase {

    public void tearDown() throws Exception {
    }

    public void testGetMoviles() {

        ArrayList<Movil> lista = new ArrayList<Movil>();
        ArrayList<String>listaTest = new ArrayList<String>();
        ArrayList<String> listaSol = new ArrayList<String>();

        Movil movil1 = new Movil("4", "Xiaomi","350","Mi9T","128","6");
        Movil movil2 = new Movil("8", "Xiaomi","200","RedmiNote10","128","4");

        listaSol.add(movil1.getDatos());
        listaSol.add(movil2.getDatos());

        CustomerDAO.getMoviles(lista, "marca", "375","modelo","almacenamiento","memoria");
        listaTest.add(lista.get(0).getDatos());
        listaTest.add(lista.get(1).getDatos());

        assertEquals(listaSol.get(1),listaTest.get(0));
        assertEquals(listaSol.get(0),listaTest.get(1));
    }

    public void testVerReviews() {

        Review reviewSol = new Review("9","8","claudio","Muy buen movil calidad precio","8");

        ArrayList<Review> reviewLista = CustomerDAO.verReviews("8");

        assertEquals(reviewSol.getDatos(),reviewLista.get(0).getDatos());


    }
}