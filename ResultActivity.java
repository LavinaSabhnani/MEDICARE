package com.example.tanma.medicare2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView resultview = (TextView) findViewById(R.id.textViewResult);

        TextView descriptionView = (TextView) findViewById(R.id.textViewDescription);
        String answer = SSDIHealthPredictor.result;

        if (answer.equals("influenza")) {
            descriptionView.setText("The flu is treated primarily with rest and fluid to let the body fight the infection on its own. Over-the-counter anti-inflammatory pain relievers may help with symptoms. \n" +
                    "\n" +
                    "General medicine:  Oseltamivir (Tamiflu) is a medication you take by mouth, zanamivir (Relenza) is inhaled, and peramivir (Rapivab) is given into a vein.");
        }

        if (answer.equals("dehydration")) {
            descriptionView.setText("You can usually reverse mild to moderate dehydration by drinking more fluids, but severe dehydration needs immediate medical treatment\n" +
                    "\n" +
                    "General medicine: Infants and children respond well to fluid replacement, and often oral rehydration therapy (ORT) can treat dehydration");
        }

        if (answer.equals("asthma")) {
            descriptionView.setText("Asthma may cause difficulty breathing, chest pain, cough, and wheezing. The symptoms may sometimes flare-up\n" +
                    "\n" +
                    "General medicine: Asthma can usually be managed with rescue inhalers to treat symptoms (albuterol)");
        }

        resultview.setText("Your Diagnosis : " + answer);
        //Toast.makeText(ResultActivity.this,"Your Diagnosis : "+answer,Toast.LENGTH_LONG).show();
    }
}

