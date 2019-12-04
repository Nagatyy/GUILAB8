import java.util.ArrayList;
import java.util.Random;

public class VisitorB implements Runnable {
    private Library lib;
    private ArrayList<String>  listOfBooks;

    public VisitorB(Library lib){
        this.lib = lib;
    }

    @Override
    public void run(){

        while (true) {
            listOfBooks = lib.getAvailableBooks(); // (a)
            // now we try to borrow
            String title = listOfBooks.get(new Random().nextInt(listOfBooks.size()));
            try {
                synchronized (lib) {
                    lib.borrowBook(title);
                    Thread.sleep(new Random().nextInt(5001));
                    lib.returnBook(title);
                    Thread.sleep(new Random().nextInt(401));
                }

            } catch (BookNotAvailableException bE) {
                bE.getLocalizedMessage();
                break; // to try again
            } catch (InterruptedException e){
                e.getLocalizedMessage();
            }

        }
    }


    public static void main(String[] args) {
        Library lib = new Library();
        for(int i = 0 ; i < 15; i++)
            lib.addBook("Book " + (i+1));

        for(int i = 0; i < 10; i++){
            Thread t = new Thread(new VisitorB(lib));
            t.start();
        }
    }
}
