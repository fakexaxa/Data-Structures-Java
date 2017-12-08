import java.util.ArrayList;
import java.util.*;
import java.io.*;

// A complete working Java program to demonstrate all
 
// Class for Doubly Linked List
public class Search 
{
    Node head; // head of list
    static ArrayList<Arts> Records = new ArrayList<Arts>();
    static ArrayList<Artist> artist = new ArrayList<Artist>();
    static Arts artRecord;
    static Artist artistRecord;
    static Node arts;
     
    /* Doubly Linked list Node*/
    class Node
    {
        int data;
        String artName;
        int id;
        int value;
        Node prev;
        Node next;
         
         
        // Constructor to create a new node
        // next and prev is by default initialized as null
        Node(int data, String artName, int id, int value)
        {
        	this.data=data;
        	this.artName=artName;
        	this.id=id;
        	this.value=value;
        } 
      
    }
 
    //Adding a node at the front of the list
    public void push(int data, String artistName, int id, int value)
    {
        /* 1. allocate node 
        * 2. put in the data */
        Node new_Node = new Node(data, artistName, id, value);
         
        /* 3. Make next of new node as head and previous as NULL */
        new_Node.next = head;
        new_Node.prev = null;
         
        /* 4. change prev of head node to new node */
        if(head != null)
            head.prev = new_Node;
 
        /* 5. move the head to point to the new node */
        head = new_Node; 
    }
 
    /* Given a node as prev_node, insert a new node after the given node */
     void reset() {
        head = null;
    }
     
    //Add a node at the end of the list
    void append(int data, String artistName, int id, int value)
    {
        /* 1. allocate node 
        * 2. put in the data */
        Node new_node = new Node( data,  artistName,  id,  value);
         
        Node last = head;/* used in step 5*/
         
        /* 3. This new node is going to be the last node, so
        * make next of it as NULL*/
        new_node.next = null;
         
        /* 4. If the Linked List is empty, then make the new
        * node as head */
        if(head == null)
        {
            new_node.prev = null;
            head = new_node;
            return;
        }
         
        /* 5. Else traverse till the last node */
        while(last.next != null)
            last = last.next;
         
        /* 6. Change the next of last node */
        last.next = new_node;
         
        /* 7. Make last node as previous of new node */
        new_node.prev = last;
    }
     
    // This function prints contents of linked list starting from the given node
    public void printlist(Node node)
    {
    	
        
        
        
        
            System.out.println(node.data + "\t "+node.artName+"\t "+node.value);
            
            node = node.next;
        
        
        
    }
     
    /* Drier program to test above functions*/
    public static void main(String[] args) 
    {
        /* Start with the empty list */
       
         
        // Insert 1 at the beginning. So linked list becomes 1->7->6->NULL
        //dll.push(1);
         
        // Insert 4 at the end. So linked list becomes 1->7->6->4->NULL
       //dll.append(4);
         
        // Insert 8, after 7. So linked list becomes 1->7->8->6->4->NULL
        //dll.InsertAfter(dll.head.next, 8);
         
         
      //  System.out.println("Created DLL is: ");
       // dll.printlist(dll.head);
        String file= "Exam4Arts.txt";
        String file2= "Exam4Artist.txt";
        readFile(file, file2);
    }
    public static void readFile(String file,String file2)
    {
    	Search arts= new Search();
    	
    	try
    	{
    		File inputFile = new File(file);
    		Scanner x = new Scanner(inputFile);
    		File inputFile2= new File(file2);
    		Scanner z= new Scanner(inputFile2);
    		x.useDelimiter("\t|\r\n");
    		
    		while(x.hasNext())
    		{
    			int art_id=x.nextInt();
    			String title= x.next();
    			int id2=x.nextInt();
    			int apvalue=x.nextInt();
    			
    			artRecord= new Arts(art_id, title, id2, apvalue);
    			Records.add(artRecord);
    				
    		}
    		while(z.hasNext())
    		{
    			int id= z.nextInt();
    			String name= z.nextLine();
    			
    			artistRecord= new Artist(id, name);
    			artist.add(artistRecord);
    			
    		}
    		int counter=0;
    		while(counter<4)
    		{
    		Scanner input= new Scanner(System.in);
			System.out.println("\nPlease Enter the ID number\n");
			int inputID= input.nextInt();
			
    		for(int i=0;i<Records.size();i++)
			{
    			
    			
				if(inputID==Records.get(i).getId())
				{
					System.out.print(artist.get(inputID-1).getID()+"\t"+artist.get(inputID-1).getName()+"\t");
					arts.append(Records.get(i).getArt_id(), Records.get(i).getTitle(), Records.get(i).getArt_id(), Records.get(i).getApvalue());
					arts.printlist(arts.head);
					arts.reset();
				}
			}
    		counter++;
    		}
    		z.close();
    		x.close();
    		
    		  
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    public static int binarySearch(int[] a, int target) {
	    return binarySearch(a, 0, a.length-1, target);
	}

	public static int binarySearch(int[] a, int start, int end, int target) 
	{
	    int middle = (start + end) / 2;
	    if(end < start) {
	        return -1;
	    } 

	    if(target==a[middle]) {
	        return middle;
	    } else if(target<a[middle]) {
	        return binarySearch(a, start, middle - 1, target);
	    } else {
	        return binarySearch(a, middle + 1, end, target);
	    }
	}
}
 