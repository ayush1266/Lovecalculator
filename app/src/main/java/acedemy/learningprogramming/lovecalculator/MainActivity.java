package acedemy.learningprogramming.lovecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {


    private String firstname;
    private String secondname;
    private EditText jTextField1;
    private EditText jTextField2;
    private int[] result = new int[20];
    private int[] finalresult = new int[2];
    private TextView jTextField3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jTextField1 =(EditText) findViewById(R.id.editText1);
        jTextField2=(EditText) findViewById(R.id.editText2);

        Button button=(Button) findViewById(R.id.button);
        jTextField3=(TextView) findViewById(R.id.textView3);

        View.OnClickListener ourOnClickListener= new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int i=0,j=0,s,count,r=0,c=0;
                char ch;
                firstname=jTextField1.getText().toString();
                secondname=jTextField2.getText().toString();
                String nam;
                nam = firstname+secondname;


                char[] name = nam.toCharArray();
                s=nam.length();
                i=j=0;

                while (i < s)
                {
                    count=0;
                    if(name[i]!='.'){
                        j=i+1;
                        ch=name[i];
                        while (j<s)
                        {
                            if(name[i]==name[j])
                            {
                                name[j]='.';
                                count++;
                            }
                            j++;
                        }
                        name[i]='.';
                        result[r]=count+1;
                        r++;

                    }
                    i++;
                }

                //TO DISPLAY ONLY FEW MEMBERS
                i=0;
                c=0;
                while(result[i]!=0)
                {
                    c++;
                    i++;
                }

                //  jTextField3.setText(Arrays.toString(result));
                //   System.out.println(c);

                while(c>2)
                {
                    i=0;
                    c=0;
                    while(result[i]!=0)
                    {
                        c++;
                        i++;
                    }
                    for(i=0;i<c/2;i++)
                    {
                        result[i]=result[i]+result[c-i-1];

                    }


                    for(i=c/2+1;i<20;i++)
                    {
                        result[i]=0;
                    }




                }
                if(result[0]>9)
                {
                    r=result[0]/10 + result[1];
                    result[1]=result[0]%10;
                    result[0]=r;
                }

                finalresult[0]=result[0];
                finalresult[1]=result[1];
                String f ;
                f=finalresult.toString();
                jTextField3.setText("");
                jTextField3.append(Integer.toString(finalresult[0]));
                jTextField3.append(Integer.toString(finalresult[1]));
                jTextField3.append("%");
                if((firstname.equals("ayush") && secondname.equals("shraddha")) || finalresult[0]>=10)
                {
                    jTextField3.setText("");
                    jTextField3.append("Uncountable love");

                }



            }
        };
        button.setOnClickListener(ourOnClickListener);
    }
}
