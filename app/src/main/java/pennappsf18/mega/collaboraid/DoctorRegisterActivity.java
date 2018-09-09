package pennappsf18.mega.collaboraid;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.design.widget.CoordinatorLayout;
import android.widget.ImageButton;

public class DoctorRegisterActivity extends AppCompatActivity {

    private static String previousFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        previousFragment = "";
        setContentView(R.layout.activity_doctor_register);

        Fragment fragment = new DoctorRegisterActivityFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.doctor_register_frame, fragment);
        ft.commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = null;
        if ("DoctorRegisterActivityFragment".equals(previousFragment)) {
            fragment = new DoctorRegisterActivityFragment();
            previousFragment = "";
        } else {
            super.onBackPressed();
            return;
        }
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.doctor_register_frame, fragment);
        ft.commit();
    }

    public void proofOfCertification(View v){
        previousFragment = "DoctorRegisterActivityFragment";
        Fragment fragment = new DoctorRegisterActivityFragment2();

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.doctor_register_frame, fragment);
        ft.commit();
    }

    public void submit(View v) {
        super.onBackPressed();
        return;
    }

    public void attemptToRegister(View v) {
        EditText password = (EditText)findViewById(R.id.password);
        EditText passwordConfirmation = (EditText)findViewById(R.id.password1);
        String passwordString = password.getText().toString();
        String passwordConfirmationString = passwordConfirmation.getText().toString();
        if (passwordString.equals(passwordConfirmationString)) {
            startActivity(new Intent(DoctorRegisterActivity.this, MainActivity.class));
            return;
        }
        else {
            Snackbar snackbar = Snackbar
                    .make(v, "Passwords do not match!", Snackbar.LENGTH_LONG);
            snackbar.show();
        }
    }

}
