import java.util.ArrayList;

public class Library {
    private ArrayList<String> listOfBooks;

    Library(){
        listOfBooks = new ArrayList<>();
    }

    public void borrowBook(String title) throws BookNotAvailableException{
        // first check if found
        if(listOfBooks.contains(title)) {
            // if available then remove from list
            listOfBooks.remove(title);
            System.out.println(title + " is being borrowed");
        }
        else   // if not available then throw BookNotAvailableException
            throw new BookNotAvailableException();
    }

    public void returnBook(String title){
        // adds title to list
        listOfBooks.add(title);
        System.out.println(title + " has been returned");
    }

    public ArrayList<String> getAvailableBooks(){
        // because ArrayList does not have a clone method, we must manually clone
        ArrayList<String> returned = new ArrayList<>();
        for (int i = 0; i < listOfBooks.size(); i++)
            returned.add(listOfBooks.get(i));
        return returned;
    }

    public void addBook(String title){ // used in adding books in main
        listOfBooks.add(title);
    }


}

class BookNotAvailableException extends Exception{

    @Override
    public String getLocalizedMessage(){
        return "Book is not available...";
    }
}
