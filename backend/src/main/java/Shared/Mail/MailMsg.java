package Shared.Mail;

import java.io.Serializable;
import java.util.List;

public class MailMsg  implements Serializable{

    private String Services;
    private String IP;
    private int Port;
    private List<String> Emails;


    public MailMsg(String services, String IP, int port, List<String> emails) {
        Services = services;
        this.IP = IP;
        Port = port;
        Emails = emails;
    }

    public String getServices() {
        return Services;
    }

    public String getIP() {
        return IP;
    }

    public int getPort() {
        return Port;
    }

    public List<String> getEmails() {
        return Emails;
    }
}
