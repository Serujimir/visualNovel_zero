package ru.serujimir.visualnovel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SearchRecentSuggestionsProvider;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private int current_stroke = 0;
    TextView mainText;
    Context context;
    String[] text;
    ConstraintLayout consLayout;
    ImageView backGround;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        mainText = findViewById(R.id.mainText);
        Resources res = getResources();
        text = res.getStringArray(R.array.strokes);
        mainText.setText(text[current_stroke]);
        backGround = findViewById(R.id.backGround);
        consLayout = findViewById(R.id.consLayout);
        backGround.setBackgroundResource(R.drawable.zero);
    }
    public void Next (View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("What do you want to do?");
        builder.setPositiveButton("Exit from the app", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAndRemoveTask();
            }
        });
        builder.setNegativeButton("Documentation", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent Documentation = new Intent(MainActivity.this, Menu.class);
                startActivity(Documentation);
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
    public void fingerSpaceClick (View v) {
        try {
            if(current_stroke != text.length)
            {
                current_stroke += 1;
                mainText.setText(text[current_stroke]);
            }
            else
            {
                mainText.setText("Ouch! Something went wrong! (0x00001 error) (Please, check the official documentation in the menu)");
            }

        } catch (Exception e)
        {
            mainText.setText("Ouch! Something went wrong! (0x00001 error) (Please, check the official documentation in the menu)");
        }
        try {
            if (current_stroke == 0 || current_stroke == 3 || text[current_stroke].toString().equals("... And continued!")){
                backGround.setBackgroundResource(R.drawable.zero);
            }
            else if(text[current_stroke].toString().equals("Nya!"))
            {
                backGround.setBackgroundResource(R.drawable.nya);
            }
            else if(text[current_stroke].toString().equals("Arigato!")) {
                backGround.setBackgroundResource(R.drawable.nya);
            }
        }
        catch (Exception e)
        {
            mainText.setText("Ouch! Something went wrong! (0x00001 error) (Please, check the official documentation in the menu)");
        }
    }
    public void fingerSpaceClickBack (View v) {
        try {
            if(current_stroke!= 0)
            {
                current_stroke -= 1;
                mainText.setText(text[current_stroke]);
            }
            else if(current_stroke==0)
            {
                current_stroke = 0;
            }

        } catch (Exception e)
        {
            mainText.setText("Ouch! Something went wrong! (0x00001 error) (Please, check the official documentation in the menu)");
        }
        try {
            if (current_stroke == 0 || current_stroke == 3 || text[current_stroke].toString().equals("... And continued!")){
                backGround.setBackgroundResource(R.drawable.zero);
            }
            else if(text[current_stroke].toString().equals("Nya!"))
            {
                backGround.setBackgroundResource(R.drawable.nya);
            }
            else if(text[current_stroke].toString().equals("Arigato!")) {
                backGround.setBackgroundResource(R.drawable.nya);
            }
        }
        catch (Exception e)
        {
            mainText.setText("Ouch! Something went wrong! (0x00001 error) (Please, check the official documentation in the menu)");
        }

    }
}