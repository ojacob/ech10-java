package ch.ech.address.builder;

import ch.ech.address.MailAddress;

public class MailAddressBuilder {

    private PersonMailAddressInfoBuider personMailAddressInfoBuilder;
    private AddressInformationBuilder addressInformationBuilder;

    private MailAddressBuilder() {
        personMailAddressInfoBuilder = new PersonMailAddressInfoBuider();
        addressInformationBuilder = new AddressInformationBuilder();
    }

    public static MailAddressBuilder newInstance() {
        return new MailAddressBuilder();
    }

    public PersonMailAddressInfoBuider personMailAddressInfo() {
        return personMailAddressInfoBuilder;
    }

    public AddressInformationBuilder addressInformation() {
        return addressInformationBuilder;
    }

    public MailAddress build() {
        MailAddress addr = new MailAddress();
        addr.setPerson(personMailAddressInfoBuilder.build());
        addr.setAddressInformation(addressInformationBuilder.build());

        return addr;
    }
}
