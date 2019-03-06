package ir.rojadev.edittextdynamically;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.text.InputType;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private Button buttonView;
    private LinearLayout parentLayout;
    private int hint1=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonView=(Button)findViewById(R.id.buttonView);
        parentLayout = (LinearLayout)findViewById(R.id.parentLayout);
        buttonView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText NumedittTxt = (EditText) findViewById(R.id.num);
                int num1= Integer.valueOf(NumedittTxt.getText().toString());
////////////////// Create by Enter Number////////////////////////////////////
                for(int i=1;i<=num1;i++)
                   createEditText();
/////////////////////////////////////////////////////////////////////////////
//                NumedittTxt.setVisibility(View.INVISIBLE);
//                buttonView.setVisibility(View.INVISIBLE);
            }
        });


    }

    protected void createEditText() {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams (
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);

        params.setMargins(0,10,0,10);

        EditText edittTxt = new EditText(this);


        int maxLength = 5;

        hint1++;
        edittTxt.setHint("EditText" + hint1);
        edittTxt.setLayoutParams(params);
        edittTxt.setInputType(InputType.TYPE_CLASS_TEXT);
        edittTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
        edittTxt.setId(hint1);
        InputFilter[] fArray = new InputFilter[1];
        fArray[0] = new InputFilter.LengthFilter(maxLength);
        edittTxt.setFilters(fArray);
        parentLayout.addView(edittTxt);



    }



}
