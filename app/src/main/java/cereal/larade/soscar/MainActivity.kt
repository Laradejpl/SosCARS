package cereal.larade.soscar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login_button.setOnClickListener {

            var url = UserInfo.url + "login.php?mobile=" + login_mobile.text.toString() +
                    "&password=" +
                    login_password.text.toString()

           var rq=Volley.newRequestQueue(this)
            var sr=StringRequest(
                Request.Method.GET,url, { response ->
                    if (response == "1")

                        Toast.makeText(this,"Login Fail",Toast.LENGTH_LONG).show()
                    else{
                        UserInfo.mobile=login_mobile.text.toString()
                        var i = Intent(this ,HomeAct::class.java)
                        startActivity(i)
                    }


                }, // quest qui se passe si ca va
                {  }) // si ca va pas
            rq.add(sr)
        }
           login_signup.setOnClickListener {
               var i = Intent(this ,SignupAct::class.java)
               startActivity(i)
           }
    }
}