package com.braintreepayments.api.models;

import android.os.Parcel;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static junit.framework.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
public class VisaCheckoutAddressUnitTest {

    private JSONObject mSampleAddress;

    @Before
    public void setup() throws JSONException {
       mSampleAddress = new JSONObject()
               .put("firstName", "firstName")
               .put("lastName", "lastName")
               .put("streetAddress", "streetAddress")
               .put("locality", "locality")
               .put("region", "region")
               .put("postalCode", "postalCode")
               .put("countryCode", "countryCode");
    }

    @Test
    public void fromJson_whenValid_returnsPopulatedObject() {
        VisaCheckoutAddress visaCheckoutAddress = VisaCheckoutAddress.fromJson(mSampleAddress);

        assertEquals("firstName", visaCheckoutAddress.getFirstName());
        assertEquals("lastName", visaCheckoutAddress.getLastName());
        assertEquals("streetAddress", visaCheckoutAddress.getStreetAddress());
        assertEquals("locality", visaCheckoutAddress.getLocality());
        assertEquals("region", visaCheckoutAddress.getRegion());
        assertEquals("postalCode", visaCheckoutAddress.getPostalCode());
        assertEquals("countryCode", visaCheckoutAddress.getCountryCode());
    }

    @Test
    public void fromJson_whenNull_returnsEmptyObject() {
        VisaCheckoutAddress visaCheckoutAddress = VisaCheckoutAddress.fromJson(null);

        assertEquals("", visaCheckoutAddress.getFirstName());
        assertEquals("", visaCheckoutAddress.getLastName());
        assertEquals("", visaCheckoutAddress.getStreetAddress());
        assertEquals("", visaCheckoutAddress.getLocality());
        assertEquals("", visaCheckoutAddress.getRegion());
        assertEquals("", visaCheckoutAddress.getPostalCode());
        assertEquals("", visaCheckoutAddress.getCountryCode());
    }

    @Test
    public void parcelsCorrectly() {
        VisaCheckoutAddress visaCheckoutAddress = VisaCheckoutAddress.fromJson(mSampleAddress);

        Parcel parcel = Parcel.obtain();
        visaCheckoutAddress.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        VisaCheckoutAddress actual = VisaCheckoutAddress.CREATOR.createFromParcel(parcel);

        assertEquals(visaCheckoutAddress.getFirstName(), actual.getFirstName());
        assertEquals(visaCheckoutAddress.getLastName(), actual.getLastName());
        assertEquals(visaCheckoutAddress.getStreetAddress(), actual.getStreetAddress());
        assertEquals(visaCheckoutAddress.getLocality(), actual.getLocality());
        assertEquals(visaCheckoutAddress.getRegion(), actual.getRegion());
        assertEquals(visaCheckoutAddress.getPostalCode(), actual.getPostalCode());
        assertEquals(visaCheckoutAddress.getCountryCode(), actual.getCountryCode());
    }
}
