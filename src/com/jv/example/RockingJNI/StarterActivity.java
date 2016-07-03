package com.jv.example.RockingJNI;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.*;

public class StarterActivity extends Activity {

    final static String FULL_FILE_PATH = Environment.getExternalStorageDirectory().toString() + "/rocking_jni.txt";

    EditText editText;
    Button appendButton, checkFileButton, deleteButton;

    String textToAppend = "Some text";

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        editText = (EditText) findViewById(R.id.editText);
        appendButton = (Button) findViewById(R.id.append_button);
        checkFileButton = (Button) findViewById(R.id.check_file_button);
        deleteButton = (Button) findViewById(R.id.delete_file_button);

        appendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileDumper.dumpFile(FULL_FILE_PATH, textToAppend + "\n");
                editText.setText("");
                textToAppend = "";
            }
        });

        checkFileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File file = new File(FULL_FILE_PATH);

                if (file.exists()) {
                    String fileContent = readFile(FULL_FILE_PATH);

                    Toast.makeText(StarterActivity.this, fileContent, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(StarterActivity.this, "File does not exists", Toast.LENGTH_SHORT).show();
                }
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File file = new File(FULL_FILE_PATH);

                if (file.exists()) {
                    boolean result = file.delete();
                    Toast.makeText(
                            StarterActivity.this,
                            String.format(result ? "Successfully removed" : "File delete failed"),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {/**/}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {/**/}

            @Override
            public void afterTextChanged(Editable editable) {
                textToAppend = editable.toString();
            }
        });
    }

    private String readFile(String fullFilePath) {
        StringBuffer sb = new StringBuffer();
        try {
            BufferedReader br = null;
            String tempLine;

            br = new BufferedReader(new FileReader(fullFilePath));

            while ((tempLine = br.readLine()) != null) {
                sb.append(tempLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return sb.toString();
        }
    }
}
