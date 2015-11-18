/*******************************************************************
Assignment #4

Book.java By: Luis Saravia Patron ID # 6800505

Part 1:
A Book class is created according to the following specifications:
- Upon the creation of a book object, the object is immediately initialized with valid values;
  that is title, ISBN and price.
- The design allows enough flexibility so that the value of any of these attributes can be
  modified later on. 
- The design allows the user of the class to obtain the value of any of the attributes individually.
  It also allows the user to view all book information at once by passing book objects to 
  the print/println() methods;
- The design allows for one book to be compared to another book for equality. Two book objects are
  considered equal if they have the same ISBN # and the same price.
********************************************************************/
import java.text.DecimalFormat;

public class Book {
	//Attributes
	private String title;
	private long isbn;
	private double price;
	
	//Create an object of DecimalFormat Class in order to format ISBN when output is required
	DecimalFormat isbn9digits = new DecimalFormat("000000000");
 
	//Constructor with default values initializes the attributes of the vehicle at creation time 
	public Book(){
		System.out.println("Creating a book with default values ......\n"); 
		title = "New book";
		isbn = 0;	//ISBN is a 9- digit number. Format will be necessary when it has leading zeros. 
		price = 0.00;	//remember formatting price later 
	}
		
	//Accessors will allow the user of the class to obtain the value of any of the attributes individually.
	public String getTitle(){
		return title;
	}
	
	public long getIsbn(){
		return isbn;
	}
	
	public double getPrice(){
		return price;
	}
	
	//Mutators will allow allow enough flexibility so that the value of any of these attributes can be
	//modified later on
	public void setTitle(String newTitle){
		//Object will control the value of attribute price and will only allow changes within the declared range.
		if (newTitle.length()>=1 && newTitle.length()<=100)
			title = newTitle;
		else
			System.out.println("Invalid entry. Title length has to be from 1 to 100. No change will be made.");
	}
	
	public void setIsbn(long newIsbn){
		//Object will control the value of attribute price and will only allow changes within the declared range.
		if (newIsbn >= 0 && newIsbn < 1000000000)
			isbn = newIsbn;
		else
			System.out.println("Invalid entry. ISBN # go from 000000000 to 999999999. No change will be made.");
	}
	
	public void setPrice(double newPrice){
		//Object will control the value of attribute price and will only allow changes within the declared range.
		if (newPrice >= 0 && newPrice < 100000)
			price = newPrice;
		else 
			System.out.println("Invalid entry. Price has to be positive and less than 100000. No change " +
					"will be made.");
	}
	
	//Compare books method will allow for one book to be compared to another book for equality.
	//Two book objects are considered equal if they have the same ISBN # and the same price.
	public boolean equals(Book bk){
	return (isbn==bk.isbn && price==bk.price);
	}
		
	//Show book information method will allow the user to view all book information at once by passing book
	//objects to the print/println() methods.
	public void showInfo(){
		System.out.printf("The book title is: \"" + title + "\", the ISBN # is " + isbn9digits.format(isbn)
				+ " and the price is $%.2f%n", price);
	}
	
	//toString method defined in order to avoid using the language default toString method.
	public String toString(){
		return (title + "#" + isbn9digits.format(isbn) + "$" +price);
	}
}// End of Class Book

/*******************************************************************
Part 2:
 
A class called UtilizeBooks is created, which is going to utilize the book class made 
in part1. In the main method of this class, the following operations will be performed:

1) It will create three book objects; with a title, ISBN (9-digit number) and a price for each
   of these objects upon creation.
2) It will show all information of each of the three objects.
3) It will change the price of the first object; the price and the title of the second object,
and the ISBN value of the third object.
4) Displays the modified attributes of the three objects. All outputs showing the price of the
book are formatted.
5) Compares some of these book objects for equality and displays whether or not they are equal.
********************************************************************/

class UtilizeBooks{
	//Create three book objects
	public static void main(String[] args) {
		
		//Welcome message
		System.out.println("Assignment 4 - Books-  written by Luis Saravia Patron.");
		System.out.println();
		
		
		Book book1= new Book();
		Book book2= new Book();
		Book book3= new Book();
	
		//Show all information of each of the three objects
		book1.showInfo();
		book2.showInfo();
		book3.showInfo();
		System.out.println();
	
		//Change the price of the first object; the price and the title of the second object, and 
		//the ISBN value of the third object.
		book1.setPrice(2.50);
		book2.setPrice(2.5);
		book2.setTitle("How to change values");
		book3.setIsbn(777777777);
	
		//Display only the modified attributes of the three objects. All outputs showing the price
		//of the book must be formatted.
		System.out.printf("The price of b1 after modification is: $%.2f%n", book1.getPrice());
		System.out.printf("The title and price of b2 after modification are: " + book2.getTitle() + ", $%.2f%n", book2.getPrice());
		System.out.println("The ISBN # of b3 after modification is: " + book3.getIsbn());
		System.out.println();
	
		//Compare some of these book objects for equality and display whether or not they are equal.
		if (book1.equals(book2)==true)
			System.out.println("Book 1 is equal to book 2");
		else
			System.out.println("Book 1 and book 2 are not equal");

		if (book2.equals(book3)==true)
			System.out.println("Book 2 is equal to book 3");
		else
			System.out.println("Book 2 and book 3 are not equal");
	
		if (book3.equals(book1)==true)
			System.out.println("Book 3 is equal to book 1");
		else
			System.out.println("Book 3 and book 1 are not equal");
		
		
		//End of program message.
		System.out.println();
		System.out.println();
		System.out.println("End of program.");

	}	//End of main method
	
}	// End of UtilizeBooks class
		
	