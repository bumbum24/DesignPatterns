package designpatterns.behavioral;

interface Iterator{
    public boolean hasNext();
    public Object next();
}

interface Collection{
    Iterator getIterator();
}

class NameIterator implements Iterator{

    String []name;
    NameIterator(String []name){
        this.name=name;
    }
    int i;
    @Override
    public boolean hasNext() {
        if(i<name.length)
            return true;
        return false;
    }

    @Override
    public Object next() {
        if(this.hasNext()){
            return name[i++];
        }
        return null;
    }
}
class MyCollection implements Collection{

    String[] names = {"Alice",
            "Bob",
            "Charlie",
            "Diana",
            "Eric",
            "Fiona",
            "George",
            "Hannah",
            "Ivan",
            "Jasmine"};


    @Override
    public Iterator getIterator() {
        return new NameIterator(names);
    }
}
public class IteratorPattern {
    public static void main(String[] args) {
        MyCollection myCollection = new MyCollection();
        for(Iterator iterator = myCollection.getIterator();iterator.hasNext();){
            System.out.print(iterator.next() + ", ");
        }
    }
}
