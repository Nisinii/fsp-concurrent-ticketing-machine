// W. A. Nisini Niketha | w1809840 | 20191213

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TicketMachine implements ServiceTicketMachine {

    // ReentrantLock to synchronize threads
    private final ReentrantLock w1809840_reentrantLock = new ReentrantLock();

    // Conditions to coordinate and communicate between threads
    private final Condition w1809840_haveToner = w1809840_reentrantLock.newCondition();
    private final Condition w1809840_havePaper = w1809840_reentrantLock.newCondition();
    private final Condition w1809840_notEnoughResources = w1809840_reentrantLock.newCondition();

    private int w1809840_paperLevel;
    private int w1809840_tonerLevel;

    public TicketMachine(int w1809840_paperLevel, int w1809840_tonerLevel) {
        this.w1809840_paperLevel = w1809840_paperLevel;
        this.w1809840_tonerLevel = w1809840_tonerLevel;
    }

    // Overriding the printTicket() method from ServiceTicketMachine interface
    @Override
    public void printTicket(Ticket ticket) {
        try {
            w1809840_reentrantLock.lock();

            // Checking if the paper and toner levels are enough to print out a ticket
            while (w1809840_paperLevel < Constants.MINIMUM_PAPER_LEVEL || w1809840_tonerLevel < Constants.MINIMUM_TONER_LEVEL) {
                System.out.println("* Either paper or toner is not available to print out a ticket.");
                w1809840_notEnoughResources.await();
            }

            w1809840_paperLevel -= 1;
            w1809840_tonerLevel -= 1;

            System.out.println("\nThe Passenger " + Thread.currentThread().getName() + " purchased the following ticket.\n" + ticket.toString() + "\n");

            w1809840_havePaper.signalAll();
            w1809840_haveToner.signalAll();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            w1809840_reentrantLock.unlock();
        }
    }


    // Overriding the refillTicketPaper() method from ServiceTicketMachine interface
    @Override
    public void refillTicketPaper() {
        try {
            w1809840_reentrantLock.lock();

            // Checking if the paper level when added with the amount of paper to be refilled each time is more than the maximum paper level
            while (w1809840_paperLevel + Constants.PAPER_SHEETS_REFILL > Constants.MAXIMUM_PAPER_LEVEL) {
                System.out.println("* The Ticket Machine has enough paper.");
                w1809840_havePaper.await();
            }

            w1809840_paperLevel += Constants.PAPER_SHEETS_REFILL;
            System.out.println("* " + Thread.currentThread().getName() + " refilled the Paper sheets.");

            w1809840_notEnoughResources.signalAll();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            w1809840_reentrantLock.unlock();
        }
    }


    // Overriding the replaceTonerCartridge() method from ServiceTicketMachine interface
    @Override
    public void replaceTonerCartridge() {
        try {

            w1809840_reentrantLock.lock();

            // Checking if the toner level is greater than the minimum toner level
            while (w1809840_tonerLevel >= Constants.MINIMUM_TONER_LEVEL) {
                System.out.println("* The Ticket Machine has enough toner.");
                w1809840_haveToner.await();
            }

            w1809840_tonerLevel = Constants.MAXIMUM_TONER_LEVEL;
            System.out.println("* " + Thread.currentThread().getName() + " refilled the Toner Cartridge.");

            w1809840_notEnoughResources.signalAll();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            w1809840_reentrantLock.unlock();
        }
    }

    // Overriding the getPaperLevel() method from ServiceTicketMachine interface
    @Override
    public int getPaperLevel() {
        return w1809840_paperLevel;
    }


    // Overriding the getTonerLevel() method from ServiceTicketMachine interface
    @Override
    public int getTonerLevel() {
        return w1809840_tonerLevel;
    }
}
