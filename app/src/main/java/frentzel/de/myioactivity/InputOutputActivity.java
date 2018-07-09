package frentzel.de.myioactivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputOutputActivity extends Activity {
    String name;
    TextView nameA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_output);
        nameA = findViewById(R.id.nameA);
        // closes Stream if failed
        try(InputStream input = getResources().openRawResource(R.raw.names)){

        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        name = br.readLine();
        nameA.setText(name);
        while ((name = br.readLine())!=null)
            nameA.append("\n"+name);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
