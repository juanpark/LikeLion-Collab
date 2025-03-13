package com.sec11.myutil;

public class GenericsTest {

	public static void main(String[] args) {		

		MyClass<? extends A> m_c = new MyClass<C>(new C());		
		m_c.doTest();
		
		m_c = new MyClass<B>(new B());
		m_c.doTest();
		
		m_c = new MyClass<A>(new A());
		m_c.doTest();
		

		MyClass<? super C> m_T = new MyClass<A>(new A());		
		m_T.doTest();
		
	   m_T = new MyClass<C>(new C());		
	   m_T.doTest();
       
    }
}

class MyClass<T extends A>{     
   private T obj;
  
	public MyClass(T obj){
        this.obj = obj;
    }     
	
	public void  doTest(){
		 obj.my_print();
	}
}

class A{
	  public void my_print(){
        System.out.println("I am in super class A");
    }
}
 
class B extends A{
	  public void my_print(){
        System.out.println("I am in sub class B");
    }
}
 
class C extends A{
    public void my_print(){
        System.out.println("I am in sub class C");
    }
}
