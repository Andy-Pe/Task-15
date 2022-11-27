package ru.netology;

import java.util.Comparator;

public class TicketByTimeAscComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket otherTicket1, Ticket otherTicket2) {
        if (otherTicket1.getTravelTime() < otherTicket2.getTravelTime()) {
            return -1;
        }
        if (otherTicket1.getTravelTime() > otherTicket2.getTravelTime()) {
            return 1;
        }
        return 0;
    }
}
