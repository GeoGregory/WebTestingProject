package org.framework.pom.Enums;

public enum BurgerLinks {
    ALL_ITEMS("ALL_ITEMS"),
    ABOUT("ABOUT"),
    LOGOUT("LOGOUT"),
    RESET_APP_STATE("RESET_APP_STATE");

    private final String link;

    public String getLink(){return link;}

    BurgerLinks(String link){
        this.link = link;
    }
}
