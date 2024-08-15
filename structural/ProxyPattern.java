package designpatterns.structural;

interface Internet {
    void connect(String site) ;
}

class RealInternet implements Internet {
    @Override
    public void connect(String site) {
        System.out.println("Connecting to the site: " + site);
    }
}

class ProxyInternet implements Internet {
    private final RealInternet realInternet = new RealInternet();
    private static final String[] bannedSites = {"abc.com", "def.com", "ijk.com"};

    @Override
    public void connect(String site) {
        System.out.println("Checking for banned sites");
        for (String bannedSite : bannedSites) {
            if (bannedSite.equals(site)) {
                System.out.println("Access Denied");
                return;
            }
        }
        realInternet.connect(site);
    }
}
public class ProxyPattern {
    public static void main(String[] args) {
        Internet internet = new ProxyInternet();
        internet.connect("abc.com");
        internet.connect("google.com");
    }
}
