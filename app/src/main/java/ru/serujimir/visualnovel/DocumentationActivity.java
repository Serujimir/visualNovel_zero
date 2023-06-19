package ru.serujimir.visualnovel;

import android.app.ListActivity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ArrayAdapter;
public class DocumentationActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Resources res = getResources();
        String[] error_list = res.getStringArray(R.array.error_list);
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, R.layout.activity_documentation, R.id.error_text, error_list);
        setListAdapter(adapter);
    }
}
