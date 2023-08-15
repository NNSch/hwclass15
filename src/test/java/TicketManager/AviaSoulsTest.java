package TicketManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    @Test
    public void TestCompareToTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "RND", 2_000, 12, 14);
        Ticket ticket2 = new Ticket("MSK", "SOCHI", 10_000, 20, 22);
        Ticket ticket3 = new Ticket("MSK", "RND", 6_000, 9, 11);
        Ticket ticket4 = new Ticket("MSK", "RND", 2_000, 10, 12);
        Ticket ticket5 = new Ticket("MSK", "SBP", 4_000, 12, 14);
        Ticket ticket6 = new Ticket("MSK", "RND", 1_500, 0, 2);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = manager.search("MSK", "RND");
        Ticket[] expected = {ticket6, ticket1, ticket4, ticket3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestCompareToZeroTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "RND", 2_000, 12, 14);
        Ticket ticket2 = new Ticket("MSK", "RND", 10_000, 20, 22);
        Ticket ticket3 = new Ticket("MSK", "RND", 6_000, 9, 11);
        Ticket ticket4 = new Ticket("MSK", "RND", 2_000, 10, 12);
        Ticket ticket5 = new Ticket("MSK", "RND", 4_000, 12, 14);
        Ticket ticket6 = new Ticket("MSK", "RND", 1_500, 0, 2);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = manager.search("MSK", "SOCHI");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestCompareToOneTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "RND", 2_000, 12, 14);
        Ticket ticket2 = new Ticket("MSK", "SOCHI", 10_000, 20, 22);
        Ticket ticket3 = new Ticket("MSK", "RND", 6_000, 9, 11);
        Ticket ticket4 = new Ticket("MSK", "RND", 2_000, 10, 12);
        Ticket ticket5 = new Ticket("MSK", "SBP", 4_000, 12, 14);
        Ticket ticket6 = new Ticket("MSK", "RND", 1_500, 0, 2);
        Ticket ticket7 = new Ticket("MSK", "SBP", 5_000, 13, 15);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.search("MSK", "SOCHI");
        Ticket[] expected = {ticket2};

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void TestComparatorTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "RND", 2_000, 12, 14);
        Ticket ticket2 = new Ticket("MSK", "SOCHI", 10_000, 20, 22);
        Ticket ticket3 = new Ticket("MSK", "RND", 6_000, 9, 14);
        Ticket ticket4 = new Ticket("MSK", "RND", 2_000, 10, 13);
        Ticket ticket5 = new Ticket("MSK", "SBP", 4_000, 12, 14);
        Ticket ticket6 = new Ticket("MSK", "RND", 1_500, 0, 3);
        Ticket ticket7 = new Ticket("MSK", "SBP", 5_000, 13, 15);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("MSK", "RND", comparator);
        Ticket[] expected = {ticket1, ticket4, ticket6, ticket3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestComparatorOneTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "RND", 2_000, 12, 14);
        Ticket ticket2 = new Ticket("MSK", "SOCHI", 10_000, 20, 22);
        Ticket ticket3 = new Ticket("MSK", "RND", 6_000, 9, 11);
        Ticket ticket4 = new Ticket("MSK", "RND", 2_000, 10, 12);
        Ticket ticket5 = new Ticket("MSK", "SBP", 4_000, 12, 14);
        Ticket ticket6 = new Ticket("MSK", "RND", 1_500, 0, 2);
        Ticket ticket7 = new Ticket("MSK", "SBP", 5_000, 13, 15);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("MSK", "SOCHI", comparator);
        Ticket[] expected = {ticket2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestComparatorZeroTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "RND", 2_000, 12, 14);
        Ticket ticket2 = new Ticket("MSK", "SOCHI", 10_000, 20, 22);
        Ticket ticket3 = new Ticket("MSK", "RND", 6_000, 9, 11);
        Ticket ticket4 = new Ticket("MSK", "RND", 2_000, 10, 12);
        Ticket ticket5 = new Ticket("MSK", "SBP", 4_000, 12, 14);
        Ticket ticket6 = new Ticket("MSK", "RND", 1_500, 0, 2);
        Ticket ticket7 = new Ticket("MSK", "SBP", 5_000, 13, 15);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("RND", "SOCHI", comparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
}
