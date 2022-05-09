import org.junit.Test;

import static org.junit.Assert.*;

public class FailingTest {
    @Test
    public void test1() {
        HotelReservation Hotel = new HotelReservation();
        assertEquals("Lakewood", Hotel.getCheapestHotel("Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)"));
    }

    @Test
    public void test2() {
        HotelReservation Hotel = new HotelReservation();
        assertEquals("Bridgewood", Hotel.getCheapestHotel("Regular: 20Mar2009(fri), 21Mar2009(sat), 22Mar2009(sun)"));
    }

    @Test
    public void test3() {
        HotelReservation Hotel = new HotelReservation();
        assertEquals("Ridgewood", Hotel.getCheapestHotel("Rewards: 26Mar2009(thur), 27Mar2009(fri), 28Mar2009(sat)"));
    }

    @Test
    public void verificarLakewoodFunfando() {
       HotelReservation hotel = new HotelReservation();
       assertEquals("Lakewood", hotel.verificarMaisBaratoECustoBeneficio(30,50,34));
    }

    @Test
    public void verificarBridgewoodFunfando() {
        HotelReservation hotel = new HotelReservation();
        assertEquals("Bridgewood", hotel.verificarMaisBaratoECustoBeneficio(300,50,55));
    }

    @Test
    public void verificarRidgewoodFunfando() {
        HotelReservation hotel = new HotelReservation();
        assertEquals("Ridgewood", hotel.verificarMaisBaratoECustoBeneficio(30,50,20));
    }

    @Test
    public void verificarSeEstaTirandoOsEspacosECortandoAsSubString(){
        HotelReservation hotel = new HotelReservation();
        assertEquals("fri", hotel.recortarDia("  20Mar2009(fri)    "));
    }
}
