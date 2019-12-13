package com.example.myapplication1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MotorActivity extends AppCompatActivity {

    int day=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motor);
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

        // Get user's KTPID
        EditText no_telp = (EditText) findViewById(R.id.telp);
        String telp = no_telp.getText().toString();

        // Get user's job
        EditText pekerjaan = (EditText) findViewById(R.id.pekerjaan);
        String job = pekerjaan.getText().toString();

        // Get user's Alamat
        EditText alamat = (EditText) findViewById(R.id.alamat);
        String address = alamat.getText().toString();

        String message = createOrderSummary(name,Jk(),telp,job,address,motor(),day,Price());

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


    private String motor(){
        RadioButton motor_1 = findViewById(R.id.motor1);
        boolean motor1 = motor_1.isChecked();
        RadioButton motor_2 = findViewById(R.id.motor2);
        boolean motor2 = motor_2.isChecked();
        RadioButton motor_3 = findViewById(R.id.motor3);
        boolean motor3 = motor_3.isChecked();

        String Motor=null;
        if(motor1){
            Motor="Honda Beat";
        }
        if(motor2){
            Motor="Yamaha Mio";
        }
        if(motor3){
            Motor="Nmax";
        }
        return Motor;
    }

    private int Price() {
        RadioButton motor_1 = findViewById(R.id.motor1);
        boolean motor1 = motor_1.isChecked();
        RadioButton motor_2 = findViewById(R.id.motor2);
        boolean motor2 = motor_2.isChecked();
        RadioButton motor_3 = findViewById(R.id.motor3);
        boolean motor3 = motor_3.isChecked();

        // First calculate the price of one cup of coffee
        int eachDay = 1;
        int Price;

        // If the user wants whipped cream, add $1 per cup
        if(motor1) {
            eachDay = 80000;
        }
        // If the user wants chocolate, add $2 per cup
        if(motor2) {
            eachDay =85000;
        }
        if(motor3){
            eachDay =90000;
        }
        Price = day * eachDay;
        // Calculate the total order price by multiplying by the quantity
        return Price;
    }


    private String createOrderSummary(String name, String Jk, String telp, String job, String address, String motor,int day,int Price) {
        String Message = "Name: " + name;
        Message += " ("+Jk+")" ;
        Message += "\nKontak: " + telp;
        Message += "\nPekerjaan: " + job;
        Message += "\nAlamat: " + address;
        Message += "\nKendaraan & Durasi Sewa: " + motor+", "+day+"hari";
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