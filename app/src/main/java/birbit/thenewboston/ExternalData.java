package birbit.thenewboston;

import android.app.Activity;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Z003EUNW on 8/2/2016.
 */
public class ExternalData extends Activity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    private TextView canWrite, canRead;
    private String state;
    boolean canW, canR;
    Spinner spinner;
    String[] paths = {"Music", "pictures", "Download"};
    File path = null;
    File file = null;
    EditText saveFile;
    Button confirm, save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.externaldata);

        canWrite = (TextView) findViewById(R.id.tvCanWrite);
        canRead = (TextView) findViewById(R.id.tvCanRead);
        confirm = (Button) findViewById(R.id.bConfirmSaveAs);
        save = (Button) findViewById(R.id.bSaveFile);
        confirm.setOnClickListener(this);
        save.setOnClickListener(this);
        saveFile = (EditText) findViewById(R.id.etSaveAs);

        checkState();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ExternalData.this,
                android.R.layout.simple_spinner_item, paths);
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    private void checkState() {
        state = Environment.getExternalStorageState();
        if(state.equals(Environment.MEDIA_MOUNTED)){
            // read n write
            canWrite.setText("true");
            canRead.setText("true");
            canW = canR = true;
        } else if (state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)){
            // read but cant write
            canWrite.setText("false");
            canRead.setText("true");
            canR = true;
            canW = false;
        } else{
            canWrite.setText("true");
            canRead.setText("false");
            canR = false;
            canW = true;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        position = spinner.getSelectedItemPosition();

        switch (position){
            case 0:
                path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
                break;
            case 1:
                path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                break;
            case 2:
                path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bSaveFile:
                String f = saveFile.getText().toString();
                file = new File(path, f + ".png");

                checkState();
                if(canW == canR == true) {

                    path.mkdirs();
                    try {
                        InputStream is = getResources().openRawResource(R.drawable.monster);
                        OutputStream os = new FileOutputStream(file);
                        byte[] data = new byte[is.available()];
                        is.read(data);
                        os.write(data);
                        is.close();
                        os.close();

                        Toast t = Toast.makeText(ExternalData.this, "File has been saved", Toast.LENGTH_LONG);
                        t.show();
                        // update files for user to use
                        MediaScannerConnection.scanFile(ExternalData.this,
                                new String[]{file.toString()},
                                null,
                                new MediaScannerConnection.OnScanCompletedListener() {
                                    @Override
                                    public void onScanCompleted(String path, Uri uri) {
                                        Toast t = Toast.makeText(ExternalData.this, "scan complete", Toast.LENGTH_SHORT);
                                        t.show();
                                    }
                                });

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.bConfirmSaveAs:
                save.setVisibility(View.VISIBLE);
                break;
        }
    }
}
