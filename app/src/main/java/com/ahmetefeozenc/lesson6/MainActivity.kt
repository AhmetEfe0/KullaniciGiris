package com.ahmetefeozenc.lesson6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.ahmetefeozenc.lesson6.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var deneme = 0
    var k_adi = "Efe"
    var sifrek = "1234"
    var random=0
    lateinit var kod:EditText
    lateinit var giris: Button
    lateinit var guvenlikkodu: TextView
    lateinit var kullaniciadi: EditText
    lateinit var sifre: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        super.onCreate(savedInstanceState)
        setContentView(view)
        kod=binding.kod
        giris=binding.giris
        guvenlikkodu=binding.guvenlikkodu
        kullaniciadi=binding.kullaniciadi
        sifre=binding.sifre

        kod.setVisibility(View.INVISIBLE);

        giris.setOnClickListener {
            if(deneme>=3){
                guvenlikkodukontrol()
            }else {
                giriskontrol()
            }
        }
    }

    fun randomguvenlik(){
        random = (1000..9999).random()
        guvenlikkodu.text="$random"

    }
    fun hatalıgiris(){
        kullaniciadi.setTextColor(resources.getColor(android.R.color.holo_red_light))
        sifre.setTextColor(resources.getColor(android.R.color.holo_red_light))
    }
    fun basarılıgiris(){
        kullaniciadi.setTextColor(resources.getColor(android.R.color.black))
        sifre.setTextColor(resources.getColor(android.R.color.black))
    }
    fun toastmsg(a:String){
        val toast = Toast.makeText(this, a, Toast.LENGTH_SHORT)
        toast.show()
    }

    fun giriskontrol() {
        val kullaniciadikontrol = kullaniciadi.text.toString()
        val sifrekontrol = sifre.text.toString()
        if (kullaniciadikontrol == k_adi && sifrekontrol == sifrek) {
            toastmsg("Giriş Başarılı")
            basarılıgiris()
        } else {
            deneme++
            hatalıgiris()
            toastmsg("Hatalı Kullanıcı Adı veya Şifre")
        }
    }

    fun guvenlikkodukontrol() {
        val guvenlikkontrol = kod.text.toString().toIntOrNull()
        kod.setVisibility(View.VISIBLE);
            if (guvenlikkontrol != random) {
                randomguvenlik()
                toastmsg("Güvenlik Kodu Hatalı")
            } else {
                giriskontrol()
            }
    }
}

