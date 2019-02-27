package bt;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;


public class bt {
    public static void main(String args[]) {
     
    	 String exp = "(100-200)*400-100"; 
         String string =infixToPostfix(exp);
         System.out.println(string);
         System.out.println("postfix evaluation: "+evaluatePostfix(string)); 
         Queue<String> q = bt2.infixToPostfix(exp);
         
         
     
    
     System.out.println("postfix evaluation: "+bt2.evaluatePostfix(q));
         
   
         
         
       
       
       
      
       
    }
    
  
   

     // A utility function to return precedence of a given operator 
     // Higher returned value means higher precedence 
     static int Prec(char ch) 
     { 
         switch (ch) 
         { 
         case '+': 
         case '-': 
             return 1; 
        
         case '*': 
         case '/': 
             return 2; 
        
         case '^': 
             return 3; 
         } 
         return -1; 
     } 
        
     // The main method that converts given infix expression 
     // to postfix expression.  
     static String infixToPostfix(String exp) 
     { 
         // initializing empty String for result 
         String result = new String(""); 
           
         // initializing empty stack 
         Stack<Character> stack = new Stack<Character>(); 
           
         for (int i = 0; i<exp.length(); ++i) 
         { 
             char c = exp.charAt(i); 
               
              // If the scanned character is an operand, add it to output. 
             if (Character.isLetterOrDigit(c)) 
                 result += c; 
                
             // If the scanned character is an '(', push it to the stack. 
             else if (c == '(') 
                 stack.push(c); 
               
             //  If the scanned character is an ')', pop and output from the stack  
             // until an '(' is encountered. 
             else if (c == ')') 
             { 
                 while (!stack.isEmpty() && stack.peek() != '(') 
                     result += stack.pop(); 
                   
                 if (!stack.isEmpty() && stack.peek() != '(') 
                     return "Invalid Expression"; // invalid expression                 
                 else
                     stack.pop(); 
             } 
             else // an operator is encountered 
             { 
                 while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) 
                     result += stack.pop(); 
                 stack.push(c); 
             } 
        
         } 
        
         // pop all the operators from the stack 
         while (!stack.isEmpty()) 
             result += stack.pop(); 
        
         return result; 
     } 
     
     // Method to evaluate value of a postfix expression 
     static int evaluatePostfix(String exp) 
     { 
         //create a stack 
         Stack<Integer> stack=new Stack(); 
           
         // Scan all characters one by one 
         for(int i=0;i<exp.length();i++) 
         { 
             char c=exp.charAt(i); 
               
             // If the scanned character is an operand (number here), 
             // push it to the stack. 
             if(Character.isDigit(c)) 
             stack.push(c - '0'); 
               
             //  If the scanned character is an operator, pop two 
             // elements from stack apply the operator 
             else
             { 
                 int val1 = stack.pop(); 
                 int val2 = stack.pop(); 
                   
                 switch(c) 
                 { 
                     case '+': 
                     stack.push(val2+val1); 
                     break; 
                       
                     case '-': 
                     stack.push(val2- val1); 
                     break; 
                       
                     case '/': 
                     stack.push(val2/val1); 
                     break; 
                       
                     case '*': 
                     stack.push(val2*val1); 
                     break; 
               } 
             } 
         } 
         return stack.pop();     
     } 
}
class bt2 {

    // A utility function to return precedence of a given operator 
    // Higher returned value means higher precedence 
    static int Prec(char ch) 
    { 
        switch (ch) 
        { 
        case '+': 
        case '-': 
            return 1; 
       
        case '*': 
        case '/': 
            return 2; 
       
        case '^': 
            return 3; 
        } 
        return -1; 
    } 
       
    // The main method that converts given infix expression 
    // to postfix expression.  
    static Queue<String> infixToPostfix(String exp) 
    { 
        // initializing empty String for result 
        String result = ""; 
         
        Queue<String> q = new LinkedList<String>();
        // initializing empty stack 
        Stack<Character> stack = new Stack<Character>(); 
    
          
        for (int i = 0; i<exp.length(); ++i) 
        { 
            char c = exp.charAt(i); 
              
             // If the scanned character is an operand, add it to output. 
            if (Character.isLetterOrDigit(c)) 
                result += c; 
               
            // If the scanned character is an '(', push it to the stack. 
            else if (c == '(') 
                stack.push(c); 
              
            //  If the scanned character is an ')', pop and output from the stack  
            // until an '(' is encountered. 
            else if (c == ')') 
            { 
            	if(result!="")
                	q.add(result);
            		result ="";
                while (!stack.isEmpty() && stack.peek() != '(')
                	
                	{
                	
                    q.add(String.valueOf(stack.pop())); 
                	}
                  
                if (!stack.isEmpty() && stack.peek() != '(') 
                	throw new RuntimeException();// invalid expression                 
                else
                    stack.pop(); 
            } 
            else // an operator is encountered 
            { 
            	q.add(result);
            	result ="";
            	
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek()))
                	q.add(String.valueOf(stack.pop()));
              
                stack.push(c); 
            } 
       
        } 
        if(result!="") {
        	q.add(result);
        }
        // pop all the operators from the stack 
        while (!stack.isEmpty()) 
            q.add(String.valueOf(stack.pop())); 
       
        return q; 
    } 
    
    // Method to evaluate value of a postfix expression 
    static int evaluatePostfix(Queue<String> q) 
    { 
        //create a stack 
        Stack<Integer> stack=new Stack(); 
        int n =q.size()-1;
        for(int i=0;i<(q.size()+n);++i) 
        { 
            String c =q.poll(); 
              
            // If the scanned character is an operand (number here), 
            // push it to the stack. 
            if(isNumeric(c))
            {
            int number = Integer.parseInt(c);
            stack.push(number);
            System.out.println(stack.peek());
         
    
            } 
            //  If the scanned character is an operator, pop two 
            // elements from stack apply the operator 
            else
            { 
            	int val1 = stack.pop();
            	int val2 = stack.pop();
                
               
            	
                switch(c) 
                { 
                  case "+": 
                  stack.push(val2+val1); 
                  break; 
                    
                   case "-": 
                   stack.push(val2-val1); 
                   break; 
                     
                   case "/": 
                    stack.push(val2/val1); 
                    break; 
                      
                    case "*": 
                    stack.push(val2*val1); 
                   break; 
              } 
            } 
        } 
        return stack.pop();     
    } 
    static boolean isNumeric(String str)
    {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
	
}
