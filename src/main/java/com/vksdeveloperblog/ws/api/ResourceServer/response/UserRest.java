package com.vksdeveloperblog.ws.api.ResourceServer.response;

/**
 * User class to return user information
 */
public class UserRest {
    private String userFirstName;
    private String userLastName;
    private String userId;

    public UserRest(String userFirstName, String userLastName, String userId) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userId = userId;
    }

    public String getUserFirstName() {
        return this.userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return this.userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
