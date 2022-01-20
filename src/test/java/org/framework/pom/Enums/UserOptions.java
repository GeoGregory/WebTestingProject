package org.framework.pom.Enums;

public enum UserOptions {

    STANDARD("standard_user"),
    LOCKED_OUT("locked_out_user"),
    PROBLEM("problem_user"),
    PERFORMANCE("performance_glitch_user");

    private final String user;

        public String getUserOption(){return user;}

    UserOptions(String user){
        this.user = user;
    }
}
