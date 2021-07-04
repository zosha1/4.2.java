package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TicketManagerTest {
    private TicketManager manager = new TicketManager();
    private Ticket t1 = new Ticket(1, 1000, "MOW", "LED", 1);
    private Ticket t2 = new Ticket(2, 1200, "MOW", "LED", 3);
    private Ticket t3 = new Ticket(3, 1300, "MOW", "LED", 5);
    private Ticket t4 = new Ticket(4, 1400, "LED", "FRU", 8);
    private Ticket t5 = new Ticket(5, 1500, "MOW", "LED", 2);
    private Ticket t6 = new Ticket(6, 1600, "MOW", "LED", 4);
    private Ticket t7 = new Ticket(7, 1700, "MOW", "LED", 6);

    @BeforeEach
    public void setUp() {
        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        manager.add(t6);
        manager.add(t7);
    }

    @Test
    public void searchTicket() {
        Ticket[] actual = manager.findAll("MOW", "LED");
        Ticket[] expected = new Ticket[]{t1, t2, t3, t5, t6, t7};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void searchOneTicket() {
        Ticket[] actual = manager.findAll("LED", "FRU");
        Ticket[] expected = new Ticket[]{t4};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void searchNothingTicket() {
        Ticket[] actual = manager.findAll("LED", "KRR");
        Ticket[] expected = new Ticket[]{};
        assertArrayEquals(actual, expected);
    }
}
