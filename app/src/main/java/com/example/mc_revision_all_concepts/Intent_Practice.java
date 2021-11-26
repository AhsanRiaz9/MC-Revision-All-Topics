package com.example.mc_revision_all_concepts;

import static android.content.Intent.ACTION_DIAL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class Intent_Practice extends AppCompatActivity implements View.OnClickListener {

    Button dialBtn,shareTxtBtn,webIntentBtn,sendEmailBtn,backBtn,sentDataBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_practice);
        // create button
        dialBtn = findViewById(R.id.dialBtn);
        shareTxtBtn = findViewById(R.id.shareTxtBtn);
        webIntentBtn = findViewById(R.id.webIntentBtn);
        sendEmailBtn = findViewById(R.id.sendEmailBtn);
        backBtn = findViewById(R.id.backBtn);
        sentDataBtn = findViewById(R.id.sentDataBtn);
        // set set on click listener for each button
        dialBtn.setOnClickListener(this);
        shareTxtBtn.setOnClickListener(this);
        webIntentBtn.setOnClickListener(this);
        sendEmailBtn.setOnClickListener(this);
        backBtn.setOnClickListener(this);
        sentDataBtn.setOnClickListener(this);
    }
    public String getRandomQuote()
    {
        String [] quotesArr = {"Think a hundred times before you take a decision, but once that decision is taken, stand by it as one man.",
                "I do not believe in taking the right decision, I take a decision and make it right.",
                "There are two powers in the world; one is the sword and the other is the pen. There is a great competition and rivalry between the two. There is a third power stronger than both, that of the women.",
                "Expect the best, prepare for the worst.",
                "Democracy is in the blood of the Muslims, who look upon complete equality of mankind, and believe in fraternity, equality, and liberty.",
                "No nation can rise to the height of glory unless your women are side by side with you. We are victims of evil customs. It is a crime against humanity that our women are shut up within the four walls of the houses as prisoners. There is no sanction anywhere for the deplorable condition in which our women have to live.",
                "You will have to make up for the smallness of your size by your courage and selfless devotion to duty, for it is not life that matters, but the courage, fortitude and determination you bring to it.",
                "With faith, discipline and selfless devotion to duty, there is nothing worthwhile that you cannot achieve.",
                "You are free; you are free to go to your temples. You are free to go to your mosques or to any other places of worship in this State of Pakistan. You may belong to any religion, caste or creed—that has nothing to do with the business of the state.",
                "No nation can ever be worthy of its existence that cannot take its women along with the men. No struggle can ever succeed without women participating side by side with men. There are two powers in the world; one is the sword and the other is the pen. There is a great competition and rivalry between the two. There is a third power stronger than both, that of the women.",
                "The great majority of us are Muslims. We follow the teachings of the Prophet Mohammed (may peace be upon him). We are members of the brotherhood of Islam in which all are equal in rights, dignity and self-respect. Consequently, we have a special and a very deep sense of unity. But make no mistake: Pakistan is not a theocracy or anything like it.",
                "Do not forget that the armed forces are the servants of the people. You do not make national policy; it is we, the civilians, who decide these issues and it is your duty to carry out these tasks with which you are entrusted."};
        Random random = new Random();
        return quotesArr[random.nextInt(quotesArr.length)];
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.dialBtn:
            {
                Uri uri = Uri.parse("tel:+923051122786");
                Intent intent = new Intent(ACTION_DIAL , uri);
                startActivity(intent);
            }
            break;
            case R.id.shareTxtBtn:
            {
                String quotes = "\"" + getRandomQuote() + "\"\n ~ Quaid-e-Azam";
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, quotes);
                intent.setType("text/plain");
                startActivity(intent);
            }
            break;
            case R.id.webIntentBtn:
            {
                Uri url = Uri.parse("https://github.com/AhsanRiaz9/MC-Revision-All-Topics.git");
                Intent intent = new Intent(Intent.ACTION_VIEW,url);
                startActivity(intent);
            }
            break;
            case R.id.sendEmailBtn:
            {
                String email = "bcsf18m009@pucit.edu.pk";
                String subject = "MC Revision of All Concepts";
                String body = "Hello, this is a github repo link of MC Revision of All concepts." + "\n" +
                "URL: https://github.com/AhsanRiaz9/MC-Revision-All-Topics" + "\n" +
                        "Regards" + "\nAhsan Riaz\nBCSF18M009";
//                Intent intent = new Intent(Intent.ACTION_SEND);
//                intent.putExtra(Intent.EXTRA_EMAIL,email);
//                intent.putExtra(Intent.EXTRA_SUBJECT,subject);
//                intent.putExtra(Intent.EXTRA_TEXT,body);
//                if(intent.resolveActivity(getPackageManager())!=null)
//                {
//                    startActivity(intent);
//                }
//                else
//                {
//                    Toast.makeText(getApplicationContext(),"No package exist for sending email",Toast.LENGTH_LONG).show();
//                }
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, email);
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, body);

//need this to prompts email client only
                intent.setType("message/rfc822");

                startActivity(Intent.createChooser(intent, "Choose an Email client :"));

            }
            break;
            case R.id.backBtn:
            {
                this.finish();
            }
            break;
            case R.id.sentDataBtn:
            {
                Intent intent = new Intent(Intent_Practice.this, Quaid_E_Azam_Quotes.class);
                String quote = getRandomQuote();
                intent.putExtra("quote",quote);
                startActivity(intent);
            }
            break;

        }
    }
}