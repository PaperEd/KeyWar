package bench.keywar.Single

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import bench.keywar.R
import kotlinx.android.synthetic.main.activity_single.*

class SingleActivity : AppCompatActivity(), SingleContract.View {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single)

        var index = 0
        val intent = intent
        val sentences = intent.getStringArrayListExtra("sentences")
        val totalSentence = sentences.size

        setSentenceCount(index, totalSentence)

        single_et_write.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if (p0.toString() == sentences[index]) {
                    changeSentence(sentences[++index])
                    setSentenceCount(index, totalSentence)
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }

    override fun setSentenceCount(count: Int, total: Int) {
        single_tv_count.text = "$count / $total"
    }

    override fun changeSentence(sentence: String) {
        single_tv_sentence.text = sentence
        single_et_write.text.clear()
    }

    override fun showToast(content: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
