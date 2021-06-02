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
import kotlinx.android.synthetic.main.activity_signup.*

class SignupAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        signup_button.setOnClickListener {

            if (signup_password.text.toString()== signup_confirm_password.text.toString()){

                var url:String = UserInfo.url + "signup.php?mobile=" + signup_mobile.text.toString() +
                        "&password=" + signup_password.text.toString() +
                        "&name=" + signup_name.text.toString()
                var rq= Volley.newRequestQueue(this)
                var sr= StringRequest(
                    Request.Method.GET,url, { response ->
                        if (response == "0")

                            Toast.makeText(this,"Mobile number already exist ",Toast.LENGTH_LONG).show()
                        else{
                            UserInfo.mobile=signup_mobile.text.toString()
                            var i = Intent(this ,HomeAct::class.java)
                            startActivity(i)
                        }


                    }, // quest qui se passe si ca va
                    {  }) // si ca va pas
                rq.add(sr)

            }else{
                Toast.makeText(this,"Password don't macht",Toast.LENGTH_LONG).show()

            }
        }
    }
}