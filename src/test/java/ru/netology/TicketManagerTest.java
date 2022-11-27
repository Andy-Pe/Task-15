package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);
    TicketByTimeAscComparator comparator = new TicketByTimeAscComparator();


    Ticket ticket1 = new Ticket(1, 2700, "MSK", "SPB", 360);
    Ticket ticket2 = new Ticket(2, 1200, "BLG", "UFA", 210);
    Ticket ticket3 = new Ticket(3, 4300, "MSK", "SPB", 470);
    Ticket ticket4 = new Ticket(4, 1600, "MSK", "UFA", 530);
    Ticket ticket5 = new Ticket(5, 1250, "STV", "MNK", 370);
    Ticket ticket6 = new Ticket(6, 2850, "MSK", "SPB", 380);
    Ticket ticket7 = new Ticket(7, 3260, "MSK", "UFA", 470);
    Ticket ticket8 = new Ticket(8, 4850, "MSK", "SPB", 580);
    Ticket ticket9 = new Ticket(9, 1950, "BLG", "SPB", 510);
    Ticket ticket10 = new Ticket(10, 2230, "MSK", "SPB", 530);


    @BeforeEach
    public void setup() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);
        repo.save(ticket7);
        repo.save(ticket8);
        repo.save(ticket9);
        repo.save(ticket10);

    }

    @Test
    public void shouldFindAllCoincidences() {

        Ticket[] expected = {ticket1, ticket6, ticket3, ticket10, ticket8};
        Ticket[] actual = manager.findAll("MSK", "SPB", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneCoincidence() {

        Ticket[] expected = {ticket2};
        Ticket[] actual = manager.findAll("BLG", "UFA", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNotingCoincidence() {

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("LON", "MBN", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}