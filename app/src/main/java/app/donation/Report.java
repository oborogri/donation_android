package app.donation;

import app.donation.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Report extends AppCompatActivity
{
    ListView listView;

    static final String[] numbers = new String[] {
            "Amount, Pay method",
            "10,     Direct",
            "100,    PayPal",
            "1000,   Direct",
            "10,     PayPal",
            "5000,   PayPal"};

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        listView = (ListView) findViewById(R.id.reportList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,  android.R.layout.simple_list_item_1, numbers);
        listView.setAdapter(adapter);
    }
}