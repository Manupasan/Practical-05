import scala.collection.mutable.ListBuffer
import scala.collection.mutable,mutable.Set
case class Book(title: String, author: String, isbn: String)

@main def main() =
  var lastList = getProductList()

  printProductList(lastList)

  println("============  Total number of products  ============\n" + getTotalProducts(lastList))


  var book1 = Book("Ben10", "Steave Smith", "221051")
  var book2 = Book("Spider-Man", "James Carl", "245789")
  var book3 = Book("Fast Five", "Christ Morgan", "123456")
  var book4 = Book("CR7", "Steave Smith", "721324")
  var book5 = Book("Hero80", "Steave Smith", "467125")
  var bookSet :Set[Book] = Set(book1, book2, book3, book4, book5)
  addNewBook(bookSet)
  removeBook(bookSet)
  alreadyExistsBook(bookSet)
  displayBook(bookSet)
  displayWithTitle(bookSet)
  displayWithAuthor(bookSet)

  println("============  To Print Fist Fibonacci Numbers  ============")
  println("Enter a number : ")
  var n: Int = scala.io.StdIn.readInt()
  var i = 0
  var j = 1
  fibonacciSequence(i, j, n)

def getProductList() =
  var product = scala.io.StdIn.readLine("============  Enter inventory names (type 'done' to stop)  ============ \n")
  val productList = ListBuffer.empty[String]
  while (product != "done")
    productList += product
    product = scala.io.StdIn.readLine()
  productList

def printProductList(func : ListBuffer[String]) : Unit =
  println("============  Inventory List  ============")
  for(i <- 0 to (func.length-1))
    println(i+1 + ". " + func(i))

def getTotalProducts(func : ListBuffer[String]) : Int =
  var total = func.length
  total

def addNewBook(set : Set[Book]) : Unit =
  println("============  Add a New Book  ============")
  val title = scala.io.StdIn.readLine("Title : ")
  val author = scala.io.StdIn.readLine("Author : ")
  val isbn = scala.io.StdIn.readLine("ISBN : ")

  val newbook = Book(title, author, isbn)
  set += newbook

def removeBook(set : Set[Book]) : Unit =
  println("============  Remove a Book  ============")
  println("Enter ISBN of the book to remove : ")
  val remove = scala.io.StdIn.readLine()
  val remBook = set.find(_.isbn == remove)
  remBook match
    case Some(book) => set -= book
    case None => println("No book found with this ISBN in the library")

def alreadyExistsBook(set : Set[Book]) : Unit =
  println("============  To Find Already Exists Books  ============")
  println("Enter ISBN of the book")
  val book = scala.io.StdIn.readLine()
  val checkBook = set.find(_.isbn == book)
  checkBook match
    case Some(book) => println("This Book is already in the library")
    case None => println("No book found with this ISBN in the library")

def displayBook(set : Set[Book]) : Unit =
  println("============  Display All the Books in the Library  ============")
  set.foreach(book => println(s"Title : ${book.title} | Author : ${book.author} | ISBN : ${book.isbn}"))

def displayWithTitle(set : Set[Book]) : Unit =
  println("============  Search a Book by Title  ============")
  val booktitle = scala.io.StdIn.readLine("Enter book title : ")
  val checktitle = set.find(_.title == booktitle)
  checktitle match
    case Some(booktitle) => println(s"Title : ${booktitle.title} | Author : ${booktitle.author} | ISBN : ${booktitle.isbn}")
    case None => println("No book found with this title in the library")

def displayWithAuthor(set : Set[Book]) : Unit =
  println("============  Display All Books by a Specific Author  ============")
  val bookauthor = scala.io.StdIn.readLine("Enter author name : ")
  val checkauthor = set.filter(_.author == bookauthor)
  if (bookauthor.isEmpty)
    println(s"No books found by author: $bookauthor")
  else
    checkauthor.foreach(book => println(s"${book.title}"))

def fibonacciSequence(i : Int, j : Int, n : Int) : Unit =
  if (n > 0)
    print(s"$i  ")
    fibonacciSequence(j, i+j, n-1)





    