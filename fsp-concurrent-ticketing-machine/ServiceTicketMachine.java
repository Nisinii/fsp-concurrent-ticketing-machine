// W. A. Nisini Niketha | w1809840 | 20191213

public interface ServiceTicketMachine {

    void printTicket(Ticket ticket);
    void refillTicketPaper();
    void replaceTonerCartridge();
    int getPaperLevel();
    int getTonerLevel();

}
