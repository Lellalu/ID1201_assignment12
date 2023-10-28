package se.kth.id1201;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class HashMapTest 
{
    @Test
    public void containsKeyTest()
    {
        HashMap hm = new HashMap(3);
        hm.put("Stockholm", new City("Stockholm"));
        hm.put("Göteborg", new City("Göteborg"));
        hm.put("Göteborg", new City("Göteborg"));
        hm.put("Göteborg", new City("Göteborg"));
        hm.put("Malmö", new City("Malmö"));
        assertTrue(hm.containsKey("Stockholm"));
        assertTrue(hm.containsKey("Göteborg"));
        assertTrue(hm.containsKey("Malmö"));
        assertFalse(hm.containsKey("Lund"));
    }

    @Test
    public void getTest()
    {
        HashMap hm = new HashMap(3);
        hm.put("Stockholm", new City("Stockholm"));
        hm.put("Göteborg", new City("Göteborg"));
        hm.put("Göteborg", new City("Göteborg"));
        hm.put("Göteborg", new City("Göteborg"));
        hm.put("Malmö", new City("Malmö"));
        assertEquals(hm.get("Stockholm").name, "Stockholm");
        assertEquals(hm.get("Göteborg").name, "Göteborg");
    }
}
