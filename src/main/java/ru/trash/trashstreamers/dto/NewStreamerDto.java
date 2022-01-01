package ru.trash.trashstreamers.dto;


public class NewStreamerDto {

    private String pseudonym;
    private String firstname;
    private String lastname;


    public NewStreamerDto() {
    }

    public NewStreamerDto(String pseudonym, String firstname, String lastname) {
        this.pseudonym = pseudonym;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "StreamerInputDto{" +
                "pseudonym='" + pseudonym + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
