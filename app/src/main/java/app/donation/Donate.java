package app.donation;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.RadioGroup;
        import android.widget.NumberPicker;
        import android.widget.ProgressBar;
        import android.widget.Toast;

        import app.donation.R;

public class Donate extends AppCompatActivity
{

    private Button donateButton;
    private RadioGroup paymentMethod;
    private ProgressBar progressBar;
    private NumberPicker amountPicker;
    private int      totalDonated = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);

        donateButton = (Button) findViewById(R.id.donateButton);
        paymentMethod = (RadioGroup)   findViewById(R.id.paymentMethod);
        progressBar   = (ProgressBar)  findViewById(R.id.progressBar);
        amountPicker  = (NumberPicker) findViewById(R.id.amountPicker);

        amountPicker.setMinValue(0);
        amountPicker.setMaxValue(1000);
        progressBar.setMax(10000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_donate, menu);
        return true;
    }


    public void donateButtonPressed (View view) {

        if (totalDonated >= progressBar.getMax()) {
            Toast toast = Toast.makeText(this, "Target Exceeded!", Toast.LENGTH_SHORT);
            toast.show();

        } else {
            int amount = amountPicker.getValue();
            int radioId = paymentMethod.getCheckedRadioButtonId();

            String method = radioId == R.id.PayPal ? "PayPal" : "Direct";
            totalDonated = totalDonated + amount;
            progressBar.setProgress(totalDonated);

            Log.v("Donate", amountPicker.getValue() + " donated by " + method + "\nCurrent total " + totalDonated);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menuReport:
                Toast.makeText(this, "Report Selected", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
