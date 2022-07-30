import java.lang.*;
import java.util.*;

class DoublyCirLL
{
    public static void main(String a[])
    {
        DoublyXCirLL obj = new DoublyXCirLL();
        int iCount = 0;
        obj.InsertFirst(111);
        obj.InsertFirst(11);
        obj.InsertFirst(1);
        obj.InsertLast(1111);
        obj.InsertLast(11111);
        obj.InsertAtPos(555,4);
        obj.Display();
        iCount = obj.CountNode();
        System.out.println("Number of Node in LL are : "+iCount);
        obj.DeleteFirst();
        obj.DeleteLast();
        obj.DeleteAtPos(3);
        obj.Display();
        iCount = obj.CountNode();
        System.out.println("Number of Node in LL are : "+iCount);
    }
}

class Node
{
    public int data;
    public Node next;
    public Node prev;
}

class DoublyXCirLL
{
    public Node Head;
    public Node Tail;
    public int iCount;

    public DoublyXCirLL()
    {
        Head = null;
        Tail = null;
        iCount = 0;
    }

    public void Display()
    {
        Node Temp = Head;
        do
        {
            System.out.print(Temp.data+"->");
            Temp = Temp.next;
        }while(Temp != Head);
        System.out.println();
    }

    public int CountNode()
    {
        return iCount;
    }

    public void InsertFirst(int iNo)
    {
        Node newn = new Node();
        newn.next = null;
        newn.prev = null;
        newn.data = iNo;
        if(Head == null && Tail == null )
        {
            Head = newn;
            Tail = newn;
        }
        else
        {
            Head.prev = newn;
            newn.next = Head;
            Head = newn;
        }
        Head.prev = Tail;
        Tail.next = Head;
        iCount++;
    }

    public void InsertLast(int iNo)
    {
        Node newn = new Node();
        newn.next = null;
        newn.prev = null;
        newn.data = iNo;

        if(Head == null && Tail == null)
        {
            Head = newn;
            Tail = newn;
        }

        else
        {
            Tail.next = newn;
            newn.prev = Tail;
            Tail = newn;
        }
        Head.prev = Tail;
        Tail.next = Head;
        iCount++;
    }

    public void InsertAtPos(int iNo, int iPos)
    {
        Node newn = new Node();
        newn.next = null;
        newn.prev = null;
        newn.data = iNo;

        if(((iCount+1) < iPos) && (iPos < 0))
        {
            System.out.println("Invalid input");
            return;
        }
        if(iPos == 1)
        {
            InsertFirst(iNo);
        }
        else if(iPos == (iCount+1))
        {
            InsertLast(iNo);
        }
        else
        {
            Node Temp = Head;
            int i = 0;
            for(i=1; i<iPos-1;i++)
            {
                Temp = Temp.next;
            }
            newn.next = Temp.next;
            Temp.next.prev = newn;
            newn.prev = Temp;
            Temp.next = newn;
            iCount++;
        }
    }

    public void DeleteFirst()
    {
        if(Head == null && Tail == null)
        {
            return;
        }
        else if(iCount == 1)
        {
            Head = null;
            Tail = null;
        }
        else
        {
            Head = Head.next;
            Tail.next = Head;
            Head.prev = Tail;
        }
        iCount--;
    }

    public void DeleteLast()
    {
        if(Head == null && Tail == null)
        {
            return;
        }
        else if(iCount ==1)
        {
            Head = null;
            Tail = null;
        }
        else
        {
            Tail = Tail.prev;
            Tail.next = Head;
            Head.prev = Tail;
        }
        iCount--;
    }

    public void DeleteAtPos(int iPos)
    {
        if(iPos < 1 && iPos > iCount)
        {
            System.out.println("Invalid position");
            return;
        }
        if(iPos == 1)
        {
            DeleteFirst();
        }
        else if(iPos == iCount)
        {
            DeleteLast();
        }
        else
        {
            Node Temp = Head;
            for(int i = 1; i<iPos-1; i++)
            {
                Temp = Temp.next;
            }
            Temp.next = Temp.next.next;
            Temp.next.prev = Temp;
            iCount--;
        }
    }
}