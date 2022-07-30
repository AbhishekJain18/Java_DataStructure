import java.lang.*;
import java.io.*;

class SinglyCirLL
{
    public static void main(String a[])
    {
        SinglyXCirLL obj = new SinglyXCirLL();

        obj.InsertFirst(51);
        obj.InsertFirst(21);
        obj.InsertFirst(11);
        obj.Display();
        System.out.println("Number of elements are : "+obj.CountNode());
        obj.InsertLast(101);
        obj.InsertLast(111);

        obj.InsertAtPos(55,4);
        obj.Display();
        System.out.println("Number of elements are : "+obj.CountNode());

    }
}

class Node
{
    public int data;
    public Node next;
}

class SinglyXCirLL
{
    public Node Head;
    public Node Tail;
    public int Count;

    public SinglyXCirLL()
    {
        Head = null;
        Tail = null;
        Count = 0;
    }

    public void Display()
    {
        Node Temp = Head;
        do
        {
            System.out.print("|"+Temp.data+"|->");
            Temp = Temp.next;
        }while(Temp != Head);
        System.out.println("Rev");
    }

    public int CountNode()
    {
        return Count;
    }

    public void InsertFirst(int iNo)
    {
        Node newn = new Node();
        newn.next = null;
        newn.data = iNo;

        if(Count == 0)
        {
            Head = newn;
            Tail = newn;
        }
        else
        {
            newn.next = Head;
            Head = newn;
        }
        Tail.next = Head;
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
            Tail = newn;
        }
        else
        {
            Tail.next = newn;
            Tail = newn;
        }
        Tail.next = Head;
        Count++;
    }

    public void InsertAtPos(int iNo, int pos)
    {
        Node newn = new Node();
        newn.data = iNo;
        newn.next = null;

        if(pos < 1 || pos >  (Count + 1))
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
            for(int i = 1; i < (pos -1); i++)
            {
                Temp = Temp.next;
            }
            newn.next = Temp.next;
            Temp.next = newn;
            Count++;
        }
    }

}