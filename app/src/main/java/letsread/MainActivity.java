package letsread;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    EditText txtId, txtName, txtAge, txtBirth, txtAdd, txtPhone;
    Button btnInsert,btnShow,btnUpdate,btnDelete;
    DatabaseReference dbref;

    user us = new user();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtId = findViewById(R.id.EtInputId);
        txtName = findViewById(R.id.EtInputName);
        txtAge = findViewById(R.id.Etlninputage);
        txtBirth = findViewById(R.id.EtInputbirth);
        txtAdd = findViewById(R.id.EtInputAdd);
        txtPhone = findViewById(R.id.Etlninputnumber);

        btnInsert = findViewById(R.id.button);
        btnShow = findViewById(R.id.button2);
        btnUpdate = findViewById(R.id.button3);
        btnDelete = findViewById(R.id.button4);

        btnInsert.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                dbref = FirebaseDatabase.getInstance().getReference().child("user");
                try {
                    if (TextUtils.isEmpty(txtId.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "enter your id", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(txtName.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "enter your name", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(txtAge.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "enter your age", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(txtBirth.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "enter your birthday", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(txtAdd.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "enter your address", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(txtPhone.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "enter your phone number", Toast.LENGTH_SHORT).show();
                    } else {
                        us.setId(txtId.getText().toString().trim());
                        us.setName(txtName.getText().toString().trim());
                        us.setAge(txtAge.getText().toString().trim());
                        us.setBirthday(txtBirth.getText().toString().trim());
                        us.setAddress(txtAdd.getText().toString().trim());
                        us.setPhone_number(Integer.parseInt(txtPhone.getText().toString().trim()));

                        dbref.push().setValue(us);
                        //dbref.child("us1").setValue(us);
                        Toast.makeText(getApplicationContext(), "data inserted successfully", Toast.LENGTH_SHORT).show();
                        clearControls();

                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Invalid phone number", Toast.LENGTH_SHORT).show();
                }

            }

        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatabaseReference updRef = FirebaseDatabase.getInstance().getReference().child("user");


                updRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String us1 = null;
                        if (snapshot.hasChild(us1)) {
                            try {
                                us.setId(txtId.getText().toString().trim());
                                us.setName(txtName.getText().toString().trim());
                                us.setAge(txtAge.getText().toString().trim());
                                us.setBirthday(txtBirth.getText().toString().trim());
                                us.setAddress(txtAdd.getText().toString().trim());
                                us.setPhone_number(Integer.parseInt(txtPhone.getText().toString().trim()));


                                dbref = FirebaseDatabase.getInstance().getReference().child("User").child(us1);
                                dbref.setValue(us);
                                clearControls();
                                Toast.makeText(getApplicationContext(), "Data Updated Successfully", Toast.LENGTH_SHORT).show();
                            } catch (NumberFormatException e) {
                                Toast.makeText(getApplicationContext(), "Invalid Contact Number", Toast.LENGTH_SHORT).show();
                            }
                        } else
                            Toast.makeText(getApplicationContext(), "No Source To Update", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }


                });

            }
        });


        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference deRef = FirebaseDatabase.getInstance().getReference().child("us1");
                deRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild(" -MImjuQMrWsQ8y1uQdNj")) {
                            dbref = FirebaseDatabase.getInstance().getReference().child("us1").child(" -MImjuQMrWsQ8y1uQdNj");
                            dbref.removeValue();

                            Toast.makeText(getApplicationContext(), "Data Deleted Successfully", Toast.LENGTH_SHORT).show();


                        } else {
                            Toast.makeText(getApplicationContext(), "No Source to Delete", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

    }
        private void clearControls () {
            txtId.setText("");
            txtName.setText("");
            txtAge.setText("");
            txtBirth.setText("");
            txtAdd.setText("");
            txtPhone.setText("");

        }


    }