package com.example.myapplication1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MobilActivity extends AppCompatActivity {

    int day=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobil);
    }
    public void increment(View view) {
        if (day == 30) {
            return;
        }
        day = day + 1;
        displayQuantity(day);
    }
    public void decrement(View view) {
        if (day == 0) {
            return;
        }
        day = day - 1;
        displayQuantity(day);
    }

    public void kirim(View view) {
        // Get user's name
        EditText namaField = (EditText) findViewById(R.id.nama);
        String name = namaField.getText().toString();

        // Get user's tepon
        EditText no_telp = (EditText) findViewById(R.id.telp);
        String telp = no_telp.getText().toString();

        // Get user's job
        EditText pekerjaan = (EditText) findViewById(R.id.pekerjaan);
        String job = pekerjaan.getText().toString();

        // Get user's Alamat
        EditText alamat = (EditText) findViewById(R.id.alamat);
        String address = alamat.getText().toString();

        String message = createOrderSummary(name,Jk(),telp,job,address,mobil(),day,Price());

        // Use an intent to launch an email app.
        // Send the order summary in the email body.
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT,
                getString(R.string.order_summary_email_subject, name));
        intent.putExtra(Intent.EXTRA_TEXT, message);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    private String Jk(){
        RadioButton lk = findViewById(R.id.lk);
        boolean laki = lk.isChecked();
        RadioButton pr = findViewById(R.id.pr);
        boolean perempuan = pr.isChecked();


        String jk=null;
        if(laki){
            jk="laki-laki";
        }
        if(perempuan){
            jk="perempuan";
        }
        return jk;
    }


    private String mobil(){
        RadioButton mobil_1 = findViewById(R.id.mobil);
        boolean mobil1 = mobil_1.isChecked();
        RadioButton mobil_2 = findViewById(R.id.mobil2);
        boolean mobil2 = mobil_2.isChecked();
        RadioButton mobil_3 = findViewById(R.id.mobil3);
        boolean mobil3 = mobil_3.isChecked();

        String Mobil=null;
        if(mobil1){
            Mobil="Suzuki APV";
        }
        if(mobil2){
            Mobil="Toyota Avanza";
        }
        if(mobil3){
            Mobil="Toyota Innova";
        }
        return Mobil;
    }

    private int Price() {
        RadioButton mobil_1 = findViewById(R.id.mobil);
        boolean mobil1 = mobil_1.isChecked();
        RadioButton mobil_2 = findViewById(R.id.mobil2);
        boolean mobil2 = mobil_2.isChecked();
        RadioButton mobil_3 = findViewById(R.id.mobil3);
        boolean mobil3 = mobil_3.isChecked();
        // First calculate the price of one cup of coffee
        int eachDay = 1;
        int Price;

        // If the user wants whipped cream, add $1 per cup
        if(mobil1) {
            eachDay = 200000;
        }
        // If the user wants chocolate, add $2 per cup
        if(mobil2) {
            eachDay =250000;
        }
        if(mobil3){
            eachDay =300000;
        }
        Price = day * eachDay;
        // Calculate the total order price by multiplying by the quantity
        return Price;
    }


    private String createOrderSummary(String name, String Jk, String telp , String job, String address, String mobil,int day,int Price) {
        String Message = "Name: " + name;
        Message += " ("+Jk+")" ;
        Message += "\nKontak: " + telp;
        Message += "\nPekerjaan: " + job;
        Message += "\nAlamat: " + address;
        Message += "\nKendaraan & Durasi Sewa: " + mobil+", "+day+"hari";
        Message += "\nTotal: Rp" + Price;
        Message += "\n \nThank you!";
        return Message;
    }
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}