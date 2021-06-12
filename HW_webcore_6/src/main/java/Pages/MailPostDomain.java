package Pages;

public enum MailPostDomain {
    Mail("@mail.ru"),
    INBOX("@inbox.ru"),
    LIST("@list.ru"),
    BK("@bk.ru"),
    INTERNET("@internet.ru");

    private String name;
    private int numberOfElements=5;

    MailPostDomain(String name){this.name=name;}

    public String getName() {return this.name;}

    public int getNumberOfElements() {return this.numberOfElements;}

}
