import java.util.*;
//Student Class

class Student{
  //Class Variables
  private String name;
  private double cgpa;
  private int token;

  //Constructor
  public Student(String name, double cgpa, int token){
    this.name = name;
    this.cgpa = cgpa;
    this.token = token;
  }

  //Getter Functions
  public String getName(){
    return this.name;
  }
  public double getCgpa(){
    return this.cgpa;
  }
  public int getToken(){
    return this.token;
  }
}

//Comparator Class
class StudentComparator implements Comparator<Student>{
  public int compare(Student s1, Student s2){
    if(s1.getCgpa() == s2.getCgpa()){
      //If cgpa is equal, comparison is made on names
      if(s1.getName().compareTo(s2.getName()) == 0){
        //If name's are also same, comparison is made on tokens
        return (s1.getToken() - s2.getToken());
      }else{
        //If names are different return their differences based on alphabatical order
        return (s1.getName().compareTo(s2.getName()));
      }
    }else{
      //Return difference if cgpa's are not equal
      return (Double.compare(s2.getCgpa(), s1.getCgpa()));
    }
  }
}

//Main Class
public class UpGrad{
  //Main function
  public static void main(String args[]){
    //Scanner for input
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    //Create priority queue with our custom comparator
    PriorityQueue<Student> pq = new PriorityQueue<>(n/2, new StudentComparator());
    for(int i=0; i<n; ++i){
      //Input the event
      String event = s.next();
      //Check if event matches "ENTER" or "SERVED"
      if(event.toUpperCase().equals("ENTER")){
        //Input Student Data
        String name = s.next();
        double cgpa = s.nextFloat();
        int token = s.nextInt();
        //Create Student Object
        Student st = new Student(name, cgpa, token);
        //Add Student to priority queue
        pq.add(st);
      }else if(event.toUpperCase().equals("SERVED")){
        //Remove the student at the top of prioity queue
        pq.poll();
      }
    }
    //Check if the priority queue is empty?
    if(pq.size() > 0){
      //Iterate through each element of priority queue
      Iterator iterator = pq.iterator();
      while(iterator.hasNext()){
        Student st = (Student)iterator.next();
        System.out.println(st.getName());
      }
    }else{
      System.out.println("EMPTY");
    }
  }
}
