package ch.ech.address.builder;

import ch.ech.address.OrganisationMailAddressInfo;

public class OrganisationMailAddressInfoBuilder {
    private String organisationName;
    private String organisationNameAddOn1;
    private String organisationNameAddOn2;
    private String firstName;
    private String lastName;
    private String title;

    public OrganisationMailAddressInfoBuilder organisationName(String organisationName) {
        this.organisationName = organisationName;
        return this;
    }

    public OrganisationMailAddressInfoBuilder organisationNameAddOn1(String organisationNameAddOn1) {
        this.organisationNameAddOn1 = organisationNameAddOn1;
        return this;
    }

    public OrganisationMailAddressInfoBuilder organisationNameAddOn2(String organisationNameAddOn2) {
        this.organisationNameAddOn2 = organisationNameAddOn2;
        return this;
    }

    public OrganisationMailAddressInfoBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public OrganisationMailAddressInfoBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public OrganisationMailAddressInfoBuilder title(String title) {
        this.title = title;
        return this;
    }

    public OrganisationMailAddressInfo build() {
        OrganisationMailAddressInfo info = new OrganisationMailAddressInfo();
        info.setOrganisationName(organisationName);
        info.setOrganisationNameAddOn1(organisationNameAddOn1);
        info.setOrganisationNameAddOn2(organisationNameAddOn2);
        info.setFirstName(firstName);
        info.setLastName(lastName);
        info.setTitle(title);

        return info;
    }
}
