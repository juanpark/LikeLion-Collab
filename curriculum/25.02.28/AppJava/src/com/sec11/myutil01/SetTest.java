package com.sec11.myutil01;
import java.util.*;

public class SetTest {
	public static void main(String[] args) {
		
     HashSet<String>  m_set =new HashSet<String>();
     m_set.add("java");
     m_set.add("servlet/jsp");
     m_set.add("spring");
     m_set.add("python");    
     m_set.add("python");   
     System.out.println("HashSet : " + m_set);
     
     TreeSet<String>   t_set = new TreeSet<String>();
     t_set.add("java");
     t_set.add("servlet/jsp");
     t_set.add("spring");
     t_set.add("python");  
     t_set.add("python"); 
   
     System.out.println("\nTreeSet  :"+  t_set);
     
     LinkedHashSet <String>   lh_set = new LinkedHashSet <String>();
     lh_set.add("java");
     lh_set.add("servlet/jsp");
     lh_set.add("spring");
     lh_set.add("python");   
     lh_set.add("python");         
     System.out.println( "\nLinkedHashSet :"+  lh_set);
	}

}
