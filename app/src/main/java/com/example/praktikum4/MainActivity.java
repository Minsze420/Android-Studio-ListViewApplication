package com.example.praktikum4;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onSuchen(View v){
        String pfad = ((EditText)findViewById(R.id.editPfad)).getText().toString();
        File dir = new File(pfad);

        File dateien[] = dir.listFiles();
        if(dateien == null){
            Toast to = Toast.makeText(this,"Pfad: "+pfad, Toast.LENGTH_LONG);
            to.show();
            return;
        }
        String txt = "";
        for(int i = 0; i< dateien.length; i++){
            txt += dateien[i].getName() + "\n";
        }
        ((TextView)findViewById(R.id.tvDateien)).setText(txt);
    }
}