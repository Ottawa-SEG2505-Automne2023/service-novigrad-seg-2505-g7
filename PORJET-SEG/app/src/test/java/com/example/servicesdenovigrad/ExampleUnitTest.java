package com.example.servicesdenovigrad;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;


import static org.junit.Assert.*;

import android.widget.EditText;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Rule
    public ActivityTestRule<MainActivity>mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);
    private MainActivity mActivity = null;
    private EditText fullname, address, email, phone;

    @Before
    public void setUp() throws Exception{
        mActivity = mActivityTestRule.getActivity();
    }



    @Test
    public void checkName() throws Exception{
        assertNotNull(mActivity.findViewById(R.id.txt_fn));
        fullname = mActivity.findViewById(R.id.txt_fn);
        fullname.setText("user");
        String name = fullname.getText().toString();
        assertNotEquals("user",name);
    }
    @Test
    public void checkAddress() throws Exception {
        assertNotNull(mActivity.findViewById(R.id.txt_address));
        address = mActivity.findViewById(R.id.txt_address);
        address.setText("address");
        String useraddress = fullname.getText().toString();
        assertNotEquals("address", useraddress);
    }

    @Test
    public void checkEmail() throws Exception {
        assertNotNull(mActivity.findViewById(R.id.txt_email));
        email = mActivity.findViewById(R.id.txt_email);
        email.setText("email");
        String useremail = fullname.getText().toString();
        assertNotEquals("email", useremail);
    }

    @Test
    public void checkPhone() throws Exception {
        assertNotNull(mActivity.findViewById(R.id.txt_num));
        phone = mActivity.findViewById(R.id.txt_num);
        phone.setText("phone number");
        String userphone = fullname.getText().toString();
        assertNotEquals("phone number", userphone);
    }
}
