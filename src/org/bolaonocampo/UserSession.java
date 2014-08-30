package org.bolaonocampo;

/**
 * User: Rogerio
 * Date: 12/2/13
 * Time: 5:28 PM
 */
public class UserSession {

    private static UserSession instance = null;

    private String userName;

    private UserSession() {
    }

    public static UserSession getInstance() {
        if (instance == null)
            instance = new UserSession();

        return instance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
