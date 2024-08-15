package designpatterns.behavioral;

//State
interface Connection{
    void open();
    void close();
}

class DatabaseConnection implements Connection{
    @Override
    public void open() {
        System.out.println("Database Connection Opened");
    }

    @Override
    public void close() {
        System.out.println("Database Connection Closed");
    }
}

class URLConnection implements Connection{
    @Override
    public void open() {
        System.out.println("URL Connection Opened");
    }

    @Override
    public void close() {
        System.out.println("URL Connection Closed");
    }
}

class ConnectionContext{
    Connection connection;
    ConnectionContext(){
        this.connection=null;
    }

    void setConnection(Connection connection){
        this.connection=connection;
    }

    public void getState(){
        System.out.println(connection.getClass().getSimpleName() + " Established");
    }

}
public class StatePattern {

    public static void main(String[] args) {
        ConnectionContext connectionContext = new ConnectionContext();
        connectionContext.setConnection(new DatabaseConnection());
        connectionContext.getState();
        connectionContext.connection.open();
        connectionContext.connection.close();
        connectionContext.setConnection(new URLConnection());
        connectionContext.getState();
        connectionContext.connection.open();
        connectionContext.connection.close();
    }
}
