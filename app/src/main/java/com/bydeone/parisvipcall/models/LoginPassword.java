package com.bydeone.parisvipcall.models;

public class LoginPassword {

    private int position;
    private String nomService;
    private String login;
    private String password;
    private String type;
    private String commentaire;

    public LoginPassword(int position, String nomService, String login, String password, String type, String commentaire) {
        this.position = position;
        this.nomService = nomService;
        this.login = login;
        this.password = password;
        this.type = type;
        this.commentaire = commentaire;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getNomService() {
        return nomService;
    }

    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}
