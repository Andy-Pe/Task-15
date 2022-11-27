package ru.netology;

public class TicketManager {
    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.save(ticket);
    }

    public Ticket[] getTickets() {
        Ticket[] all = repo.getTickets();
        Ticket[] reversed = new Ticket[all.length];
        for (int i = 0; i < reversed.length; i++) {
            reversed[i] = all[all.length - 1 - i];
        }
        return reversed;
    }


//    public Ticket[] findAll(String from, String to) {
//        Ticket[] airport = new Ticket[getTickets().length];
//        for (int i = 0; i < getTickets().length; i++) {
//            airport[i] = ;
//        }
//        return airport;
//    }


    public boolean matches(Ticket ticket, String departureAirport, String arrivalAirport) {
        if (ticket.getDepartureAirport().contains(departureAirport)) {
            return true;
        } else if (ticket.getArrivalAirport().contains(arrivalAirport)) {
            return true;
        } else {
            return false;
        }
    }

    public Ticket[] findAll(String departureAirport, String arrivalAirport) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.getTickets()) {
            if (matches(ticket, departureAirport, arrivalAirport)) {
                result = repo.getTickets();
            }
        }
        return result;
    }
}
