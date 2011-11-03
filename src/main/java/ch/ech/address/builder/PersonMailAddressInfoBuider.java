package ch.ech.address.builder;

import ch.ech.address.PersonMailAddressInfo;

public class PersonMailAddressInfoBuider {
    private String mrMrs;
    private String title;
    private String firstName;
    private String lastName;

    public PersonMailAddressInfoBuider mrMrs(String mrMrs) {
        this.mrMrs = mrMrs;
        return this;
    }

    public PersonMailAddressInfoBuider title(String title) {
        this.title = title;
        return this;
    }

    public PersonMailAddressInfoBuider firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonMailAddressInfoBuider lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonMailAddressInfo build() {
        PersonMailAddressInfo info = new PersonMailAddressInfo();
        info.setMrMrs(mrMrs);
        info.setTitle(title);
        info.setFirstName(firstName);
        info.setLastName(lastName);

        return info;
    }
}
