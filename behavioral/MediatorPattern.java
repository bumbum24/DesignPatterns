package designpatterns.behavioral;

interface Mediator{
    public void login();
}

class DoLogin implements Mediator{

    private String username;
    private String password;
    DoLogin(String username,String password){
        this.username=username;
        this.password=password;
    }
    @Override
    public void login() {
        System.out.println("UserName : " + username + " Password : " + password);
    }
}

interface Component {
    void setMediator(Mediator mediator);

}

class Login implements Component{

    Mediator mediator;
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator=mediator;
    }

    public void login(){
        mediator.login();
    }

}
public class MediatorPattern {
    public static void main(String[] args) {
        Mediator doLogin= new DoLogin("bumbum","bole");
        Login login = new Login();
        login.setMediator(doLogin);
        login.login();
    }
}
