package net.velion.arena.team;

public class TeamTickets {
    private final int tickets;
    private int ticketsUsed;

    public TeamTickets(int tickets) {
        this.tickets = tickets;
    }

    public boolean useTicket() {
        if (getRemainingTickets() > 0) {
            ticketsUsed++;
            return true;
        }
        return false;
    }

    public int getTickets() {
        return tickets;
    }

    public int getTicketsUsed() {
        return ticketsUsed;
    }

    public int getRemainingTickets() {
        return tickets - ticketsUsed;
    }
}
