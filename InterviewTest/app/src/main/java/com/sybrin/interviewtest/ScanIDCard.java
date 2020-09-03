package com.sybrin.interviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.*;

import com.example.identitydocumentsdk.SybrinSmartIdentification;
import com.example.identitydocumentsdk.SybrinSmartIdentificationInterface;
import com.example.identitydocumentsdk.models.IDModel;
import com.example.identitydocumentsdk.utils.CountryProvider;
import com.example.identitydocumentsdk.utils.DocTypeProvider;

public class ScanIDCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_i_d_card);

        SybrinSmartIdentification sybrinIdScan = SybrinSmartIdentification.getInstance(ScanIDCard.this);
        sybrinIdScan.setListener(new SybrinSmartIdentificationInterface() {
            @Override
            public void onDataReturned(IDModel idModel) {
                ImageView imageView = findViewById(R.id.ivPortrait);
                imageView.setImageBitmap(idModel.PortraitImage);

                TextView tvFirstName = findViewById(R.id.tvFirstName);
                tvFirstName.setText(idModel.GivenNames);

                TextView tvLastName = findViewById(R.id.tvLastName);
                tvLastName.setText(idModel.Surname);

                TextView tvIDNumber = findViewById(R.id.tvIdNumber);
                tvIDNumber.setText(idModel.IDNumber);

                TextView tvCountryOfBirth = findViewById(R.id.tvCountryOfBirth);
                tvCountryOfBirth.setText(idModel.CountryOfBirth);

                TextView tvDateOfExpiry = findViewById(R.id.tvDateOfExpiry);
                tvDateOfExpiry.setText(idModel.DateOfExpire);

                TextView tvDateOfIssue = findViewById(R.id.tvDateOfIssue);
                tvDateOfIssue.setText(idModel.DateOfIssue);

                TextView tvDateOfBirth = findViewById(R.id.tvDoB);
                tvDateOfBirth.setText(idModel.DateOfBirth);

                TextView tvSex = findViewById(R.id.tvSex);
                tvDateOfBirth.setText(idModel.Sex);



            }

            @Override
            public void onFailure(String s) {

            }
        });
        sybrinIdScan.startSmartIdentification("8+F9HvN7JNNOGf41YGJ0201juBwxwX27Zg1VUnVLCUS0gNOKK/q0g/DZQYQoFho/+6u2lswGpGYtDxRpoNoh6b8YR2pJIivdZSUncmgZLNtzMcRC7B9y2Sp0UxBuSLopHUpy73DtGcFQ2BmG5gyBU4EqbxFaDpb2kz6VJn82RZDJSltVL4J0RK3UUHZLkyWxdif1jn11xVPOiiqJzdCmNZBGqVofhLpE4gCXE/zyVZ/ZeJBUOh0kvlEigyFnm5gZHakF4bKVjLumRxgzMrS6kiDzkte10JFIJi3AIsG5NTAl2Pv6J6x9fzIowG9zXxPZ59UM4G6wwnn43by1DFBU6IJ7S9ooUB1/pqJFt47zd2Hoa0jkwKjJHw9rYMtQJ5uU5wlOnlx0iVb/aGk6ujtNgQ==",
                DocTypeProvider.IDCard, CountryProvider.SouthAfrica);
    }
}