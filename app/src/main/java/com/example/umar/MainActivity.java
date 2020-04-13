package com.example.umar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity ValueEventListener {
    private TextView HeadingText;
    private EditText HeadingLayout;
    private RadioButton RbRed,RbBlue;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference= firebaseDatabase.getReference();
    private DatabaseReference mHeadingReference= mRootReference.child("heading");
    private DatabaseReference mFontColorReference= mRootReference.child("fontcolor");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HeadingText = (TextView)findViewById(R.id.headingtext);
        HeadingLayout= (TextView)findViewById(R.id.headingInput);
        RbRed= (RadioButton)findViewById(R.id.rbBred);
        RbBlue= (RadioButton)findViewById(R.id.rbBlue);

    }
    public_void submitHeading(View view){
        String heading = HeadingInput.getText().toString();
        aHeadingReference.setValue(heading);
        HeadingInput.setText("");



    }
    public_void onRadioButtonClicked(View view)
    {
        switch (view.getId()){
            case R.id.rbRed;
                mFontColorReference.setValue("red");
                break;

            case R.id.rbBlue;
                mFontColorReference.setValue("blue");
                break;

        }
    }
    @Override
    public void onDataChange(DataSnapshot dataSnapshot){
        if(dataSnapshot.getValue(String.class)!=null);
        {
            String Key = dataSnapshot.getKey();

            if(key.equals("heading")){
                String heading=dataSnapshot.getValue(String.class);
                HeadingText.setText(heading);

            }
            else if(Key.equals("fontcolor"))
            {
                String color = datasnapshot.getValue(String.class)
                if(color.equals("red")){
                    HeadingText.setTextColor(ContextCompat.getColor(this,R.color.colorRed));
                    RbRed.setChecked(true);
                }
                else if(color.equals("blue"))
                {
                    HeadingText.setTextColor(ContextCompat.getColor(this,R.color.colorBlue));
                    RbBlue.setChecked("true");

                }
            }
        }

    }
    @Override
    public void onCancelled(DatabaseError databaseError){

    }
    @Override
    protected void onStart(){
        super.onStart();
        aheadingReference.addValueEventListener(this);
        aFontColorreference.addValueEventListener(this);

    }
}

