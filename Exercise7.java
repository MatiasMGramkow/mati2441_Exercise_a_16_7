import java.util.NoSuchElementException;

public class Exercise7
    /*
    Write a method called deleteBack that deletes the last value (the value at the back of the list) and returns the
deleted value. If the list is empty, throw a NoSuchElementException.
     */
{
    public static void main(String[] args)
    {
        LinkedIntList liste1 = new LinkedIntList();

        liste1.add(1);
        liste1.add(8);
        liste1.add(19);
        liste1.add(4);
        liste1.add(17);
        liste1.add(6);
        liste1.add(22);

        System.out.println("Listen indeholder: ");
        System.out.println(liste1);

        int slet = liste1.deleteBack();
        System.out.println("\n De slettede elementer er: " + slet);
        System.out.println("listen indeholder nu: " + liste1);
    }
}

class list
{
    public int data;
    public list next;

    public list()
    {
        this(0, null);
    }

    public list(int data)
    {
        this(data, null);
    }

    public list(int data, list next)
    {
        this.data = data;
        this.next = next;
    }
}

class LinkedIntList
{
    private list front;

    public LinkedIntList()
    {
        front = null;
    }

    public int size()
    {
        int count = 0;
        list current = front;

        while (current != null)
        {
            current = current.next;
            count++;
        }
        return count;
    }

    public int get(int index)
    {
        return nodeAt(index).data;
    }

    public String toString()
    {
        if (front == null)
        {
            return "[]";
        } else
        {
            String result = "[" + front.data;
            list current = front.next;

            while (current != null)
            {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }

    public int indexOf(int value)
    {
        int index = 0;
        list current = front;

        while (current != null)
        {
            if (current.data == value)
            {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    public void add (int value)
    {
        if (front == null)
        {
            front = new list (value);
        }
        else
        {
            list current = front;

            while (current.next != null)
            {
                current = current.next;
            }
            current.next = new list (value);
        }
    }

    public void add (int index, int value)
    {
        if (index == 0)
        {
            front = new list (value, front);
        }
        else
        {
            list current = nodeAt(index -1);
            current.next = new list (value,current.next);
        }
    }

    public void remove (int index)
    {
        if (index == 0)
        {
            front = front.next;
        }
        else
        {
            list current = nodeAt(index - 1);
            current.next = current.next.next;
        }
    }

    private list nodeAt (int index)
    {
        list current = front;
        for (int i = 0; i < index; i++)
        {
            current = current.next;
        }
        return current;
    }

    public int deleteBack()
    {
        if (front == null)
        {
            throw new NoSuchElementException();
        }
        else
        {
            list last = front;
            list current = front.next.next;

            while (current != null)
            {
                last = last.next;
                current = current.next;
            }
            int nummer = last.next.data;
            last.next = null;
            return nummer;
        }
    }
}

