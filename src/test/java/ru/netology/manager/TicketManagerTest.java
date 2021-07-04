package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.domain.TicketByPriceAscComparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TicketManagerTest {
    private TicketManager manager = new TicketManager();
    private Ticket t1 = new Ticket(1, 5000, "LED", "MOW", 2);
    private Ticket t2 = new Ticket(2, 2500, "MOW", "LED", 3);
    private Ticket t3 = new Ticket(3, 32000, "MOW", "FRU", 5);
    private Ticket t4 = new Ticket(4, 7200, "LED", "FRU", 8);
    private Ticket t5 = new Ticket(5, 1234, "LED", "MOW", 2);
    private Ticket t6 = new Ticket(6, 5050, "MOW", "LED", 4);
    private Ticket t7 = new Ticket(7, 9850, "FRU", "KUF", 3);

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
        Ticket[] actual = manager.findAll("MOW", "LED", new TicketByPriceAscComparator());
        Ticket[] expected = new Ticket[]{t2, t6};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void searchOneTicket() {
        Ticket[] actual = manager.findAll("LED", "FRU", new TicketByPriceAscComparator());
        Ticket[] expected = new Ticket[]{t4};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void searchNothingTicket() {
        Ticket[] actual = manager.findAll("LED", "KRR", new TicketByPriceAscComparator());
        Ticket[] expected = new Ticket[]{};
        assertArrayEquals(actual, expected);
    }
}
