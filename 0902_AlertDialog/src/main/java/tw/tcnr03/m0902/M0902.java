package tw.tcnr03.m0902;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class M0902 extends AppCompatActivity implements View.OnClickListener {

    private Button b01;
    private Button b02;
    private TextView t01;
    final String[] ListStr = {"張三", "李四", "王五", "陳六", "呂七", "宋八",
            "如果選擇項目太多", "Android也會", "自動的可以拖曳喔！～","aa","bb","cc"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0902);
        setupViewComponent();
    }

    private void setupViewComponent() {
        b01=(Button)findViewById(R.id.m0902_b001);
        b02=(Button)findViewById(R.id.m0902_b002);
        t01=(TextView)findViewById(R.id.m0902_t001);
        b01.setOnClickListener(this);
        b02.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        t01.setText("");
        switch (v.getId()){
            case R.id.m0902_b001:
                MyAlertDialog myAltDlg = new MyAlertDialog(this);

                myAltDlg.setTitle(getString(R.string.m0902_title));
                myAltDlg.setMessage(getString(R.string.m0902_b001)+getString(R.string.m0902_t001));
                myAltDlg.setIcon(android.R.drawable.btn_star);
                myAltDlg.setCancelable(false);

                myAltDlg.setButton(DialogInterface.BUTTON_POSITIVE, getString(R.string.m0902_positive),alt01ON); //which=-1
                myAltDlg.setButton(DialogInterface.BUTTON_NEGATIVE, getString(R.string.m0902_negative),alt01ON);//which=-2
                myAltDlg.setButton(DialogInterface.BUTTON_NEUTRAL, getString(R.string.m0902_neutral),alt01ON);//which=-3
                myAltDlg.show();
                break;

            case R.id.m0902_b002:
                AlertDialog.Builder altDlgBldr = new AlertDialog.Builder(this);

                altDlgBldr.setTitle(getString(R.string.m0902_title));
//                altDlgBldr.setMessage(getString(R.string.m0902_b001)+getString(R.string.m0902_t001)); message太多另外build
                altDlgBldr.setIcon(android.R.drawable.btn_star);
                altDlgBldr.setCancelable(false);

//                --------------------------------------------------此為監聽內容
                altDlgBldr.setItems(ListStr, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "select:" + ListStr[which], Toast.LENGTH_SHORT).show();
                        //--可進行不同的處理方法
                        t01.setText(getString(R.string.m0902_t001) +
                                getString(R.string.m0902_b002) + "\n" +
                                getString(R.string.m0902_click) + " " + ListStr[which]);
//                        altDlgBldr.setButton(DialogInterface.BUTTON_POSITIVE, getString(R.string.m0902_positive),alt01ON); //which=-1
//                        altDlgBldr.setButton(DialogInterface.BUTTON_NEGATIVE, getString(R.string.m0902_negative),alt01ON);//which=-2
//                        altDlgBldr.setButton(DialogInterface.BUTTON_NEUTRAL, getString(R.string.m0902_neutral),alt01ON);//which=-3
                    }
                });
//                --------------------------------------------------此為監聽按鈕
                altDlgBldr.setPositiveButton(getString(R.string.m0902_positive), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        t01.setText(getString(R.string.m0902_t001)+
                                getString(R.string.m0902_b002)+
                                getString(R.string.m0902_click)+
                                getString(R.string.m0902_positive)+
                                getString(R.string.m0902_button));
                    }
                });

                altDlgBldr.setNegativeButton(getString(R.string.m0902_negative), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        t01.setText(getString(R.string.m0902_t001)+
                                getString(R.string.m0902_b002)+
                                getString(R.string.m0902_click)+
                                getString(R.string.m0902_negative)+
                                getString(R.string.m0902_button));
                    }
                });

                altDlgBldr.setNeutralButton(getString(R.string.m0902_neutral), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        t01.setText(getString(R.string.m0902_t001)+
                                getString(R.string.m0902_b002)+
                                getString(R.string.m0902_click)+
                                getString(R.string.m0902_neutral)+
                                getString(R.string.m0902_button));
                    }
                });

                altDlgBldr.show();
                break;
        }
    }

    private DialogInterface.OnClickListener alt01ON = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case -1:
                    t01.setText(getString(R.string.m0902_t001)+
                            getString(R.string.m0902_b001)+
                            getString(R.string.m0902_click)+
                            getString(R.string.m0902_positive)+
                            getString(R.string.m0902_button));
                    break;

                case -2:
                    t01.setText(getString(R.string.m0902_t001)+
                            getString(R.string.m0902_b001)+
                            getString(R.string.m0902_click)+
                            getString(R.string.m0902_negative)+
                            getString(R.string.m0902_button));
                    break;

                case -3:
                    t01.setText(getString(R.string.m0902_t001)+
                            getString(R.string.m0902_b001)+
                            getString(R.string.m0902_click)+
                            getString(R.string.m0902_neutral)+
                            getString(R.string.m0902_button));
                    break;
            }
        }
    } ;
}