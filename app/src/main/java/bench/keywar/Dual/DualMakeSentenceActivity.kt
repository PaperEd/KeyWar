package bench.keywar.Dual


import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import bench.keywar.BaseView
import bench.keywar.R
import kotlinx.android.synthetic.main.activity_dual_make_sentence.*

class DualMakeSentenceActivity : AppCompatActivity(), DualContract.View {
    override fun showToast(content: String) {
        Toast.makeText(baseContext, content, LENGTH_SHORT).show()
    }

    lateinit var dualPresenter: DualPresenter
    var sentence_count_now = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dual_make_sentence)
        val intent = intent
        var sentence_count_total = intent.getIntExtra("count", 0)
        dual_make_sentence_count_now.text = sentence_count_now.toString()
        dual_make_sentence_count_total.text = sentence_count_total.toString()

        dual_make_sentence_btn.setOnClickListener({
            if (sentence_count_total > sentence_count_now) {
               // dualPresenter.postUserString(dual_make_sentence_et.text.toString())
                sentence_count_now++
                dual_make_sentence_count_now.text = sentence_count_now.toString()
                showToast("다음 문장을 입력해주세요.")
                dual_make_sentence_et.text.clear()
            } else {
                val dual_toActivity_intent = Intent(DualMakeSentenceActivity@ this, DualActivity::class.java)
                        .putExtra("count", sentence_count_total)
                startActivity(dual_toActivity_intent)
            }
        })


    }
}