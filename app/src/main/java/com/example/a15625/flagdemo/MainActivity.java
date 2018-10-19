package com.example.a15625.flagdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import static android.view.View.*;

public class MainActivity extends Activity {

    ListView listView;
    ArrayList<Item> arrayList ;
    private static final int CHANGE_PAGE_N=1;
    MyBaseAdapter myBaseAdapter;
    AlertDialog.Builder builder;
    MainActivity activity;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);
        arrayList = new ArrayList<>();

        arrayList.add(new Item("China",R.drawable.china));
        arrayList.add(new Item("France",R.drawable.france));
        arrayList.add(new Item("Algeria",R.drawable.algeria));
        arrayList.add(new Item("Aruba",R.drawable.aruba));
        arrayList.add(new Item("Chile",R.drawable.chile));
        arrayList.add(new Item("Denmark",R.drawable.demark));
        arrayList.add(new Item("Ecuador",R.drawable.ecuador));
        arrayList.add(new Item("Austria",R.drawable.austria));
        arrayList.add(new Item("Dominica",R.drawable.dominica));
        arrayList.add(new Item("Colombia",R.drawable.colombia));

         myBaseAdapter = new MyBaseAdapter(this,R.layout.flag,arrayList);

        listView.setAdapter(myBaseAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // Log.i("M",arrayList.get(position).getName());
                Intent intent = new Intent(MainActivity.this,showFlag.class);
                intent.putExtra("name",arrayList.get(position).getName());
                intent.putExtra("image",""+arrayList.get(position).getImageId());
                startActivityForResult(intent,CHANGE_PAGE_N);
            }
        });


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, final View view, final int position, long id) {
                builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Delete it?").setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //onUserSelect("yes",position);
                       // listView.removeView(view);
                        myBaseAdapter.remove(arrayList.get(position));
                        myBaseAdapter.notifyDataSetChanged();
                    }
                }).setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show().create();


                return true;//If you return false ,click will be worked then.
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode)
        { case CHANGE_PAGE_N:;
            default:
                listView.setAdapter(myBaseAdapter);

        }
    }
}
