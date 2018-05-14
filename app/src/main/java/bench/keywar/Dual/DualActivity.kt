package bench.keywar.Dual

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import bench.keywar.R
import kotlinx.android.synthetic.main.activity_dual.*
import java.util.*

class DualActivity : AppCompatActivity(), DualContract.View {


    var sentence_count_now  = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dual)

        val intent = intent
        val sentence_count_total = intent.getIntExtra("count",0)

        dual_count_total.text = sentence_count_total.toString()
        dual_count_now.text = sentence_count_now.toString()

        dual_sentence_et.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        dual_next_btn.setOnClickListener{
            if(sentence_count_total > sentence_count_now) {
                sentence_count_now++
                dual_count_now.text = sentence_count_now.toString()
                dual_sentence_tv.text = "text"
                dual_sentence_et.text.clear()
            }

        }

    }

    override fun showToast(content: String) {
        Toast.makeText(baseContext,content,Toast.LENGTH_SHORT).show()
    }
}