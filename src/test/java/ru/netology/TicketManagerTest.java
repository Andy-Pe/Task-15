package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);
    TicketPriceComparator priceComparator = new TicketPriceComparator();

    Ticket ticket1 = new Ticket(45, 2700, "VKO", "SVO", 360);
    Ticket ticket2 = new Ticket(6, 1200, "SVO", "DME", 210);
    Ticket ticket3 = new Ticket(21, 4300, "DME", "VKO", 470);
    Ticket ticket4 = new Ticket(16, 1600, "VKO", "VKO", 530);
    Ticket ticket5 = new Ticket(7, 2450, "DME", "DME", 370);


    @BeforeEach
    public void setup() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
    }

    @Test
    public void shouldFindAllCoincidences() {

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = manager.findAll("VKO", "SVO");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortByPrice() {

        Ticket[] tickets = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Arrays.sort(tickets, priceComparator);
    }
}