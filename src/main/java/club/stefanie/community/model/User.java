package club.stefanie.community.model;

public class User {
    int id;
    String name;
    String accountId;
    String toker;
    String gtmlCreate;
    String gmtModified;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getToker() {
        return toker;
    }

    public void setToker(String toker) {
        this.toker = toker;
    }

    public String getGtmlCreate() {
        return gtmlCreate;
    }

    public void setGtmlCreate(String gtmlCreate) {
        this.gtmlCreate = gtmlCreate;
    }

    public String getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
