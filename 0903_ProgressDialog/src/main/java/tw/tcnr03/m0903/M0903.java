package tw.tcnr03.m0903;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.Calendar;

public class M0903 extends AppCompatActivity implements View.OnClickListener {

    private Button b01;
    private Handler mHandler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0903);
        setupViewComponent();
    }

    private void setupViewComponent() {
        b01=(Button)findViewById(R.id.m0903_b001);
        b01.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final ProgressDialog proDlg = new ProgressDialog(this);

        proDlg.setTitle(getString(R.string.m0903_title));
        proDlg.setMessage(getString(R.string.m0903_message));
        proDlg.setIcon(android.R.drawable.btn_star_big_on);
        proDlg.setCancelable(false);
        proDlg.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        proDlg.setMax(100);
        proDlg.show();

//------------------------------------------------------------
        new Thread(new Runnable() {
            public void run() {
                Calendar begin = Calendar.getInstance();
                do {
                    Calendar now = Calendar.getInstance();
                    final int iDiffSec = 60 * (now.get(Calendar.MINUTE) - begin.get(Calendar.MINUTE)) +
                            (now.get(Calendar.SECOND) - begin.get(Calendar.SECOND));
//-------------------------------------
                    if (iDiffSec * 10 > 100) {
                        mHandler.post(new Runnable() {
                            public void run() {
                                proDlg.setProgress(100);
                            }
                        });
                        break;
                    }
//-------------------------------------
                    mHandler.post(new Runnable() {
                        public void run() {
                            proDlg.setProgress(iDiffSec * 10); //1,2,4,5
                        }
                    });
//-------------------------------------
                    if ((iDiffSec * 20) < 100){
                        mHandler.post(new Runnable() {
                                          public void run() {
                                              proDlg.setSecondaryProgress(iDiffSec * 20);
                                          }
                                      }
                        );
                    }else{
                        mHandler.post(new Runnable() {
                            public void run() {
                                proDlg.setSecondaryProgress(100);
                            }
                        });
                    }

                } while (true);
                proDlg.cancel();
            }
        }).start();
    }
}