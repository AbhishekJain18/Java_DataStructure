import java.lang.*;
import java.io.*;

class SinglyLirLL
{
    public static void main(String a[])
    {
        SinglyXLirLL obj = new SinglyXLirLL();

        obj.InsertFirst(51);
        obj.InsertFirst(21);
        obj.InsertFirst(11);

        obj.InsertLast(101);
        obj.InsertLast(111);

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
}
class SinglyXLirLL
{
    public Node Head;
    public int Count;
    public SinglyXLirLL()
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

        if(Count == 0)
        {
            Head = newn;
        }
        else
        {
            newn.next = Head;
            Head = newn;
        }
        Count++;
    }

    public void InsertLast(int iNo)
    {
        Node newn = new Node();
        newn.data = iNo;
        newn.next = null;

        if(Count == 0)
        {
            Head = newn;
        }
        else
        {
            Node Temp = Head;
            while (Temp.next != null)
            {
                Temp = Temp.next;
            }
            Temp.next = newn;
        }
        Count++;
    }
    public void InsertAtPos(int iNo, int pos)
    {
        Node newn = new Node();

        if(pos > (Count+1) || pos < 1)
        {
            return;
        }
        newn.data = iNo;
        newn.next = null;

        if(pos == 1)
        {
            InsertFirst(iNo);
        }
        else if(pos == (Count+1))
        {
            InsertLast(iNo);
        }
        else
        {
            Node Temp = Head;
            for(int i = 1; i < (pos-1); i++)
            {
                Temp = Temp.next;
            }
            newn.next = Temp.next;
            Temp.next = newn;
            Count++;
        }
    }
    public void DeleteFirst()
    {
        if(Head == null)
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
            Head = Temp.next;
            Temp = null;
        }
        Count--;
    }
    public void DeleteLast()
    {
        if(Head == null)
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
        }
        Count--;
    }
    public void DeleteAtPos(int pos)
    {
        if(pos < 1 || pos > (Count))
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
            for(int i = 1; i < pos-1; i++)
            {
                Temp = Temp.next;
            }
            Temp.next = Temp.next.next;
            Count--;
        }
    }
}
