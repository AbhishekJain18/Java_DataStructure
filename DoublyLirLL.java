import java.lang.*;
import java.io.*;

class DoublyLirLL
{
    public static void main(String a[])
    {
        DoublyXLirLL obj = new DoublyXLirLL();

        obj.InsertFirst(51);
        obj.InsertFirst(21);
        obj.InsertFirst(11);

        obj.InsertLast(101);
        obj.InsertLast(111);
        obj.Display();
        System.out.println("Number of elements are : "+obj.CountNode());

        obj.InsertAtPos(55,4);
        obj.Display();
        obj.DeleteAtPos(4);
        obj.Display();

        System.out.println("Number of elements are : "+obj.CountNode());

        obj.DeleteFirst();
        obj.DeleteLast();

        obj.Display();

        System.out.println("Number of elements are : "+obj.CountNode());

    }
}

class Node
{
    public int data;
    public Node next;
    public Node prev;
}

class DoublyXLirLL
{
    public Node Head;
    public int Count;

    public DoublyXLirLL()
    {
        Head = null;
        Count = 0;
    }

    public void Display()
    {
        Node Temp = Head;

        while(Temp != null)
        {
            System.out.print("|"+Temp.data+"|->");
            Temp = Temp.next;
        }
        System.out.println("NULL");
    }

    public int CountNode()
    {
        return Count;
    }

    public void InsertFirst(int iNo)
    {
        Node newn = new Node();
        newn.data = iNo;
        newn.next = null;
        newn.prev = null;

        if(Count==0)
        {
            Head = newn;
        }
        else
        {
            newn.next = Head;
            Head.prev = newn;
            Head = newn;
        }
        Count++;
    }

    public void InsertLast(int iNo)
    {
        Node newn = new Node();
        newn.data = iNo;
        newn.next = null;
        newn.prev = null;

        if(Count == 0)
        {
            Head = newn;
        }
        else
        {
            Node Temp = Head;
            while(Temp.next != null)
            {
                Temp = Temp.next;
            }
            newn.prev = Temp;
            Temp.next = newn;
        }
        Count++;
    }

    public void InsertAtPos(int iNo, int pos)
    {
        Node newn = new Node();
        newn.data = iNo;
        newn.next = null;
        newn.prev = null;

        if(pos < 1 || pos > (Count + 1))
        {
            return;
        }
        if(pos == 1)
        {
            InsertFirst(iNo);
        }
        else if(pos == (Count+1) )
        {
            InsertLast(iNo);
        }
        else
        {
            Node Temp = Head;
            for(int i = 1; i< (pos -1); i++)
            {
                Temp = Temp.next;
            }
            newn.next = Temp.next;
            Temp.next.prev = newn;
            newn.prev = Temp;
            Temp.next = newn;
            Count++;
        }
    }

    public void DeleteFirst()
    {
        if(Count == 0)
        {
            return;
        }
        if(Count == 1)
        {
            Head = null;
        }
        else
        {
            Head = Head.next;
            Head.prev = null;
        }
        Count--;
    }

    public void DeleteLast()
    {
        if(Count == 0)
        {
            return;
        }
        if(Count == 1)
        {
            Head = null;
        }
        else
        {
            Node Temp = Head;
            while(Temp.next.next != null)
            {
                Temp = Temp.next;
            }
            Temp.next = null;
            Count--;
        }
    }

    public void DeleteAtPos(int pos)
    {
        if(Count == 0)
        {
            return;
        }
        else if(pos < 1 || pos > (Count))
        {
            return;
        }

        if(pos == 1)
        {
            DeleteFirst();
        }
        else if(pos == Count)
        {
            DeleteLast();
        }
        else
        {
            Node Temp = Head;
            for (int i = 1; i<(pos-1); i++)
            {
                Temp = Temp.next;
            }
            Temp.next = Temp.next.next;
            Temp.next.prev = Temp;
            Count--;
        }
    }
}