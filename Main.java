import java.io.*;
import java.util.Scanner;
/**
 * InfiniteAdder.java
 * This class reads in two files containing digits that make up integers and puts them in a doublylinked list, 
 * then cycles through each list and multiplies by their respective 10's place, then places them in a third linked list, w
 * here carrying (if necessary) is taken place and then is printed out to the console.
 * @author Nikhail Mann
 */
public class Main {
  public static void main(String[] args) throws Exception {
    Scanner scan;
    scan = new Scanner(new BufferedReader(new FileReader("num1.txt")));
    Scanner scan2;
    scan2 = new Scanner(new BufferedReader(new FileReader("num2.txt")));

    Digit head = new Digit();
    Digit curr = head;
    Digit old = curr;
    while (scan.hasNext()) {
      curr.value = scan.nextInt();
      if (scan.hasNext()) {
        curr.next = new Digit();
        old = curr;
        curr = curr.next;
        curr.prev = old;
      }
    }

    Digit head2 = new Digit();
    Digit curr2 = head2;
    Digit old2 = curr2;
    while (scan2.hasNext()) {
      curr2.value = scan2.nextInt();
      if (scan2.hasNext()) {
        curr2.next = new Digit();
        old2 = curr2;
        curr2 = curr2.next;
        curr2.prev = old2;
      }
    }

    Digit head3 = new Digit();
    Digit curr3 = head3;
    Digit old3 = curr3;

    while (curr != null || curr2 != null) {
      int valueHolder1 = 0; 
      int valueHolder2 = 0;
      if (curr != null) {
        valueHolder1 = curr.value;
      }
      if (curr2 != null) {
        valueHolder2 = curr2.value;
      }
      int added_sum = valueHolder1 + valueHolder2;
      if (old2 != null || old != null){
        curr3.next = new Digit();
        old3 = curr3;
        curr3 = curr3.next;
        curr3.prev = old3;
      }
      if (added_sum >= 10) {
        added_sum -= 10;
        old3.value += added_sum;
        curr3.value = 1;
      } else {
        old3.value += added_sum;
      }
      if (curr.prev == null && curr2.prev != null) {
        curr2 = curr2.prev;
        curr.value = 0;
      } else if (curr2.prev == null && curr.prev != null) {
        curr = curr.prev;
        curr2.value = 0;
      } else if (curr2.prev == null && curr.prev == null) {
        break;
        } else {
        curr = curr.prev;
        curr2 = curr2.prev;
      }
    }
    if (curr3.value == 0) {
      curr3 = curr3.prev;
      while(curr3 != null) {
      System.out.print(curr3.value);
      curr3 = curr3.prev;
    }
    } else {
    while(curr3 != null) {
      System.out.print(curr3.value);
      curr3 = curr3.prev;
    }
    }
    }
  
}