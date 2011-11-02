package ch.ech.address.builder;

import ch.ech.address.AddressInformation;

public class AddressInformationBuilder {
    private String addressLine1;
    private String addressLine2;
    private String street;
    private String houseNumber;
    private String dwellingNumber;
    private Long postOfficeBoxNumber;
    private String postOfficeBoxText;
    private String locality;
    private String town;
    private Long swissZipCode;
    private String swissZipCodeAddOn;
    private Integer swissZipCodeId;
    private String foreignZipCode;
    private String country;

    public AddressInformationBuilder addressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
        return this;
    }

    public AddressInformationBuilder addressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
        return this;
    }

    public AddressInformationBuilder street(String street) {
        this.street = street;
        return this;
    }

    public AddressInformationBuilder houseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    public AddressInformationBuilder dwellingNumber(String dwellingNumber) {
        this.dwellingNumber = dwellingNumber;
        return this;
    }

    public AddressInformationBuilder postOfficeBoxNumber(Long postOfficeBoxNumber) {
        this.postOfficeBoxNumber = postOfficeBoxNumber;
        return this;
    }

    public AddressInformationBuilder postOfficeBoxText(String postOfficeBoxText) {
        this.postOfficeBoxText = postOfficeBoxText;
        return this;
    }

    public AddressInformationBuilder locality(String locality) {
        this.locality = locality;
        return this;
    }

    public AddressInformationBuilder town(String town) {
        this.town = town;
        return this;
    }

    public AddressInformationBuilder swissZipCode(Long swissZipCode) {
        this.swissZipCode = swissZipCode;
        return this;
    }

    public AddressInformationBuilder swissZipCodeAddOn(String swissZipCodeAddOn) {
        this.swissZipCodeAddOn = swissZipCodeAddOn;
        return this;
    }

    public AddressInformationBuilder swissZipCodeId(Integer swissZipCodeId) {
        this.swissZipCodeId = swissZipCodeId;
        return this;
    }

    public AddressInformationBuilder foreignZipCode(String foreignZipCode) {
        this.foreignZipCode = foreignZipCode;
        return this;
    }

    public AddressInformationBuilder country(String country) {
        this.country = country;
        return this;
    }

    public AddressInformation build() {
        AddressInformation info = new AddressInformation();
        info.setAddressLine1(addressLine1);
        info.setAddressLine2(addressLine2);
        info.setStreet(street);
        info.setHouseNumber(houseNumber);
        info.setDwellingNumber(dwellingNumber);
        info.setPostOfficeBoxNumber(postOfficeBoxNumber);
        info.setPostOfficeBoxText(postOfficeBoxText);
        info.setLocality(locality);
        info.setTown(town);
        info.setSwissZipCode(swissZipCode);
        info.setSwissZipCodeAddOn(swissZipCodeAddOn);
        info.setSwissZipCodeId(swissZipCodeId);
        info.setForeignZipCode(foreignZipCode);
        info.setCountry(country);

        return info;
    }
}
